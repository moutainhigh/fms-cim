/**
 * 规约数据单元
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PWsdTaskdataAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPTaskDetailService;
import org.fms.cim.common.service.IPWsdTaskdataService;
import org.fms.cim.common.vo.uas.PTaskRelVO;
import org.fms.cim.common.vo.uas.PWsdTaskdataRelVO;
import org.fms.cim.common.vo.uas.PWsdTaskdataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PWsdTaskdata")
public class PWsdTaskdataAction {

    @Autowired
    @Qualifier("PWsdTaskdataServiceImpl")
    private IPWsdTaskdataService pWsdTaskdataService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PWsdTaskdataVO pWsdTaskdataVO) {
        int i = pWsdTaskdataService.insert(pWsdTaskdataVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PWsdTaskdataVO pWsdTaskdataVO) {
        int i = pWsdTaskdataService.update(pWsdTaskdataVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PWsdTaskdataVO> deleteList) throws Exception {
        HttpResult httpResult = pWsdTaskdataService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PWsdTaskdataVO pWsdTaskdataVO) {
        PWsdTaskdataVO modelVo = pWsdTaskdataService.findByKey(pWsdTaskdataVO);

        if (modelVo != null) {
            return new HttpResult<PWsdTaskdataVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PWsdTaskdataVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PWsdTaskdataVO pWsdTaskdataVO) {

        return new HttpResultPagination(pWsdTaskdataVO, pWsdTaskdataService.findByWhere(pWsdTaskdataVO));
    }



}
