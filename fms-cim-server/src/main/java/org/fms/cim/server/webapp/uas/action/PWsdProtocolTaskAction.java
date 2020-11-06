/**
 * 规约任务类型（※相当于原来变电站采集的规约数据类型表与负控采集的任务类型合并的表。对于厂站系列为电量、15分钟电量、瞬时量等；对于负荷、低压系列为一类、二类数据等）
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PWsdProtocolTaskAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPWsdProtocolTaskService;
import org.fms.cim.common.vo.uas.PWsdProtocolTaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PWsdProtocolTask")
public class PWsdProtocolTaskAction {

    @Autowired
    @Qualifier("PWsdProtocolTaskServiceImpl")
    private IPWsdProtocolTaskService pWsdProtocolTaskService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PWsdProtocolTaskVO pWsdProtocolTaskVO) {
        int i = pWsdProtocolTaskService.insert(pWsdProtocolTaskVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PWsdProtocolTaskVO pWsdProtocolTaskVO) {
        int i = pWsdProtocolTaskService.update(pWsdProtocolTaskVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PWsdProtocolTaskVO> deleteList) throws Exception {
        HttpResult httpResult = pWsdProtocolTaskService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PWsdProtocolTaskVO pWsdProtocolTaskVO) {
        PWsdProtocolTaskVO modelVo = pWsdProtocolTaskService.findByKey(pWsdProtocolTaskVO);

        if (modelVo != null) {
            return new HttpResult<PWsdProtocolTaskVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PWsdProtocolTaskVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PWsdProtocolTaskVO pWsdProtocolTaskVO) {

        return new HttpResultPagination(pWsdProtocolTaskVO, pWsdProtocolTaskService.findByWhere(pWsdProtocolTaskVO));
    }
}
