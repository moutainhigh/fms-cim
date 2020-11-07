/**
 * 电量替代
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.SEnergyRpServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.SEnergyRpDAO;
import org.fms.cim.common.domain.uas.SEnergyRpDomain;
import org.fms.cim.common.service.ISEnergyRpService;
import org.fms.cim.common.vo.uas.SEnergyRpVO;

import java.util.*;

@TransactionService
public class SEnergyRpServiceImpl implements ISEnergyRpService {

    @TransactionDAO("read")
    private SEnergyRpDAO sEnergyRpReadDAO;

    @TransactionDAO("write")
    private SEnergyRpDAO sEnergyRpWriteDAO;

    @Override
    public int insert(SEnergyRpVO sEnergyRpVO) {
        return sEnergyRpWriteDAO.insert(sEnergyRpVO.vo2Domain());
    }

    @Override
    public int update(SEnergyRpVO sEnergyRpVO) {
        return sEnergyRpWriteDAO.update(sEnergyRpVO.vo2Domain());
    }

    @Override
    public int delete(SEnergyRpVO sEnergyRpVO) {
        return sEnergyRpWriteDAO.delete(sEnergyRpVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<SEnergyRpVO> deleteList) throws Exception {
        int num = sEnergyRpWriteDAO.deleteList(ReflectUtil.cast(deleteList, SEnergyRpDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public SEnergyRpVO findByKey(SEnergyRpVO sEnergyRpVO) {
        SEnergyRpDomain model = sEnergyRpReadDAO.findByKey(sEnergyRpVO.vo2Domain());
        SEnergyRpVO modelVo = new SEnergyRpVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<SEnergyRpVO> findByWhere(SEnergyRpVO sEnergyRpVO) {
        SEnergyRpDomain sEnergyRpDomain = sEnergyRpVO.vo2Domain();
        List<SEnergyRpDomain> lstDomain = sEnergyRpReadDAO.findByWhere(sEnergyRpDomain);
        sEnergyRpVO.setTotalRow(sEnergyRpDomain.getTotalRow());
        sEnergyRpVO.setPageCurrent(sEnergyRpDomain.getPageCurrent());
        sEnergyRpVO.setDbName(sEnergyRpDomain.getDbName());
        sEnergyRpVO.setPageSize(sEnergyRpDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, SEnergyRpVO.class);
    }

}
