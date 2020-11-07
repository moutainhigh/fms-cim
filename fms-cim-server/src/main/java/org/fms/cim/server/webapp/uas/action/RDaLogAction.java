/**
 * 采集日志表
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.RDaLogAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IRDaLogService;
import org.fms.cim.common.vo.uas.RDaLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("RDaLog")
public class RDaLogAction {

    @Autowired
    @Qualifier("RDaLogServiceImpl")
    private IRDaLogService rDaLogService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody RDaLogVO rDaLogVO) {
        int i = rDaLogService.insert(rDaLogVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody RDaLogVO rDaLogVO) {
        int i = rDaLogService.update(rDaLogVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<RDaLogVO> deleteList) throws Exception {
        HttpResult httpResult = rDaLogService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody RDaLogVO rDaLogVO) {
        RDaLogVO modelVo = rDaLogService.findByKey(rDaLogVO);

        if (modelVo != null) {
            return new HttpResult<RDaLogVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<RDaLogVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody RDaLogVO rDaLogVO) {

        return new HttpResultPagination(rDaLogVO, rDaLogService.findByWhere(rDaLogVO));
    }
}
