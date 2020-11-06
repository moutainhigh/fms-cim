/**
 * 采集任务设置模板
 * ※设置时根据设置的模板明细、任务明细自动生成终端的任务及明细
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PTaskTplAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPTaskTplService;
import org.fms.cim.common.service.IPWsdProtocolService;
import org.fms.cim.common.service.ISystemCommonConfigService;
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
@RequestMapping("PTaskTpl")
public class PTaskTplAction {

    @Autowired
    @Qualifier("PTaskTplServiceImpl")
    private IPTaskTplService pTaskTplService;

    @Autowired
    @Qualifier("PWsdProtocolServiceImpl")
    private IPWsdProtocolService pWsdProtocolService;

    @Autowired
    @Qualifier("systemCommonConfigServiceImpl")
    private ISystemCommonConfigService systemCommonConfigService;

    /**
     * 同一个规约下只允许有一个默认的任务模板
     *
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PTaskTplVO pTaskTplVO) {
        if (pTaskTplVO != null) {
            if (pTaskTplVO.getDefaultFlag() == "1") {//是否通用下拉  1-是 0-否
                PTaskTplVO selectModel = new PTaskTplVO();
                selectModel.setProtocolId(pTaskTplVO.getProtocolId());
                int num = pTaskTplService.findByWhere(selectModel).size();//该规约下任务模板
                if (num > 0) {
                    return new HttpResult<String>(HttpResult.ERROR, "同一个规约下只允许有一个默认的任务模板", null);
                }
            }
            int i = pTaskTplService.insert(pTaskTplVO);
            if (i > 0) {
                return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
            } else {
                return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
            }
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "参数传递错误", null);
        }
    }

    /**
     * 同一个规约下只允许有一个默认的任务模板
     *
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PTaskTplVO pTaskTplVO) {
        if (pTaskTplVO != null) {
            if (pTaskTplVO.getDefaultFlag() == "1") {//是否通用下拉  1-是 0-否
                PTaskTplVO selectModel = new PTaskTplVO();
                selectModel.setProtocolId(pTaskTplVO.getProtocolId());
                Long num = pTaskTplService.findByWhere(selectModel).stream()
                        .filter(s -> s.getId() != pTaskTplVO.getId()).count();//该规约下任务模板
                if (num > 0) {
                    return new HttpResult<String>(HttpResult.ERROR, "同一个规约下只允许有一个默认的任务模板", null);
                }
            }
            int i = pTaskTplService.update(pTaskTplVO);

            if (i > 0) {
                return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
            } else {
                return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
            }
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "参数传递错误", null);
        }
    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PTaskTplVO> deleteList) throws Exception {
        HttpResult httpResult = pTaskTplService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PTaskTplVO pTaskTplVO) {
        PTaskTplVO modelVo = pTaskTplService.findByKey(pTaskTplVO);

        if (modelVo != null) {
            return new HttpResult<PTaskTplVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PTaskTplVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PTaskTplVO pTaskTplVO) {

        return new HttpResultPagination(pTaskTplVO, pTaskTplService.findByWhere(pTaskTplVO));
    }

    /**
     * 获取采集任务模板树
     *
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=findTaskTplTree")
    public HttpResult<?> findTaskTplTree() {
        //获取通讯规约
        PWsdProtocolVO pWsdProtocolVO = new PWsdProtocolVO();//此处加条件 例如是否可用等
        //pWsdProtocolVO.setStatus("可用");
        List<PWsdProtocolVO> pWsdProtocolVOList = pWsdProtocolService.findByWhere(pWsdProtocolVO);
        //获取采集任务模板
        PTaskTplVO pTaskTplVO = new PTaskTplVO();//此处加条件 例如是否可用等
        List<PTaskTplVO> pTaskTplVOList = pTaskTplService.findByWhere(pTaskTplVO);
        //拼接树
        if (pWsdProtocolVOList != null && pWsdProtocolVOList.size() > 0) {
            for (PWsdProtocolVO item : pWsdProtocolVOList) {
                //筛选条件
                List<PTaskTplVO> childList = pTaskTplVOList.stream()
                        .filter((PTaskTplVO s) -> s.getProtocolId() == item.getId())
                        .collect(Collectors.toList());
                item.setpTaskTplVOList(childList);
            }
        }
        return new HttpResult<List<PWsdProtocolVO>>(HttpResult.SUCCESS, "查询成功", pWsdProtocolVOList);
    }
}
