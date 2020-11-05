/**
 * 台区表
 * Author :
 * Date : 2020年10月22日 上午9:59:25
 * Title : org.fms.eis.webapp.dao.TgInfoDAO.java
 **/
package org.fms.cim.server.webapp.uas.dao;

import java.util.List;

import org.fms.cim.common.domain.archives.TgInfoDomain;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;

@TransactionDAO
public class TgInfoDAO extends AbstractTransactionDAOSupport implements BaseDAO<TgInfoDomain> {

    @Override
    public int insert(TgInfoDomain tgInfoDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().insert(getNamespace() + ".insert", tgInfoDomain);
    }

    @Override
    public int delete(TgInfoDomain tgInfoDomain) {
        return getPersistanceManager().delete(getNamespace() + ".delete", tgInfoDomain);
    }

    @Override
    public TgInfoDomain findByKey(TgInfoDomain tgInfoDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().load(getNamespace() + ".findByKey", tgInfoDomain);
    }

    @PaginationSupport
    @Override
    public List<TgInfoDomain> findByWhere(TgInfoDomain tgInfoDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", tgInfoDomain);
    }

    @Override
    public int update(TgInfoDomain tgInfoDomain) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".update", tgInfoDomain);
    }

    public int deleteList(List<TgInfoDomain> deleteList) {
        return getPersistanceManager().deleteList(getNamespace() + ".delete", deleteList);
    }

}
