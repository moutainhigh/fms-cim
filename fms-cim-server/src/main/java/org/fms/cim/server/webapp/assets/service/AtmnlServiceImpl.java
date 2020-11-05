/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.assets.service;

import java.util.List;

import org.fms.cim.common.domain.assets.ATmnlDomain;
import org.fms.cim.common.service.IAtmnlService;
import org.fms.cim.server.webapp.assets.dao.ATmnlDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class AtmnlServiceImpl implements IAtmnlService {
	
	@TransactionDAO
	private ATmnlDAO atmnlDAO;
	

	@Override
	public int insert(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return atmnlDAO.insert(t);
	}

	@Override
	public int delete(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return atmnlDAO.delete(t);
	}

	@Override
	public int update(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return atmnlDAO.update(t);
	}

	@Override
	public ATmnlDomain findByKey(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return atmnlDAO.findByKey(t);
	}

	@Override
	public List<ATmnlDomain> findByWhere(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return atmnlDAO.findByWhere(t);
	}

}
