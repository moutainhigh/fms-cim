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
	
	@TransactionDAO("read")
	private ATmnlDAO atmnlReadDAO;
	
	@TransactionDAO("write")
	private ATmnlDAO atmnlWriteDAO;
	

	@Override
	public int insert(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return atmnlWriteDAO.insert(t);
	}

	@Override
	public int delete(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return atmnlWriteDAO.delete(t);
	}

	@Override
	public int update(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return atmnlWriteDAO.update(t);
	}

	@Override
	public ATmnlDomain findByKey(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return atmnlReadDAO.findByKey(t);
	}

	@Override
	public List<ATmnlDomain> findByWhere(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return atmnlReadDAO.findByWhere(t);
	}

}
