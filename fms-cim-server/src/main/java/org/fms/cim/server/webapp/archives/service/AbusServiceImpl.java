package org.fms.cim.server.webapp.archives.service;

import java.util.List;

import org.fms.cim.common.domain.archives.ABusDomain;
import org.fms.cim.common.service.IAbusService;
import org.fms.cim.server.webapp.archives.dao.ABusDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class AbusServiceImpl implements IAbusService {
	
	@TransactionDAO("read")
	private ABusDAO abusReadDAO;
	
	@TransactionDAO("write")
	private ABusDAO abusWriteDAO;

	@Override
	public int insert(ABusDomain t) {
		// TODO Auto-generated method stub
		return abusWriteDAO.insert(t);
	}

	@Override
	public int delete(ABusDomain t) {
		// TODO Auto-generated method stub
		return abusWriteDAO.delete(t);
	}

	@Override
	public int update(ABusDomain t) {
		// TODO Auto-generated method stub
		return abusWriteDAO.update(t);
	}

	@Override
	public ABusDomain findByKey(ABusDomain t) {
		// TODO Auto-generated method stub
		return abusReadDAO.findByKey(t);
	}

	@Override
	public List<ABusDomain> findByWhere(ABusDomain t) {
		// TODO Auto-generated method stub
		return abusReadDAO.findByWhere(t);
	}

}
