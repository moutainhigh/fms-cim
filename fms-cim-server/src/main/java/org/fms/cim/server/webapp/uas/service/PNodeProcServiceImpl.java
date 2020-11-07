/**
 * 系统节点进程信息
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.PNodeProcServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.PNodeProcDAO;
import org.fms.cim.common.domain.uas.PNodeProcDomain;
import org.fms.cim.common.service.IPNodeProcService;
import org.fms.cim.common.vo.uas.PNodeProcVO;

import java.util.*;

@TransactionService
public class PNodeProcServiceImpl implements IPNodeProcService {

    @TransactionDAO("read")
    private PNodeProcDAO pNodeProcReadDAO;

    @TransactionDAO("write")
    private PNodeProcDAO pNodeProcWriteDAO;

    @Override
    public int insert(PNodeProcVO pNodeProcVO) {
        return pNodeProcWriteDAO.insert(pNodeProcVO.vo2Domain());
    }

    @Override
    public int update(PNodeProcVO pNodeProcVO) {
        return pNodeProcWriteDAO.update(pNodeProcVO.vo2Domain());
    }

    @Override
    public int delete(PNodeProcVO pNodeProcVO) {
        return pNodeProcWriteDAO.delete(pNodeProcVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PNodeProcVO> deleteList) throws Exception {
        int num = pNodeProcWriteDAO.deleteList(ReflectUtil.cast(deleteList, PNodeProcDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PNodeProcVO findByKey(PNodeProcVO pNodeProcVO) {
        PNodeProcDomain model = pNodeProcReadDAO.findByKey(pNodeProcVO.vo2Domain());
        PNodeProcVO modelVo = new PNodeProcVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PNodeProcVO> findByWhere(PNodeProcVO pNodeProcVO) {
        PNodeProcDomain pNodeProcDomain = pNodeProcVO.vo2Domain();
        List<PNodeProcDomain> lstDomain = pNodeProcReadDAO.findByWhere(pNodeProcDomain);
        pNodeProcVO.setTotalRow(pNodeProcDomain.getTotalRow());
        pNodeProcVO.setPageCurrent(pNodeProcDomain.getPageCurrent());
        pNodeProcVO.setDbName(pNodeProcDomain.getDbName());
        pNodeProcVO.setPageSize(pNodeProcDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PNodeProcVO.class);
    }

}
