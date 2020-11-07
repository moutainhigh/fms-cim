/**
 * 采集点
 * Author :
 * Date :
 * Title : org.fms.cim.common.service;.RCpServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.RCpDAO;
import org.fms.cim.common.domain.uas.RCpDomain;
import org.fms.cim.common.service.IRCpService;
import org.fms.cim.common.vo.uas.RCpVO;

import java.util.*;

@TransactionService
public class RCpServiceImpl implements IRCpService {

    @TransactionDAO("read")
    private RCpDAO rCpReadDAO;

    @TransactionDAO("write")
    private RCpDAO rCpWriteDAO;

    @Override
    public int insert(RCpVO rCpVO) {
        return rCpWriteDAO.insert(rCpVO.vo2Domain());
    }

    @Override
    public int update(RCpVO rCpVO) {
        return rCpWriteDAO.update(rCpVO.vo2Domain());
    }

    @Override
    public int delete(RCpVO rCpVO) {
        return rCpWriteDAO.delete(rCpVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<RCpVO> deleteList) throws Exception {
        int num = rCpWriteDAO.deleteList(ReflectUtil.cast(deleteList, RCpDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public RCpVO findByKey(RCpVO rCpVO) {
        RCpDomain model = rCpReadDAO.findByKey(rCpVO.vo2Domain());
        RCpVO modelVo = new RCpVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<RCpVO> findByWhere(RCpVO rCpVO) {
        RCpDomain rCpDomain = rCpVO.vo2Domain();
        List<RCpDomain> lstDomain = rCpReadDAO.findByWhere(rCpDomain);
        rCpVO.setTotalRow(rCpDomain.getTotalRow());
        rCpVO.setPageCurrent(rCpDomain.getPageCurrent());
        rCpVO.setDbName(rCpDomain.getDbName());
        rCpVO.setPageSize(rCpDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, RCpVO.class);
    }

}
