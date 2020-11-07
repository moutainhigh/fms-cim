/**
 * 旁路事件审核表
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.SLineRpPreAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.ISLineRpPreService;
import org.fms.cim.common.vo.uas.SLineRpPreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("SLineRpPre")
public class SLineRpPreAction {

    @Autowired
    @Qualifier("SLineRpPreServiceImpl")
    private ISLineRpPreService sLineRpPreService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody SLineRpPreVO sLineRpPreVO) {
        int i = sLineRpPreService.insert(sLineRpPreVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody SLineRpPreVO sLineRpPreVO) {
        int i = sLineRpPreService.update(sLineRpPreVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<SLineRpPreVO> deleteList) throws Exception {
        HttpResult httpResult = sLineRpPreService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody SLineRpPreVO sLineRpPreVO) {
        SLineRpPreVO modelVo = sLineRpPreService.findByKey(sLineRpPreVO);

        if (modelVo != null) {
            return new HttpResult<SLineRpPreVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<SLineRpPreVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody SLineRpPreVO sLineRpPreVO) {

        return new HttpResultPagination(sLineRpPreVO, sLineRpPreService.findByWhere(sLineRpPreVO));
    }
}
