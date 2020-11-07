/**
 * 计量业务触发表
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.RWorkTriggerServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.RWorkTriggerDAO;
import org.fms.cim.common.domain.uas.RWorkTriggerDomain;
import org.fms.cim.common.service.IRWorkTriggerService;
import org.fms.cim.common.vo.uas.RWorkTriggerVO;

import java.util.*;

@TransactionService
public class RWorkTriggerServiceImpl implements IRWorkTriggerService {

    @TransactionDAO("read")
    private RWorkTriggerDAO rWorkTriggerReadDAO;

    @TransactionDAO("write")
    private RWorkTriggerDAO rWorkTriggerWriteDAO;

    @Override
    public int insert(RWorkTriggerVO rWorkTriggerVO) {
        return rWorkTriggerWriteDAO.insert(rWorkTriggerVO.vo2Domain());
    }

    @Override
    public int update(RWorkTriggerVO rWorkTriggerVO) {
        return rWorkTriggerWriteDAO.update(rWorkTriggerVO.vo2Domain());
    }

    @Override
    public int delete(RWorkTriggerVO rWorkTriggerVO) {
        return rWorkTriggerWriteDAO.delete(rWorkTriggerVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<RWorkTriggerVO> deleteList) throws Exception {
        int num = rWorkTriggerWriteDAO.deleteList(ReflectUtil.cast(deleteList, RWorkTriggerDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public RWorkTriggerVO findByKey(RWorkTriggerVO rWorkTriggerVO) {
        RWorkTriggerDomain model = rWorkTriggerReadDAO.findByKey(rWorkTriggerVO.vo2Domain());
        RWorkTriggerVO modelVo = new RWorkTriggerVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<RWorkTriggerVO> findByWhere(RWorkTriggerVO rWorkTriggerVO) {
        RWorkTriggerDomain rWorkTriggerDomain = rWorkTriggerVO.vo2Domain();
        List<RWorkTriggerDomain> lstDomain = rWorkTriggerReadDAO.findByWhere(rWorkTriggerDomain);
        rWorkTriggerVO.setTotalRow(rWorkTriggerDomain.getTotalRow());
        rWorkTriggerVO.setPageCurrent(rWorkTriggerDomain.getPageCurrent());
        rWorkTriggerVO.setDbName(rWorkTriggerDomain.getDbName());
        rWorkTriggerVO.setPageSize(rWorkTriggerDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, RWorkTriggerVO.class);
    }

}
