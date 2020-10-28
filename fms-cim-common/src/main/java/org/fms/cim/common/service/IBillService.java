package org.fms.cim.common.service;

import java.io.IOException;
import java.util.List;

import org.fms.cim.common.domain.archives.MeterDomain;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

public interface IBillService {

	public List<MeterDomain> getMeters(JsonNode jsonNode)throws JsonParseException, JsonMappingException, IOException;

	public List<MeterDomain> getMetersBySettlement(JsonNode jsonNode)throws JsonParseException, JsonMappingException, IOException;

}
