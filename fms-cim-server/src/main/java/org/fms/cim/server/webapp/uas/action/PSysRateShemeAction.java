/**
 * 多费率方案定义表
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PSysRateShemeAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPSysRateShemeService;
import org.fms.cim.common.vo.uas.PSysRateShemeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PSysRateSheme")
public class PSysRateShemeAction {

    @Autowired
    @Qualifier("PSysRateShemeServiceImpl")
    private IPSysRateShemeService pSysRateShemeService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PSysRateShemeVO pSysRateShemeVO) {
        int i = pSysRateShemeService.insert(pSysRateShemeVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PSysRateShemeVO pSysRateShemeVO) {
        int i = pSysRateShemeService.update(pSysRateShemeVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PSysRateShemeVO> deleteList) throws Exception {
        HttpResult httpResult = pSysRateShemeService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PSysRateShemeVO pSysRateShemeVO) {
        PSysRateShemeVO modelVo = pSysRateShemeService.findByKey(pSysRateShemeVO);

        if (modelVo != null) {
            return new HttpResult<PSysRateShemeVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PSysRateShemeVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PSysRateShemeVO pSysRateShemeVO) {

        return new HttpResultPagination(pSysRateShemeVO, pSysRateShemeService.findByWhere(pSysRateShemeVO));
    }
}
