package org.fms.cim.server.webapp.assets.action;

import java.io.IOException;

import org.fms.cim.common.domain.assets.PSimCardDomain;
import org.fms.cim.common.service.IPsimCardService;
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
 *SIM卡档案
 *
 */
@ControllerAdvice
@RequestMapping("psimcard")
public class PsimCardAction {
	
	@Autowired
	@Qualifier("psimCardServiceImpl")
	private IPsimCardService psimcardService;
	
	@ResponseBody
	@PostMapping(params = "method=getPsimCard")
	public HttpResultPagination<?> getAllPsimCard(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		PSimCardDomain t = GsonUtils.readValue(body, PSimCardDomain.class);

		return new HttpResultPagination(t,psimcardService.findByWhere(t));
	}
	
	@ResponseBody
	@PostMapping(params = "method=getPsimCardByKey")
	public PSimCardDomain getPsimCardByKey(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		PSimCardDomain t = GsonUtils.readValue(body, PSimCardDomain.class);

		return psimcardService.findByKey(t);
	}
	
	@ResponseBody
	@PostMapping(params = "method=addPsimCard")
	public Mono<HttpResult> addPsimCard(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		PSimCardDomain t = GsonUtils.readValue(body, PSimCardDomain.class);
	
		int count = psimcardService.insert(t);
		if(count>0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "新增SIM信息成功"));
		}
		return Mono.just(new HttpResult(HttpResult.ERROR, "新增SIM信息失败"));

	}
	
	@ResponseBody
	@PostMapping(params = "method=updatePsimCard")
	public Mono<HttpResult> updatePsimCard(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		PSimCardDomain t = GsonUtils.readValue(body, PSimCardDomain.class);
		int count = psimcardService.update(t);
		if(count>0) {
			return Mono.just(new HttpResult(HttpResult.SUCCESS, "更新SIM信息成功"));
		}
		return Mono.just(new HttpResult(HttpResult.ERROR, "更新SIM信息失败"));
	}
}

