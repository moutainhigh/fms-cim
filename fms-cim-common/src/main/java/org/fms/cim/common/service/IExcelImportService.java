/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:03
 *    Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import org.fms.cim.common.domain.archives.MeterReplaceDomain;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IExcelImportService {

	HttpResult changeDevExcel(MeterReplaceDomain mr);

	
	
}
