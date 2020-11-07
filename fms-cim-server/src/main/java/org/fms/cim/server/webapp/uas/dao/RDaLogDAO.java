/**
 * 采集日志表
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.RDaLogDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.RDaLogDomain;

import java.util.List;

@TransactionDAO
public class RDaLogDAO extends AbstractTransactionDAOSupport implements BaseDAO<RDaLogDomain> {

    @Override
    public int insert(RDaLogDomain rDaLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", rDaLogDomain);
    }

    @Override
    public int delete(RDaLogDomain rDaLogDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", rDaLogDomain);
    }

    @Override
    public RDaLogDomain findByKey(RDaLogDomain rDaLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", rDaLogDomain);
    }

    @PaginationSupport
    @Override
    public List<RDaLogDomain> findByWhere(RDaLogDomain rDaLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", rDaLogDomain);
    }

    @Override
    public int update(RDaLogDomain rDaLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", rDaLogDomain);
    }

    public int deleteList(List<RDaLogDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
