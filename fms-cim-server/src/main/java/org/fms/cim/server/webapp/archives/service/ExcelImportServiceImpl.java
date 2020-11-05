/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.fms.cim.common.domain.archives.DeptMonDomain;
import org.fms.cim.common.domain.archives.MeterMeterAssetsRelDomain;
import org.fms.cim.common.domain.archives.MeterReplaceDomain;
import org.fms.cim.common.domain.archives.SettlementDomain;
import org.fms.cim.common.domain.archives.SettlementMeterRelDomain;
import org.fms.cim.common.domain.archives.WriteFilesDomain;
import org.fms.cim.common.domain.assets.MeterAssetsDomain;
import org.fms.cim.common.service.IExcelImportService;
import org.fms.cim.server.webapp.archives.dao.MeterDAO;
import org.fms.cim.server.webapp.archives.dao.MeterInductorAssetsRelDAO;
import org.fms.cim.server.webapp.archives.dao.MeterMeterAssetsRelDAO;
import org.fms.cim.server.webapp.archives.dao.MeterReplaceInfoDAO;
import org.fms.cim.server.webapp.archives.dao.SettlementDAO;
import org.fms.cim.server.webapp.archives.dao.SystemCommonConfigDAO;
import org.fms.cim.server.webapp.assets.dao.InductorAssetsDAO;
import org.fms.cim.server.webapp.assets.dao.MeterAssetsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.type.TypeReference;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.spring.web.client.TitanTemplate;
import com.riozenc.titanTool.spring.web.http.HttpResult;

@TransactionService
public class ExcelImportServiceImpl implements IExcelImportService {

	@Autowired
	private TitanTemplate titanTemplate;

	@TransactionDAO
	private InductorAssetsDAO inductorAssetsDAO;
	@TransactionDAO
	private SystemCommonConfigDAO systemCommonConfigDAO;
	@TransactionDAO
	private MeterInductorAssetsRelDAO meterInductorAssetsRelDAO;
	@TransactionDAO
	private MeterMeterAssetsRelDAO meterMeterAssetsRelDAO;
	@TransactionDAO
	private SettlementDAO settlementDAO;
	@TransactionDAO
	private MeterAssetsDAO meterAssetsDAO;
	@TransactionDAO
	private MeterDAO meterDAO;
	@TransactionDAO
	private MeterMeterAssetsRelDAO meterMeterAssetsDAO;
	@TransactionDAO
	private MeterReplaceInfoDAO meterReplaceInfoDAO;
	
	


	@Override
	public HttpResult changeDevExcel(MeterReplaceDomain e) {

		HttpResult httpResult = new HttpResult<>();
		httpResult.setStatusCode(HttpResult.ERROR);

		int equipmentType = 1;
		// 操作类型 1装 2拆
		int operateType = e.getOperateType();

		// 资产档案
		MeterAssetsDomain meterAssets = new MeterAssetsDomain();

		/**
		 * 2.装表 生成综合倍率
		 *
		 */
		if (operateType == 1) { // 装

			// 判断表序号
			int maxMeterSn = getMaxMeterSn(e);
			if (e.getMeterSn() == null || e.getMeterSn() - maxMeterSn <= 0) {
				e.setMeterSn(maxMeterSn);
			}
			
			MeterMeterAssetsRelDomain meterMeterAssetsRelDomain = new MeterMeterAssetsRelDomain();
			meterMeterAssetsRelDomain.setMeterId(e.getMeterId());
			meterMeterAssetsRelDomain.setMeterAssetsId(e.getMeterAssetsId());
			meterMeterAssetsRelDomain.setPhaseSeq(e.getPhaseSeq());
			meterMeterAssetsRelDomain.setFunctionCode(e.getFunctionCode());
			meterMeterAssetsRelDomain.setPowerDirection(e.getPowerDirection());
			meterMeterAssetsRelDomain.setTsFlag("0");
			meterMeterAssetsRelDomain.setCreateDate(e.getCreateDate());
			meterMeterAssetsRelDomain.setFactorNum(e.getFactorNum());
			meterMeterAssetsRelDomain.setStatus((byte)1);
			meterMeterAssetsRelDomain.setMeterSn(e.getMeterSn());
			meterMeterAssetsRelDomain.setWriteSn(e.getWriteSn());
	
			//判断同一计量点下是否存在虚拟+有功表

			// 如果是装表，把资产状态改为 8、装出

			int ma = meterMeterAssetsRelDAO.insert(meterMeterAssetsRelDomain);

			// 获取和电能表同向的pt ct
			if (ma <= 0) {
				httpResult.setMessage("电能表资产档案更新失败");
				return httpResult;
			}


		} else if (operateType == 2) { // 拆

			// 如果是拆表，就把状态改为9、拆回
			if (e.getMeterAssetsId() != null && equipmentType == 1) {
				meterAssets.setId(e.getMeterAssetsId());
				meterAssets.setStatus((byte) 9);
				int ma = meterAssetsDAO.update(meterAssets);

				// 拆表时生成换表电量
				changeMeterPower(e);

				// 删除运行电能表
				MeterMeterAssetsRelDomain delMeterAssetsRel = new MeterMeterAssetsRelDomain();
				delMeterAssetsRel.setMeterId(e.getMeterId());
				delMeterAssetsRel.setMeterAssetsId(e.getMeterAssetsId());
				delMeterAssetsRel.setFunctionCode(e.getFunctionCode());
				ma += meterMeterAssetsRelDAO.delete(delMeterAssetsRel);
				if (ma <= 0) {
					httpResult.setMessage("电能表资产档案更新失败");
					return httpResult;
				}
			}

		}


		int count = meterReplaceInfoDAO.insert(e);
		if (count < 1) {
			httpResult.setMessage("操作记录插入失败");
			return httpResult;
		}

		// 组一串返回信息。
	//	String massage = (operateType == 1 ? "装" : "拆") + (equipmentType == 1 ? "电能表" : "互感器") + "操作成功";
	//	httpResult.setMessage(massage);

		httpResult.setStatusCode(HttpResult.SUCCESS);

		return httpResult;

	}

	/**
	 * 生成换表电量 拆表时获取拆表底码和上次结算止码
	 */
	public void changeMeterPower(MeterReplaceDomain mr) {

		HashMap<String, Object> rMap = new HashMap<String, Object>();
		rMap.put("result", false);

		/**
		 * 换标记录添加当前电费月份，处理月份
		 *
		 * 根据计量点找结算户 根据结算户的营业区域获取电费月份 根据电费月份和计量点ID获取止码和止码抄表时间
		 *
		 * 用meterid、相序 获取综合倍率
		 *
		 * 判断装表和上次表码的时间先后
		 *
		 * 根据起止码和综合倍率计算分费率电量
		 *
		 * 将换表电量放在P5开头的字段
		 *
		 */
		BigDecimal rate = new BigDecimal(0);
		// 获取综合倍率。和电能表资产，没有则直接跳出方法
		MeterMeterAssetsRelDomain tmmar = new MeterMeterAssetsRelDomain();
		tmmar.setMeterId(mr.getMeterId());
		tmmar.setPhaseSeq(mr.getPhaseSeq());

		List<MeterMeterAssetsRelDomain> returnMeterMeterAssets = meterMeterAssetsRelDAO.findByWhere(tmmar);
		if (returnMeterMeterAssets.size() == 0 || returnMeterMeterAssets.get(0).getFactorNum() == null) {
			return; // 未装电能表，或电能表综合倍率为空的。直接取消计算
		}
		rate = BigDecimal.valueOf(returnMeterMeterAssets.get(0).getFactorNum()==null?0:
			returnMeterMeterAssets.get(0).getFactorNum());

		// 上次的结算月份，对于未计费过的新户，直接使用装表记录。
		HashMap<String, Object> monMap = getCurrentMon(mr);
		String mon = "202001";
		if ((boolean) monMap.get("result")) {
			mon = monMap.get("mon").toString();
		}

		// 上个月表码
		WriteFilesDomain writeFiles = new WriteFilesDomain();
		writeFiles.setMeterId(mr.getMeterId());
		writeFiles.setMon(Integer.parseInt(mon));
		writeFiles.setMeterAssetsId(returnMeterMeterAssets.get(0).getMeterAssetsId());
		writeFiles.setFunctionCode(mr.getFunctionCode()); // 有功
		writeFiles.setPowerDirection(mr.getPowerDirection()); // 正向
		List<WriteFilesDomain> writeFileList = getCodeByMeter(writeFiles);

		// 上次的装表记录
		MeterReplaceDomain lmr = getLastMeterReplaceInfo(mr);
		if (lmr == null) {
			// 无装表记录
			lmr = new MeterReplaceDomain();
			
			Date tempDate = new Date();
			Calendar calendar = Calendar.getInstance();  
			calendar.add(Calendar.YEAR, -1);//当前时间减去一年，即一年前的时间  
		//	calendar.getTime();//获取一年前的时间，或者一个月前的时间  
			tempDate.setTime(calendar.getTimeInMillis());
			lmr.setReplaceDate(tempDate);
		}

		// 计算换表电量并赋值到mr
		if (writeFileList ==null ||writeFileList.size() == 0 
				|| writeFileList.get(0).getWriteDate()==null
				|| lmr.getReplaceDate()==null
				|| lmr.getReplaceDate().after(writeFileList.get(0).getWriteDate())) {// 首次算费
			calcReplacePower(null, lmr, rate, mr);
		} else {
			calcReplacePower(writeFileList, null, rate, mr);
		}
	}

	// 获取计量点结算户的当前电费月份
	private HashMap<String, Object> getCurrentMon(MeterReplaceDomain mr) {

		HashMap<String, Object> rMap = new HashMap<String, Object>();
		rMap.put("result", false);

		SettlementMeterRelDomain smr = new SettlementMeterRelDomain();
		smr.setMeterId(mr.getMeterId());
		List<SettlementDomain> sl = settlementDAO.getSettlementbyMeter(smr);
		if (sl.size() == 0) {
			rMap.put("massage", "计量点未关联结算户");
			return rMap;
		}
		Long deptId = sl.get(0).getBusinessPlaceCode();

		HashMap<String, Object> tempMap = new HashMap<String, Object>();
//        tempMap.put("ids", "[" + deptId + "]");
		tempMap.put("ids", Arrays.asList(deptId));

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		Calendar cal = Calendar.getInstance();

		try {
			List<DeptMonDomain> deptMonDomains = titanTemplate.post("BILLING-SERVER",
					"billingServer/deptMon?method=getDeptCurrentMonById", httpHeaders, tempMap,
					new TypeReference<List<DeptMonDomain>>() {
					});

			if (deptMonDomains.size() == 0 || deptMonDomains.get(0).getMon() == null) {
				rMap.put("result", true);
				rMap.put("mon", cal.get(Calendar.YEAR) + String.format("%02d", cal.get(Calendar.MONTH)));
				return rMap;
			}

			int mon = Integer.parseInt(deptMonDomains.get(0).getMon());
			cal.set(mon / 100, mon % 100, 3);// 这个3 没有特殊意义,可以删除。
			rMap.put("mon", cal.get(Calendar.YEAR) + String.format("%02d", cal.get(Calendar.MONTH)));
			rMap.put("result", true);
			return rMap;
		} catch (Exception e) {
			rMap.put("massage", "调用billingServer失败");
			return rMap;
		}

	}

	// 获取计量点ID和电费月份获取抄表止码和时间
	private List<WriteFilesDomain> getCodeByMeter(WriteFilesDomain writeFiles) {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		List<WriteFilesDomain> writeFileList = new ArrayList<WriteFilesDomain>();

		try {
			writeFileList = titanTemplate.post("BILLING-SERVER", "billingServer/WriteFiles/getWriteFiles", httpHeaders,
					writeFiles, new TypeReference<List<WriteFilesDomain>>() {
					});

		} catch (Exception e) {
			// TODO 待添加返回信息或处理方法
		}
		return writeFileList;

	}

	// 根据meterid和电能表资产或互感器资产获取上次的装表记录
	private MeterReplaceDomain getLastMeterReplaceInfo(MeterReplaceDomain mr) {
		MeterReplaceDomain tmr = new MeterReplaceDomain();
		tmr.setMeterId(mr.getMeterId());
		tmr.setMeterAssetsId(mr.getMeterAssetsId());
		tmr.setCtAssetsId(mr.getCtAssetsId());
		tmr.setPtAssetsId(mr.getPtAssetsId());
		tmr.setOperateType((byte) 1);
		List<MeterReplaceDomain> tl = meterReplaceInfoDAO.findByWhere(tmr);

		if (tl == null || tl.size() == 0) {

			return new MeterReplaceDomain();
		}
		return tl.get(0);

	}


	// 计算换表电量
	private void calcReplacePower(List<WriteFilesDomain> writeFileList, MeterReplaceDomain lmr, BigDecimal rate,
			MeterReplaceDomain mr) {

		BigDecimal p1r0 = new BigDecimal(0);
		BigDecimal p1r1 = new BigDecimal(0);
		BigDecimal p1r2 = new BigDecimal(0);
		BigDecimal p1r3 = new BigDecimal(0);
		BigDecimal p1r4 = new BigDecimal(0);

		if (writeFileList == null) {// 上次装表在本抄表周期内，使用上次装表记录计算
			p1r0 = mr.getP1r0() == null ? new BigDecimal(0)
					: mr.getP1r0().subtract(lmr.getP1r0() == null ? new BigDecimal(0) : lmr.getP1r0()).multiply(rate);
			if (mr.getP1r1() != null && lmr.getP1r1() != null) {
				p1r1 = mr.getP1r1().subtract(lmr.getP1r1()).multiply(rate);// 尖
			}
			if (mr.getP1r2() != null && lmr.getP1r2() != null) {
				p1r2 = mr.getP1r2().subtract(lmr.getP1r2()).multiply(rate);// 峰
			}
			if (mr.getP1r3() != null && lmr.getP1r3() != null) {
				p1r3 = mr.getP1r3().subtract(lmr.getP1r3()).multiply(rate);// 平
			}
			if (mr.getP1r4() != null && lmr.getP1r4() != null) {
				p1r4 = mr.getP1r4().subtract(lmr.getP1r4()).multiply(rate);// 谷
			}
		} else {// 上次装表不在本抄表周期内，使用上月止码计算
			for (WriteFilesDomain wf : writeFileList) {
				switch (wf.getTimeSeg()) {
				case 0:
					if (mr.getP1r0() != null) {
						p1r0 = mr.getP1r0().subtract(wf.getEndNum()).multiply(rate);
					}
					break;
				case 1: // 峰
					if (mr.getP1r2() != null) {
						p1r2 = mr.getP1r2().subtract(wf.getEndNum()).multiply(rate);
					}
					break;
				case 2: // 平
					if (mr.getP1r3() != null) {
						p1r3 = mr.getP1r3().subtract(wf.getEndNum()).multiply(rate);
					}
					break;
				case 3: // 谷
					if (mr.getP1r4() != null) {
						p1r4 = mr.getP1r4().subtract(wf.getEndNum()).multiply(rate);
					}
					break;
				case 4: // 尖
					if (mr.getP1r1() != null) {
						p1r1 = mr.getP1r1().subtract(wf.getEndNum()).multiply(rate);
					}
					break;
				}
			}
		}
		mr.setP5r0(p1r0);
		mr.setP5r1(p1r1);
		mr.setP5r2(p1r2);
		mr.setP5r3(p1r3);
		mr.setP5r4(p1r4);

	}


	// 根据计量点获取该用户下最大的表序号
	public int getMaxMeterSn(MeterReplaceDomain m) {

		int maxMeterSn = meterReplaceInfoDAO.getMaxMeterSn(m);

		return maxMeterSn;

	}






}
