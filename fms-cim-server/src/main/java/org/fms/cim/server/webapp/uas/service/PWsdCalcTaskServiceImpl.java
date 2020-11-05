/**
 * 计算任务类型定义表
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.impl.PWsdCalcTaskServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import java.util.List;

import org.fms.cim.common.domain.uas.PWsdCalcTaskDomain;
import org.fms.cim.common.service.IPWsdCalcTaskService;
import org.fms.cim.common.vo.uas.PWsdCalcTaskVO;
import org.fms.cim.server.webapp.uas.dao.PWsdCalcTaskDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.spring.web.http.HttpResult;

@TransactionService
public class PWsdCalcTaskServiceImpl implements IPWsdCalcTaskService {

    @TransactionDAO("read")
    private PWsdCalcTaskDAO pWsdCalcTaskReadDAO;

    @TransactionDAO("write")
    private PWsdCalcTaskDAO pWsdCalcTaskWriteDAO;

    @Override
    public int insert(PWsdCalcTaskVO pWsdCalcTaskVO) {
        return pWsdCalcTaskWriteDAO.insert(pWsdCalcTaskVO.vo2Domain());
    }

    @Override
    public int update(PWsdCalcTaskVO pWsdCalcTaskVO) {
        return pWsdCalcTaskWriteDAO.update(pWsdCalcTaskVO.vo2Domain());
    }

    @Override
    public int delete(PWsdCalcTaskVO pWsdCalcTaskVO) {
        return pWsdCalcTaskWriteDAO.delete(pWsdCalcTaskVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PWsdCalcTaskVO> deleteList) throws Exception {
        int num = pWsdCalcTaskWriteDAO.deleteList(ReflectUtil.cast(deleteList, PWsdCalcTaskDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PWsdCalcTaskVO findByKey(PWsdCalcTaskVO pWsdCalcTaskVO) {
        PWsdCalcTaskDomain model = pWsdCalcTaskReadDAO.findByKey(pWsdCalcTaskVO.vo2Domain());
        PWsdCalcTaskVO modelVo = new PWsdCalcTaskVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PWsdCalcTaskVO> findByWhere(PWsdCalcTaskVO pWsdCalcTaskVO) {
        PWsdCalcTaskDomain pWsdCalcTaskDomain = pWsdCalcTaskVO.vo2Domain();
        List<PWsdCalcTaskDomain> lstDomain = pWsdCalcTaskReadDAO.findByWhere(pWsdCalcTaskDomain);
        pWsdCalcTaskVO.setTotalRow(pWsdCalcTaskDomain.getTotalRow());
        pWsdCalcTaskVO.setPageCurrent(pWsdCalcTaskDomain.getPageCurrent());
        pWsdCalcTaskVO.setDbName(pWsdCalcTaskDomain.getDbName());
        pWsdCalcTaskVO.setPageSize(pWsdCalcTaskDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PWsdCalcTaskVO.class);
    }

}
