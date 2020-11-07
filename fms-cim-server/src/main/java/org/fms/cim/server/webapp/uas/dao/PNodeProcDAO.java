/**
 * 系统节点进程信息
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.PNodeProcDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.PNodeProcDomain;

import java.util.List;

@TransactionDAO
public class PNodeProcDAO extends AbstractTransactionDAOSupport implements BaseDAO<PNodeProcDomain> {

    @Override
    public int insert(PNodeProcDomain pNodeProcDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pNodeProcDomain);
    }

    @Override
    public int delete(PNodeProcDomain pNodeProcDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pNodeProcDomain);
    }

    @Override
    public PNodeProcDomain findByKey(PNodeProcDomain pNodeProcDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pNodeProcDomain);
    }

    @PaginationSupport
    @Override
    public List<PNodeProcDomain> findByWhere(PNodeProcDomain pNodeProcDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pNodeProcDomain);
    }

    @Override
    public int update(PNodeProcDomain pNodeProcDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pNodeProcDomain);
    }

    public int deleteList(List<PNodeProcDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
