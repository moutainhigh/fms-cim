/**
 * 通道使用日志
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.RChannelUseLogAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IRChannelUseLogService;
import org.fms.cim.common.vo.uas.RChannelUseLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("RChannelUseLog")
public class RChannelUseLogAction {

    @Autowired
    @Qualifier("RChannelUseLogServiceImpl")
    private IRChannelUseLogService rChannelUseLogService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody RChannelUseLogVO rChannelUseLogVO) {
        int i = rChannelUseLogService.insert(rChannelUseLogVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody RChannelUseLogVO rChannelUseLogVO) {
        int i = rChannelUseLogService.update(rChannelUseLogVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<RChannelUseLogVO> deleteList) throws Exception {
        HttpResult httpResult = rChannelUseLogService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody RChannelUseLogVO rChannelUseLogVO) {
        RChannelUseLogVO modelVo = rChannelUseLogService.findByKey(rChannelUseLogVO);

        if (modelVo != null) {
            return new HttpResult<RChannelUseLogVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<RChannelUseLogVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody RChannelUseLogVO rChannelUseLogVO) {

        return new HttpResultPagination(rChannelUseLogVO, rChannelUseLogService.findByWhere(rChannelUseLogVO));
    }
}
