/**
 * 旁路事件
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.SLineRpAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.ISLineRpService;
import org.fms.cim.common.vo.uas.SLineRpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("SLineRp")
public class SLineRpAction {

    @Autowired
    @Qualifier("SLineRpServiceImpl")
    private ISLineRpService sLineRpService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody SLineRpVO sLineRpVO) {
        int i = sLineRpService.insert(sLineRpVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody SLineRpVO sLineRpVO) {
        int i = sLineRpService.update(sLineRpVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<SLineRpVO> deleteList) throws Exception {
        HttpResult httpResult = sLineRpService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody SLineRpVO sLineRpVO) {
        SLineRpVO modelVo = sLineRpService.findByKey(sLineRpVO);

        if (modelVo != null) {
            return new HttpResult<SLineRpVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<SLineRpVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody SLineRpVO sLineRpVO) {

        return new HttpResultPagination(sLineRpVO, sLineRpService.findByWhere(sLineRpVO));
    }
}
