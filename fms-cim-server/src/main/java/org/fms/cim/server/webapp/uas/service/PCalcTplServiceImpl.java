/**
 * 计算方案模板
 * Author :
 * Date :
 * Title : org.fms.cim.common.service;.PCalcTplServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.fms.cim.common.vo.uas.PCalcTaskVO;
import org.fms.cim.server.webapp.uas.dao.PCalcTplDAO;
import org.fms.cim.common.domain.uas.PCalcTplDomain;
import org.fms.cim.common.service.IPCalcTplService;
import org.fms.cim.common.vo.uas.PCalcTplVO;

import java.util.*;

@TransactionService
public class PCalcTplServiceImpl implements IPCalcTplService {

    @TransactionDAO("read")
    private PCalcTplDAO pCalcTplReadDAO;

    @TransactionDAO("write")
    private PCalcTplDAO pCalcTplWriteDAO;

    @Override
    public int insert(PCalcTplVO pCalcTplVO) {
        return pCalcTplWriteDAO.insert(pCalcTplVO.vo2Domain());
    }

    @Override
    public int update(PCalcTplVO pCalcTplVO) {
        return pCalcTplWriteDAO.update(pCalcTplVO.vo2Domain());
    }

    @Override
    public int delete(PCalcTplVO pCalcTplVO) {
        return pCalcTplWriteDAO.delete(pCalcTplVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PCalcTplVO> deleteList) throws Exception {
        int num = pCalcTplWriteDAO.deleteList(ReflectUtil.cast(deleteList, PCalcTplDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PCalcTplVO findByKey(PCalcTplVO pCalcTplVO) {
        PCalcTplDomain model = pCalcTplReadDAO.findByKey(pCalcTplVO.vo2Domain());
        PCalcTplVO modelVo = new PCalcTplVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PCalcTplVO> findByWhere(PCalcTplVO pCalcTplVO) {
        PCalcTplDomain pCalcTplDomain = pCalcTplVO.vo2Domain();
        List<PCalcTplDomain> lstDomain = pCalcTplReadDAO.findByWhere(pCalcTplDomain);
        pCalcTplVO.setTotalRow(pCalcTplDomain.getTotalRow());
        pCalcTplVO.setPageCurrent(pCalcTplDomain.getPageCurrent());
        pCalcTplVO.setDbName(pCalcTplDomain.getDbName());
        pCalcTplVO.setPageSize(pCalcTplDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PCalcTplVO.class);
    }

    @Override
    public int verifyDefaultUniqueness(PCalcTplVO modelVO){
        return pCalcTplReadDAO.verifyDefaultUniqueness(modelVO.vo2Domain());
    }
}
