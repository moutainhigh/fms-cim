/**
 * 告警范围
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PAlarmDataAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPAlarmDataService;
import org.fms.cim.common.vo.uas.PAlarmDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PAlarmData")
public class PAlarmDataAction {

    @Autowired
    @Qualifier("PAlarmDataServiceImpl")
    private IPAlarmDataService pAlarmDataService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PAlarmDataVO pAlarmDataVO) {
        int i = pAlarmDataService.insert(pAlarmDataVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PAlarmDataVO pAlarmDataVO) {
        int i = pAlarmDataService.update(pAlarmDataVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PAlarmDataVO> deleteList) throws Exception {
        HttpResult httpResult = pAlarmDataService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PAlarmDataVO pAlarmDataVO) {
        PAlarmDataVO modelVo = pAlarmDataService.findByKey(pAlarmDataVO);

        if (modelVo != null) {
            return new HttpResult<PAlarmDataVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PAlarmDataVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PAlarmDataVO pAlarmDataVO) {

        return new HttpResultPagination(pAlarmDataVO, pAlarmDataService.findByWhere(pAlarmDataVO));
    }
}
