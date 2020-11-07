/**
 * 值班日志
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.SOndutyLogDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.SOndutyLogDomain;

import java.util.List;

@TransactionDAO
public class SOndutyLogDAO extends AbstractTransactionDAOSupport implements BaseDAO<SOndutyLogDomain> {

    @Override
    public int insert(SOndutyLogDomain sOndutyLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", sOndutyLogDomain);
    }

    @Override
    public int delete(SOndutyLogDomain sOndutyLogDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", sOndutyLogDomain);
    }

    @Override
    public SOndutyLogDomain findByKey(SOndutyLogDomain sOndutyLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", sOndutyLogDomain);
    }

    @PaginationSupport
    @Override
    public List<SOndutyLogDomain> findByWhere(SOndutyLogDomain sOndutyLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", sOndutyLogDomain);
    }

    @Override
    public int update(SOndutyLogDomain sOndutyLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", sOndutyLogDomain);
    }

    public int deleteList(List<SOndutyLogDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
