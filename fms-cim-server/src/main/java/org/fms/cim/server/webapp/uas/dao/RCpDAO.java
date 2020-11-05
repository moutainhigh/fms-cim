/**
 * 采集点
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.RCpDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import java.util.List;

import org.fms.cim.common.domain.uas.RCpDomain;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;

@TransactionDAO
public class RCpDAO extends AbstractTransactionDAOSupport implements BaseDAO<RCpDomain> {

    @Override
    public int insert(RCpDomain rCpDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", rCpDomain);
    }

    @Override
    public int delete(RCpDomain rCpDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", rCpDomain);
    }

    @Override
    public RCpDomain findByKey(RCpDomain rCpDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", rCpDomain);
    }

    @PaginationSupport
    @Override
    public List<RCpDomain> findByWhere(RCpDomain rCpDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", rCpDomain);
    }

    @Override
    public int update(RCpDomain rCpDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", rCpDomain);
    }

    public int deleteList(List<RCpDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
