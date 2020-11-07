/**
 * 异常工单明细
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.SWorkOrderDetailServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.SWorkOrderDetailDAO;
import org.fms.cim.common.domain.uas.SWorkOrderDetailDomain;
import org.fms.cim.common.service.ISWorkOrderDetailService;
import org.fms.cim.common.vo.uas.SWorkOrderDetailVO;

import java.util.*;

@TransactionService
public class SWorkOrderDetailServiceImpl implements ISWorkOrderDetailService {

    @TransactionDAO("read")
    private SWorkOrderDetailDAO sWorkOrderDetailReadDAO;

    @TransactionDAO("write")
    private SWorkOrderDetailDAO sWorkOrderDetailWriteDAO;

    @Override
    public int insert(SWorkOrderDetailVO sWorkOrderDetailVO) {
        return sWorkOrderDetailWriteDAO.insert(sWorkOrderDetailVO.vo2Domain());
    }

    @Override
    public int update(SWorkOrderDetailVO sWorkOrderDetailVO) {
        return sWorkOrderDetailWriteDAO.update(sWorkOrderDetailVO.vo2Domain());
    }

    @Override
    public int delete(SWorkOrderDetailVO sWorkOrderDetailVO) {
        return sWorkOrderDetailWriteDAO.delete(sWorkOrderDetailVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<SWorkOrderDetailVO> deleteList) throws Exception {
        int num = sWorkOrderDetailWriteDAO.deleteList(ReflectUtil.cast(deleteList, SWorkOrderDetailDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public SWorkOrderDetailVO findByKey(SWorkOrderDetailVO sWorkOrderDetailVO) {
        SWorkOrderDetailDomain model = sWorkOrderDetailReadDAO.findByKey(sWorkOrderDetailVO.vo2Domain());
        SWorkOrderDetailVO modelVo = new SWorkOrderDetailVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<SWorkOrderDetailVO> findByWhere(SWorkOrderDetailVO sWorkOrderDetailVO) {
        SWorkOrderDetailDomain sWorkOrderDetailDomain = sWorkOrderDetailVO.vo2Domain();
        List<SWorkOrderDetailDomain> lstDomain = sWorkOrderDetailReadDAO.findByWhere(sWorkOrderDetailDomain);
        sWorkOrderDetailVO.setTotalRow(sWorkOrderDetailDomain.getTotalRow());
        sWorkOrderDetailVO.setPageCurrent(sWorkOrderDetailDomain.getPageCurrent());
        sWorkOrderDetailVO.setDbName(sWorkOrderDetailDomain.getDbName());
        sWorkOrderDetailVO.setPageSize(sWorkOrderDetailDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, SWorkOrderDetailVO.class);
    }

}
