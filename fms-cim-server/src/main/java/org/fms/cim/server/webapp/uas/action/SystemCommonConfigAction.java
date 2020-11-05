/**
 * 下拉表 -迟子曰改
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.action.SystemCommonConfigAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import java.util.List;

import org.fms.cim.common.service.ISystemCommonConfigService;
import org.fms.cim.common.vo.uas.SystemCommonConfigVO;
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
@RequestMapping("SystemCommonConfig")
public class SystemCommonConfigAction {

    @Autowired
    @Qualifier("systemCommonConfigServiceImpl")
    private ISystemCommonConfigService systemCommonConfigService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody SystemCommonConfigVO systemCommonConfigVO) {
        int i = systemCommonConfigService.insert(systemCommonConfigVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody SystemCommonConfigVO systemCommonConfigVO) {
        int i = systemCommonConfigService.update(systemCommonConfigVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<SystemCommonConfigVO> deleteList) throws Exception {
        HttpResult httpResult = systemCommonConfigService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody SystemCommonConfigVO systemCommonConfigVO) {
        SystemCommonConfigVO modelVo = systemCommonConfigService.findByKey(systemCommonConfigVO);

        if (modelVo != null) {
            return new HttpResult<SystemCommonConfigVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<SystemCommonConfigVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody SystemCommonConfigVO systemCommonConfigVO) {

        return new HttpResultPagination(systemCommonConfigVO, systemCommonConfigService.findByWhere(systemCommonConfigVO));
    }
}
