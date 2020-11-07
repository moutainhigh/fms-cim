/**
 * 计量业务触发表
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.RWorkTriggerAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IRWorkTriggerService;
import org.fms.cim.common.vo.uas.RWorkTriggerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("RWorkTrigger")
public class RWorkTriggerAction {

    @Autowired
    @Qualifier("RWorkTriggerServiceImpl")
    private IRWorkTriggerService rWorkTriggerService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody RWorkTriggerVO rWorkTriggerVO) {
        int i = rWorkTriggerService.insert(rWorkTriggerVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody RWorkTriggerVO rWorkTriggerVO) {
        int i = rWorkTriggerService.update(rWorkTriggerVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<RWorkTriggerVO> deleteList) throws Exception {
        HttpResult httpResult = rWorkTriggerService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody RWorkTriggerVO rWorkTriggerVO) {
        RWorkTriggerVO modelVo = rWorkTriggerService.findByKey(rWorkTriggerVO);

        if (modelVo != null) {
            return new HttpResult<RWorkTriggerVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<RWorkTriggerVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody RWorkTriggerVO rWorkTriggerVO) {

        return new HttpResultPagination(rWorkTriggerVO, rWorkTriggerService.findByWhere(rWorkTriggerVO));
    }
}
