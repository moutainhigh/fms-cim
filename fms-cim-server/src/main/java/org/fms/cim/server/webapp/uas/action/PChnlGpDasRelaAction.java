/**
 * 通道组主机关系
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.action.PChnlGpDasRelaAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import java.util.List;

import org.fms.cim.common.service.IPChnlGpDasRelaService;
import org.fms.cim.common.vo.uas.PChnlGpDasRelaVO;
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
@RequestMapping("PChnlGpDasRela")
public class PChnlGpDasRelaAction {

    @Autowired
    @Qualifier("PChnlGpDasRelaServiceImpl")
    private IPChnlGpDasRelaService pChnlGpDasRelaService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PChnlGpDasRelaVO pChnlGpDasRelaVO) {
        int i = pChnlGpDasRelaService.insert(pChnlGpDasRelaVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PChnlGpDasRelaVO pChnlGpDasRelaVO) {
        int i = pChnlGpDasRelaService.update(pChnlGpDasRelaVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PChnlGpDasRelaVO> deleteList) throws Exception {
        HttpResult httpResult = pChnlGpDasRelaService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PChnlGpDasRelaVO pChnlGpDasRelaVO) {
        PChnlGpDasRelaVO modelVo = pChnlGpDasRelaService.findByKey(pChnlGpDasRelaVO);

        if (modelVo != null) {
            return new HttpResult<PChnlGpDasRelaVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PChnlGpDasRelaVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PChnlGpDasRelaVO pChnlGpDasRelaVO) {

        return new HttpResultPagination(pChnlGpDasRelaVO, pChnlGpDasRelaService.findByWhere(pChnlGpDasRelaVO));
    }
}
