package org.fms.cim.server.webapp.archives.service;

import java.util.Date;
import java.util.List;

import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.archives.TgInfoDomain;
import org.fms.cim.common.domain.uas.PCalcTaskDomain;
import org.fms.cim.common.service.ITgInfoService;
import org.fms.cim.common.vo.uas.PCalcTaskVO;
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
        return tgInfoDAO.insert(t.vo2Domain());
    }
    @Override
    public int delete(TgInfoVO t) {
        return tgInfoDAO.delete(t.vo2Domain());
    }
    @Override
    public int update(TgInfoVO t) {
        return tgInfoDAO.update(t.vo2Domain());
    }
    @Override
    public TgInfoVO findByKey(TgInfoVO t) {
        TgInfoDomain model = tgInfoDAO.findByKey(t.vo2Domain());
        TgInfoVO modelVo = new TgInfoVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }
    @Override
    public List<TgInfoVO> findByWhere(TgInfoVO t) {
        TgInfoDomain tgInfoDomain = t.vo2Domain();
        List<TgInfoDomain> lstDomain = tgInfoDAO.findByWhere(tgInfoDomain);
        t.setTotalRow(tgInfoDomain.getTotalRow());
        t.setPageCurrent(tgInfoDomain.getPageCurrent());
        t.setDbName(tgInfoDomain.getDbName());
        t.setPageSize(tgInfoDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, TgInfoVO.class);
    }
    @Override
    public List<TgInfoVO> findByNo(TgInfoVO t) {
        TgInfoDomain tgInfoDomain = t.vo2Domain();
        List<TgInfoDomain> lstDomain = tgInfoDAO.findByNo(tgInfoDomain);
        t.setTotalRow(tgInfoDomain.getTotalRow());
        t.setPageCurrent(tgInfoDomain.getPageCurrent());
        t.setDbName(tgInfoDomain.getDbName());
        t.setPageSize(tgInfoDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, TgInfoVO.class);

        //return tgInfoDAO.findByNo(t.vo2Domain());
    }
    //TODO
	@Override
	public HttpResult deleteList(List<TgInfoVO> deleteList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
