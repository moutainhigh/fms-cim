/**
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PMeterModelAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPMeterModelService;
import org.fms.cim.common.vo.uas.PMeterModelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PMeterModel")
public class PMeterModelAction {

    @Autowired
    @Qualifier("PMeterModelServiceImpl")
    private IPMeterModelService pMeterModelService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PMeterModelVO pMeterModelVO) {
        int i = pMeterModelService.insert(pMeterModelVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PMeterModelVO pMeterModelVO) {
        int i = pMeterModelService.update(pMeterModelVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PMeterModelVO> deleteList) throws Exception {
        HttpResult httpResult = pMeterModelService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PMeterModelVO pMeterModelVO) {
        PMeterModelVO modelVo = pMeterModelService.findByKey(pMeterModelVO);

        if (modelVo != null) {
            return new HttpResult<PMeterModelVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PMeterModelVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PMeterModelVO pMeterModelVO) {

        return new HttpResultPagination(pMeterModelVO, pMeterModelService.findByWhere(pMeterModelVO));
    }
}
