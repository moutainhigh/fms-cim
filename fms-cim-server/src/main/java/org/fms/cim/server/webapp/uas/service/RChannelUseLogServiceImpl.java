/**
 * 通道使用日志
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.RChannelUseLogServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.RChannelUseLogDAO;
import org.fms.cim.common.domain.uas.RChannelUseLogDomain;
import org.fms.cim.common.service.IRChannelUseLogService;
import org.fms.cim.common.vo.uas.RChannelUseLogVO;

import java.util.*;

@TransactionService
public class RChannelUseLogServiceImpl implements IRChannelUseLogService {

    @TransactionDAO("read")
    private RChannelUseLogDAO rChannelUseLogReadDAO;

    @TransactionDAO("write")
    private RChannelUseLogDAO rChannelUseLogWriteDAO;

    @Override
    public int insert(RChannelUseLogVO rChannelUseLogVO) {
        return rChannelUseLogWriteDAO.insert(rChannelUseLogVO.vo2Domain());
    }

    @Override
    public int update(RChannelUseLogVO rChannelUseLogVO) {
        return rChannelUseLogWriteDAO.update(rChannelUseLogVO.vo2Domain());
    }

    @Override
    public int delete(RChannelUseLogVO rChannelUseLogVO) {
        return rChannelUseLogWriteDAO.delete(rChannelUseLogVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<RChannelUseLogVO> deleteList) throws Exception {
        int num = rChannelUseLogWriteDAO.deleteList(ReflectUtil.cast(deleteList, RChannelUseLogDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public RChannelUseLogVO findByKey(RChannelUseLogVO rChannelUseLogVO) {
        RChannelUseLogDomain model = rChannelUseLogReadDAO.findByKey(rChannelUseLogVO.vo2Domain());
        RChannelUseLogVO modelVo = new RChannelUseLogVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<RChannelUseLogVO> findByWhere(RChannelUseLogVO rChannelUseLogVO) {
        RChannelUseLogDomain rChannelUseLogDomain = rChannelUseLogVO.vo2Domain();
        List<RChannelUseLogDomain> lstDomain = rChannelUseLogReadDAO.findByWhere(rChannelUseLogDomain);
        rChannelUseLogVO.setTotalRow(rChannelUseLogDomain.getTotalRow());
        rChannelUseLogVO.setPageCurrent(rChannelUseLogDomain.getPageCurrent());
        rChannelUseLogVO.setDbName(rChannelUseLogDomain.getDbName());
        rChannelUseLogVO.setPageSize(rChannelUseLogDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, RChannelUseLogVO.class);
    }

}
