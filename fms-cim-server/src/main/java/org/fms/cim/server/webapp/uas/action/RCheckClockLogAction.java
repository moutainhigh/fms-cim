/**
 * 终端对时日志表
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.RCheckClockLogAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IRCheckClockLogService;
import org.fms.cim.common.vo.uas.RCheckClockLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("RCheckClockLog")
public class RCheckClockLogAction {

    @Autowired
    @Qualifier("RCheckClockLogServiceImpl")
    private IRCheckClockLogService rCheckClockLogService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody RCheckClockLogVO rCheckClockLogVO) {
        int i = rCheckClockLogService.insert(rCheckClockLogVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody RCheckClockLogVO rCheckClockLogVO) {
        int i = rCheckClockLogService.update(rCheckClockLogVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<RCheckClockLogVO> deleteList) throws Exception {
        HttpResult httpResult = rCheckClockLogService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody RCheckClockLogVO rCheckClockLogVO) {
        RCheckClockLogVO modelVo = rCheckClockLogService.findByKey(rCheckClockLogVO);

        if (modelVo != null) {
            return new HttpResult<RCheckClockLogVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<RCheckClockLogVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody RCheckClockLogVO rCheckClockLogVO) {

        return new HttpResultPagination(rCheckClockLogVO, rCheckClockLogService.findByWhere(rCheckClockLogVO));
    }
}
