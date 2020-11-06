/**
 * 采集主机组
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.cim.server.webapp.uas.dao.PWsdChnlTypeDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;
import org.fms.cim.common.domain.uas.PWsdChnlTypeDomain;

import java.util.List;

@TransactionDAO
public class PWsdChnlTypeDAO extends AbstractTransactionDAOSupport implements BaseDAO<PWsdChnlTypeDomain> {

    @Override
    public int insert(PWsdChnlTypeDomain pWsdChnlTypeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pWsdChnlTypeDomain);
    }

    @Override
    public int delete(PWsdChnlTypeDomain pWsdChnlTypeDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pWsdChnlTypeDomain);
    }

    @Override
    public PWsdChnlTypeDomain findByKey(PWsdChnlTypeDomain pWsdChnlTypeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pWsdChnlTypeDomain);
    }

    @PaginationSupport
    @Override
    public List<PWsdChnlTypeDomain> findByWhere(PWsdChnlTypeDomain pWsdChnlTypeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pWsdChnlTypeDomain);
    }

    @Override
    public int update(PWsdChnlTypeDomain pWsdChnlTypeDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pWsdChnlTypeDomain);
    }

    public int deleteList(List<PWsdChnlTypeDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
