/**
 * Author :
 * Date :
 * Title : org.fms.cim.common.service;.PMeterModelServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.PMeterModelDAO;
import org.fms.cim.common.domain.uas.PMeterModelDomain;
import org.fms.cim.common.service.IPMeterModelService;
import org.fms.cim.common.vo.uas.PMeterModelVO;

import java.util.*;

@TransactionService
public class PMeterModelServiceImpl implements IPMeterModelService {

    @TransactionDAO("read")
    private PMeterModelDAO pMeterModelReadDAO;

    @TransactionDAO("write")
    private PMeterModelDAO pMeterModelWriteDAO;

    @Override
    public int insert(PMeterModelVO pMeterModelVO) {
        return pMeterModelWriteDAO.insert(pMeterModelVO.vo2Domain());
    }

    @Override
    public int update(PMeterModelVO pMeterModelVO) {
        return pMeterModelWriteDAO.update(pMeterModelVO.vo2Domain());
    }

    @Override
    public int delete(PMeterModelVO pMeterModelVO) {
        return pMeterModelWriteDAO.delete(pMeterModelVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PMeterModelVO> deleteList) throws Exception {
        int num = pMeterModelWriteDAO.deleteList(ReflectUtil.cast(deleteList, PMeterModelDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PMeterModelVO findByKey(PMeterModelVO pMeterModelVO) {
        PMeterModelDomain model = pMeterModelReadDAO.findByKey(pMeterModelVO.vo2Domain());
        PMeterModelVO modelVo = new PMeterModelVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PMeterModelVO> findByWhere(PMeterModelVO pMeterModelVO) {
        PMeterModelDomain pMeterModelDomain = pMeterModelVO.vo2Domain();
        List<PMeterModelDomain> lstDomain = pMeterModelReadDAO.findByWhere(pMeterModelDomain);
        pMeterModelVO.setTotalRow(pMeterModelDomain.getTotalRow());
        pMeterModelVO.setPageCurrent(pMeterModelDomain.getPageCurrent());
        pMeterModelVO.setDbName(pMeterModelDomain.getDbName());
        pMeterModelVO.setPageSize(pMeterModelDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PMeterModelVO.class);
    }

}
