/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.Date;
import java.util.List;

import org.fms.cim.common.domain.archives.SubsLineRelaDomain;
import org.fms.cim.common.service.ISubsLineRelaService;
import org.fms.cim.server.webapp.archives.dao.SubsLineRelaDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class SubsLineRelaServiceImpl implements ISubsLineRelaService {
	
	@TransactionDAO
	private SubsLineRelaDAO subsLineRelaDAO;

	Date now = new Date();

	@Override
	public int insert(SubsLineRelaDomain t) {
		// TODO Auto-generated method stub
		return subsLineRelaDAO.insert(t);
	}

	@Override
	public int delete(SubsLineRelaDomain t) {
		// TODO Auto-generated method stub
		return subsLineRelaDAO.delete(t);
	}

	@Override
	public int update(SubsLineRelaDomain t) {
		// TODO Auto-generated method stub
		return subsLineRelaDAO.update(t);
	}

	@Override
	public SubsLineRelaDomain findByKey(SubsLineRelaDomain t) {
		// TODO Auto-generated method stub
		return subsLineRelaDAO.findByKey(t);
	}

	@Override
	public List<SubsLineRelaDomain> findByWhere(SubsLineRelaDomain t) {
		// TODO Auto-generated method stub
		return subsLineRelaDAO.findByWhere(t);
	}
	
}
