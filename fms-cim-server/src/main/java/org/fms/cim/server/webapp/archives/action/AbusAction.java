package org.fms.cim.server.webapp.archives.action;

import java.io.IOException;

import org.fms.cim.common.domain.archives.ABusDomain;
import org.fms.cim.common.service.IAbusService;
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
 * 母线
 * 
 * @author qxw
 *
 */
@ControllerAdvice
@RequestMapping("abus")
public class AbusAction {
	
	@Autowired
	@Qualifier("abusServiceImpl")
	private IAbusService abusService;
	
	@ResponseBody
	@PostMapping(params = "method=getABus")
	public HttpResultPagination<?> getAllLineABus(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		ABusDomain t = GsonUtils.readValue(body, ABusDomain.class);

		return new HttpResultPagination(t,abusService.findByWhere(t));
	}
	
	@ResponseBody
	@PostMapping(params = "method=getABusByKey")
	public ABusDomain getABusByKey(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		ABusDomain t = GsonUtils.readValue(body, ABusDomain.class);

		return abusService.findByKey(t);
	}
	
	@ResponseBody
	@PostMapping(params = "method=addABus")
	public Mono<HttpResult> addABus(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		ABusDomain t = GsonUtils.readValue(body, ABusDomain.class);
	
		int count = abusService.insert(t);
		if(count>0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "新增母线信息成功"));
		}
		return Mono.just(new HttpResult(HttpResult.ERROR, "新增母线信息失败"));

	}
	
	@ResponseBody
	@PostMapping(params = "method=updateABus")
	public Mono<HttpResult> updateABus(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		ABusDomain t = GsonUtils.readValue(body, ABusDomain.class);
		int count = abusService.update(t);
		if(count>0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "更新母线信息成功"));
		}
		return Mono.just(new HttpResult(HttpResult.ERROR, "更新母线信息失败"));
	}
}
