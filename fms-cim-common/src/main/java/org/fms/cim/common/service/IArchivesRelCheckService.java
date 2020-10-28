/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:03
 *    Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.archives.MeterDomain;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IArchivesRelCheckService {

	HttpResult meterCheck(List<MeterDomain> meterList);

}
