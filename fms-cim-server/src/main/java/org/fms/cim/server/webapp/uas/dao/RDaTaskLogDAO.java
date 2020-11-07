/**
 * 采集任务执行日志表
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.RDaTaskLogDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.RDaTaskLogDomain;

import java.util.List;

@TransactionDAO
public class RDaTaskLogDAO extends AbstractTransactionDAOSupport implements BaseDAO<RDaTaskLogDomain> {

    @Override
    public int insert(RDaTaskLogDomain rDaTaskLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", rDaTaskLogDomain);
    }

    @Override
    public int delete(RDaTaskLogDomain rDaTaskLogDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", rDaTaskLogDomain);
    }

    @Override
    public RDaTaskLogDomain findByKey(RDaTaskLogDomain rDaTaskLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", rDaTaskLogDomain);
    }

    @PaginationSupport
    @Override
    public List<RDaTaskLogDomain> findByWhere(RDaTaskLogDomain rDaTaskLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", rDaTaskLogDomain);
    }

    @Override
    public int update(RDaTaskLogDomain rDaTaskLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", rDaTaskLogDomain);
    }

    public int deleteList(List<RDaTaskLogDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
