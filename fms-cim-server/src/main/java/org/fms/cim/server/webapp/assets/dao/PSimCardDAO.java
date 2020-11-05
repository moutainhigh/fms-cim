package org.fms.cim.server.webapp.assets.dao;

import java.util.List;

import org.fms.cim.common.domain.assets.ATmnlDomain;
import org.fms.cim.common.domain.assets.PSimCardDomain;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;

@TransactionDAO
public class PSimCardDAO extends AbstractTransactionDAOSupport implements BaseDAO<PSimCardDomain> {

	@Override
	public int insert(PSimCardDomain t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().insert(getNamespace() + ".insert", t);
	}

	@Override
	public int delete(PSimCardDomain t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().delete(getNamespace() + ".delete", t);
	}

	@Override
	public int update(PSimCardDomain t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().update(getNamespace() + ".update", t);
	}

	@Override
	public PSimCardDomain findByKey(PSimCardDomain t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().load(getNamespace() + ".findByKey", t);
	}

	@Override
	@PaginationSupport
	public List<PSimCardDomain> findByWhere(PSimCardDomain t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
	}

}
