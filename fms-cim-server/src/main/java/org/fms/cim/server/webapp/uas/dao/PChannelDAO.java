/**
 * 通道参数表
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.PChannelDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import java.util.List;

import org.fms.cim.common.domain.uas.PChannelDomain;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;

@TransactionDAO
public class PChannelDAO extends AbstractTransactionDAOSupport implements BaseDAO<PChannelDomain> {

    @Override
    public int insert(PChannelDomain pChannelDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pChannelDomain);
    }

    @Override
    public int delete(PChannelDomain pChannelDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pChannelDomain);
    }

    @Override
    public PChannelDomain findByKey(PChannelDomain pChannelDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pChannelDomain);
    }

    @PaginationSupport
    @Override
    public List<PChannelDomain> findByWhere(PChannelDomain pChannelDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pChannelDomain);
    }

    @Override
    public int update(PChannelDomain pChannelDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pChannelDomain);
    }

    public int deleteList(List<PChannelDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
