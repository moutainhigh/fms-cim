/**
 * 计算任务
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PCalcTaskAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPCalcTaskService;
import org.fms.cim.common.vo.uas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RequestMapping("PCalcTask")
public class PCalcTaskAction {

    @Autowired
    @Qualifier("PCalcTaskServiceImpl")
    private IPCalcTaskService pCalcTaskService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PCalcTaskVO pCalcTaskVO) {
        int i = pCalcTaskService.insert(pCalcTaskVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PCalcTaskVO pCalcTaskVO) {
        int i = pCalcTaskService.update(pCalcTaskVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PCalcTaskVO> deleteList) throws Exception {
        HttpResult httpResult = pCalcTaskService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PCalcTaskVO pCalcTaskVO) {
        PCalcTaskVO modelVo = pCalcTaskService.findByKey(pCalcTaskVO);

        if (modelVo != null) {
            return new HttpResult<PCalcTaskVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PCalcTaskVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PCalcTaskVO pCalcTaskVO) {

        return new HttpResultPagination(pCalcTaskVO, pCalcTaskService.findByWhere(pCalcTaskVO));
    }

    /**
     * 通过任务模板获取任务列表
     *
     * @param pCalcTplVO 任务模板对象
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=findByRelTpl")
    public HttpResultPagination<?> findByRelTpl(@RequestBody PCalcTplVO pCalcTplVO) {
        if (pCalcTplVO != null) {
            PCalcTaskRelVO pCalcTaskRelVO = new PCalcTaskRelVO();
            pCalcTaskRelVO.setObjtype(pCalcTplVO.getType());//获取适用范围下所有的点
            List<PCalcTaskRelVO> pCalcTaskRelVOList = pCalcTaskService.findByRelTpl(pCalcTaskRelVO);
            if (pCalcTaskRelVOList != null && pCalcTaskRelVOList.size() > 0) {
                for (PCalcTaskRelVO item : pCalcTaskRelVOList) {
                    item.setIsSelect(item.getTplID() == pCalcTplVO.getId() ? 1 : 0);
                }
            }
            return new HttpResultPagination(pCalcTaskRelVO, pCalcTaskRelVOList);
        } else {
            return new HttpResultPagination(null, null);
        }
    }
}
