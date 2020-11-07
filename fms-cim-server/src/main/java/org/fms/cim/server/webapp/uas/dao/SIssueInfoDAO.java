/**
 * 系统公告
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.SIssueInfoDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.SIssueInfoDomain;

import java.util.List;

@TransactionDAO
public class SIssueInfoDAO extends AbstractTransactionDAOSupport implements BaseDAO<SIssueInfoDomain> {

    @Override
    public int insert(SIssueInfoDomain sIssueInfoDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", sIssueInfoDomain);
    }

    @Override
    public int delete(SIssueInfoDomain sIssueInfoDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", sIssueInfoDomain);
    }

    @Override
    public SIssueInfoDomain findByKey(SIssueInfoDomain sIssueInfoDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", sIssueInfoDomain);
    }

    @PaginationSupport
    @Override
    public List<SIssueInfoDomain> findByWhere(SIssueInfoDomain sIssueInfoDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", sIssueInfoDomain);
    }

    @Override
    public int update(SIssueInfoDomain sIssueInfoDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", sIssueInfoDomain);
    }

    public int deleteList(List<SIssueInfoDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
