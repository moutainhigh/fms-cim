/**
 * 系统公告
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.SIssueInfoServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.SIssueInfoDAO;
import org.fms.cim.common.domain.uas.SIssueInfoDomain;
import org.fms.cim.common.service.ISIssueInfoService;
import org.fms.cim.common.vo.uas.SIssueInfoVO;

import java.util.*;

@TransactionService
public class SIssueInfoServiceImpl implements ISIssueInfoService {

    @TransactionDAO("read")
    private SIssueInfoDAO sIssueInfoReadDAO;

    @TransactionDAO("write")
    private SIssueInfoDAO sIssueInfoWriteDAO;

    @Override
    public int insert(SIssueInfoVO sIssueInfoVO) {
        return sIssueInfoWriteDAO.insert(sIssueInfoVO.vo2Domain());
    }

    @Override
    public int update(SIssueInfoVO sIssueInfoVO) {
        return sIssueInfoWriteDAO.update(sIssueInfoVO.vo2Domain());
    }

    @Override
    public int delete(SIssueInfoVO sIssueInfoVO) {
        return sIssueInfoWriteDAO.delete(sIssueInfoVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<SIssueInfoVO> deleteList) throws Exception {
        int num = sIssueInfoWriteDAO.deleteList(ReflectUtil.cast(deleteList, SIssueInfoDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public SIssueInfoVO findByKey(SIssueInfoVO sIssueInfoVO) {
        SIssueInfoDomain model = sIssueInfoReadDAO.findByKey(sIssueInfoVO.vo2Domain());
        SIssueInfoVO modelVo = new SIssueInfoVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<SIssueInfoVO> findByWhere(SIssueInfoVO sIssueInfoVO) {
        SIssueInfoDomain sIssueInfoDomain = sIssueInfoVO.vo2Domain();
        List<SIssueInfoDomain> lstDomain = sIssueInfoReadDAO.findByWhere(sIssueInfoDomain);
        sIssueInfoVO.setTotalRow(sIssueInfoDomain.getTotalRow());
        sIssueInfoVO.setPageCurrent(sIssueInfoDomain.getPageCurrent());
        sIssueInfoVO.setDbName(sIssueInfoDomain.getDbName());
        sIssueInfoVO.setPageSize(sIssueInfoDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, SIssueInfoVO.class);
    }

}
