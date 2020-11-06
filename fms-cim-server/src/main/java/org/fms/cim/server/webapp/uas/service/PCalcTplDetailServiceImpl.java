/**
 * 计算方案模板明细
 * Author :
 * Date :
 * Title : org.fms.cim.common.service;.PCalcTplDetailServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.PCalcTplDetailDAO;
import org.fms.cim.common.domain.uas.PCalcTplDetailDomain;
import org.fms.cim.common.service.IPCalcTplDetailService;
import org.fms.cim.common.vo.uas.PCalcTplDetailVO;

import java.util.*;

@TransactionService
public class PCalcTplDetailServiceImpl implements IPCalcTplDetailService {

    @TransactionDAO("read")
    private PCalcTplDetailDAO pCalcTplDetailReadDAO;

    @TransactionDAO("write")
    private PCalcTplDetailDAO pCalcTplDetailWriteDAO;

    @Override
    public int insert(PCalcTplDetailVO pCalcTplDetailVO) {
        return pCalcTplDetailWriteDAO.insert(pCalcTplDetailVO.vo2Domain());
    }

    @Override
    public int update(PCalcTplDetailVO pCalcTplDetailVO) {
        return pCalcTplDetailWriteDAO.update(pCalcTplDetailVO.vo2Domain());
    }

    @Override
    public int delete(PCalcTplDetailVO pCalcTplDetailVO) {
        return pCalcTplDetailWriteDAO.delete(pCalcTplDetailVO.vo2Domain());
    }

    @Override
    public int deleteList(List<PCalcTplDetailVO> deleteList) {
        return pCalcTplDetailWriteDAO.deleteList(ReflectUtil.cast(deleteList, PCalcTplDetailDomain.class));
    }

    @Override
    public PCalcTplDetailVO findByKey(PCalcTplDetailVO pCalcTplDetailVO) {
        PCalcTplDetailDomain model = pCalcTplDetailReadDAO.findByKey(pCalcTplDetailVO.vo2Domain());
        PCalcTplDetailVO modelVo = new PCalcTplDetailVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PCalcTplDetailVO> findByWhere(PCalcTplDetailVO pCalcTplDetailVO) {
        PCalcTplDetailDomain pCalcTplDetailDomain = pCalcTplDetailVO.vo2Domain();
        List<PCalcTplDetailDomain> lstDomain = pCalcTplDetailReadDAO.findByWhere(pCalcTplDetailDomain);
        pCalcTplDetailVO.setTotalRow(pCalcTplDetailDomain.getTotalRow());
        pCalcTplDetailVO.setPageCurrent(pCalcTplDetailDomain.getPageCurrent());
        pCalcTplDetailVO.setDbName(pCalcTplDetailDomain.getDbName());
        pCalcTplDetailVO.setPageSize(pCalcTplDetailDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PCalcTplDetailVO.class);
    }

    @Override
    public int insertList(List<PCalcTplDetailVO> insertList) {
        return pCalcTplDetailWriteDAO.insertList(ReflectUtil.cast(insertList, PCalcTplDetailDomain.class));
    }
}
