/**
 * 异常工单
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.SWorkOrderServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.SWorkOrderDAO;
import org.fms.cim.common.domain.uas.SWorkOrderDomain;
import org.fms.cim.common.service.ISWorkOrderService;
import org.fms.cim.common.vo.uas.SWorkOrderVO;

import java.util.*;

@TransactionService
public class SWorkOrderServiceImpl implements ISWorkOrderService {

    @TransactionDAO("read")
    private SWorkOrderDAO sWorkOrderReadDAO;

    @TransactionDAO("write")
    private SWorkOrderDAO sWorkOrderWriteDAO;

    @Override
    public int insert(SWorkOrderVO sWorkOrderVO) {
        return sWorkOrderWriteDAO.insert(sWorkOrderVO.vo2Domain());
    }

    @Override
    public int update(SWorkOrderVO sWorkOrderVO) {
        return sWorkOrderWriteDAO.update(sWorkOrderVO.vo2Domain());
    }

    @Override
    public int delete(SWorkOrderVO sWorkOrderVO) {
        return sWorkOrderWriteDAO.delete(sWorkOrderVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<SWorkOrderVO> deleteList) throws Exception {
        int num = sWorkOrderWriteDAO.deleteList(ReflectUtil.cast(deleteList, SWorkOrderDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public SWorkOrderVO findByKey(SWorkOrderVO sWorkOrderVO) {
        SWorkOrderDomain model = sWorkOrderReadDAO.findByKey(sWorkOrderVO.vo2Domain());
        SWorkOrderVO modelVo = new SWorkOrderVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<SWorkOrderVO> findByWhere(SWorkOrderVO sWorkOrderVO) {
        SWorkOrderDomain sWorkOrderDomain = sWorkOrderVO.vo2Domain();
        List<SWorkOrderDomain> lstDomain = sWorkOrderReadDAO.findByWhere(sWorkOrderDomain);
        sWorkOrderVO.setTotalRow(sWorkOrderDomain.getTotalRow());
        sWorkOrderVO.setPageCurrent(sWorkOrderDomain.getPageCurrent());
        sWorkOrderVO.setDbName(sWorkOrderDomain.getDbName());
        sWorkOrderVO.setPageSize(sWorkOrderDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, SWorkOrderVO.class);
    }

}
