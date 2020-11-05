/**
 * 采集任务模板明细
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.impl.PTaskTplDetailServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import java.util.List;

import org.fms.cim.common.domain.uas.PTaskTplDetailDomain;
import org.fms.cim.common.service.IPTaskTplDetailService;
import org.fms.cim.common.vo.uas.PTaskTplDetailVO;
import org.fms.cim.server.webapp.uas.dao.PTaskTplDetailDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;

@TransactionService
public class PTaskTplDetailServiceImpl implements IPTaskTplDetailService {

    @TransactionDAO("read")
    private PTaskTplDetailDAO pTaskTplDetailReadDAO;

    @TransactionDAO("write")
    private PTaskTplDetailDAO pTaskTplDetailWriteDAO;

    @Override
    public int insert(PTaskTplDetailVO pTaskTplDetailVO) {
        return pTaskTplDetailWriteDAO.insert(pTaskTplDetailVO.vo2Domain());
    }

    @Override
    public int update(PTaskTplDetailVO pTaskTplDetailVO) {
        return pTaskTplDetailWriteDAO.update(pTaskTplDetailVO.vo2Domain());
    }

    @Override
    public int delete(PTaskTplDetailVO pTaskTplDetailVO) {
        return pTaskTplDetailWriteDAO.delete(pTaskTplDetailVO.vo2Domain());
    }

    @Override
    public int deleteList(List<PTaskTplDetailVO> deleteList) {
        return pTaskTplDetailWriteDAO.deleteList(ReflectUtil.cast(deleteList, PTaskTplDetailDomain.class));
    }

    @Override
    public PTaskTplDetailVO findByKey(PTaskTplDetailVO pTaskTplDetailVO) {
        PTaskTplDetailDomain model = pTaskTplDetailReadDAO.findByKey(pTaskTplDetailVO.vo2Domain());
        PTaskTplDetailVO modelVo = new PTaskTplDetailVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PTaskTplDetailVO> findByWhere(PTaskTplDetailVO pTaskTplDetailVO) {
        PTaskTplDetailDomain pTaskTplDetailDomain = pTaskTplDetailVO.vo2Domain();
        List<PTaskTplDetailDomain> lstDomain = pTaskTplDetailReadDAO.findByWhere(pTaskTplDetailDomain);
        pTaskTplDetailVO.setTotalRow(pTaskTplDetailDomain.getTotalRow());
        pTaskTplDetailVO.setPageCurrent(pTaskTplDetailDomain.getPageCurrent());
        pTaskTplDetailVO.setDbName(pTaskTplDetailDomain.getDbName());
        pTaskTplDetailVO.setPageSize(pTaskTplDetailDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PTaskTplDetailVO.class);
    }

    @Override
    public int insertList(List<PTaskTplDetailVO> insertList){
        return pTaskTplDetailReadDAO.insertList(ReflectUtil.cast(insertList, PTaskTplDetailDomain.class));
    }
}
