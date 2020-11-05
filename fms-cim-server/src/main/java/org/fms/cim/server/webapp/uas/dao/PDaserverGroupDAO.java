/**
 * 采集主机组
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.PDaserverGroupDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import java.util.List;

import org.fms.cim.common.domain.uas.PDaserverGroupDomain;
import org.fms.cim.common.domain.uas.PDaserverGroupStaticDomain;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;

@TransactionDAO
public class PDaserverGroupDAO extends AbstractTransactionDAOSupport implements BaseDAO<PDaserverGroupDomain> {

    @Override
    public int insert(PDaserverGroupDomain pDaserverGroupDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pDaserverGroupDomain);
    }

    @Override
    public int delete(PDaserverGroupDomain pDaserverGroupDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pDaserverGroupDomain);
    }

    @Override
    public PDaserverGroupDomain findByKey(PDaserverGroupDomain pDaserverGroupDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pDaserverGroupDomain);
    }

    @PaginationSupport
    @Override
    public List<PDaserverGroupDomain> findByWhere(PDaserverGroupDomain pDaserverGroupDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pDaserverGroupDomain);
    }

    @Override
    public int update(PDaserverGroupDomain pDaserverGroupDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pDaserverGroupDomain);
    }

    public int deleteList(List<PDaserverGroupDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

    @PaginationSupport
    public List<PDaserverGroupStaticDomain> findByWhereStatic(PDaserverGroupStaticDomain pDaserverGroupStaticDomain) {
        return getPersistanceManager().find(getNamespace() + ".findByWhereStatic", pDaserverGroupStaticDomain);
    }
}
