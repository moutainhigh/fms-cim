/**
 * 终端对时日志表
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.RCheckClockLogDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.RCheckClockLogDomain;

import java.util.List;

@TransactionDAO
public class RCheckClockLogDAO extends AbstractTransactionDAOSupport implements BaseDAO<RCheckClockLogDomain> {

    @Override
    public int insert(RCheckClockLogDomain rCheckClockLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", rCheckClockLogDomain);
    }

    @Override
    public int delete(RCheckClockLogDomain rCheckClockLogDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", rCheckClockLogDomain);
    }

    @Override
    public RCheckClockLogDomain findByKey(RCheckClockLogDomain rCheckClockLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", rCheckClockLogDomain);
    }

    @PaginationSupport
    @Override
    public List<RCheckClockLogDomain> findByWhere(RCheckClockLogDomain rCheckClockLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", rCheckClockLogDomain);
    }

    @Override
    public int update(RCheckClockLogDomain rCheckClockLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", rCheckClockLogDomain);
    }

    public int deleteList(List<RCheckClockLogDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
