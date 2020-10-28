/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:03
 *    Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import java.util.List;
import java.util.Map;

import org.fms.cim.common.domain.archives.MeterDomain;

public interface IPrePaidService {

	Map<Long,List<MeterDomain>> getSettlementAndMeter(MeterDomain meterDomain);

	List<MeterDomain> getMeterForPrePaid(MeterDomain meterDomain);

}
