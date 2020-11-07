/**
 * 异常工单明细
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.SWorkOrderDetailDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.SWorkOrderDetailDomain;

import java.util.List;

@TransactionDAO
public class SWorkOrderDetailDAO extends AbstractTransactionDAOSupport implements BaseDAO<SWorkOrderDetailDomain> {

    @Override
    public int insert(SWorkOrderDetailDomain sWorkOrderDetailDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", sWorkOrderDetailDomain);
    }

    @Override
    public int delete(SWorkOrderDetailDomain sWorkOrderDetailDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", sWorkOrderDetailDomain);
    }

    @Override
    public SWorkOrderDetailDomain findByKey(SWorkOrderDetailDomain sWorkOrderDetailDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", sWorkOrderDetailDomain);
    }

    @PaginationSupport
    @Override
    public List<SWorkOrderDetailDomain> findByWhere(SWorkOrderDetailDomain sWorkOrderDetailDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", sWorkOrderDetailDomain);
    }

    @Override
    public int update(SWorkOrderDetailDomain sWorkOrderDetailDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", sWorkOrderDetailDomain);
    }

    public int deleteList(List<SWorkOrderDetailDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
