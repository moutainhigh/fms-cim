/**
 * 计算方案
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.cim.server.webapp.uas.dao.PSysCalcSchemeDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.PSysCalcSchemeDomain;

import java.util.List;

@TransactionDAO
public class PSysCalcSchemeDAO extends AbstractTransactionDAOSupport implements BaseDAO<PSysCalcSchemeDomain> {

    @Override
    public int insert(PSysCalcSchemeDomain pSysCalcSchemeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pSysCalcSchemeDomain);
    }

    @Override
    public int delete(PSysCalcSchemeDomain pSysCalcSchemeDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pSysCalcSchemeDomain);
    }

    @Override
    public PSysCalcSchemeDomain findByKey(PSysCalcSchemeDomain pSysCalcSchemeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pSysCalcSchemeDomain);
    }

    @PaginationSupport
    @Override
    public List<PSysCalcSchemeDomain> findByWhere(PSysCalcSchemeDomain pSysCalcSchemeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pSysCalcSchemeDomain);
    }

    @Override
    public int update(PSysCalcSchemeDomain pSysCalcSchemeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pSysCalcSchemeDomain);
    }

    public int deleteList(List<PSysCalcSchemeDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
