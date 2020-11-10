package org.fms.cim.server.webapp.assets.action;

import java.io.IOException;

import org.fms.cim.common.domain.assets.ATmnlDomain;
import org.fms.cim.common.service.IAtmnlService;
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

/**
 * 
 * 设备终端
 * 
 *
 */
@ControllerAdvice
@RequestMapping("atmnl")
public class AtmnlAction {
	
	@Autowired
	@Qualifier("atmnlServiceImpl")
	private IAtmnlService atmnlService;
	
	@ResponseBody
	@PostMapping(params = "method=getATmnl")
	public HttpResultPagination<?> getAllATmnl(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		ATmnlDomain t = GsonUtils.readValue(body, ATmnlDomain.class);

		return new HttpResultPagination(t,atmnlService.findByWhere(t));
	}
	
	@ResponseBody
	@PostMapping(params = "method=getATmnlByKey")
	public ATmnlDomain getATmnlByKey(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		ATmnlDomain t = GsonUtils.readValue(body, ATmnlDomain.class);

		return atmnlService.findByKey(t);
	}
	
	@ResponseBody
	@PostMapping(params = "method=addATmnl")
	public Mono<HttpResult> addATmnl(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		ATmnlDomain t = GsonUtils.readValue(body, ATmnlDomain.class);
		
		int count = atmnlService.insert(t);
		if(count>0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "新增终端设备信息成功"));
		}
		return Mono.just(new HttpResult(HttpResult.ERROR, "新增终端设备信息失败"));

	}
	
	@ResponseBody
	@PostMapping(params = "method=updateATmnl")
	public Mono<HttpResult> updateATmnl(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		ATmnlDomain t = GsonUtils.readValue(body, ATmnlDomain.class);
		int count = atmnlService.update(t);
		if(count>0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "更新终端设备信息成功"));
		}
		return Mono.just(new HttpResult(HttpResult.ERROR, "更新终端设备信息失败"));
	}
}

