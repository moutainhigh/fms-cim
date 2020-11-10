package org.fms.cim.server.webapp.archives.action;

import java.io.IOException;

import org.fms.cim.common.domain.archives.ABusDomain;
import org.fms.cim.common.domain.archives.DropSqlDomain;
import org.fms.cim.common.service.IAbusService;
import org.fms.cim.common.service.IDropSqlTwoService;
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
 * DROP_SQL
 * @author qxw
 *
 */
@ControllerAdvice
@RequestMapping("dropsql")
public class DropSqlAction {
	
	@Autowired
	@Qualifier("dropSqlTwoService")
	private IDropSqlTwoService dropSqlTwoService;
	
	@ResponseBody
	@PostMapping(params = "method=getABus")
	public HttpResultPagination<?> getAllLineABus(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		DropSqlDomain t = GsonUtils.readValue(body, DropSqlDomain.class);

		return new HttpResultPagination(t,dropSqlTwoService.findByWhere(t));
	}
	
}
