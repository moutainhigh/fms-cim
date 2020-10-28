/**
 *    Auth:riozenc
 *    Date:2019年3月14日 上午8:50:19
 *    Title:com.riozenc.cim.webapp.action.MeterAction.java
 **/
package org.fms.cim.server.webapp.archives.action;

import java.io.IOException;

import org.fms.cim.common.domain.archives.SubsLineRelaDomain;
import org.fms.cim.common.service.ISubsLineRelaService;
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
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;

@ControllerAdvice
@RequestMapping("subsLineRela")
public class SubsLineRelaAction {

	@Autowired
	@Qualifier("subsLineRelaServiceImpl")
	private ISubsLineRelaService subsLineRelaService;

	@ResponseBody
	@PostMapping(params = "method=getsubsLineRela")
	public HttpResultPagination<?> getsubsLineRela(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		SubsLineRelaDomain subsLineRelaDomain = GsonUtils.readValue(body,
				SubsLineRelaDomain.class);
		return new HttpResultPagination(subsLineRelaDomain,subsLineRelaService.findByWhere(subsLineRelaDomain));
	}
	


}
