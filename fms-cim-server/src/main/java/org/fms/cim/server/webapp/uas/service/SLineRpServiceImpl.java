/**
 * 旁路事件
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.SLineRpServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.SLineRpDAO;
import org.fms.cim.common.domain.uas.SLineRpDomain;
import org.fms.cim.common.service.ISLineRpService;
import org.fms.cim.common.vo.uas.SLineRpVO;

import java.util.*;

@TransactionService
public class SLineRpServiceImpl implements ISLineRpService {

    @TransactionDAO("read")
    private SLineRpDAO sLineRpReadDAO;

    @TransactionDAO("write")
    private SLineRpDAO sLineRpWriteDAO;

    @Override
    public int insert(SLineRpVO sLineRpVO) {
        return sLineRpWriteDAO.insert(sLineRpVO.vo2Domain());
    }

    @Override
    public int update(SLineRpVO sLineRpVO) {
        return sLineRpWriteDAO.update(sLineRpVO.vo2Domain());
    }

    @Override
    public int delete(SLineRpVO sLineRpVO) {
        return sLineRpWriteDAO.delete(sLineRpVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<SLineRpVO> deleteList) throws Exception {
        int num = sLineRpWriteDAO.deleteList(ReflectUtil.cast(deleteList, SLineRpDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public SLineRpVO findByKey(SLineRpVO sLineRpVO) {
        SLineRpDomain model = sLineRpReadDAO.findByKey(sLineRpVO.vo2Domain());
        SLineRpVO modelVo = new SLineRpVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<SLineRpVO> findByWhere(SLineRpVO sLineRpVO) {
        SLineRpDomain sLineRpDomain = sLineRpVO.vo2Domain();
        List<SLineRpDomain> lstDomain = sLineRpReadDAO.findByWhere(sLineRpDomain);
        sLineRpVO.setTotalRow(sLineRpDomain.getTotalRow());
        sLineRpVO.setPageCurrent(sLineRpDomain.getPageCurrent());
        sLineRpVO.setDbName(sLineRpDomain.getDbName());
        sLineRpVO.setPageSize(sLineRpDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, SLineRpVO.class);
    }

}
