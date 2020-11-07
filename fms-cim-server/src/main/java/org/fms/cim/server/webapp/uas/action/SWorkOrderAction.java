/**
 * 异常工单
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.SWorkOrderAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.ISWorkOrderService;
import org.fms.cim.common.vo.uas.SWorkOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("SWorkOrder")
public class SWorkOrderAction {

    @Autowired
    @Qualifier("SWorkOrderServiceImpl")
    private ISWorkOrderService sWorkOrderService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody SWorkOrderVO sWorkOrderVO) {
        int i = sWorkOrderService.insert(sWorkOrderVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody SWorkOrderVO sWorkOrderVO) {
        int i = sWorkOrderService.update(sWorkOrderVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<SWorkOrderVO> deleteList) throws Exception {
        HttpResult httpResult = sWorkOrderService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody SWorkOrderVO sWorkOrderVO) {
        SWorkOrderVO modelVo = sWorkOrderService.findByKey(sWorkOrderVO);

        if (modelVo != null) {
            return new HttpResult<SWorkOrderVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<SWorkOrderVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody SWorkOrderVO sWorkOrderVO) {

        return new HttpResultPagination(sWorkOrderVO, sWorkOrderService.findByWhere(sWorkOrderVO));
    }
}
