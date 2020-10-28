package org.fms.cim.server.webapp.archives.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.service.IPrePaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.riozenc.titanTool.common.json.utils.JSONUtil;

@ControllerAdvice
@RequestMapping("prePaid")
public class PrePaidAction {

	@Autowired
	@Qualifier("prePaidServiceImpl")
	private IPrePaidService prePaidService;

	/**
	 * 返回费控用户和计量点
	 * @return Map<settlementNo,List<MeterDomain>>
	 */
	@ResponseBody
	@RequestMapping(params = "method=getSettlementAndMeter")
	public Map<Long,List<MeterDomain>> getSettlementAndMeter(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		MeterDomain meterDomain = JSONUtil.readValue(body, MeterDomain.class);

		return prePaidService.getSettlementAndMeter(meterDomain);

	}
	
	/**
	 * 返回费控用户和计量点
	 * @return List<MeterDomain>
	 */
	@ResponseBody
	@RequestMapping(params = "method=getMeterForPrePaid")
	public List<MeterDomain> getMeterForPrePaid(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		MeterDomain meterDomain = JSONUtil.readValue(body, MeterDomain.class);

		return prePaidService.getMeterForPrePaid(meterDomain);

	}
	
}
