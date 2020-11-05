/**
 * 通道组主机关系
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.impl.PChnlGpDasRelaServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import java.util.List;

import org.fms.cim.common.domain.uas.PChnlGpDasRelaDomain;
import org.fms.cim.common.service.IPChnlGpDasRelaService;
import org.fms.cim.common.vo.uas.PChnlGpDasRelaVO;
import org.fms.cim.server.webapp.uas.dao.PChnlGpDasRelaDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.spring.web.http.HttpResult;

@TransactionService
public class PChnlGpDasRelaServiceImpl implements IPChnlGpDasRelaService {

    @TransactionDAO("read")
    private PChnlGpDasRelaDAO pChnlGpDasRelaReadDAO;

    @TransactionDAO("write")
    private PChnlGpDasRelaDAO pChnlGpDasRelaWriteDAO;

    @Override
    public int insert(PChnlGpDasRelaVO pChnlGpDasRelaVO) {
        return pChnlGpDasRelaWriteDAO.insert(pChnlGpDasRelaVO.vo2Domain());
    }

    @Override
    public int update(PChnlGpDasRelaVO pChnlGpDasRelaVO) {
        return pChnlGpDasRelaWriteDAO.update(pChnlGpDasRelaVO.vo2Domain());
    }

    @Override
    public int delete(PChnlGpDasRelaVO pChnlGpDasRelaVO) {
        return pChnlGpDasRelaWriteDAO.delete(pChnlGpDasRelaVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PChnlGpDasRelaVO> deleteList) throws Exception {
        int num = pChnlGpDasRelaWriteDAO.deleteList(ReflectUtil.cast(deleteList, PChnlGpDasRelaDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PChnlGpDasRelaVO findByKey(PChnlGpDasRelaVO pChnlGpDasRelaVO) {
        PChnlGpDasRelaDomain model = pChnlGpDasRelaReadDAO.findByKey(pChnlGpDasRelaVO.vo2Domain());
        PChnlGpDasRelaVO modelVo = new PChnlGpDasRelaVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PChnlGpDasRelaVO> findByWhere(PChnlGpDasRelaVO pChnlGpDasRelaVO) {
        PChnlGpDasRelaDomain pChnlGpDasRelaDomain = pChnlGpDasRelaVO.vo2Domain();
        List<PChnlGpDasRelaDomain> lstDomain = pChnlGpDasRelaReadDAO.findByWhere(pChnlGpDasRelaDomain);
        pChnlGpDasRelaVO.setTotalRow(pChnlGpDasRelaDomain.getTotalRow());
        pChnlGpDasRelaVO.setPageCurrent(pChnlGpDasRelaDomain.getPageCurrent());
        pChnlGpDasRelaVO.setDbName(pChnlGpDasRelaDomain.getDbName());
        pChnlGpDasRelaVO.setPageSize(pChnlGpDasRelaDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PChnlGpDasRelaVO.class);
    }

}
