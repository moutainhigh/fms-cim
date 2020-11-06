/**
 * 多费率方案定义表
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.cim.server.webapp.uas.dao.PSysRateShemeDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.PSysRateShemeDomain;

import java.util.List;

@TransactionDAO
public class PSysRateShemeDAO extends AbstractTransactionDAOSupport implements BaseDAO<PSysRateShemeDomain> {

    @Override
    public int insert(PSysRateShemeDomain pSysRateShemeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pSysRateShemeDomain);
    }

    @Override
    public int delete(PSysRateShemeDomain pSysRateShemeDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pSysRateShemeDomain);
    }

    @Override
    public PSysRateShemeDomain findByKey(PSysRateShemeDomain pSysRateShemeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pSysRateShemeDomain);
    }

    @PaginationSupport
    @Override
    public List<PSysRateShemeDomain> findByWhere(PSysRateShemeDomain pSysRateShemeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pSysRateShemeDomain);
    }

    @Override
    public int update(PSysRateShemeDomain pSysRateShemeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pSysRateShemeDomain);
    }

    public int deleteList(List<PSysRateShemeDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
