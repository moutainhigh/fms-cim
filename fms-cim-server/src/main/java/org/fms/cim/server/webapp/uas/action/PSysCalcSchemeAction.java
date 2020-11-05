/**
 * 计算方案
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.action.PSysCalcSchemeAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import java.util.List;

import org.fms.cim.common.service.IPSysCalcSchemeService;
import org.fms.cim.common.vo.uas.PSysCalcSchemeVO;
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
@RequestMapping("PSysCalcScheme")
public class PSysCalcSchemeAction {

    @Autowired
    @Qualifier("PSysCalcSchemeServiceImpl")
    private IPSysCalcSchemeService pSysCalcSchemeService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PSysCalcSchemeVO pSysCalcSchemeVO) {
        int i = pSysCalcSchemeService.insert(pSysCalcSchemeVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PSysCalcSchemeVO pSysCalcSchemeVO) {
        int i = pSysCalcSchemeService.update(pSysCalcSchemeVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PSysCalcSchemeVO> deleteList) throws Exception {
        HttpResult httpResult = pSysCalcSchemeService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PSysCalcSchemeVO pSysCalcSchemeVO) {
        PSysCalcSchemeVO modelVo = pSysCalcSchemeService.findByKey(pSysCalcSchemeVO);

        if (modelVo != null) {
            return new HttpResult<PSysCalcSchemeVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PSysCalcSchemeVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PSysCalcSchemeVO pSysCalcSchemeVO) {

        return new HttpResultPagination(pSysCalcSchemeVO, pSysCalcSchemeService.findByWhere(pSysCalcSchemeVO));
    }
}
