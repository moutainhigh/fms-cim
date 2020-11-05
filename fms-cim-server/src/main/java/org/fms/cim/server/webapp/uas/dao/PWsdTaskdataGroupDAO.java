/**
 * 规约数据单元组（※相当于原来变电站采集的规约信息体类型）
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.PWsdTaskdataGroupDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import java.util.List;

import org.fms.cim.common.domain.uas.PWsdTaskdataGroupDomain;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;

@TransactionDAO
public class PWsdTaskdataGroupDAO extends AbstractTransactionDAOSupport implements BaseDAO<PWsdTaskdataGroupDomain> {

    @Override
    public int insert(PWsdTaskdataGroupDomain pWsdTaskdataGroupDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", pWsdTaskdataGroupDomain);
    }

    @Override
    public int delete(PWsdTaskdataGroupDomain pWsdTaskdataGroupDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", pWsdTaskdataGroupDomain);
    }

    @Override
    public PWsdTaskdataGroupDomain findByKey(PWsdTaskdataGroupDomain pWsdTaskdataGroupDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", pWsdTaskdataGroupDomain);
    }

    @PaginationSupport
    @Override
    public List<PWsdTaskdataGroupDomain> findByWhere(PWsdTaskdataGroupDomain pWsdTaskdataGroupDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", pWsdTaskdataGroupDomain);
    }

    @Override
    public int update(PWsdTaskdataGroupDomain pWsdTaskdataGroupDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", pWsdTaskdataGroupDomain);
    }

    public int deleteList(List<PWsdTaskdataGroupDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
