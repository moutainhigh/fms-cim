/**
 * 通道组主机关系
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.cim.server.webapp.uas.dao.PChnlGpDasRelaDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.PChnlGpDasRelaDomain;

import java.util.List;

@TransactionDAO
public class PChnlGpDasRelaDAO extends AbstractTransactionDAOSupport implements BaseDAO<PChnlGpDasRelaDomain> {

    @Override
    public int insert(PChnlGpDasRelaDomain pChnlGpDasRelaDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pChnlGpDasRelaDomain);
    }

    @Override
    public int delete(PChnlGpDasRelaDomain pChnlGpDasRelaDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pChnlGpDasRelaDomain);
    }

    @Override
    public PChnlGpDasRelaDomain findByKey(PChnlGpDasRelaDomain pChnlGpDasRelaDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pChnlGpDasRelaDomain);
    }

    @PaginationSupport
    @Override
    public List<PChnlGpDasRelaDomain> findByWhere(PChnlGpDasRelaDomain pChnlGpDasRelaDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pChnlGpDasRelaDomain);
    }

    @Override
    public int update(PChnlGpDasRelaDomain pChnlGpDasRelaDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pChnlGpDasRelaDomain);
    }

    public int deleteList(List<PChnlGpDasRelaDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

    public List<PChnlGpDasRelaDomain> findByRelSysNode(String value) {
        return getPersistanceManager().find(getNamespace() + ".findByRelSysNode", value);
    }

    public List<PChnlGpDasRelaDomain> findByRelGroup(String value) {
        return getPersistanceManager().find(getNamespace() + ".findByRelGroup", value);
    }
}
