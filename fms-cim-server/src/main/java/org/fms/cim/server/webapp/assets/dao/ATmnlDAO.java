package org.fms.cim.server.webapp.assets.dao;

import java.util.List;

import org.fms.cim.common.domain.assets.ATmnlDomain;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;

@TransactionDAO
public class ATmnlDAO extends AbstractTransactionDAOSupport implements BaseDAO<ATmnlDomain> {

	@Override
	public int insert(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().insert(getNamespace() + ".insert", t);
	}

	@Override
	public int delete(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().delete(getNamespace() + ".delete", t);
	}

	@Override
	public int update(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().update(getNamespace() + ".update", t);
	}

	@Override
	public ATmnlDomain findByKey(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().load(getNamespace() + ".findByKey", t);
	}

	@Override
	@PaginationSupport
	public List<ATmnlDomain> findByWhere(ATmnlDomain t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
	}

}
