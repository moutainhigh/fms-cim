/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:37:16
 *    Title:com.riozenc.cim.webapp.action.MeterReplaceInfoAction.java
 **/
package org.fms.cim.server.webapp.archives.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.fms.cim.common.domain.archives.LastCodeEntity;
import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.MeterReplaceDomain;
import org.fms.cim.common.service.IMeterInductorAssetsService;
import org.fms.cim.common.service.IMeterMeterAssetsService;
import org.fms.cim.common.service.IMeterReplaceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;

import reactor.core.publisher.Mono;

@ControllerAdvice
@RequestMapping("meterReplaceInfo")
public class MeterReplaceInfoAction {

	@Autowired
	@Qualifier("meterReplaceInfoServiceImpl")
	private IMeterReplaceInfoService meterReplaceInfoService;

	@Autowired
	@Qualifier("meterMeterAssetsServiceImpl")
	private IMeterMeterAssetsService meterMeterAssetsService;

	@Autowired
	@Qualifier("meterInductorAssetsServiceImpl")
	private IMeterInductorAssetsService meterInductorAssetsService;
	
	//装表、ct、pt；拆表、pt、ct通用方法
	@ResponseBody
	@PostMapping(params = "method=changeDev")
	public HttpResult changeDev(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		JsonNode jsonNode = JSONUtil.readValue(body, JsonNode.class);
       
    	List<LastCodeEntity> lastCodeEntityList = 
			JSONUtil.readValue(jsonNode.get("workTableDataByRemove").toString(), new TypeReference<List<LastCodeEntity>>() {});

    	HttpResult httpResult = meterReplaceInfoService.changeDev(jsonNode.get("meterReplace").toString(),lastCodeEntityList);
		
    	return httpResult;
	}
	
//	
//	@ResponseBody
//	@PostMapping(params = "method=changeDevByList")
//	public Mono<HttpResult> changeDevByList(@RequestBody String body)
//			throws JsonParseException, JsonMappingException, IOException {
//		JsonNode jsonNode = JSONUtil.readValue(body, JsonNode.class);
//       
//    	List<LastCodeEntity> lastCodeEntityList = 
//			JSONUtil.readValue(jsonNode.get("workTableDataByRemove").toString(), new TypeReference<List<LastCodeEntity>>() {});
//
//		HashMap<String,Object> rmap = meterReplaceInfoService.changeDev(jsonNode.get("meterReplace").toString(),lastCodeEntityList);
//		
//	//	HashMap<String,Object> rmap = meterReplaceInfoService.changeDev(body);
//		if((boolean)rmap.get("result")) {
//			return Mono.just(new HttpResult(HttpResult.SUCCESS,rmap.get("massage").toString()));
//		}
//        return Mono.just(new HttpResult(HttpResult.ERROR, rmap.get("massage").toString()));
//	}
	
	
	
	//装拆表专用电能表资产查询
	@ResponseBody
	@PostMapping(params = "method=findMeterAssetsByDept")
	public Mono<HttpResultPagination<?>> findMeterAssetsByDept(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException{
		
		
		
		
		
		return null;	
	}
	
	
	@ResponseBody
	@PostMapping(params = "method=addMeterReplaceInfo")
	public Mono<HttpResult> addMeterReplaceInfo(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		MeterReplaceDomain e = GsonUtils.readValue(body, MeterReplaceDomain.class);
		e.setCreateDate(new Date());
		e.setOperator(Long.parseLong(e.getManagerId()));
		int count = meterReplaceInfoService.insert(e);
		if(count>0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "新增换表记录信息成功"));
		}
		return Mono.just(new HttpResult(HttpResult.ERROR, "新增换表记录信息失败"));	
	}
	
//	//查历史记录
//	@ResponseBody
//	@PostMapping(params = "method=getMeterReplaceInfoByMpedId")
//	public HttpResult getMeterReplaceInfoByMpedId(@RequestBody String body)
//			throws JsonParseException, JsonMappingException, IOException {
//		MeterDomain e = GsonUtils.readValue(body, MeterDomain.class);
//		MeterReplaceDomain receiveReplace=GsonUtils.readValue(body,MeterReplaceDomain.class);
//		MeterReplaceDomain mr = new MeterReplaceDomain();
//		mr.setMeterId(e.getId());
//		HttpResult httpResult = new HttpResult();
//		httpResult.setResultData(meterReplaceInfoService.findByMeter(mr));
//		return httpResult;
//	}
	
	//查历史记录
	@ResponseBody
	@PostMapping(params = "method=getMeterReplaceInfoByMpedId")
	public Mono<HttpResultPagination<?>> getMeterReplaceInfoByMpedId(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		MeterDomain e = GsonUtils.readValue(body, MeterDomain.class);
		MeterReplaceDomain receiveReplace=GsonUtils.readValue(body,MeterReplaceDomain.class);
		MeterReplaceDomain mr = new MeterReplaceDomain();
		mr.setMeterId(e.getId());
		//根据设备类型
  //    mr.setEquipmentType(receiveReplace.getEquipmentType());
		return Mono.just(new HttpResultPagination(e,meterReplaceInfoService.findByMeter(mr)));

	}
	
	@ResponseBody
	@PostMapping(params = "method=getMeterReplaceInfoByWhere")
	public Mono<HttpResultPagination<?>> getMeterReplaceInfoByWhere(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		MeterReplaceDomain e = GsonUtils.readValue(body, MeterReplaceDomain.class);
		return Mono.just(new HttpResultPagination(e,meterReplaceInfoService.findByWhere(e)));

	}
	
	@ResponseBody
	@PostMapping(params = "method=getMeterReplaceInfoByKey")
	public Mono<MeterReplaceDomain> getMeterReplaceInfoByKey(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		MeterReplaceDomain e = GsonUtils.readValue(body, MeterReplaceDomain.class);
		return Mono.just(meterReplaceInfoService.findByKey(e));
	}

	@ResponseBody
	@PostMapping(params = "method=updateMeterReplaceInfo")
	public Mono<HttpResult> updateMeterReplaceInfo(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		MeterReplaceDomain e = GsonUtils.readValue(body, MeterReplaceDomain.class);
		int count = meterReplaceInfoService.update(e);
		e.setCreateDate(new Date());
		e.setOperator(Long.parseLong(e.getManagerId()));

		if (count > 0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "修改换表记录信息成功"));
		} else {
			return Mono.just(new HttpResult(HttpResult.ERROR, "修改换表记录信息失败"));
		}
	}

	@ResponseBody
	@PostMapping(params = "method=getLastCodeByMeter")
	public Mono<List<LastCodeEntity>> getLastCodeByMeter(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		MeterReplaceDomain e = GsonUtils.readValue(body, MeterReplaceDomain.class);
		return Mono.just(meterReplaceInfoService.getLastCodeByMeter(e));
	}


}
