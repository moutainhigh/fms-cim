/**
 * 旁路事件
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.SLineRpDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.SLineRpDomain;

import java.util.List;

@TransactionDAO
public class SLineRpDAO extends AbstractTransactionDAOSupport implements BaseDAO<SLineRpDomain> {

    @Override
    public int insert(SLineRpDomain sLineRpDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", sLineRpDomain);
    }

    @Override
    public int delete(SLineRpDomain sLineRpDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", sLineRpDomain);
    }

    @Override
    public SLineRpDomain findByKey(SLineRpDomain sLineRpDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", sLineRpDomain);
    }

    @PaginationSupport
    @Override
    public List<SLineRpDomain> findByWhere(SLineRpDomain sLineRpDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", sLineRpDomain);
    }

    @Override
    public int update(SLineRpDomain sLineRpDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", sLineRpDomain);
    }

    public int deleteList(List<SLineRpDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
