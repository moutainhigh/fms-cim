/**
 * 采集主机组
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PWsdChnlTypeAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPWsdChnlTypeService;
import org.fms.cim.common.vo.uas.PWsdChnlTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PWsdChnlType")
public class PWsdChnlTypeAction {

    @Autowired
    @Qualifier("PWsdChnlTypeServiceImpl")
    private IPWsdChnlTypeService pWsdChnlTypeService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PWsdChnlTypeVO pWsdChnlTypeVO) {
        int i = pWsdChnlTypeService.insert(pWsdChnlTypeVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PWsdChnlTypeVO pWsdChnlTypeVO) {
        int i = pWsdChnlTypeService.update(pWsdChnlTypeVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PWsdChnlTypeVO> deleteList) throws Exception {
        HttpResult httpResult = pWsdChnlTypeService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PWsdChnlTypeVO pWsdChnlTypeVO) {
        PWsdChnlTypeVO modelVo = pWsdChnlTypeService.findByKey(pWsdChnlTypeVO);

        if (modelVo != null) {
            return new HttpResult<PWsdChnlTypeVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PWsdChnlTypeVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PWsdChnlTypeVO pWsdChnlTypeVO) {

        return new HttpResultPagination(pWsdChnlTypeVO, pWsdChnlTypeService.findByWhere(pWsdChnlTypeVO));
    }
}
