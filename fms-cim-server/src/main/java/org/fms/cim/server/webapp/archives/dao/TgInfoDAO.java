package org.fms.cim.server.webapp.archives.dao;

import java.util.List;

import org.fms.cim.common.domain.archives.TgInfoDomain;
import org.fms.cim.common.vo.uas.TgInfoVO;

import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;

@TransactionDAO
public class TgInfoDAO extends AbstractTransactionDAOSupport implements BaseDAO<TgInfoVO> {
    @Override
    public int insert(TgInfoVO t) {
        return getPersistanceManager().insert(getNamespace() + ".insert", t);
    }

    @Override
    public int delete(TgInfoVO t) {
        return getPersistanceManager().delete(getNamespace() + ".delete", t);
    }

    @Override
    public int update(TgInfoVO t) {
        return getPersistanceManager().update(getNamespace() + ".update", t);
    }

    @Override
    public TgInfoVO findByKey(TgInfoVO t) {
        return getPersistanceManager().load(getNamespace() + ".findByKey", t);
    }

    @Override
	@PaginationSupport
    public List<TgInfoVO> findByWhere(TgInfoVO t) {
        return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
    }

    public List<TgInfoVO> findByNo(TgInfoVO t) {
        return getPersistanceManager().find(getNamespace() + ".findByNo", t);
    }
}
