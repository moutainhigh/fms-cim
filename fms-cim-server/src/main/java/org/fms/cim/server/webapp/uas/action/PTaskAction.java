/**
 * 采集任务
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PTaskAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPTaskService;
import org.fms.cim.common.vo.uas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RequestMapping("PTask")
public class PTaskAction {

    @Autowired
    @Qualifier("PTaskServiceImpl")
    private IPTaskService pTaskService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PTaskVO pTaskVO) {
        int i = pTaskService.insert(pTaskVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PTaskVO pTaskVO) {
        int i = pTaskService.update(pTaskVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PTaskVO> deleteList) throws Exception {
        HttpResult httpResult = pTaskService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PTaskVO pTaskVO) {
        PTaskVO modelVo = pTaskService.findByKey(pTaskVO);

        if (modelVo != null) {
            return new HttpResult<PTaskVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PTaskVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PTaskVO pTaskVO) {

        return new HttpResultPagination(pTaskVO, pTaskService.findByWhere(pTaskVO));
    }

    /**
     * 通过通讯规约ID获取任务列表
     *
     * @param pWsdProtocolID 通讯规约ID
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=findByProtocolID")
    public HttpResult<?> findByProtocolID(@RequestBody Long pWsdProtocolID) {
        PTaskVO pTaskVO = new PTaskVO();
        pTaskVO.setProtocolId(pWsdProtocolID);//规约赋值
        pTaskVO.setPageSize(-1);//不设置分页
        List<PTaskVO> listVo = pTaskService.findByWhere(pTaskVO);//获取此规约的任务
        return new HttpResult<List<PTaskVO>>(HttpResult.SUCCESS, "获取成功", listVo);
    }

    /**
     * 通过任务模板获取任务列表
     *
     * @param pTaskTplVO 任务模板
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=findByTaskTpl")
    public HttpResult<?> findByTaskTpl(@RequestBody PTaskTplVO pTaskTplVO) {
        if (pTaskTplVO != null) {
            PTaskRelVO pTaskRelVO = new PTaskRelVO();
            pTaskRelVO.setPageSize(-1);//设置-1不进行分页
            pTaskRelVO.setProtocolId(pTaskTplVO.getProtocolId());//赋值规约
            List<PTaskRelVO> listVo = pTaskService.findByTaskTpl(pTaskRelVO);//获取此规约全部任务
            if (listVo != null && listVo.size() > 0) {
                for (PTaskRelVO item : listVo) {
                    item.setIsSelect(item.getTplID() == pTaskTplVO.getId() ? 1 : 0);
                }
            }
            return new HttpResult<List<PTaskRelVO>>(HttpResult.SUCCESS, "获取成功", listVo);
        } else {
            return new HttpResult<List<PTaskRelVO>>(HttpResult.ERROR, "参数传递错误", null);
        }
    }
}
