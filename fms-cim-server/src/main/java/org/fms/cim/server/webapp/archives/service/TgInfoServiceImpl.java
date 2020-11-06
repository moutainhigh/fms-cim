package org.fms.cim.server.webapp.archives.service;

import java.util.Date;
import java.util.List;

import org.fms.cim.common.domain.archives.TgInfoDomain;
import org.fms.cim.common.service.ITgInfoService;
import org.fms.cim.common.vo.uas.TgInfoVO;
import org.fms.cim.server.webapp.archives.dao.TgInfoDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.spring.web.http.HttpResult;

@TransactionService
public class TgInfoServiceImpl implements ITgInfoService {

    @TransactionDAO
    private TgInfoDAO tgInfoDAO;

    Date now = new Date();
    @Override
    public int insert(TgInfoVO t) {
        return tgInfoDAO.insert(t);
    }
    @Override
    public int delete(TgInfoVO t) {
        return tgInfoDAO.delete(t);
    }
    @Override
    public int update(TgInfoVO t) {
        return tgInfoDAO.update(t);
    }
    @Override
    public TgInfoVO findByKey(TgInfoVO t) {
        return tgInfoDAO.findByKey(t);
    }
    @Override
    public List<TgInfoVO> findByWhere(TgInfoVO t) {
        return tgInfoDAO.findByWhere(t);
    }
    @Override
    public List<TgInfoVO> findByNo(TgInfoVO t) {
        return tgInfoDAO.findByNo(t);
    }
    //TODO
	@Override
	public HttpResult deleteList(List<TgInfoVO> deleteList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
