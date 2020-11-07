/**
 * 告警事项设置
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.PAlarmItemDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.PAlarmItemDomain;

import java.util.List;

@TransactionDAO
public class PAlarmItemDAO extends AbstractTransactionDAOSupport implements BaseDAO<PAlarmItemDomain> {

    @Override
    public int insert(PAlarmItemDomain pAlarmItemDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pAlarmItemDomain);
    }

    @Override
    public int delete(PAlarmItemDomain pAlarmItemDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pAlarmItemDomain);
    }

    @Override
    public PAlarmItemDomain findByKey(PAlarmItemDomain pAlarmItemDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pAlarmItemDomain);
    }

    @PaginationSupport
    @Override
    public List<PAlarmItemDomain> findByWhere(PAlarmItemDomain pAlarmItemDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pAlarmItemDomain);
    }

    @Override
    public int update(PAlarmItemDomain pAlarmItemDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pAlarmItemDomain);
    }

    public int deleteList(List<PAlarmItemDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
