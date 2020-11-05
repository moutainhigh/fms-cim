/**
 * 采集点
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.action.RCpAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import java.util.List;

import org.fms.cim.common.service.IRCpService;
import org.fms.cim.common.vo.uas.RCpVO;
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
@RequestMapping("RCp")
public class RCpAction {

    @Autowired
    @Qualifier("RCpServiceImpl")
    private IRCpService rCpService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody RCpVO rCpVO) {
        int i = rCpService.insert(rCpVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody RCpVO rCpVO) {
        int i = rCpService.update(rCpVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<RCpVO> deleteList) throws Exception {
        HttpResult httpResult = rCpService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody RCpVO rCpVO) {
        RCpVO modelVo = rCpService.findByKey(rCpVO);

        if (modelVo != null) {
            return new HttpResult<RCpVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<RCpVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody RCpVO rCpVO) {

        return new HttpResultPagination(rCpVO, rCpService.findByWhere(rCpVO));
    }
}
