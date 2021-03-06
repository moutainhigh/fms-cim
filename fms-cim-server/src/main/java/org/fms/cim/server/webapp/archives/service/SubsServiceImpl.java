/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.List;

import org.fms.cim.common.domain.archives.SubsDomain;
import org.fms.cim.common.service.ISubsService;
import org.fms.cim.server.webapp.archives.dao.SubsDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class SubsServiceImpl implements ISubsService {

	@TransactionDAO("read")
	private SubsDAO subsReadDAO;
	@TransactionDAO("write")
	private SubsDAO subsWriteDAO;

	@Override
	public int insert(SubsDomain t) {
		// TODO Auto-generated method stub
		return subsWriteDAO.insert(t);
	}

	@Override
	public int delete(SubsDomain t) {
		// TODO Auto-generated method stub
		return subsWriteDAO.delete(t);
	}

	@Override
	public int update(SubsDomain t) {
		// TODO Auto-generated method stub
		return subsWriteDAO.update(t);
	}

	@Override
	public SubsDomain findByKey(SubsDomain t) {
		// TODO Auto-generated method stub
		return subsReadDAO.findByKey(t);
	}

	@Override
	public List<SubsDomain> findByWhere(SubsDomain t) {
		// TODO Auto-generated method stub
		return subsReadDAO.findByWhere(t);
	}

	@Override
	public List<SubsDomain> findByNo(SubsDomain t) {
		// TODO Auto-generated method stub
		return subsReadDAO.findByNo(t);
	}

}
