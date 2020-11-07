/**
 * 告警事项设置
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.PAlarmItemServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.PAlarmItemDAO;
import org.fms.cim.common.domain.uas.PAlarmItemDomain;
import org.fms.cim.common.service.IPAlarmItemService;
import org.fms.cim.common.vo.uas.PAlarmItemVO;

import java.util.*;

@TransactionService
public class PAlarmItemServiceImpl implements IPAlarmItemService {

    @TransactionDAO("read")
    private PAlarmItemDAO pAlarmItemReadDAO;

    @TransactionDAO("write")
    private PAlarmItemDAO pAlarmItemWriteDAO;

    @Override
    public int insert(PAlarmItemVO pAlarmItemVO) {
        return pAlarmItemWriteDAO.insert(pAlarmItemVO.vo2Domain());
    }

    @Override
    public int update(PAlarmItemVO pAlarmItemVO) {
        return pAlarmItemWriteDAO.update(pAlarmItemVO.vo2Domain());
    }

    @Override
    public int delete(PAlarmItemVO pAlarmItemVO) {
        return pAlarmItemWriteDAO.delete(pAlarmItemVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PAlarmItemVO> deleteList) throws Exception {
        int num = pAlarmItemWriteDAO.deleteList(ReflectUtil.cast(deleteList, PAlarmItemDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PAlarmItemVO findByKey(PAlarmItemVO pAlarmItemVO) {
        PAlarmItemDomain model = pAlarmItemReadDAO.findByKey(pAlarmItemVO.vo2Domain());
        PAlarmItemVO modelVo = new PAlarmItemVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PAlarmItemVO> findByWhere(PAlarmItemVO pAlarmItemVO) {
        PAlarmItemDomain pAlarmItemDomain = pAlarmItemVO.vo2Domain();
        List<PAlarmItemDomain> lstDomain = pAlarmItemReadDAO.findByWhere(pAlarmItemDomain);
        pAlarmItemVO.setTotalRow(pAlarmItemDomain.getTotalRow());
        pAlarmItemVO.setPageCurrent(pAlarmItemDomain.getPageCurrent());
        pAlarmItemVO.setDbName(pAlarmItemDomain.getDbName());
        pAlarmItemVO.setPageSize(pAlarmItemDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PAlarmItemVO.class);
    }

}
