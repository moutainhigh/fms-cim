package org.fms.cim.server.webapp.archives.service;

import java.util.List;

import org.fms.cim.common.domain.archives.SDevIrDomain;
import org.fms.cim.common.service.ISdevIrService;
import org.fms.cim.server.webapp.archives.dao.SDevIrDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class SdevIrServiceImpl implements ISdevIrService {
	
	@TransactionDAO("read")
	private SDevIrDAO sdevIrReadDAO;
	
	@TransactionDAO("write")
	private SDevIrDAO sdevIrWriteDAO;

	@Override
	public int insert(SDevIrDomain t) {
		// TODO Auto-generated method stub
		return sdevIrWriteDAO.insert(t);
	}

	@Override
	public int delete(SDevIrDomain t) {
		// TODO Auto-generated method stub
		return sdevIrWriteDAO.delete(t);
	}

	@Override
	public int update(SDevIrDomain t) {
		// TODO Auto-generated method stub
		return sdevIrWriteDAO.update(t);
	}

	@Override
	public SDevIrDomain findByKey(SDevIrDomain t) {
		// TODO Auto-generated method stub
		return sdevIrReadDAO.findByKey(t);
	}

	@Override
	public List<SDevIrDomain> findByWhere(SDevIrDomain t) {
		// TODO Auto-generated method stub
		return sdevIrReadDAO.findByWhere(t);
	}

	

}
