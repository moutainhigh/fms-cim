/**
 * 规约定义表
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.cim.server.webapp.uas.dao.PWsdProtocolDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.PWsdProtocolDomain;

import java.util.List;

@TransactionDAO
public class PWsdProtocolDAO extends AbstractTransactionDAOSupport implements BaseDAO<PWsdProtocolDomain> {

    @Override
    public int insert(PWsdProtocolDomain pWsdProtocolDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pWsdProtocolDomain);
    }

    @Override
    public int delete(PWsdProtocolDomain pWsdProtocolDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pWsdProtocolDomain);
    }

    @Override
    public PWsdProtocolDomain findByKey(PWsdProtocolDomain pWsdProtocolDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pWsdProtocolDomain);
    }

    @PaginationSupport
    @Override
    public List<PWsdProtocolDomain> findByWhere(PWsdProtocolDomain pWsdProtocolDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pWsdProtocolDomain);
    }

    @Override
    public int update(PWsdProtocolDomain pWsdProtocolDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pWsdProtocolDomain);
    }

    public int deleteList(List<PWsdProtocolDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
