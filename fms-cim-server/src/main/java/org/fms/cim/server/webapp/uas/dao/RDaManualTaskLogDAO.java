/**
 * 人工任务执行日志表
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.RDaManualTaskLogDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.RDaManualTaskLogDomain;

import java.util.List;

@TransactionDAO
public class RDaManualTaskLogDAO extends AbstractTransactionDAOSupport implements BaseDAO<RDaManualTaskLogDomain> {

    @Override
    public int insert(RDaManualTaskLogDomain rDaManualTaskLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", rDaManualTaskLogDomain);
    }

    @Override
    public int delete(RDaManualTaskLogDomain rDaManualTaskLogDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", rDaManualTaskLogDomain);
    }

    @Override
    public RDaManualTaskLogDomain findByKey(RDaManualTaskLogDomain rDaManualTaskLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", rDaManualTaskLogDomain);
    }

    @PaginationSupport
    @Override
    public List<RDaManualTaskLogDomain> findByWhere(RDaManualTaskLogDomain rDaManualTaskLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", rDaManualTaskLogDomain);
    }

    @Override
    public int update(RDaManualTaskLogDomain rDaManualTaskLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", rDaManualTaskLogDomain);
    }

    public int deleteList(List<RDaManualTaskLogDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
