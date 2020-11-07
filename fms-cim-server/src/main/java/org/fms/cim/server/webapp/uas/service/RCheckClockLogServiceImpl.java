/**
 * 终端对时日志表
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.RCheckClockLogServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.RCheckClockLogDAO;
import org.fms.cim.common.domain.uas.RCheckClockLogDomain;
import org.fms.cim.common.service.IRCheckClockLogService;
import org.fms.cim.common.vo.uas.RCheckClockLogVO;

import java.util.*;

@TransactionService
public class RCheckClockLogServiceImpl implements IRCheckClockLogService {

    @TransactionDAO("read")
    private RCheckClockLogDAO rCheckClockLogReadDAO;

    @TransactionDAO("write")
    private RCheckClockLogDAO rCheckClockLogWriteDAO;

    @Override
    public int insert(RCheckClockLogVO rCheckClockLogVO) {
        return rCheckClockLogWriteDAO.insert(rCheckClockLogVO.vo2Domain());
    }

    @Override
    public int update(RCheckClockLogVO rCheckClockLogVO) {
        return rCheckClockLogWriteDAO.update(rCheckClockLogVO.vo2Domain());
    }

    @Override
    public int delete(RCheckClockLogVO rCheckClockLogVO) {
        return rCheckClockLogWriteDAO.delete(rCheckClockLogVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<RCheckClockLogVO> deleteList) throws Exception {
        int num = rCheckClockLogWriteDAO.deleteList(ReflectUtil.cast(deleteList, RCheckClockLogDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public RCheckClockLogVO findByKey(RCheckClockLogVO rCheckClockLogVO) {
        RCheckClockLogDomain model = rCheckClockLogReadDAO.findByKey(rCheckClockLogVO.vo2Domain());
        RCheckClockLogVO modelVo = new RCheckClockLogVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<RCheckClockLogVO> findByWhere(RCheckClockLogVO rCheckClockLogVO) {
        RCheckClockLogDomain rCheckClockLogDomain = rCheckClockLogVO.vo2Domain();
        List<RCheckClockLogDomain> lstDomain = rCheckClockLogReadDAO.findByWhere(rCheckClockLogDomain);
        rCheckClockLogVO.setTotalRow(rCheckClockLogDomain.getTotalRow());
        rCheckClockLogVO.setPageCurrent(rCheckClockLogDomain.getPageCurrent());
        rCheckClockLogVO.setDbName(rCheckClockLogDomain.getDbName());
        rCheckClockLogVO.setPageSize(rCheckClockLogDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, RCheckClockLogVO.class);
    }

}
