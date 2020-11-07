/**
 * 电量替代
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.SEnergyRpDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.SEnergyRpDomain;

import java.util.List;

@TransactionDAO
public class SEnergyRpDAO extends AbstractTransactionDAOSupport implements BaseDAO<SEnergyRpDomain> {

    @Override
    public int insert(SEnergyRpDomain sEnergyRpDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", sEnergyRpDomain);
    }

    @Override
    public int delete(SEnergyRpDomain sEnergyRpDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", sEnergyRpDomain);
    }

    @Override
    public SEnergyRpDomain findByKey(SEnergyRpDomain sEnergyRpDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", sEnergyRpDomain);
    }

    @PaginationSupport
    @Override
    public List<SEnergyRpDomain> findByWhere(SEnergyRpDomain sEnergyRpDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", sEnergyRpDomain);
    }

    @Override
    public int update(SEnergyRpDomain sEnergyRpDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", sEnergyRpDomain);
    }

    public int deleteList(List<SEnergyRpDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
