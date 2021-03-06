/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.List;

import org.fms.cim.common.domain.archives.MeterMpedRelDomain;
import org.fms.cim.common.service.IMeterMpedRelService;
import org.fms.cim.server.webapp.archives.dao.MeterMpedRelDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class MeterMpedRelServiceImpl implements IMeterMpedRelService {

	@TransactionDAO("read")
	private MeterMpedRelDAO MeterMpedRelReadDAO;
	
	@TransactionDAO("write")
	private MeterMpedRelDAO MeterMpedRelWriteDAO;

	@Override
	public int insert(MeterMpedRelDomain t) {
		return MeterMpedRelWriteDAO.insert(t);
	}

	@Override
	public int delete(MeterMpedRelDomain t) {
		return MeterMpedRelWriteDAO.delete(t);
	}

	@Override
	public int update(MeterMpedRelDomain t) {
		return MeterMpedRelWriteDAO.update(t);
	}

	@Override
	public MeterMpedRelDomain findByKey(MeterMpedRelDomain t) {
		return MeterMpedRelReadDAO.findByKey(t);
	}

	@Override
	public List<MeterMpedRelDomain> findByWhere(MeterMpedRelDomain t) {
		return MeterMpedRelReadDAO.findByWhere(t);
	}

}
