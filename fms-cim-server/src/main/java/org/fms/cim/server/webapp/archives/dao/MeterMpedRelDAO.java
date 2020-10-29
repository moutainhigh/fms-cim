/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:28:46
 *    Title:com.riozenc.cim.webapp.dao.CustomerDAO.java
 **/
package org.fms.cim.server.webapp.archives.dao;

import java.util.List;

import org.fms.cim.common.domain.archives.MeterMpedRelDomain;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;

@TransactionDAO
public class MeterMpedRelDAO extends AbstractTransactionDAOSupport implements BaseDAO<MeterMpedRelDomain> {

	@Override
	public int insert(MeterMpedRelDomain t) {
		return getPersistanceManager().insert(getNamespace() + ".insert", t);
	}

	@Override
	public int delete(MeterMpedRelDomain t) {
		return getPersistanceManager().delete(getNamespace() + ".delete", t);
	}

	@Override
	public int update(MeterMpedRelDomain t) {
		return getPersistanceManager().update(getNamespace() + ".update", t);
	}

	@Override
	public MeterMpedRelDomain findByKey(MeterMpedRelDomain t) {
		return getPersistanceManager().load(getNamespace() + ".findByKey", t);
	}

	@Override
	@PaginationSupport
	public List<MeterMpedRelDomain> findByWhere(MeterMpedRelDomain t) {
		return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
	}

}
