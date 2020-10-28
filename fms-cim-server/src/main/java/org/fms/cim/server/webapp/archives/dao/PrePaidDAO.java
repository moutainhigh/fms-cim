/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:28:46
 *    Title:com.riozenc.cim.webapp.dao.CustomerDAO.java
 **/
package org.fms.cim.server.webapp.archives.dao;

import java.util.List;

import org.fms.cim.common.domain.archives.MeterDomain;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;

@TransactionDAO()
public class PrePaidDAO extends AbstractTransactionDAOSupport  {

	public List<MeterDomain> getSettlementAndMeter(MeterDomain meterDomain) {
		return getPersistanceManager().find(getNamespace() + ".getSettlementAndMeter", meterDomain);
	}

	

}
