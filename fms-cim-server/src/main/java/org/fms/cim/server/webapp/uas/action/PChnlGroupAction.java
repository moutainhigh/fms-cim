/**
 * 通道组
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.action.PChnlGroupAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import java.util.List;

import org.fms.cim.common.service.IPChnlGroupService;
import org.fms.cim.common.vo.uas.PChnlGroupStaticVO;
import org.fms.cim.common.vo.uas.PChnlGroupVO;
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
@RequestMapping("PChnlGroup")
public class PChnlGroupAction {

    @Autowired
    @Qualifier("PChnlGroupServiceImpl")
    private IPChnlGroupService pChnlGroupService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PChnlGroupVO pChnlGroupVO) {
        int i = pChnlGroupService.insert(pChnlGroupVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }
    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PChnlGroupVO pChnlGroupVO) {
        int i = pChnlGroupService.update(pChnlGroupVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PChnlGroupVO> deleteList) throws Exception {
        HttpResult httpResult = pChnlGroupService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PChnlGroupVO pChnlGroupVO) {
        PChnlGroupVO modelVo = pChnlGroupService.findByKey(pChnlGroupVO);

        if (modelVo != null) {
            return new HttpResult<PChnlGroupVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PChnlGroupVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PChnlGroupVO pChnlGroupVO) {

        return new HttpResultPagination(pChnlGroupVO, pChnlGroupService.findByWhere(pChnlGroupVO));
    }

    @ResponseBody
    @PostMapping(params = "method=findByWhereStatic")
    public HttpResultPagination<?> findByWhereStatic(@RequestBody PChnlGroupStaticVO pChnlGroupStaticVO) {

        return new HttpResultPagination(pChnlGroupStaticVO, pChnlGroupService.findByWhereStatic(pChnlGroupStaticVO));
    }
}
