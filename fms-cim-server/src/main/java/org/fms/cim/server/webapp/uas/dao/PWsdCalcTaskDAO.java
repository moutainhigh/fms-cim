/**
 * 计算任务类型定义表
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.PWsdCalcTaskDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import java.util.List;

import org.fms.cim.common.domain.uas.PWsdCalcTaskDomain;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;

@TransactionDAO
public class PWsdCalcTaskDAO extends AbstractTransactionDAOSupport implements BaseDAO<PWsdCalcTaskDomain> {

    @Override
    public int insert(PWsdCalcTaskDomain pWsdCalcTaskDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pWsdCalcTaskDomain);
    }

    @Override
    public int delete(PWsdCalcTaskDomain pWsdCalcTaskDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pWsdCalcTaskDomain);
    }

    @Override
    public PWsdCalcTaskDomain findByKey(PWsdCalcTaskDomain pWsdCalcTaskDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pWsdCalcTaskDomain);
    }

    @PaginationSupport
    @Override
    public List<PWsdCalcTaskDomain> findByWhere(PWsdCalcTaskDomain pWsdCalcTaskDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pWsdCalcTaskDomain);
    }

    @Override
    public int update(PWsdCalcTaskDomain pWsdCalcTaskDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pWsdCalcTaskDomain);
    }

    public int deleteList(List<PWsdCalcTaskDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
