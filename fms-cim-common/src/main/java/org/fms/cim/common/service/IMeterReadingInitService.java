package org.fms.cim.common.service;

import java.util.List;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IMeterReadingInitService {

	public HttpResult meterReadingInitByCustomer(List<Long> ids,String sn);

	public HttpResult meterReadingInitByWriteSec(List<Long> ids,String sn);

	public HttpResult meterReadingInitByUser(List<Long> ids, String sn);

	public HttpResult meterReadingInitDaily(List<Long> ids);
	
	
}
 