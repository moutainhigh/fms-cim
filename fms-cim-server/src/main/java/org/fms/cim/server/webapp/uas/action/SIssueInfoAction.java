/**
 * 系统公告
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.SIssueInfoAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.ISIssueInfoService;
import org.fms.cim.common.vo.uas.SIssueInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("SIssueInfo")
public class SIssueInfoAction {

    @Autowired
    @Qualifier("SIssueInfoServiceImpl")
    private ISIssueInfoService sIssueInfoService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody SIssueInfoVO sIssueInfoVO) {
        int i = sIssueInfoService.insert(sIssueInfoVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody SIssueInfoVO sIssueInfoVO) {
        int i = sIssueInfoService.update(sIssueInfoVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<SIssueInfoVO> deleteList) throws Exception {
        HttpResult httpResult = sIssueInfoService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody SIssueInfoVO sIssueInfoVO) {
        SIssueInfoVO modelVo = sIssueInfoService.findByKey(sIssueInfoVO);

        if (modelVo != null) {
            return new HttpResult<SIssueInfoVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<SIssueInfoVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody SIssueInfoVO sIssueInfoVO) {

        return new HttpResultPagination(sIssueInfoVO, sIssueInfoService.findByWhere(sIssueInfoVO));
    }
}
