/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.List;

import org.fms.cim.common.domain.archives.BankDomain;
import org.fms.cim.common.service.IBankService;
import org.fms.cim.server.webapp.archives.dao.BankDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class BankServiceImpl implements IBankService {

	@TransactionDAO
	private BankDAO bankDAO;

	@Override
	public int insert(BankDomain t) {
		return bankDAO.insert(t);
	}

	@Override
	public int delete(BankDomain t) {
		return bankDAO.delete(t);
	}

	@Override
	public int update(BankDomain t) {
		return bankDAO.update(t);
	}

	@Override
	public BankDomain findByKey(BankDomain t) {
		return bankDAO.findByKey(t);
	}

	@Override
	public List<BankDomain> findByWhere(BankDomain t) {
		return bankDAO.findByWhere(t);
	}

}
