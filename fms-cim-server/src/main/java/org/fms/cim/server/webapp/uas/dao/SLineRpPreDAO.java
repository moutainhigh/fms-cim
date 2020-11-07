/**
 * 旁路事件审核表
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.SLineRpPreDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.SLineRpPreDomain;

import java.util.List;

@TransactionDAO
public class SLineRpPreDAO extends AbstractTransactionDAOSupport implements BaseDAO<SLineRpPreDomain> {

    @Override
    public int insert(SLineRpPreDomain sLineRpPreDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", sLineRpPreDomain);
    }

    @Override
    public int delete(SLineRpPreDomain sLineRpPreDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", sLineRpPreDomain);
    }

    @Override
    public SLineRpPreDomain findByKey(SLineRpPreDomain sLineRpPreDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", sLineRpPreDomain);
    }

    @PaginationSupport
    @Override
    public List<SLineRpPreDomain> findByWhere(SLineRpPreDomain sLineRpPreDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", sLineRpPreDomain);
    }

    @Override
    public int update(SLineRpPreDomain sLineRpPreDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", sLineRpPreDomain);
    }

    public int deleteList(List<SLineRpPreDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
