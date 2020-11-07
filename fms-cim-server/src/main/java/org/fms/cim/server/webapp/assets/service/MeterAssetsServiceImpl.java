/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:49
 *    Title:com.riozenc.cim.webapp.service.impl.CustomerServiceImpl.java
 **/
package org.fms.cim.server.webapp.assets.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.domain.assets.MeterAssetsDomain;
import org.fms.cim.common.domain.assets.MeterAssetsEntity;
import org.fms.cim.common.service.IMeterAssetsService;
import org.fms.cim.common.util.CommonUtil;
import org.fms.cim.server.webapp.assets.dao.MeterAssetsDAO;
import org.fms.cim.server.webapp.assets.dao.MeterAssetsLogDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.spring.web.http.HttpResult;

@TransactionService
public class MeterAssetsServiceImpl implements IMeterAssetsService {

	@TransactionDAO("read")
	private MeterAssetsDAO meterAssetsReadDAO;
	
	@TransactionDAO("write")
	private MeterAssetsDAO meterAssetsWriteDAO;
	
	@TransactionDAO("read")
	private MeterAssetsLogDAO meterAssetsLogReadDAO;
	
	@TransactionDAO("write")
	private MeterAssetsLogDAO meterAssetsLogWriteDAO;

	@Override
	public int insert(MeterAssetsDomain t) {
		return meterAssetsWriteDAO.insert(t);
	}

	@Override
	public int delete(MeterAssetsDomain t) {
		return meterAssetsWriteDAO.delete(t);
	}

	@Override
	public int update(MeterAssetsDomain t) {
		return meterAssetsWriteDAO.update(t);
	}

	@Override
	public MeterAssetsDomain findByKey(MeterAssetsDomain t) {
		return meterAssetsReadDAO.findByKey(t);
	}

	@Override
	public List<MeterAssetsDomain> findByWhere(MeterAssetsDomain t) {
		return meterAssetsReadDAO.findByWhere(t);
	}

	@Override
	public List<MeterAssetsDomain> getMeterAssetsByManager(MeterAssetsDomain meterAssetsDomain) {
		return meterAssetsReadDAO.getMeterAssetsByDept(meterAssetsDomain);
	}

	@Override
	public List<Map<String, Object>> getAssetsByUser(UserDomain t) {
		return meterAssetsReadDAO.getAssetsByUser(t);
	}

	/**
	 * 批量新增
	 * 1、获取起始表号和个数
	 * 2、生成新资产并查重
	 * 3、插入
	 * */
	@Override
	public HttpResult addAssetsList(MeterAssetsDomain t) {
				
		String madeNoBegin = t.getMadeNo();
		if(madeNoBegin==null||"".equals(madeNoBegin)||madeNoBegin.length()<5) {
			
			return new HttpResult<>(HttpResult.ERROR, "更新失败，初始表号为空," +
					"或表长度不符合要求");
		}
		String tempSn = madeNoBegin.substring(madeNoBegin.length()-4, madeNoBegin.length());
		String noHead = madeNoBegin.substring(0,madeNoBegin.length()-4);
		if(!NumberUtils.isNumber(tempSn)) {
			
			return new HttpResult<>(HttpResult.ERROR,
					"更新失败，初始表号后四位非数字格式不能转化成流水号");
		}
		Integer beginSn = Integer.valueOf(tempSn);
		Integer assetsNum = t.getAssetsNum();
		if(assetsNum==null||assetsNum==0) {
			
			return new HttpResult<>(HttpResult.ERROR, "更新失败，需新增资产个数为0");
		}

		for(int i =0;i<assetsNum;i++) {
	        
			String tempStr = String.format("%04d", beginSn+i);//字符串格式化. 
			String madeNo = noHead +tempStr;
			String assetsNo=CommonUtil.generateFormatNo(madeNo,18,"0",true);
			t.setMadeNo(madeNo);
			t.setMeterAssetsNo(assetsNo);
			List<MeterAssetsDomain> meterAssetsList = meterAssetsReadDAO.findByWhereDC(t);
			if(meterAssetsList.size()>0) {
				return new HttpResult<>(HttpResult.ERROR, "更新失败，资产编号重复");

			}
		//	t.setStatus((byte) 0);//购入
			t.setId(null);
			//入库
			int m = meterAssetsWriteDAO.insert(t);

			if(m!=1) {
				return new HttpResult<>(HttpResult.ERROR, "更新失败，存库失败资产号为："+assetsNo);
			}
			
		}
		
		return new HttpResult<>(HttpResult.SUCCESS, "更新成功，新增条数："+assetsNum);
		
		
	}

	@Override
	public List<MeterAssetsDomain> findByWhereDC(MeterAssetsDomain tt) {
		return meterAssetsReadDAO.findByWhereDC(tt);
	}

	@Override
	public int updateList(List<MeterAssetsDomain> l) {
		return meterAssetsWriteDAO.updateList(l);

	}

	@Override
	public MeterAssetsEntity findMeterEntityByWhere(Long id) {
		return meterAssetsReadDAO.findMeterEntityByWhere(id);
	}

	@Override
	public List<MeterAssetsDomain> getMeterAssetsByAssetsIds(List<Long> idsList) {
		
		List<MeterAssetsDomain> rl =new ArrayList<MeterAssetsDomain>();
		// 处理超过1000个id
		int len = idsList.size();
		for (int m = 0; m < len / 999 + 1; m++) {// 遍历次数

			List<Long> tl = idsList.subList(m * 999, (m + 1) * 999 > len ? len : (m + 1) * 999);

			List<MeterAssetsDomain> tList = meterAssetsReadDAO.getMeterAssetsByAssetsIds(tl);

			rl.addAll(tList);

		}

		return rl;
		
	}
	
	
	@Override
	public List<MeterAssetsEntity> getMeterAssetsByFunctionCode(Map ids){
		return meterAssetsReadDAO.getMeterAssetsByFunctionCode(ids);
	}
	
	@Override
	public int insertList(List<MeterAssetsDomain> rl) {
		return meterAssetsWriteDAO.insertList(rl);
	}

	@Override
	public List<MeterAssetsDomain> getMeterAssetsByNos( List<MeterAssetsDomain> meterAssetsNos) {
		return meterAssetsReadDAO.getMeterAssetsByNos(meterAssetsNos);
	}

	@Override
	public HttpResult deleteList(List<MeterAssetsDomain> deleteList) throws Exception {
		int num = meterAssetsWriteDAO.deleteList(deleteList);
		if(num==deleteList.size()) {
			return new HttpResult(HttpResult.SUCCESS,"删除成功，删除条数："+num);
		}else {
			throw new Exception();
		}
	}
	
	
}
