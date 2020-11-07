/**
 * 采集主机组
 * Author :
 * Date :
 * Title : org.fms.cim.common.service;.PWsdChnlTypeServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.server.webapp.uas.dao.PWsdChnlTypeDAO;
import org.fms.cim.common.domain.uas.PWsdChnlTypeDomain;
import org.fms.cim.common.service.IPWsdChnlTypeService;
import org.fms.cim.common.vo.uas.PWsdChnlTypeVO;

import java.util.*;

@TransactionService
public class PWsdChnlTypeServiceImpl implements IPWsdChnlTypeService {

    @TransactionDAO("read")
    private PWsdChnlTypeDAO pWsdChnlTypeReadDAO;

    @TransactionDAO("write")
    private PWsdChnlTypeDAO pWsdChnlTypeWriteDAO;

    @Override
    public int insert(PWsdChnlTypeVO pWsdChnlTypeVO) {
        return pWsdChnlTypeWriteDAO.insert(pWsdChnlTypeVO.vo2Domain());
    }

    @Override
    public int update(PWsdChnlTypeVO pWsdChnlTypeVO) {
        return pWsdChnlTypeWriteDAO.update(pWsdChnlTypeVO.vo2Domain());
    }

    @Override
    public int delete(PWsdChnlTypeVO pWsdChnlTypeVO) {
        return pWsdChnlTypeWriteDAO.delete(pWsdChnlTypeVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PWsdChnlTypeVO> deleteList) throws Exception {
        int num = pWsdChnlTypeWriteDAO.deleteList(ReflectUtil.cast(deleteList, PWsdChnlTypeDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PWsdChnlTypeVO findByKey(PWsdChnlTypeVO pWsdChnlTypeVO) {
        PWsdChnlTypeDomain model = pWsdChnlTypeReadDAO.findByKey(pWsdChnlTypeVO.vo2Domain());
        PWsdChnlTypeVO modelVo = new PWsdChnlTypeVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PWsdChnlTypeVO> findByWhere(PWsdChnlTypeVO pWsdChnlTypeVO) {
        PWsdChnlTypeDomain pWsdChnlTypeDomain = pWsdChnlTypeVO.vo2Domain();
        List<PWsdChnlTypeDomain> lstDomain = pWsdChnlTypeReadDAO.findByWhere(pWsdChnlTypeDomain);
        pWsdChnlTypeVO.setTotalRow(pWsdChnlTypeDomain.getTotalRow());
        pWsdChnlTypeVO.setPageCurrent(pWsdChnlTypeDomain.getPageCurrent());
        pWsdChnlTypeVO.setDbName(pWsdChnlTypeDomain.getDbName());
        pWsdChnlTypeVO.setPageSize(pWsdChnlTypeDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PWsdChnlTypeVO.class);
    }

}
