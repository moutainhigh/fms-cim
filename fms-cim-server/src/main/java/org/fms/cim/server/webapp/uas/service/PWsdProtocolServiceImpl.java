/**
 * 规约定义表
 * Author :
 * Date :
 * Title : org.fms.cim.common.service;.PWsdProtocolServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.PWsdProtocolDAO;
import org.fms.cim.common.domain.uas.PWsdProtocolDomain;
import org.fms.cim.common.service.IPWsdProtocolService;
import org.fms.cim.common.vo.uas.PWsdProtocolVO;

import java.util.*;

@TransactionService
public class PWsdProtocolServiceImpl implements IPWsdProtocolService {

    @TransactionDAO("read")
    private PWsdProtocolDAO pWsdProtocolReadDAO;

    @TransactionDAO("write")
    private PWsdProtocolDAO pWsdProtocolWriteDAO;

    @Override
    public int insert(PWsdProtocolVO pWsdProtocolVO) {
        return pWsdProtocolWriteDAO.insert(pWsdProtocolVO.vo2Domain());
    }

    @Override
    public int update(PWsdProtocolVO pWsdProtocolVO) {
        return pWsdProtocolWriteDAO.update(pWsdProtocolVO.vo2Domain());
    }

    @Override
    public int delete(PWsdProtocolVO pWsdProtocolVO) {
        return pWsdProtocolWriteDAO.delete(pWsdProtocolVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PWsdProtocolVO> deleteList) throws Exception {
        int num = pWsdProtocolWriteDAO.deleteList(ReflectUtil.cast(deleteList, PWsdProtocolDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PWsdProtocolVO findByKey(PWsdProtocolVO pWsdProtocolVO) {
        PWsdProtocolDomain model = pWsdProtocolReadDAO.findByKey(pWsdProtocolVO.vo2Domain());
        PWsdProtocolVO modelVo = new PWsdProtocolVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PWsdProtocolVO> findByWhere(PWsdProtocolVO pWsdProtocolVO) {
        PWsdProtocolDomain pWsdProtocolDomain = pWsdProtocolVO.vo2Domain();
        List<PWsdProtocolDomain> lstDomain = pWsdProtocolReadDAO.findByWhere(pWsdProtocolDomain);
        pWsdProtocolVO.setTotalRow(pWsdProtocolDomain.getTotalRow());
        pWsdProtocolVO.setPageCurrent(pWsdProtocolDomain.getPageCurrent());
        pWsdProtocolVO.setDbName(pWsdProtocolDomain.getDbName());
        pWsdProtocolVO.setPageSize(pWsdProtocolDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PWsdProtocolVO.class);
    }

}
