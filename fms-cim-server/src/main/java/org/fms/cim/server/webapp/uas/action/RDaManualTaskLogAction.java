/**
 * 人工任务执行日志表
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.RDaManualTaskLogAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IRDaManualTaskLogService;
import org.fms.cim.common.vo.uas.RDaManualTaskLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("RDaManualTaskLog")
public class RDaManualTaskLogAction {

    @Autowired
    @Qualifier("RDaManualTaskLogServiceImpl")
    private IRDaManualTaskLogService rDaManualTaskLogService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody RDaManualTaskLogVO rDaManualTaskLogVO) {
        int i = rDaManualTaskLogService.insert(rDaManualTaskLogVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody RDaManualTaskLogVO rDaManualTaskLogVO) {
        int i = rDaManualTaskLogService.update(rDaManualTaskLogVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<RDaManualTaskLogVO> deleteList) throws Exception {
        HttpResult httpResult = rDaManualTaskLogService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody RDaManualTaskLogVO rDaManualTaskLogVO) {
        RDaManualTaskLogVO modelVo = rDaManualTaskLogService.findByKey(rDaManualTaskLogVO);

        if (modelVo != null) {
            return new HttpResult<RDaManualTaskLogVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<RDaManualTaskLogVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody RDaManualTaskLogVO rDaManualTaskLogVO) {

        return new HttpResultPagination(rDaManualTaskLogVO, rDaManualTaskLogService.findByWhere(rDaManualTaskLogVO));
    }
}
