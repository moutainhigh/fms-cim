/**
 * 采集任务设置模板
 * ※设置时根据设置的模板明细、任务明细自动生成终端的任务及明细
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.PTaskTplDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import java.util.List;

import org.fms.cim.common.domain.uas.PTaskTplDomain;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;

@TransactionDAO
public class PTaskTplDAO extends AbstractTransactionDAOSupport implements BaseDAO<PTaskTplDomain> {

    @Override
    public int insert(PTaskTplDomain pTaskTplDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pTaskTplDomain);
    }

    @Override
    public int delete(PTaskTplDomain pTaskTplDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pTaskTplDomain);
    }

    @Override
    public PTaskTplDomain findByKey(PTaskTplDomain pTaskTplDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pTaskTplDomain);
    }

    @PaginationSupport
    @Override
    public List<PTaskTplDomain> findByWhere(PTaskTplDomain pTaskTplDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pTaskTplDomain);
    }

    @Override
    public int update(PTaskTplDomain pTaskTplDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pTaskTplDomain);
    }

    public int deleteList(List<PTaskTplDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
