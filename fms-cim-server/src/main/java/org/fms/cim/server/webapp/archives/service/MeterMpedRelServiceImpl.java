/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.List;
import org.fms.cim.server.webapp.archives.dao.MeterMpedRelDAO;

import org.fms.cim.common.domain.archives.MeterMpedRelDomain;
import org.fms.cim.common.service.IMeterMpedRelService;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class MeterMpedRelServiceImpl implements IMeterMpedRelService {

	@TransactionDAO
	private MeterMpedRelDAO MeterMpedRelDAO;

	@Override
	public int insert(MeterMpedRelDomain t) {
		return MeterMpedRelDAO.insert(t);
	}

	@Override
	public int delete(MeterMpedRelDomain t) {
		return MeterMpedRelDAO.delete(t);
	}

	@Override
	public int update(MeterMpedRelDomain t) {
		return MeterMpedRelDAO.update(t);
	}

	@Override
	public MeterMpedRelDomain findByKey(MeterMpedRelDomain t) {
		return MeterMpedRelDAO.findByKey(t);
	}

	@Override
	public List<MeterMpedRelDomain> findByWhere(MeterMpedRelDomain t) {
		return MeterMpedRelDAO.findByWhere(t);
	}

}
