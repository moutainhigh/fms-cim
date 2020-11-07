/**
 * 值班日志
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.SOndutyLogAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.ISOndutyLogService;
import org.fms.cim.common.vo.uas.SOndutyLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("SOndutyLog")
public class SOndutyLogAction {

    @Autowired
    @Qualifier("SOndutyLogServiceImpl")
    private ISOndutyLogService sOndutyLogService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody SOndutyLogVO sOndutyLogVO) {
        int i = sOndutyLogService.insert(sOndutyLogVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody SOndutyLogVO sOndutyLogVO) {
        int i = sOndutyLogService.update(sOndutyLogVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<SOndutyLogVO> deleteList) throws Exception {
        HttpResult httpResult = sOndutyLogService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody SOndutyLogVO sOndutyLogVO) {
        SOndutyLogVO modelVo = sOndutyLogService.findByKey(sOndutyLogVO);

        if (modelVo != null) {
            return new HttpResult<SOndutyLogVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<SOndutyLogVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody SOndutyLogVO sOndutyLogVO) {

        return new HttpResultPagination(sOndutyLogVO, sOndutyLogService.findByWhere(sOndutyLogVO));
    }
}
