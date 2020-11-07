/**
 * 异常工单
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.SWorkOrderDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.SWorkOrderDomain;

import java.util.List;

@TransactionDAO
public class SWorkOrderDAO extends AbstractTransactionDAOSupport implements BaseDAO<SWorkOrderDomain> {

    @Override
    public int insert(SWorkOrderDomain sWorkOrderDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", sWorkOrderDomain);
    }

    @Override
    public int delete(SWorkOrderDomain sWorkOrderDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", sWorkOrderDomain);
    }

    @Override
    public SWorkOrderDomain findByKey(SWorkOrderDomain sWorkOrderDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", sWorkOrderDomain);
    }

    @PaginationSupport
    @Override
    public List<SWorkOrderDomain> findByWhere(SWorkOrderDomain sWorkOrderDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", sWorkOrderDomain);
    }

    @Override
    public int update(SWorkOrderDomain sWorkOrderDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", sWorkOrderDomain);
    }

    public int deleteList(List<SWorkOrderDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
