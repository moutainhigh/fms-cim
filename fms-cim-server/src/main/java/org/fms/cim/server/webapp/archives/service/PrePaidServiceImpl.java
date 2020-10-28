/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.service.IPrePaidService;
import org.fms.cim.server.webapp.archives.dao.PrePaidDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class PrePaidServiceImpl implements IPrePaidService {

    @TransactionDAO
    private PrePaidDAO prePaidDAO;
    
	@Override
	public Map<Long,List<MeterDomain>> getSettlementAndMeter(MeterDomain meterDomain) {
        List<MeterDomain> meterList = prePaidDAO.getSettlementAndMeter(meterDomain);
        
        Map<Long,List<MeterDomain>> settlementId_meterList = meterList.stream().
        		collect(Collectors.groupingBy(MeterDomain::getSettlementId));
              
        return settlementId_meterList;
	}

	@Override
	public List<MeterDomain> getMeterForPrePaid(MeterDomain meterDomain) {
		return prePaidDAO.getSettlementAndMeter(meterDomain);
	}

	

}
