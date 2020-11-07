/**
 * 采集任务
 * Author :
 * Date :
 * Title : org.fms.cim.common.service;.PTaskServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.PTaskDAO;
import org.fms.cim.common.domain.uas.PTaskDomain;
import org.fms.cim.common.domain.uas.PTaskRelDomain;
import org.fms.cim.common.service.IPTaskService;
import org.fms.cim.common.vo.uas.PTaskRelVO;
import org.fms.cim.common.vo.uas.PTaskVO;

import java.util.*;

@TransactionService
public class PTaskServiceImpl implements IPTaskService {

    @TransactionDAO("read")
    private PTaskDAO pTaskReadDAO;

    @TransactionDAO("write")
    private PTaskDAO pTaskWriteDAO;

    @Override
    public int insert(PTaskVO pTaskVO) {
        return pTaskWriteDAO.insert(pTaskVO.vo2Domain());
    }

    @Override
    public int update(PTaskVO pTaskVO) {
        return pTaskWriteDAO.update(pTaskVO.vo2Domain());
    }

    @Override
    public int delete(PTaskVO pTaskVO) {
        return pTaskWriteDAO.delete(pTaskVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PTaskVO> deleteList) throws Exception {
        int num = pTaskWriteDAO.deleteList(ReflectUtil.cast(deleteList, PTaskDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PTaskVO findByKey(PTaskVO pTaskVO) {
        PTaskDomain model = pTaskReadDAO.findByKey(pTaskVO.vo2Domain());
        PTaskVO modelVo = new PTaskVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PTaskVO> findByWhere(PTaskVO pTaskVO) {
        PTaskDomain pTaskDomain = pTaskVO.vo2Domain();
        List<PTaskDomain> lstDomain = pTaskReadDAO.findByWhere(pTaskDomain);
        pTaskVO.setTotalRow(pTaskDomain.getTotalRow());
        pTaskVO.setPageCurrent(pTaskDomain.getPageCurrent());
        pTaskVO.setDbName(pTaskDomain.getDbName());
        pTaskVO.setPageSize(pTaskDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PTaskVO.class);
    }

    @Override
    public List<PTaskRelVO> findByTaskTpl(PTaskRelVO modelVO) {
        PTaskRelDomain modelDomain = modelVO.vo2Domain();
        List<PTaskRelDomain> lstDomain = pTaskReadDAO.findByTaskTpl(modelDomain);
        modelVO.setTotalRow(modelDomain.getTotalRow());
        modelVO.setPageCurrent(modelDomain.getPageCurrent());
        modelVO.setDbName(modelDomain.getDbName());
        modelVO.setPageSize(modelDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PTaskRelVO.class);
    }
}
