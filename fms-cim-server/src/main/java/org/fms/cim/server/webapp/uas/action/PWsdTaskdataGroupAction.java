/**
 * 规约数据单元组（※相当于原来变电站采集的规约信息体类型）
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.action.PWsdTaskdataGroupAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import java.util.List;

import org.fms.cim.common.service.IPWsdTaskdataGroupService;
import org.fms.cim.common.vo.uas.PWsdTaskdataGroupVO;
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
@RequestMapping("PWsdTaskdataGroup")
public class PWsdTaskdataGroupAction {

    @Autowired
    @Qualifier("PWsdTaskdataGroupServiceImpl")
    private IPWsdTaskdataGroupService pWsdTaskdataGroupService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PWsdTaskdataGroupVO pWsdTaskdataGroupVO) {
        int i = pWsdTaskdataGroupService.insert(pWsdTaskdataGroupVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PWsdTaskdataGroupVO pWsdTaskdataGroupVO) {
        int i = pWsdTaskdataGroupService.update(pWsdTaskdataGroupVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PWsdTaskdataGroupVO> deleteList) throws Exception {
        HttpResult httpResult = pWsdTaskdataGroupService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PWsdTaskdataGroupVO pWsdTaskdataGroupVO) {
        PWsdTaskdataGroupVO modelVo = pWsdTaskdataGroupService.findByKey(pWsdTaskdataGroupVO);

        if (modelVo != null) {
            return new HttpResult<PWsdTaskdataGroupVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PWsdTaskdataGroupVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PWsdTaskdataGroupVO pWsdTaskdataGroupVO) {

        return new HttpResultPagination(pWsdTaskdataGroupVO, pWsdTaskdataGroupService.findByWhere(pWsdTaskdataGroupVO));
    }
}
