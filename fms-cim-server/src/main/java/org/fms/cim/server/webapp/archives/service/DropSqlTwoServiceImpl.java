package org.fms.cim.server.webapp.archives.service;

import java.util.List;

import org.fms.cim.common.domain.archives.DropSqlDomain;
import org.fms.cim.common.service.IDropSqlTwoService;
import org.fms.cim.server.webapp.archives.dao.DropSqlDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;

public class DropSqlTwoServiceImpl implements IDropSqlTwoService{
	
	@TransactionDAO("read")
	private DropSqlDAO dropSqlReadDAO;
	
	@TransactionDAO("write")
	private DropSqlDAO dropSqlWriteDAO;
	
	@Override
	public List<DropSqlDomain> findByWhere(DropSqlDomain t) {
		// TODO Auto-generated method stub
		return dropSqlReadDAO.findByWhere(t);
	}

}
