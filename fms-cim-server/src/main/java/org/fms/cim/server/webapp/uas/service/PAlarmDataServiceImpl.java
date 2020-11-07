/**
 * 告警范围
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.PAlarmDataServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.PAlarmDataDAO;
import org.fms.cim.common.domain.uas.PAlarmDataDomain;
import org.fms.cim.common.service.IPAlarmDataService;
import org.fms.cim.common.vo.uas.PAlarmDataVO;

import java.util.*;

@TransactionService
public class PAlarmDataServiceImpl implements IPAlarmDataService {

    @TransactionDAO("read")
    private PAlarmDataDAO pAlarmDataReadDAO;

    @TransactionDAO("write")
    private PAlarmDataDAO pAlarmDataWriteDAO;

    @Override
    public int insert(PAlarmDataVO pAlarmDataVO) {
        return pAlarmDataWriteDAO.insert(pAlarmDataVO.vo2Domain());
    }

    @Override
    public int update(PAlarmDataVO pAlarmDataVO) {
        return pAlarmDataWriteDAO.update(pAlarmDataVO.vo2Domain());
    }

    @Override
    public int delete(PAlarmDataVO pAlarmDataVO) {
        return pAlarmDataWriteDAO.delete(pAlarmDataVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PAlarmDataVO> deleteList) throws Exception {
        int num = pAlarmDataWriteDAO.deleteList(ReflectUtil.cast(deleteList, PAlarmDataDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PAlarmDataVO findByKey(PAlarmDataVO pAlarmDataVO) {
        PAlarmDataDomain model = pAlarmDataReadDAO.findByKey(pAlarmDataVO.vo2Domain());
        PAlarmDataVO modelVo = new PAlarmDataVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PAlarmDataVO> findByWhere(PAlarmDataVO pAlarmDataVO) {
        PAlarmDataDomain pAlarmDataDomain = pAlarmDataVO.vo2Domain();
        List<PAlarmDataDomain> lstDomain = pAlarmDataReadDAO.findByWhere(pAlarmDataDomain);
        pAlarmDataVO.setTotalRow(pAlarmDataDomain.getTotalRow());
        pAlarmDataVO.setPageCurrent(pAlarmDataDomain.getPageCurrent());
        pAlarmDataVO.setDbName(pAlarmDataDomain.getDbName());
        pAlarmDataVO.setPageSize(pAlarmDataDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PAlarmDataVO.class);
    }

}
