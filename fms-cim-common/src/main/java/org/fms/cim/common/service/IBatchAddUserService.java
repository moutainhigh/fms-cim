/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:03
 *    Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import java.util.Map;

import org.fms.cim.common.domain.archives.BatchAddUserDomain;
import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.TransformerDomain;
import org.fms.cim.common.domain.archives.WriteSectDomain;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IBatchAddUserService {

	public HttpResult batchAddUser(BatchAddUserDomain tt, Long businessPlaceCode, String customerNo,
			Map<String, WriteSectDomain> writeSecNo_writeSecDomain,
			Map<String, TransformerDomain> transformerNo_transformerDomain, 
			Map<String, MeterDomain> meterNo_MeterDomain);
	
}
