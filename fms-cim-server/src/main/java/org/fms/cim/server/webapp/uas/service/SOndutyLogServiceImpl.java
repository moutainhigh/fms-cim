/**
 * 值班日志
 * Author :
 * Date :
 * Title : rg.fms.cim.server.webapp.uas.service.SOndutyLogServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.SOndutyLogDAO;
import org.fms.cim.common.domain.uas.SOndutyLogDomain;
import org.fms.cim.common.service.ISOndutyLogService;
import org.fms.cim.common.vo.uas.SOndutyLogVO;

import java.util.*;

@TransactionService
public class SOndutyLogServiceImpl implements ISOndutyLogService {

    @TransactionDAO("read")
    private SOndutyLogDAO sOndutyLogReadDAO;

    @TransactionDAO("write")
    private SOndutyLogDAO sOndutyLogWriteDAO;

    @Override
    public int insert(SOndutyLogVO sOndutyLogVO) {
        return sOndutyLogWriteDAO.insert(sOndutyLogVO.vo2Domain());
    }

    @Override
    public int update(SOndutyLogVO sOndutyLogVO) {
        return sOndutyLogWriteDAO.update(sOndutyLogVO.vo2Domain());
    }

    @Override
    public int delete(SOndutyLogVO sOndutyLogVO) {
        return sOndutyLogWriteDAO.delete(sOndutyLogVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<SOndutyLogVO> deleteList) throws Exception {
        int num = sOndutyLogWriteDAO.deleteList(ReflectUtil.cast(deleteList, SOndutyLogDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public SOndutyLogVO findByKey(SOndutyLogVO sOndutyLogVO) {
        SOndutyLogDomain model = sOndutyLogReadDAO.findByKey(sOndutyLogVO.vo2Domain());
        SOndutyLogVO modelVo = new SOndutyLogVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<SOndutyLogVO> findByWhere(SOndutyLogVO sOndutyLogVO) {
        SOndutyLogDomain sOndutyLogDomain = sOndutyLogVO.vo2Domain();
        List<SOndutyLogDomain> lstDomain = sOndutyLogReadDAO.findByWhere(sOndutyLogDomain);
        sOndutyLogVO.setTotalRow(sOndutyLogDomain.getTotalRow());
        sOndutyLogVO.setPageCurrent(sOndutyLogDomain.getPageCurrent());
        sOndutyLogVO.setDbName(sOndutyLogDomain.getDbName());
        sOndutyLogVO.setPageSize(sOndutyLogDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, SOndutyLogVO.class);
    }

}
