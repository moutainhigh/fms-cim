/**
 * 告警范围
 * Author : 
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.PAlarmDataDAO.java
 *
**/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.PAlarmDataDomain;

import java.util.List;

@TransactionDAO
public class PAlarmDataDAO extends AbstractTransactionDAOSupport implements BaseDAO<PAlarmDataDomain> {

	@Override
	public int insert(PAlarmDataDomain pAlarmDataDomain) {
		// TODO Auto-generated method stub
		return getPersistanceManager().insert(getNamespace() + ".insert", pAlarmDataDomain);
	}

	@Override
	public int delete(PAlarmDataDomain pAlarmDataDomain) {
		return getPersistanceManager().delete(getNamespace() + ".delete", pAlarmDataDomain);
	}

	@Override
	public PAlarmDataDomain findByKey(PAlarmDataDomain pAlarmDataDomain) {
		// TODO Auto-generated method stub
		return getPersistanceManager().load(getNamespace() + ".findByKey", pAlarmDataDomain);
	}

	@PaginationSupport
	@Override
	public List<PAlarmDataDomain> findByWhere(PAlarmDataDomain pAlarmDataDomain) {
		// TODO Auto-generated method stub
		return getPersistanceManager().find(getNamespace() + ".findByWhere", pAlarmDataDomain);
	}

	@Override
	public int update(PAlarmDataDomain pAlarmDataDomain) {
		// TODO Auto-generated method stub
		return getPersistanceManager().update(getNamespace() + ".update", pAlarmDataDomain);
	}

	   public int deleteList(List<PAlarmDataDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
