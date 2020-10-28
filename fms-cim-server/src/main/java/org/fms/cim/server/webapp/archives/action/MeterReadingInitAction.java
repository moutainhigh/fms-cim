/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:37:16
 *    Title:com.riozenc.cim.webapp.action.MeterReadingInitAction.java
 **/
package org.fms.cim.server.webapp.archives.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.service.IMeterReadingInitService;
import org.fms.cim.common.service.IMeterService;
import org.fms.cim.common.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.riozenc.titanTool.common.json.utils.GsonUtils;
import com.riozenc.titanTool.common.json.utils.JSONUtil;
import com.riozenc.titanTool.spring.web.client.TitanTemplate;
import com.riozenc.titanTool.spring.web.http.HttpResult;

@ControllerAdvice
@RequestMapping("meterReadingInit")
public class MeterReadingInitAction {

	@Autowired
	@Qualifier("meterReadingInitServiceImpl2")
	private IMeterReadingInitService meterReadingInitService;
	@Autowired
	@Qualifier("userServiceImpl")
	private IUserService userService;
    @Autowired
    @Qualifier("meterServiceImpl")
    private IMeterService meterService;
	@Autowired
	private TitanTemplate titanTemplate;
    
	
	// 根据客户抄表初始化
	@ResponseBody
	@PostMapping(params = "method=meterReadingInitByCustomer")
	public HttpResult meterReadingInitByCustomer(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		JsonNode jsonNode = JSONUtil.readValue(body, JsonNode.class);

		if (jsonNode.get("ids") != null && jsonNode.get("ids").isArray()) {
			List<Long> ids = JSONUtil.readValue(jsonNode.get("ids").toString(), new TypeReference<List<Long>>() {
			});

			String sn = jsonNode.get("sn").toString();

			return meterReadingInitService.meterReadingInitByCustomer(ids, sn);
		} else {
			return new HttpResult<>(HttpResult.ERROR, "未选择客户");
		}

	}
	
	// 根据用电户抄表初始化
	@ResponseBody
	@PostMapping(params = "method=meterReadingInitByUser")
	public HttpResult meterReadingInitByUser(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		JsonNode jsonNode = JSONUtil.readValue(body, JsonNode.class);

		if (jsonNode.get("ids") != null && jsonNode.get("ids").isArray()) {
			List<Long> ids = JSONUtil.readValue(jsonNode.get("ids").toString(), new TypeReference<List<Long>>() {
			});

			String sn = jsonNode.get("sn").toString();

			return meterReadingInitService.meterReadingInitByUser(ids, sn);
		} else {
			return new HttpResult<>(HttpResult.ERROR, "未选择用电户");
		}

	}
	

	// 根据抄表段抄表初始化
	@ResponseBody
	@PostMapping(params = "method=meterReadingInitByWriteSec")
	public HttpResult meterReadingInitByWriteSec(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
//		Long btime = System.currentTimeMillis();
//		Long etime = System.currentTimeMillis();
		JsonNode jsonNode = JSONUtil.readValue(body, JsonNode.class);

		if (jsonNode.get("ids") != null && jsonNode.get("ids").isArray()) {
			List<Long> ids = JSONUtil.readValue(jsonNode.get("ids").toString(), new TypeReference<List<Long>>() {
			});
			String sn = jsonNode.get("sn").toString();

			return meterReadingInitService.meterReadingInitByWriteSec(ids, sn);

		} else {
			return new HttpResult<>(HttpResult.ERROR, "未选择抄表段");
		}

	}
	
	//获取未初始化的用户
	@ResponseBody
	@PostMapping(params = "method=getUserInfoForInit")
	public List<MeterDomain> getUserInfoForInit(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		UserDomain userDomain = GsonUtils.readValue(body, UserDomain.class);
		//获取用户
		List<UserDomain> userList = userService.findByWhere(userDomain);
		List<Long> userIds = userList.stream().map(UserDomain::getId).collect(Collectors.toList());
		
		//去mysql根据用户获取计量点
		List<MeterDomain> meterListFromMySql = meterService.getMeterByUserIds(userIds);
		
		if(userDomain.getStatus()-99 ==0) {
			//去monogo根据用户获取计量点
			List<MeterDomain> meterListFromMonogo = getElectricMeterFromMonogoByUserIds(userIds);

			//去掉monogo中已经存在的记录（electric_meter存在视为已初始化）
			return meterListFromMySql.stream().
					filter(m -> !meterListFromMonogo.contains(m)).collect(Collectors.toList());
			
		}

		return meterListFromMySql;
	}


	public List<MeterDomain> getElectricMeterFromMonogoByUserIds(List<Long> userIds) {
		
		HashMap<String, Object> tempMap = new HashMap<String, Object>();
		
		tempMap.put("userIds", userIds);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		List<MeterDomain> meterList = new ArrayList<MeterDomain>();
		
		try {
			meterList = titanTemplate.post("BILLING-SERVER","billingServer/meter?method=findMeterDomain", 
					httpHeaders, tempMap,new TypeReference<List<MeterDomain>>() {});

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return meterList;
		
	}

	//日测算档案获取
	@ResponseBody
	@PostMapping(params = "method=meterReadingInitDaily")
	public HttpResult meterReadingInitDaily(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {

		JsonNode jsonNode = JSONUtil.readValue(body, JsonNode.class);
		List<Long> ids = new ArrayList<Long>();
		if (jsonNode.get("ids") != null && jsonNode.get("ids").isArray()) {
			ids = JSONUtil.readValue(jsonNode.get("ids").toString(), new TypeReference<List<Long>>() {});
		}
		return meterReadingInitService.meterReadingInitDaily(ids);


	}
	
	
	
	
	
}
