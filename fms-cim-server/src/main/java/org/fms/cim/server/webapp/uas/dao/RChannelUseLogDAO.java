/**
 * 通道使用日志
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.RChannelUseLogDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.RChannelUseLogDomain;

import java.util.List;

@TransactionDAO
public class RChannelUseLogDAO extends AbstractTransactionDAOSupport implements BaseDAO<RChannelUseLogDomain> {

    @Override
    public int insert(RChannelUseLogDomain rChannelUseLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", rChannelUseLogDomain);
    }

    @Override
    public int delete(RChannelUseLogDomain rChannelUseLogDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", rChannelUseLogDomain);
    }

    @Override
    public RChannelUseLogDomain findByKey(RChannelUseLogDomain rChannelUseLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", rChannelUseLogDomain);
    }

    @PaginationSupport
    @Override
    public List<RChannelUseLogDomain> findByWhere(RChannelUseLogDomain rChannelUseLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", rChannelUseLogDomain);
    }

    @Override
    public int update(RChannelUseLogDomain rChannelUseLogDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", rChannelUseLogDomain);
    }

    public int deleteList(List<RChannelUseLogDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
