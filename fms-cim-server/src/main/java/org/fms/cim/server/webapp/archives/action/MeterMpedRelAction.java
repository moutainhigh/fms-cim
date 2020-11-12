/**
 *   qt
 *   计费点与计量点关系
 **/
package org.fms.cim.server.webapp.archives.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.fms.cim.common.domain.archives.MeterMpedRelDomain;
import org.fms.cim.common.service.IMeterMpedRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.riozenc.titanTool.common.json.utils.GsonUtils;
import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;

import reactor.core.publisher.Mono;

@ControllerAdvice
@RequestMapping("meterMpedRel")
public class MeterMpedRelAction {

	@Autowired
	@Qualifier("meterMpedRelServiceImpl")
	private IMeterMpedRelService meterMpedRelService;

	@ResponseBody
	@PostMapping(params = "method=getMeterMpedRel")
	public HttpResultPagination<?> getBank(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		MeterMpedRelDomain t = GsonUtils.readValue(body, MeterMpedRelDomain.class);
		return new HttpResultPagination(t,meterMpedRelService.findByWhere(t));
	}
	
	@ResponseBody
	@PostMapping(params = "method=getMeterMpedRelList")
	public List<MeterMpedRelDomain> getBankList(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		MeterMpedRelDomain t = GsonUtils.readValue(body, MeterMpedRelDomain.class);
		return meterMpedRelService.findByWhere(t);
	}
	
	@ResponseBody
	@PostMapping(params = "method=getMeterMpedRelByKey")
	public MeterMpedRelDomain getBankByKey(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		MeterMpedRelDomain t = GsonUtils.readValue(body, MeterMpedRelDomain.class);
		return meterMpedRelService.findByKey(t);
	}


	@ResponseBody
	@PostMapping(params = "method=addMeterMpedRel")
	public Mono<HttpResult> addBank(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		MeterMpedRelDomain t = GsonUtils.readValue(body, MeterMpedRelDomain.class);
		
		String pss = t.getPhaseSeq();
		MeterMpedRelDomain tt = new MeterMpedRelDomain();
		
		tt.setMeterId(t.getMeterId());
		
		List<MeterMpedRelDomain> list =  meterMpedRelService.findByWhere(tt);
		
		if(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				String ps = list.get(i).getPhaseSeq();
				if(pss.equals(ps)) {
					switch(pss) {
						case "1":{
							return Mono.just(new HttpResult(HttpResult.ERROR, "已存在相序A，请选择其他相序"));
						}
						case "2":{
							return Mono.just(new HttpResult(HttpResult.ERROR, "已存在相序B，请选择其他相序"));
						}
						case "3":{
							return Mono.just(new HttpResult(HttpResult.ERROR, "已存在相序C，请选择其他相序"));
						}
						case "4":{
							return Mono.just(new HttpResult(HttpResult.ERROR, "已存在相序D，不能继续选择相序"));
						}
					}
					
				}
				
			}
		}
		t.setCreateDate(new Date());
		int count = meterMpedRelService.insert(t);
		
		if(count>0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "新增计费点与计量点关系成功"));
		}
		return Mono.just(new HttpResult(HttpResult.ERROR, "新增计费点与计量点关系失败"));

	}

	@ResponseBody
	@PostMapping(params = "method=updateMeterMpedRel")
	public Mono<HttpResult> updateBank(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		MeterMpedRelDomain t = GsonUtils.readValue(body, MeterMpedRelDomain.class);
		int count = meterMpedRelService.update(t);
		if(count>0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "更新计费点与计量点关系成功"));
		}
		return Mono.just(new HttpResult(HttpResult.ERROR, "更新计费点与计量点关系失败"));
	}

}
