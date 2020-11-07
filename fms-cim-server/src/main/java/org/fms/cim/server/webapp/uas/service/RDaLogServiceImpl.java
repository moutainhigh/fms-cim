/**
 * 采集日志表
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.RDaLogServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.RDaLogDAO;
import org.fms.cim.common.domain.uas.RDaLogDomain;
import org.fms.cim.common.service.IRDaLogService;
import org.fms.cim.common.vo.uas.RDaLogVO;

import java.util.*;

@TransactionService
public class RDaLogServiceImpl implements IRDaLogService {

    @TransactionDAO("read")
    private RDaLogDAO rDaLogReadDAO;

    @TransactionDAO("write")
    private RDaLogDAO rDaLogWriteDAO;

    @Override
    public int insert(RDaLogVO rDaLogVO) {
        return rDaLogWriteDAO.insert(rDaLogVO.vo2Domain());
    }

    @Override
    public int update(RDaLogVO rDaLogVO) {
        return rDaLogWriteDAO.update(rDaLogVO.vo2Domain());
    }

    @Override
    public int delete(RDaLogVO rDaLogVO) {
        return rDaLogWriteDAO.delete(rDaLogVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<RDaLogVO> deleteList) throws Exception {
        int num = rDaLogWriteDAO.deleteList(ReflectUtil.cast(deleteList, RDaLogDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public RDaLogVO findByKey(RDaLogVO rDaLogVO) {
        RDaLogDomain model = rDaLogReadDAO.findByKey(rDaLogVO.vo2Domain());
        RDaLogVO modelVo = new RDaLogVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<RDaLogVO> findByWhere(RDaLogVO rDaLogVO) {
        RDaLogDomain rDaLogDomain = rDaLogVO.vo2Domain();
        List<RDaLogDomain> lstDomain = rDaLogReadDAO.findByWhere(rDaLogDomain);
        rDaLogVO.setTotalRow(rDaLogDomain.getTotalRow());
        rDaLogVO.setPageCurrent(rDaLogDomain.getPageCurrent());
        rDaLogVO.setDbName(rDaLogDomain.getDbName());
        rDaLogVO.setPageSize(rDaLogDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, RDaLogVO.class);
    }

}
