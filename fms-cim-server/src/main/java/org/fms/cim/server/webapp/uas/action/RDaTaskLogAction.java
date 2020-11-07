/**
 * 采集任务执行日志表
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.RDaTaskLogAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IRDaTaskLogService;
import org.fms.cim.common.vo.uas.RDaTaskLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("RDaTaskLog")
public class RDaTaskLogAction {

    @Autowired
    @Qualifier("RDaTaskLogServiceImpl")
    private IRDaTaskLogService rDaTaskLogService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody RDaTaskLogVO rDaTaskLogVO) {
        int i = rDaTaskLogService.insert(rDaTaskLogVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody RDaTaskLogVO rDaTaskLogVO) {
        int i = rDaTaskLogService.update(rDaTaskLogVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<RDaTaskLogVO> deleteList) throws Exception {
        HttpResult httpResult = rDaTaskLogService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody RDaTaskLogVO rDaTaskLogVO) {
        RDaTaskLogVO modelVo = rDaTaskLogService.findByKey(rDaTaskLogVO);

        if (modelVo != null) {
            return new HttpResult<RDaTaskLogVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<RDaTaskLogVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody RDaTaskLogVO rDaTaskLogVO) {

        return new HttpResultPagination(rDaTaskLogVO, rDaTaskLogService.findByWhere(rDaTaskLogVO));
    }
}
