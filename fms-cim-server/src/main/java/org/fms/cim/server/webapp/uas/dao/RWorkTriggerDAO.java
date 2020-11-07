/**
 * 计量业务触发表
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.RWorkTriggerDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.RWorkTriggerDomain;

import java.util.List;

@TransactionDAO
public class RWorkTriggerDAO extends AbstractTransactionDAOSupport implements BaseDAO<RWorkTriggerDomain> {

    @Override
    public int insert(RWorkTriggerDomain rWorkTriggerDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", rWorkTriggerDomain);
    }

    @Override
    public int delete(RWorkTriggerDomain rWorkTriggerDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", rWorkTriggerDomain);
    }

    @Override
    public RWorkTriggerDomain findByKey(RWorkTriggerDomain rWorkTriggerDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", rWorkTriggerDomain);
    }

    @PaginationSupport
    @Override
    public List<RWorkTriggerDomain> findByWhere(RWorkTriggerDomain rWorkTriggerDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", rWorkTriggerDomain);
    }

    @Override
    public int update(RWorkTriggerDomain rWorkTriggerDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", rWorkTriggerDomain);
    }

    public int deleteList(List<RWorkTriggerDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
