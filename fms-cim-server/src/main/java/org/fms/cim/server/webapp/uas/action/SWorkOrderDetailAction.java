/**
 * 异常工单明细
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.SWorkOrderDetailAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.ISWorkOrderDetailService;
import org.fms.cim.common.vo.uas.SWorkOrderDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("SWorkOrderDetail")
public class SWorkOrderDetailAction {

    @Autowired
    @Qualifier("SWorkOrderDetailServiceImpl")
    private ISWorkOrderDetailService sWorkOrderDetailService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody SWorkOrderDetailVO sWorkOrderDetailVO) {
        int i = sWorkOrderDetailService.insert(sWorkOrderDetailVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody SWorkOrderDetailVO sWorkOrderDetailVO) {
        int i = sWorkOrderDetailService.update(sWorkOrderDetailVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<SWorkOrderDetailVO> deleteList) throws Exception {
        HttpResult httpResult = sWorkOrderDetailService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody SWorkOrderDetailVO sWorkOrderDetailVO) {
        SWorkOrderDetailVO modelVo = sWorkOrderDetailService.findByKey(sWorkOrderDetailVO);

        if (modelVo != null) {
            return new HttpResult<SWorkOrderDetailVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<SWorkOrderDetailVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody SWorkOrderDetailVO sWorkOrderDetailVO) {

        return new HttpResultPagination(sWorkOrderDetailVO, sWorkOrderDetailService.findByWhere(sWorkOrderDetailVO));
    }
}
