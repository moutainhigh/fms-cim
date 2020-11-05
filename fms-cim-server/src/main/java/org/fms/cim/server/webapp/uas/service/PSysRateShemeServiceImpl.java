/**
 * 多费率方案定义表
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.impl.PSysRateShemeServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import java.util.List;

import org.fms.cim.common.domain.uas.PSysRateShemeDomain;
import org.fms.cim.common.service.IPSysRateShemeService;
import org.fms.cim.common.vo.uas.PSysRateShemeVO;
import org.fms.cim.server.webapp.uas.dao.PSysRateShemeDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.spring.web.http.HttpResult;

@TransactionService
public class PSysRateShemeServiceImpl implements IPSysRateShemeService {

    @TransactionDAO("read")
    private PSysRateShemeDAO pSysRateShemeReadDAO;

    @TransactionDAO("write")
    private PSysRateShemeDAO pSysRateShemeWriteDAO;

    @Override
    public int insert(PSysRateShemeVO pSysRateShemeVO) {
        return pSysRateShemeWriteDAO.insert(pSysRateShemeVO.vo2Domain());
    }

    @Override
    public int update(PSysRateShemeVO pSysRateShemeVO) {
        return pSysRateShemeWriteDAO.update(pSysRateShemeVO.vo2Domain());
    }

    @Override
    public int delete(PSysRateShemeVO pSysRateShemeVO) {
        return pSysRateShemeWriteDAO.delete(pSysRateShemeVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PSysRateShemeVO> deleteList) throws Exception {
        int num = pSysRateShemeWriteDAO.deleteList(ReflectUtil.cast(deleteList, PSysRateShemeDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PSysRateShemeVO findByKey(PSysRateShemeVO pSysRateShemeVO) {
        PSysRateShemeDomain model = pSysRateShemeReadDAO.findByKey(pSysRateShemeVO.vo2Domain());
        PSysRateShemeVO modelVo = new PSysRateShemeVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PSysRateShemeVO> findByWhere(PSysRateShemeVO pSysRateShemeVO) {
        PSysRateShemeDomain pSysRateShemeDomain = pSysRateShemeVO.vo2Domain();
        List<PSysRateShemeDomain> lstDomain = pSysRateShemeReadDAO.findByWhere(pSysRateShemeDomain);
        pSysRateShemeVO.setTotalRow(pSysRateShemeDomain.getTotalRow());
        pSysRateShemeVO.setPageCurrent(pSysRateShemeDomain.getPageCurrent());
        pSysRateShemeVO.setDbName(pSysRateShemeDomain.getDbName());
        pSysRateShemeVO.setPageSize(pSysRateShemeDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PSysRateShemeVO.class);
    }

}
