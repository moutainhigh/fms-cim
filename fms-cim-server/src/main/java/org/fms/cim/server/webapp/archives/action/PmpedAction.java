/**
 *    Auth:riozenc
 *    Date:2019年3月14日 上午8:50:19
 *    Title:com.riozenc.cim.webapp.action.MeterAction.java
 **/
package org.fms.cim.server.webapp.archives.action;

import java.io.IOException;

import org.fms.cim.common.domain.archives.PMpedDomain;
import org.fms.cim.common.service.IPmpedService;
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
@RequestMapping("pemped")
public class PmpedAction {

	@Autowired
	@Qualifier("pmpedServiceImpl")
	private IPmpedService pmpedService;

	@ResponseBody
	@PostMapping(params = "method=getPmped")
	public HttpResultPagination<?> getAllLinePmped(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		PMpedDomain t = GsonUtils.readValue(body, PMpedDomain.class);

		return new HttpResultPagination(t,pmpedService.findByWhere(t));
	}
	
	@ResponseBody
	@PostMapping(params = "method=getPmpedByKey")
	public PMpedDomain getPmpedByKey(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		PMpedDomain t = GsonUtils.readValue(body, PMpedDomain.class);

		return pmpedService.findByKey(t);
	}
	
	@ResponseBody
	@PostMapping(params = "method=addABus")
	public Mono<HttpResult> addPmped(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		PMpedDomain t = GsonUtils.readValue(body, PMpedDomain.class);
	
		int count = pmpedService.insert(t);
		if(count>0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "新增测量点信息成功"));
		}
		return Mono.just(new HttpResult(HttpResult.ERROR, "新增测量点信息失败"));

	}
	
	@ResponseBody
	@PostMapping(params = "method=updateABus")
	public Mono<HttpResult> updatePmped(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		PMpedDomain t = GsonUtils.readValue(body, PMpedDomain.class);
		int count = pmpedService.update(t);
		if(count>0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "更新测量点信息成功"));
		}
		return Mono.just(new HttpResult(HttpResult.ERROR, "更新测量点信息失败"));
	}


}
