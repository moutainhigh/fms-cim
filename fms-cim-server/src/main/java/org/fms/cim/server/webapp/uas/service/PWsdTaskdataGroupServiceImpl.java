/**
 * 规约数据单元组（※相当于原来变电站采集的规约信息体类型）
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.impl.PWsdTaskdataGroupServiceImpl.java
 **/
package org.fms.cim.server.webapp.uas.service;

import java.util.List;

import org.fms.cim.common.domain.uas.PWsdTaskdataGroupDomain;
import org.fms.cim.common.service.IPWsdTaskdataGroupService;
import org.fms.cim.common.vo.uas.PWsdTaskdataGroupVO;
import org.fms.cim.server.webapp.uas.dao.PWsdTaskdataGroupDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.spring.web.http.HttpResult;

@TransactionService
public class PWsdTaskdataGroupServiceImpl implements IPWsdTaskdataGroupService {

    @TransactionDAO("read")
    private PWsdTaskdataGroupDAO pWsdTaskdataGroupReadDAO;

    @TransactionDAO("write")
    private PWsdTaskdataGroupDAO pWsdTaskdataGroupWriteDAO;

    @Override
    public int insert(PWsdTaskdataGroupVO pWsdTaskdataGroupVO) {
        return pWsdTaskdataGroupWriteDAO.insert(pWsdTaskdataGroupVO.vo2Domain());
    }

    @Override
    public int update(PWsdTaskdataGroupVO pWsdTaskdataGroupVO) {
        return pWsdTaskdataGroupWriteDAO.update(pWsdTaskdataGroupVO.vo2Domain());
    }

    @Override
    public int delete(PWsdTaskdataGroupVO pWsdTaskdataGroupVO) {
        return pWsdTaskdataGroupWriteDAO.delete(pWsdTaskdataGroupVO.vo2Domain());
    }

    @Override
    public HttpResult deleteList(List<PWsdTaskdataGroupVO> deleteList) throws Exception {
        int num = pWsdTaskdataGroupWriteDAO.deleteList(ReflectUtil.cast(deleteList, PWsdTaskdataGroupDomain.class));
        if (num == deleteList.size()) {
            return new HttpResult(HttpResult.SUCCESS, "删除成功，删除条数：" + num);
        } else {
            throw new Exception();
        }
    }

    @Override
    public PWsdTaskdataGroupVO findByKey(PWsdTaskdataGroupVO pWsdTaskdataGroupVO) {
        PWsdTaskdataGroupDomain model = pWsdTaskdataGroupReadDAO.findByKey(pWsdTaskdataGroupVO.vo2Domain());
        PWsdTaskdataGroupVO modelVo = new PWsdTaskdataGroupVO();
        if (model != null) {
            modelVo = model.domain2VO();
        } else {
            modelVo = null;
        }
        return modelVo;
    }

    @Override
    public List<PWsdTaskdataGroupVO> findByWhere(PWsdTaskdataGroupVO pWsdTaskdataGroupVO) {
        PWsdTaskdataGroupDomain pWsdTaskdataGroupDomain = pWsdTaskdataGroupVO.vo2Domain();
        List<PWsdTaskdataGroupDomain> lstDomain = pWsdTaskdataGroupReadDAO.findByWhere(pWsdTaskdataGroupDomain);
        pWsdTaskdataGroupVO.setTotalRow(pWsdTaskdataGroupDomain.getTotalRow());
        pWsdTaskdataGroupVO.setPageCurrent(pWsdTaskdataGroupDomain.getPageCurrent());
        pWsdTaskdataGroupVO.setDbName(pWsdTaskdataGroupDomain.getDbName());
        pWsdTaskdataGroupVO.setPageSize(pWsdTaskdataGroupDomain.getPageSize());

        return ReflectUtil.cast(lstDomain, PWsdTaskdataGroupVO.class);
    }

}
