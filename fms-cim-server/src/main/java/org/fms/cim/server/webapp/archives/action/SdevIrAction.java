package org.fms.cim.server.webapp.archives.action;

import java.io.IOException;

import org.fms.cim.common.domain.archives.SDevIrDomain;
import org.fms.cim.common.service.ISdevIrService;
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
@RequestMapping("sdevir")
public class SdevIrAction {
	
	@Autowired
	@Qualifier("sdevIrServiceImpl")
	private ISdevIrService sdevIrService;
	
	@ResponseBody
	@PostMapping(params = "method=getSDevIr")
	public HttpResultPagination<?> getAllSDevIr(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		SDevIrDomain t = GsonUtils.readValue(body, SDevIrDomain.class);

		return new HttpResultPagination(t,sdevIrService.findByWhere(t));
	}
	
	@ResponseBody
	@PostMapping(params = "method=getSDevIrByKey")
	public SDevIrDomain getSDevIrByKey(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		SDevIrDomain t = GsonUtils.readValue(body, SDevIrDomain.class);

		return sdevIrService.findByKey(t);
	}
	
	@ResponseBody
	@PostMapping(params = "method=addSDevIr")
	public Mono<HttpResult> addSDevIr(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		SDevIrDomain t = GsonUtils.readValue(body, SDevIrDomain.class);
	
		int count = sdevIrService.insert(t);
		if(count>0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "新增成功"));
		}
		return Mono.just(new HttpResult(HttpResult.ERROR, "新增拆信息失败"));

	}
	
	@ResponseBody
	@PostMapping(params = "method=updateSDevIr")
	public Mono<HttpResult> updateSDevIr(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		SDevIrDomain t = GsonUtils.readValue(body, SDevIrDomain.class);
		int count = sdevIrService.update(t);
		if(count>0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "更新装拆信息成功"));
		}
		return Mono.just(new HttpResult(HttpResult.ERROR, "更新装拆信息失败"));
	}
}
