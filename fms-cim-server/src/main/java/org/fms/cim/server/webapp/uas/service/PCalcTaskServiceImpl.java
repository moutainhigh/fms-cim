/**
 * 计算任务
 * Author :
 * Date :
 * Title : org.fms.cim.common.service;.PCalcTaskServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.PCalcTaskDAO;
import org.fms.cim.common.domain.uas.PCalcTaskDomain;
import org.fms.cim.common.domain.uas.PCalcTaskRelDomain;
import org.fms.cim.common.service.IPCalcTaskService;
import org.fms.cim.common.vo.uas.PCalcTaskRelVO;
import org.fms.cim.common.vo.uas.PCalcTaskVO;

import java.util.*;

@TransactionService
public class PCalcTaskServiceImpl implements IPCalcTaskService {

    @TransactionDAO("read")
    private PCalcTaskDAO pCalcTaskReadDAO;

    @TransactionDAO("write")
    private PCalcTaskDAO pCalcTaskWriteDAO;

    @Override
    public int insert(PCalcTaskVO pCalcTaskVO) {
        return pCalcTaskWriteDAO.insert(pCalcTaskVO.vo2Domain());
    }

    @Override
    public int update(PCalcTaskVO pCalcTaskVO) {
        return pCalcTaskWriteDAO.update(pCalcTaskVO.vo2Domain());
    }

    @Override
    public int delete(PCalcTaskVO pCalcTaskVO) {
        return pCalcTaskWriteDAO.delete(pCalcTaskVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PCalcTaskVO> deleteList) throws Exception {
        int num = pCalcTaskWriteDAO.deleteList(ReflectUtil.cast(deleteList, PCalcTaskDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PCalcTaskVO findByKey(PCalcTaskVO pCalcTaskVO) {
        PCalcTaskDomain model = pCalcTaskReadDAO.findByKey(pCalcTaskVO.vo2Domain());
        PCalcTaskVO modelVo = new PCalcTaskVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PCalcTaskVO> findByWhere(PCalcTaskVO pCalcTaskVO) {
        PCalcTaskDomain pCalcTaskDomain = pCalcTaskVO.vo2Domain();
        List<PCalcTaskDomain> lstDomain = pCalcTaskReadDAO.findByWhere(pCalcTaskDomain);
        pCalcTaskVO.setTotalRow(pCalcTaskDomain.getTotalRow());
        pCalcTaskVO.setPageCurrent(pCalcTaskDomain.getPageCurrent());
        pCalcTaskVO.setDbName(pCalcTaskDomain.getDbName());
        pCalcTaskVO.setPageSize(pCalcTaskDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PCalcTaskVO.class);
    }

    @Override
    public List<PCalcTaskRelVO> findByRelTpl(PCalcTaskRelVO modelVO) {
        PCalcTaskRelDomain modelDomain = modelVO.vo2Domain();
        List<PCalcTaskRelDomain> lstDomain = pCalcTaskReadDAO.findByRelTpl(modelDomain);
        modelVO.setTotalRow(modelDomain.getTotalRow());
        modelVO.setPageCurrent(modelDomain.getPageCurrent());
        modelVO.setDbName(modelDomain.getDbName());
        modelVO.setPageSize(modelDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PCalcTaskRelVO.class);
    }
}
