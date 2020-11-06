/**
 * 规约任务类型（※相当于原来变电站采集的规约数据类型表与负控采集的任务类型合并的表。对于厂站系列为电量、15分钟电量、瞬时量等；对于负荷、低压系列为一类、二类数据等）
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.cim.server.webapp.uas.dao.PWsdProtocolTaskDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.PWsdProtocolTaskDomain;

import java.util.List;

@TransactionDAO
public class PWsdProtocolTaskDAO extends AbstractTransactionDAOSupport implements BaseDAO<PWsdProtocolTaskDomain> {

    @Override
    public int insert(PWsdProtocolTaskDomain pWsdProtocolTaskDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pWsdProtocolTaskDomain);
    }

    @Override
    public int delete(PWsdProtocolTaskDomain pWsdProtocolTaskDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pWsdProtocolTaskDomain);
    }

    @Override
    public PWsdProtocolTaskDomain findByKey(PWsdProtocolTaskDomain pWsdProtocolTaskDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pWsdProtocolTaskDomain);
    }

    @PaginationSupport
    @Override
    public List<PWsdProtocolTaskDomain> findByWhere(PWsdProtocolTaskDomain pWsdProtocolTaskDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pWsdProtocolTaskDomain);
    }

    @Override
    public int update(PWsdProtocolTaskDomain pWsdProtocolTaskDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pWsdProtocolTaskDomain);
    }

    public int deleteList(List<PWsdProtocolTaskDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
