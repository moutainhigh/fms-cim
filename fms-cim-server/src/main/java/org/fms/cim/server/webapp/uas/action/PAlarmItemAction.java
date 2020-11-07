/**
 * 告警事项设置
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PAlarmItemAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPAlarmItemService;
import org.fms.cim.common.vo.uas.PAlarmItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PAlarmItem")
public class PAlarmItemAction {

    @Autowired
    @Qualifier("PAlarmItemServiceImpl")
    private IPAlarmItemService pAlarmItemService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PAlarmItemVO pAlarmItemVO) {
        int i = pAlarmItemService.insert(pAlarmItemVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PAlarmItemVO pAlarmItemVO) {
        int i = pAlarmItemService.update(pAlarmItemVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PAlarmItemVO> deleteList) throws Exception {
        HttpResult httpResult = pAlarmItemService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PAlarmItemVO pAlarmItemVO) {
        PAlarmItemVO modelVo = pAlarmItemService.findByKey(pAlarmItemVO);

        if (modelVo != null) {
            return new HttpResult<PAlarmItemVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PAlarmItemVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PAlarmItemVO pAlarmItemVO) {

        return new HttpResultPagination(pAlarmItemVO, pAlarmItemService.findByWhere(pAlarmItemVO));
    }
}
