/**
 * 规约数据单元
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.PWsdTaskdataDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import java.util.List;

import org.fms.cim.common.domain.uas.PWsdTaskdataDomain;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;

@TransactionDAO
public class PWsdTaskdataDAO extends AbstractTransactionDAOSupport implements BaseDAO<PWsdTaskdataDomain> {

    @Override
    public int insert(PWsdTaskdataDomain pWsdTaskdataDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pWsdTaskdataDomain);
    }

    @Override
    public int delete(PWsdTaskdataDomain pWsdTaskdataDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pWsdTaskdataDomain);
    }

    @Override
    public PWsdTaskdataDomain findByKey(PWsdTaskdataDomain pWsdTaskdataDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pWsdTaskdataDomain);
    }

    @PaginationSupport
    @Override
    public List<PWsdTaskdataDomain> findByWhere(PWsdTaskdataDomain pWsdTaskdataDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pWsdTaskdataDomain);
    }

    @Override
    public int update(PWsdTaskdataDomain pWsdTaskdataDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pWsdTaskdataDomain);
    }

    public int deleteList(List<PWsdTaskdataDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
