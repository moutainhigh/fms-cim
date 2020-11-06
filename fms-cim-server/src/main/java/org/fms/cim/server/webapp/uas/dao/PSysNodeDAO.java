/**
 * 系统节点
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.cim.server.webapp.uas.dao.PSysNodeDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.PChnlGpDasRelaDomain;
import org.fms.cim.common.domain.uas.PSysNodeDomain;
import org.fms.cim.common.vo.uas.PSysNodeVO;

import java.util.List;
import java.util.Map;

@TransactionDAO
public class PSysNodeDAO extends AbstractTransactionDAOSupport implements BaseDAO<PSysNodeDomain> {

    @Override
    public int insert(PSysNodeDomain pSysNodeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pSysNodeDomain);
    }

    @Override
    public int delete(PSysNodeDomain pSysNodeDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pSysNodeDomain);
    }

    @Override
    public PSysNodeDomain findByKey(PSysNodeDomain pSysNodeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pSysNodeDomain);
    }

    @PaginationSupport
    @Override
    public List<PSysNodeDomain> findByWhere(PSysNodeDomain pSysNodeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pSysNodeDomain);
    }

    @Override
    public int update(PSysNodeDomain pSysNodeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pSysNodeDomain);
    }

    public int deleteList(List<PSysNodeDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

    public int updateListDaserverGroup(List<PSysNodeDomain> sysNodeDomainList) {
        return getPersistanceManager().updateList(getNamespace() + ".update", sysNodeDomainList);
    }

    public List<PSysNodeDomain> findByRelDasGroup(String value) {
        return getPersistanceManager().find(getNamespace() + ".findByRelDasGroup", value);
    }
}
