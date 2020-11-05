/**
 * 计算任务类型定义表
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.action.PWsdCalcTaskAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import java.util.List;

import org.fms.cim.common.service.IPWsdCalcTaskService;
import org.fms.cim.common.vo.uas.PWsdCalcTaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;

@ControllerAdvice
@RequestMapping("PWsdCalcTask")
public class PWsdCalcTaskAction {

    @Autowired
    @Qualifier("PWsdCalcTaskServiceImpl")
    private IPWsdCalcTaskService pWsdCalcTaskService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PWsdCalcTaskVO pWsdCalcTaskVO) {
        int i = pWsdCalcTaskService.insert(pWsdCalcTaskVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PWsdCalcTaskVO pWsdCalcTaskVO) {
        int i = pWsdCalcTaskService.update(pWsdCalcTaskVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PWsdCalcTaskVO> deleteList) throws Exception {
        HttpResult httpResult = pWsdCalcTaskService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PWsdCalcTaskVO pWsdCalcTaskVO) {
        PWsdCalcTaskVO modelVo = pWsdCalcTaskService.findByKey(pWsdCalcTaskVO);

        if (modelVo != null) {
            return new HttpResult<PWsdCalcTaskVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PWsdCalcTaskVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PWsdCalcTaskVO pWsdCalcTaskVO) {

        return new HttpResultPagination(pWsdCalcTaskVO, pWsdCalcTaskService.findByWhere(pWsdCalcTaskVO));
    }
}
