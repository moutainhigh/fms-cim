/**
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.cim.server.webapp.uas.dao.PMeterModelDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.PMeterModelDomain;

import java.util.List;

@TransactionDAO
public class PMeterModelDAO extends AbstractTransactionDAOSupport implements BaseDAO<PMeterModelDomain> {

    @Override
    public int insert(PMeterModelDomain pMeterModelDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pMeterModelDomain);
    }

    @Override
    public int delete(PMeterModelDomain pMeterModelDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pMeterModelDomain);
    }

    @Override
    public PMeterModelDomain findByKey(PMeterModelDomain pMeterModelDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pMeterModelDomain);
    }

    @PaginationSupport
    @Override
    public List<PMeterModelDomain> findByWhere(PMeterModelDomain pMeterModelDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pMeterModelDomain);
    }

    @Override
    public int update(PMeterModelDomain pMeterModelDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pMeterModelDomain);
    }

    public int deleteList(List<PMeterModelDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
