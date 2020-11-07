/**
 * 旁路事件审核表
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.SLineRpPreServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.SLineRpPreDAO;
import org.fms.cim.common.domain.uas.SLineRpPreDomain;
import org.fms.cim.common.service.ISLineRpPreService;
import org.fms.cim.common.vo.uas.SLineRpPreVO;

import java.util.*;

@TransactionService
public class SLineRpPreServiceImpl implements ISLineRpPreService {

    @TransactionDAO("read")
    private SLineRpPreDAO sLineRpPreReadDAO;

    @TransactionDAO("write")
    private SLineRpPreDAO sLineRpPreWriteDAO;

    @Override
    public int insert(SLineRpPreVO sLineRpPreVO) {
        return sLineRpPreWriteDAO.insert(sLineRpPreVO.vo2Domain());
    }

    @Override
    public int update(SLineRpPreVO sLineRpPreVO) {
        return sLineRpPreWriteDAO.update(sLineRpPreVO.vo2Domain());
    }

    @Override
    public int delete(SLineRpPreVO sLineRpPreVO) {
        return sLineRpPreWriteDAO.delete(sLineRpPreVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<SLineRpPreVO> deleteList) throws Exception {
        int num = sLineRpPreWriteDAO.deleteList(ReflectUtil.cast(deleteList, SLineRpPreDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public SLineRpPreVO findByKey(SLineRpPreVO sLineRpPreVO) {
        SLineRpPreDomain model = sLineRpPreReadDAO.findByKey(sLineRpPreVO.vo2Domain());
        SLineRpPreVO modelVo = new SLineRpPreVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<SLineRpPreVO> findByWhere(SLineRpPreVO sLineRpPreVO) {
        SLineRpPreDomain sLineRpPreDomain = sLineRpPreVO.vo2Domain();
        List<SLineRpPreDomain> lstDomain = sLineRpPreReadDAO.findByWhere(sLineRpPreDomain);
        sLineRpPreVO.setTotalRow(sLineRpPreDomain.getTotalRow());
        sLineRpPreVO.setPageCurrent(sLineRpPreDomain.getPageCurrent());
        sLineRpPreVO.setDbName(sLineRpPreDomain.getDbName());
        sLineRpPreVO.setPageSize(sLineRpPreDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, SLineRpPreVO.class);
    }

}
