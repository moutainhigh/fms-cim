/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.List;

import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.archives.PMpedDomain;
import org.fms.cim.common.service.IPmpedService;
import org.fms.cim.server.webapp.archives.dao.PMpedDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class PmpedServiceImpl implements IPmpedService {

	@TransactionDAO("read")
	private PMpedDAO pmpedReadDAO;
	
	@TransactionDAO("write")
	private PMpedDAO pmpedWriteDAO;

	@Override
	public int insert(PMpedDomain t) {
		// TODO Auto-generated method stub
		return pmpedWriteDAO.insert(t);
	}

	@Override
	public int delete(PMpedDomain t) {
		// TODO Auto-generated method stub
		return pmpedWriteDAO.delete(t);
	}

	@Override
	public int update(PMpedDomain t) {
		// TODO Auto-generated method stub
		return pmpedWriteDAO.update(t);
	}

	@Override
	public PMpedDomain findByKey(PMpedDomain t) {
		// TODO Auto-generated method stub
		return pmpedReadDAO.findByKey(t);
	}

	@Override
	public List<PMpedDomain> getPMpedBySDevIr(PMpedDomain t) {
		// TODO Auto-generated method stub
		return pmpedReadDAO.getPMpedBySDevIr(t);
	}
	
	@Override
	public List<PMpedDomain> findByWhere(PMpedDomain t) {
		// TODO Auto-generated method stub
		return pmpedReadDAO.findByWhere(t);
	}

	@Override
	public int updateList(List<PMpedDomain> list) {
		return pmpedWriteDAO.updateList(list);
	}
}
