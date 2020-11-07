/**
 * 人工任务执行日志表
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.RDaManualTaskLogServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.RDaManualTaskLogDAO;
import org.fms.cim.common.domain.uas.RDaManualTaskLogDomain;
import org.fms.cim.common.service.IRDaManualTaskLogService;
import org.fms.cim.common.vo.uas.RDaManualTaskLogVO;

import java.util.*;

@TransactionService
public class RDaManualTaskLogServiceImpl implements IRDaManualTaskLogService {

    @TransactionDAO("read")
    private RDaManualTaskLogDAO rDaManualTaskLogReadDAO;

    @TransactionDAO("write")
    private RDaManualTaskLogDAO rDaManualTaskLogWriteDAO;

    @Override
    public int insert(RDaManualTaskLogVO rDaManualTaskLogVO) {
        return rDaManualTaskLogWriteDAO.insert(rDaManualTaskLogVO.vo2Domain());
    }

    @Override
    public int update(RDaManualTaskLogVO rDaManualTaskLogVO) {
        return rDaManualTaskLogWriteDAO.update(rDaManualTaskLogVO.vo2Domain());
    }

    @Override
    public int delete(RDaManualTaskLogVO rDaManualTaskLogVO) {
        return rDaManualTaskLogWriteDAO.delete(rDaManualTaskLogVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<RDaManualTaskLogVO> deleteList) throws Exception {
        int num = rDaManualTaskLogWriteDAO.deleteList(ReflectUtil.cast(deleteList, RDaManualTaskLogDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public RDaManualTaskLogVO findByKey(RDaManualTaskLogVO rDaManualTaskLogVO) {
        RDaManualTaskLogDomain model = rDaManualTaskLogReadDAO.findByKey(rDaManualTaskLogVO.vo2Domain());
        RDaManualTaskLogVO modelVo = new RDaManualTaskLogVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<RDaManualTaskLogVO> findByWhere(RDaManualTaskLogVO rDaManualTaskLogVO) {
        RDaManualTaskLogDomain rDaManualTaskLogDomain = rDaManualTaskLogVO.vo2Domain();
        List<RDaManualTaskLogDomain> lstDomain = rDaManualTaskLogReadDAO.findByWhere(rDaManualTaskLogDomain);
        rDaManualTaskLogVO.setTotalRow(rDaManualTaskLogDomain.getTotalRow());
        rDaManualTaskLogVO.setPageCurrent(rDaManualTaskLogDomain.getPageCurrent());
        rDaManualTaskLogVO.setDbName(rDaManualTaskLogDomain.getDbName());
        rDaManualTaskLogVO.setPageSize(rDaManualTaskLogDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, RDaManualTaskLogVO.class);
    }

}
