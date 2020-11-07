/**
 * 系统节点进程信息
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PNodeProcAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPNodeProcService;
import org.fms.cim.common.vo.uas.PNodeProcVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PNodeProc")
public class PNodeProcAction {

    @Autowired
    @Qualifier("PNodeProcServiceImpl")
    private IPNodeProcService pNodeProcService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PNodeProcVO pNodeProcVO) {
        int i = pNodeProcService.insert(pNodeProcVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PNodeProcVO pNodeProcVO) {
        int i = pNodeProcService.update(pNodeProcVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PNodeProcVO> deleteList) throws Exception {
        HttpResult httpResult = pNodeProcService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PNodeProcVO pNodeProcVO) {
        PNodeProcVO modelVo = pNodeProcService.findByKey(pNodeProcVO);

        if (modelVo != null) {
            return new HttpResult<PNodeProcVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PNodeProcVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PNodeProcVO pNodeProcVO) {

        return new HttpResultPagination(pNodeProcVO, pNodeProcService.findByWhere(pNodeProcVO));
    }
}
