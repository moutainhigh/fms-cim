/**
 * 采集任务明细
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.cim.server.webapp.uas.dao.PTaskDetailDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.PTaskDetailDomain;
import org.fms.cim.common.domain.uas.PTaskDetailRelDomain;
import org.fms.cim.common.domain.uas.PWsdTaskdataRelDomain;
import org.fms.cim.common.vo.uas.PTaskDetailRelVO;

import java.util.List;

@TransactionDAO
public class PTaskDetailDAO extends AbstractTransactionDAOSupport implements BaseDAO<PTaskDetailDomain> {

    @Override
    public int insert(PTaskDetailDomain pTaskDetailDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pTaskDetailDomain);
    }

    @Override
    public int delete(PTaskDetailDomain pTaskDetailDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pTaskDetailDomain);
    }

    @Override
    public PTaskDetailDomain findByKey(PTaskDetailDomain pTaskDetailDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pTaskDetailDomain);
    }

    @PaginationSupport
    @Override
    public List<PTaskDetailDomain> findByWhere(PTaskDetailDomain pTaskDetailDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pTaskDetailDomain);
    }

    @Override
    public int update(PTaskDetailDomain pTaskDetailDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pTaskDetailDomain);
    }

    public int deleteList(List<PTaskDetailDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

    public List<PWsdTaskdataRelDomain> findByTaskRel(PWsdTaskdataRelDomain modelDomain) {
        return getPersistanceManager().find(getNamespace() + ".findByTaskRel", modelDomain);
    }

    public int insertList(List<PTaskDetailDomain> insertList) {
        return getPersistanceManager().insertList(getNamespace() + ".insert", insertList);
    }
}
