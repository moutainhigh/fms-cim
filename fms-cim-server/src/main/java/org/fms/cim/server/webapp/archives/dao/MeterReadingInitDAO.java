package org.fms.cim.server.webapp.archives.dao;

import java.util.List;

import org.fms.cim.common.domain.archives.MeterDomain;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;

@TransactionDAO
public class MeterReadingInitDAO extends AbstractTransactionDAOSupport {

	public List<MeterDomain> getFKMeterListByIds(List<Long> ids) {
		return getPersistanceManager().find(getNamespace() + ".getFKMeterListByIds", ids);
	}
	
	
}
