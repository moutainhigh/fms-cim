/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.List;

import org.fms.cim.common.domain.archives.PMpedDomain;
import org.fms.cim.common.service.IPmpedService;
import org.fms.cim.server.webapp.archives.dao.PMpedDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class PmpedServiceImpl implements IPmpedService {

	@TransactionDAO("read")
	private PMpedDAO pmpedDAO;

	@Override
	public int insert(PMpedDomain t) {
		// TODO Auto-generated method stub
		return pmpedDAO.insert(t);
	}

	@Override
	public int delete(PMpedDomain t) {
		// TODO Auto-generated method stub
		return pmpedDAO.delete(t);
	}

	@Override
	public int update(PMpedDomain t) {
		// TODO Auto-generated method stub
		return pmpedDAO.update(t);
	}

	@Override
	public PMpedDomain findByKey(PMpedDomain t) {
		// TODO Auto-generated method stub
		return pmpedDAO.findByKey(t);
	}

	@Override
	public List<PMpedDomain> findByWhere(PMpedDomain t) {
		// TODO Auto-generated method stub
		return pmpedDAO.findByWhere(t);
	}
	
}
