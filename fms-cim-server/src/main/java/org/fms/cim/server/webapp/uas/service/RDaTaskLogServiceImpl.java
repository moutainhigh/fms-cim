/**
 * 采集任务执行日志表
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.RDaTaskLogServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.RDaTaskLogDAO;
import org.fms.cim.common.domain.uas.RDaTaskLogDomain;
import org.fms.cim.common.service.IRDaTaskLogService;
import org.fms.cim.common.vo.uas.RDaTaskLogVO;

import java.util.*;

@TransactionService
public class RDaTaskLogServiceImpl implements IRDaTaskLogService {

    @TransactionDAO("read")
    private RDaTaskLogDAO rDaTaskLogReadDAO;

    @TransactionDAO("write")
    private RDaTaskLogDAO rDaTaskLogWriteDAO;

    @Override
    public int insert(RDaTaskLogVO rDaTaskLogVO) {
        return rDaTaskLogWriteDAO.insert(rDaTaskLogVO.vo2Domain());
    }

    @Override
    public int update(RDaTaskLogVO rDaTaskLogVO) {
        return rDaTaskLogWriteDAO.update(rDaTaskLogVO.vo2Domain());
    }

    @Override
    public int delete(RDaTaskLogVO rDaTaskLogVO) {
        return rDaTaskLogWriteDAO.delete(rDaTaskLogVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<RDaTaskLogVO> deleteList) throws Exception {
        int num = rDaTaskLogWriteDAO.deleteList(ReflectUtil.cast(deleteList, RDaTaskLogDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public RDaTaskLogVO findByKey(RDaTaskLogVO rDaTaskLogVO) {
        RDaTaskLogDomain model = rDaTaskLogReadDAO.findByKey(rDaTaskLogVO.vo2Domain());
        RDaTaskLogVO modelVo = new RDaTaskLogVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<RDaTaskLogVO> findByWhere(RDaTaskLogVO rDaTaskLogVO) {
        RDaTaskLogDomain rDaTaskLogDomain = rDaTaskLogVO.vo2Domain();
        List<RDaTaskLogDomain> lstDomain = rDaTaskLogReadDAO.findByWhere(rDaTaskLogDomain);
        rDaTaskLogVO.setTotalRow(rDaTaskLogDomain.getTotalRow());
        rDaTaskLogVO.setPageCurrent(rDaTaskLogDomain.getPageCurrent());
        rDaTaskLogVO.setDbName(rDaTaskLogDomain.getDbName());
        rDaTaskLogVO.setPageSize(rDaTaskLogDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, RDaTaskLogVO.class);
    }

}
