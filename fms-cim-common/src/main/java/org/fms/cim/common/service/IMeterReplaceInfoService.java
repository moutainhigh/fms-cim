/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:03
 *    Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.archives.LastCodeEntity;
import org.fms.cim.common.domain.archives.MeterReplaceDomain;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface IMeterReplaceInfoService extends BaseService<MeterReplaceDomain> {


	public HttpResult changeDev(String body, List<LastCodeEntity> lastCodeEntityList);

	public List<MeterReplaceDomain> findByMeter(MeterReplaceDomain mr);

	public List<MeterReplaceDomain> getMeterReplaceByWriteSectIds(List<Long> writeSectIds);

	public List<MeterReplaceDomain> getMeterReplaceByMeterIds(List<Long> meterIds);

	public List<LastCodeEntity> getLastCodeByMeter(MeterReplaceDomain t);

	public int insertList(List<MeterReplaceDomain> mrList);

	public int updateList(List<MeterReplaceDomain> mruList);

}
