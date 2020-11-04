/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.fms.cim.common.domain.archives.DeptMonDomain;
import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.service.ICustomerService;
import org.fms.cim.common.service.IMeterInductorAssetsService;
import org.fms.cim.common.service.IMeterMeterAssetsService;
import org.fms.cim.common.service.IMeterReadingInitService;
import org.fms.cim.common.service.IMeterRelationService;
import org.fms.cim.common.service.IMeterReplaceInfoService;
import org.fms.cim.common.service.IMeterService;
import org.fms.cim.common.service.ITransformerMeterRelationService;
import org.fms.cim.common.service.ITransformerService;
import org.fms.cim.common.service.IUserService;
import org.fms.cim.common.service.IWriteSectService;
import org.fms.cim.server.webapp.archives.dao.MeterReadingInitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.type.TypeReference;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.spring.web.client.TitanTemplate;
import com.riozenc.titanTool.spring.web.http.HttpResult;

//多线程查询+单次post
@TransactionService
public class MeterReadingInitServiceImpl2 implements IMeterReadingInitService {

	@Autowired
	private TitanTemplate titanTemplate;
	@Autowired
	@Qualifier("meterServiceImpl")
	private IMeterService meterService;
	@Autowired
	@Qualifier("meterRelationServiceImpl")
	private IMeterRelationService meterRelationService;
	@Autowired
	@Qualifier("meterReplaceInfoServiceImpl")
	private IMeterReplaceInfoService meterReplaceInfoService;
	@Autowired
	@Qualifier("transformerServiceImpl")
	private ITransformerService transformerService;
	@Autowired
	@Qualifier("transformerMeterRelationServiceImpl")
	private ITransformerMeterRelationService transformerMeterRelationService;
	@Autowired
	@Qualifier("userServiceImpl")
	private IUserService userService;
	@Autowired
	@Qualifier("customerServiceImpl")
	private ICustomerService customerService;
	@Autowired
	@Qualifier("writeSectServiceImpl")
	private IWriteSectService writeSectService;
	@Autowired
	@Qualifier("meterMeterAssetsServiceImpl")
	private IMeterMeterAssetsService meterMeterAssetsService;
	@Autowired
	@Qualifier("meterInductorAssetsServiceImpl")
	private IMeterInductorAssetsService meterInductorAssetsService;
	
	@TransactionDAO
	private MeterReadingInitDAO meterReadingInitDAO;

	private final ExecutorService executorService = Executors.newFixedThreadPool(10);

	private Long btime = (long) 0;
	private Long etime = (long) 0;
	
	// 按客户ID初始化
	@Override
	public HttpResult meterReadingInitByCustomer(List<Long> customerIds, String sn) {

		if (customerIds.size() == 0) {
			return new HttpResult(HttpResult.ERROR, "无所选客户");
		}

		List<UserDomain> userList = userService.getUserByCustomerIds(customerIds);
		if (userList.size() == 0) {
			return new HttpResult(HttpResult.ERROR, "所选客户无用户");
		}
		//userIDS去重
		HashSet<Long> userIdSet = new HashSet<Long>();
		for(UserDomain tempuser :userList) {
			userIdSet.add(tempuser.getId());
		}
		List<Long> userIdList = new ArrayList<Long>(userIdSet);
		// 获取用户获取所属dept

		List<Long> deptIds = userService.getDeptIdsByUserIds(userIdList);
		
		if (deptIds.size() == 0) {
			return new HttpResult(HttpResult.ERROR, "用户无管理单位");
		}
		HashMap<String, Object> remap = getCurrentMon(deptIds);
		String mon = "202001";
		if (!(boolean) remap.get("result")) {
			return new HttpResult(HttpResult.ERROR, remap.get("massage").toString());
		}else {
			mon = remap.get("mon").toString();
		}

		List<MeterDomain> meterList = meterService.getMeterByUserIds(userIdList);

		if (meterList.size() == 0) {
			return new HttpResult(HttpResult.ERROR, "所选客户无计量点");
		}


		return cfsPost(userList, meterList, mon, sn);

	}
	
	
	// 按用户ID初始化
	@Override
	public HttpResult meterReadingInitByUser(List<Long> ids, String sn) {

		// 获取用户获取所属dept
		List<Long> deptIds = userService.getDeptIdsByUserIds(ids);
		
		if (deptIds.size() == 0) {
			return new HttpResult(HttpResult.ERROR, "用户无管理单位");
		}
		HashMap<String, Object> remap = getCurrentMon(deptIds);
		String mon = "202001";
		if (!(boolean) remap.get("result")) {
			return new HttpResult(HttpResult.ERROR, remap.get("massage").toString());
		}else {
			mon = remap.get("mon").toString();
		}

		List<UserDomain> userList = userService.getUserByIds(ids);

		List<MeterDomain> meterList = meterService.getMeterByUserIds(ids);

		if (meterList.size() == 0) {
			return new HttpResult(HttpResult.ERROR, "所选客户无计量点");
		}


		return cfsPost(userList, meterList, mon, sn);

	}
	

	// 按照抄表段id初始化
	@Override
	public HttpResult meterReadingInitByWriteSec(List<Long> writeSectIds, String sn) {
		btime = System.currentTimeMillis();

		if (writeSectIds == null || writeSectIds.size() == 0) {
			return new HttpResult(HttpResult.ERROR, "未选择抄表段");
		}
		// 获取抄表段所属dept
		List<Long> deptIds = writeSectService.getDeptIdsByWriteSectIds(writeSectIds);
		if (deptIds == null || deptIds.size() == 0) {
			return new HttpResult(HttpResult.ERROR, "抄表段无管理单位");
		}
		// 电费月份判断
		HashMap<String, Object> remap = getCurrentMon(deptIds);
		if (!(boolean) remap.get("result")) {
			return new HttpResult(HttpResult.ERROR, remap.get("massage").toString());
		}
		
//		// 根据抄表区段ID获取用户
//		List<UserDomain> userList = userService.getUserByWriteSectIds(writeSectIds);
//		if (userList.size() == 0) {
//			return new HttpResult(HttpResult.ERROR, "无用户");
//		}
//		HashSet<Long> userIdSet = new HashSet<Long>();
//		for(UserDomain tempuser :userList) {
//			userIdSet.add(tempuser.getId());
//		}
//		List<Long> userIdList = new ArrayList<Long>(userIdSet);
//		// 根据用户  获取测量点
//		List<MeterDomain> meterList = meterService.getMeterByUserIds(userIdList);
//		// 根据抄表区段  获取测量点---未处理套扣关系关联的计量点
////		List<MeterDomain> meterList = meterService.getMeterByWriteSectIds(writeSectIds);
//		
//		if (meterList.size() == 0) {
//			return new HttpResult(HttpResult.ERROR, "无计量点");
//		}

//		return cfsPost(userList, meterList, remap.get("mon").toString(), sn,writeSectIds);
		return cfsPost(remap.get("mon").toString(), sn,writeSectIds);

	}

	// 调用cfs抄表初始化 ------- 根据客户
	private HttpResult cfsPost(List<UserDomain> userList, List<MeterDomain> meterList, String mon, String sn) {

		HashMap<String, Object> cimMap = new HashMap<String, Object>();
		HashSet<Long> meterIdsSet = new HashSet<Long>();
		for(MeterDomain tempuser :meterList) {
			meterIdsSet.add(tempuser.getId());
		}
		List<Long> meterIdsList = new ArrayList<Long>(meterIdsSet);

		// 抄表次数
		cimMap.put("sn", sn);
		// 月份
		cimMap.put("date", mon);
		// 用电户
		cimMap.put("userDomains", userList);
		// 计量点
		cimMap.put("meterDomains", meterList);
		// 计量点关系
		cimMap.put("meterRelationDomains", meterService.getMeterRelByMeterIds(meterIdsList));
		// 换表记录
		cimMap.put("meterReplaceDomains", meterReplaceInfoService.getMeterReplaceByMeterIds(meterIdsList));
		// 测量点与变压器关系
		cimMap.put("transformerMeterRelationDomains",
				transformerMeterRelationService.getTransformerMeterRelationByMeterIds(meterIdsList));
		// 变压器
		cimMap.put("transformerDomains", transformerService.getTransformerByMeterIds(meterIdsList));
		// 计量点与表计的关系
		cimMap.put("meterMeterAssetsRelDomains", meterMeterAssetsService.getMeterAssetsByMeterIds(meterIdsList));
		// 计量点与互感器的关系
		cimMap.put("meterInductorAssetsRelDomains", meterInductorAssetsService.getMeterInductorByMeterIds(meterIdsList));


		try {
			return titanTemplate.post("CFS", "cfs/billingDataInit?method=initializeMany", null, cimMap,
					HttpResult.class);
		} catch (Exception e) {

			return new HttpResult(HttpResult.ERROR, "抄表初始化失败,CFS服务异常");
		}

	}

	// 调用cfs抄表初始化 ------- 根据抄表区段
	private HttpResult cfsPost(String mon, String sn,List<Long> writeSectIds) {

		//TODO  需要根据计量点套扣关系获取关系用户和计量点-------------暂未实现
		HashMap<String, Object> cimMap = new HashMap<String, Object>();

		// 抄表次数
		cimMap.put("sn", sn);
		// 月份
		cimMap.put("date", mon);
		
		try {
			// 用户
//				cimMap.put("meterRelationDomains", meterRelationService.getMeterRelationByWriteSectIds(writeSectIds));
			cimMap.put("userDomains", futureGet(new Callable<Object>() {
				@Override
				public Object call() throws Exception {
					return userService.getUserByWriteSectIds(writeSectIds);
				}
			}));
			
			
			// 计量点
//				cimMap.put("meterRelationDomains", meterRelationService.getMeterRelationByWriteSectIds(writeSectIds));
			cimMap.put("meterDomains", futureGet(new Callable<Object>() {
				@Override
				public Object call() throws Exception {
					return meterService.getMeterByWriteSectIds(writeSectIds);
				}
			}));
			
			
			// 计量点关系
//				cimMap.put("meterRelationDomains", meterRelationService.getMeterRelationByWriteSectIds(writeSectIds));
			cimMap.put("meterRelationDomains", futureGet(new Callable<Object>() {
				@Override
				public Object call() throws Exception {
					return meterRelationService.getMeterRelationByWriteSectIds(writeSectIds);
				}
			}));

			// 换表记录
//				cimMap.put("meterReplaceDomains", meterReplaceInfoService.getMeterReplaceByWriteSectIds(writeSectIds));
			cimMap.put("meterReplaceDomains", futureGet(new Callable<Object>() {
				@Override
				public Object call() throws Exception {
					return meterReplaceInfoService.getMeterReplaceByWriteSectIds(writeSectIds);
				}
			}));
			
			
			// 测量点与变压器关系
//				cimMap.put("transformerMeterRelationDomains",
//						transformerMeterRelationService.getTransformerMeterRelationByWriteSectId(writeSectIds));
			cimMap.put("transformerMeterRelationDomains", futureGet(new Callable<Object>() {
				@Override
				public Object call() throws Exception {
					return transformerMeterRelationService.getTransformerMeterRelationByWriteSectId(writeSectIds);
				}
			}));
			
			
			// 变压器
//				cimMap.put("transformerDomains", transformerService.getTransformerByWriteSectIds(writeSectIds));
			cimMap.put("transformerDomains", futureGet(new Callable<Object>() {
				@Override
				public Object call() throws Exception {
					return transformerService.getTransformerByWriteSectIds(writeSectIds);
				}
			}));
			
			
			// 计量点与表计的关系
//				cimMap.put("meterMeterAssetsRelDomains",
//						meterMeterAssetsService.getMeterAssetsByWriteSectIds(writeSectIds));
			cimMap.put("meterMeterAssetsRelDomains", futureGet(new Callable<Object>() {
				@Override
				public Object call() throws Exception {
					return meterMeterAssetsService.getMeterAssetsByWriteSectIds(writeSectIds);
				}
			}));
			
			
			// 计量点与互感器的关系
//				cimMap.put("meterInductorAssetsRelDomains",
//						meterInductorAssetsService.getMeterInductorByWriteSectIds(writeSectIds));
			cimMap.put("meterInductorAssetsRelDomains", futureGet(new Callable<Object>() {
				@Override
				public Object call() throws Exception {
					return meterInductorAssetsService.getMeterInductorByWriteSectIds(writeSectIds);
				}
			}));
			
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		etime = System.currentTimeMillis();
		System.out.println("本次抄表初始化运行时间为"+ (etime - btime)+"ms");

		try {
			return titanTemplate.post("CFS", "cfs/billingDataInit?method=initializeMany", null, cimMap,
					HttpResult.class);
		} catch (Exception e) {

			return new HttpResult(HttpResult.ERROR, "抄表初始化失败,CFS服务异常");
		}

	}

		
	// 获取初始化日期
	private HashMap<String, Object> getCurrentMon(List<Long> ids) {

		HashMap<String, Object> tempMap = new HashMap<String, Object>();
		HashMap<String, Object> reMap = new HashMap<String, Object>();
		Set<Long> tempSet = new HashSet<>();
		for(Long id : ids) {
			tempSet.add(id);
		}
		
		tempMap.put("ids", tempSet);
		reMap.put("result", false);
		reMap.put("massage", "开始获取电费月份");

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		try {
			List<DeptMonDomain> deptMonDomains = titanTemplate.post("BILLING-SERVER",
					"billingServer/deptMon?method=getDeptCurrentMonById", httpHeaders, tempMap,
					new TypeReference<List<DeptMonDomain>>() {
					});

			Set<String> set = deptMonDomains.stream().map(m -> m.getMon()).collect(Collectors.toSet());
			String[] mons = new String[1];
			if (set.size() == 1) {
				set.toArray(mons);
				if (mons[0] != null && !"".equals(mons[0])) {
					reMap.put("result", true);
					reMap.put("mon", mons[0]);
					reMap.put("massage", "获取电费月份成功，当前月份为" + mons[0]);

				} else {
					reMap.put("massage", "所选对象的电费月份异常");
				}

			} else if (set.size() == 0) {
				reMap.put("massage", "获取电费月份失败，当前月份为空");
			} else if (set.size() > 1) {
				reMap.put("massage", "所选对象的电费月份不一致");
			} else {
				reMap.put("massage", "所选对象的电费月份异常");

			}

		} catch (Exception e) {

			reMap.put("massage", "获取电费月份失败，调用biling服务失败");
		}

		return reMap;

	}
	
	private <T> T futureGet(Callable<T> callable) throws InterruptedException, ExecutionException {

		Future<T> future = executorService.submit(callable);

		return future.get();
	}


	@Override
	public HttpResult meterReadingInitDaily(List<Long> ids) {
		// 查询费控用户。如果ids为空查全部
		HashMap<String, Object> cimMap = new HashMap<String, Object>();

		List<MeterDomain> meterList = meterReadingInitDAO.getFKMeterListByIds(ids);
		
		List<Long> meterIdsList = meterList.stream().map(MeterDomain::getId).collect(Collectors.toList());
		// 计量点
		cimMap.put("meterDomains", meterList);
		// 计量点关系
		cimMap.put("meterRelationDomains", meterService.getMeterRelByMeterIds(meterIdsList));
		// 换表记录
		cimMap.put("meterReplaceDomains", meterReplaceInfoService.getMeterReplaceByMeterIds(meterIdsList));
		// 计量点与表计的关系
		cimMap.put("meterMeterAssetsRelDomains", 
				meterMeterAssetsService.getMeterAssetsByMeterIds(meterIdsList)
				//TODO  (qtt)原来此处代码为 .stream().filter(m->m.getFunctionCode()!=null && m.getFunctionCode()-1==0)     // getFunctionCode()原来是byte类型,现在下拉改为String类型,待处理此处逻辑???
				.stream().filter(m->m.getFunctionCode()!=null ).collect(Collectors.toList()));

		return new HttpResult(HttpResult.SUCCESS,"数据查询完成",cimMap);
	}




}
