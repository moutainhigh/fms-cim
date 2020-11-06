/**
 * 计算方案模板
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PCalcTplAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPCalcTplService;
import org.fms.cim.common.vo.uas.PCalcTplVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PCalcTpl")
public class PCalcTplAction {

    @Autowired
    @Qualifier("PCalcTplServiceImpl")
    private IPCalcTplService pCalcTplService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PCalcTplVO pCalcTplVO) {
        int i = pCalcTplService.insert(pCalcTplVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PCalcTplVO pCalcTplVO) {
        int i = pCalcTplService.update(pCalcTplVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PCalcTplVO> deleteList) throws Exception {
        HttpResult httpResult = pCalcTplService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PCalcTplVO pCalcTplVO) {
        PCalcTplVO modelVo = pCalcTplService.findByKey(pCalcTplVO);

        if (modelVo != null) {
            return new HttpResult<PCalcTplVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PCalcTplVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PCalcTplVO pCalcTplVO) {

        return new HttpResultPagination(pCalcTplVO, pCalcTplService.findByWhere(pCalcTplVO));
    }
}
