/**
 * 采集任务设置模板
 * ※设置时根据设置的模板明细、任务明细自动生成终端的任务及明细
 * Author :
 * Date :
 * Title : org.fms.cim.common.service;.PTaskTplServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.PTaskTplDAO;
import org.fms.cim.common.domain.uas.PTaskTplDomain;
import org.fms.cim.common.service.IPTaskTplService;
import org.fms.cim.common.vo.uas.PTaskTplVO;

import java.util.*;

@TransactionService
public class PTaskTplServiceImpl implements IPTaskTplService {

    @TransactionDAO("read")
    private PTaskTplDAO pTaskTplReadDAO;

    @TransactionDAO("write")
    private PTaskTplDAO pTaskTplWriteDAO;

    @Override
    public int insert(PTaskTplVO pTaskTplVO) {
        return pTaskTplWriteDAO.insert(pTaskTplVO.vo2Domain());
    }

    @Override
    public int update(PTaskTplVO pTaskTplVO) {
        return pTaskTplWriteDAO.update(pTaskTplVO.vo2Domain());
    }

    @Override
    public int delete(PTaskTplVO pTaskTplVO) {
        return pTaskTplWriteDAO.delete(pTaskTplVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PTaskTplVO> deleteList) throws Exception {
        int num = pTaskTplWriteDAO.deleteList(ReflectUtil.cast(deleteList, PTaskTplDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PTaskTplVO findByKey(PTaskTplVO pTaskTplVO) {
        PTaskTplDomain model = pTaskTplReadDAO.findByKey(pTaskTplVO.vo2Domain());
        PTaskTplVO modelVo = new PTaskTplVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PTaskTplVO> findByWhere(PTaskTplVO pTaskTplVO) {
        PTaskTplDomain pTaskTplDomain = pTaskTplVO.vo2Domain();
        List<PTaskTplDomain> lstDomain = pTaskTplReadDAO.findByWhere(pTaskTplDomain);
        pTaskTplVO.setTotalRow(pTaskTplDomain.getTotalRow());
        pTaskTplVO.setPageCurrent(pTaskTplDomain.getPageCurrent());
        pTaskTplVO.setDbName(pTaskTplDomain.getDbName());
        pTaskTplVO.setPageSize(pTaskTplDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PTaskTplVO.class);
    }

}
