package org.fms.cim.server.webapp.archives.dao;

import java.util.List;

import org.fms.cim.common.domain.archives.DropSqlDomain;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;

@TransactionDAO
public class DropSqlDAO extends AbstractTransactionDAOSupport{
	
	public List<DropSqlDomain> findByWhere(DropSqlDomain t) {
		return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
	}

}
