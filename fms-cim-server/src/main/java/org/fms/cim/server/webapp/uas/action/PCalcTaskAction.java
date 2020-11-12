/**
 * 计算任务
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PCalcTaskAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPCalcTaskService;
import org.fms.cim.common.vo.uas.*;
import org.fms.cim.server.webapp.uas.helper.UtilityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PCalcTask")
public class PCalcTaskAction {

    @Autowired
    @Qualifier("PCalcTaskServiceImpl")
    private IPCalcTaskService pCalcTaskService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PCalcTaskVO pCalcTaskVO) {
        if (pCalcTaskVO != null) {
            pCalcTaskVO.setGltsFlag(getCalcTaskDataType(pCalcTaskVO.getDataTypeList()));
            int i = pCalcTaskService.insert(pCalcTaskVO);
            if (i > 0) {
                return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
            } else {
                return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
            }
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "参数传递错误", null);
        }
    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PCalcTaskVO pCalcTaskVO) {
        if (pCalcTaskVO != null) {
            pCalcTaskVO.setGltsFlag(getCalcTaskDataType(pCalcTaskVO.getDataTypeList()));
            int i = pCalcTaskService.update(pCalcTaskVO);
            if (i > 0) {
                return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
            } else {
                return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
            }
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "参数传递错误", null);
        }
    }

    private String getCalcTaskDataType(List<PCalcTaskDataTypeVO> list) {
        char[] dataType = UtilityHelper.caclTaskDataType.toCharArray();//获取默认
        if (list != null && list.size() > 0) {
            for (PCalcTaskDataTypeVO item : list) {
                if (item.getIsSelect() == 1) {
                    dataType[item.getKey()] = '1';
                }
            }
        }
        return dataType.toString();
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
            if (modelVo.getGltsFlag() != null && modelVo.getGltsFlag().length() == 64) {
                modelVo.setDataTypeList(UtilityHelper.getDataType());//获取对象
                char[] dataType = modelVo.getGltsFlag().toCharArray();//获取默认
                for (PCalcTaskDataTypeVO item : modelVo.getDataTypeList()) {
                    if (dataType[item.getKey()] == '1') {
                        item.setIsSelect(1);
                    }
                }
                return new HttpResult<>(HttpResult.SUCCESS, "获取成功", modelVo);
            } else {
                return new HttpResult<>(HttpResult.ERROR, "功率、费率标识错误，获取失败!", null);
            }
        } else {
            return new HttpResult<>(HttpResult.ERROR, "未检索到相关数据!", null);
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
     * @param modelVO 任务模板对象
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=findByRelTpl")
    public HttpResultPagination<?> findByRelTpl(@RequestBody PCalcTplVO modelVO) {
        if (modelVO != null) {
            PCalcTaskRelVO pCalcTaskRelVO = new PCalcTaskRelVO();
            pCalcTaskRelVO.setObjtype(modelVO.getType());//获取适用范围下所有的任务
            pCalcTaskRelVO.setPageSize(-1);//不分页
            pCalcTaskRelVO.setTplID(modelVO.getId());
            List<PCalcTaskRelVO> pCalcTaskRelVOList = pCalcTaskService.findByRelTpl(pCalcTaskRelVO);
            if (pCalcTaskRelVOList != null && pCalcTaskRelVOList.size() > 0) {
                for (PCalcTaskRelVO item : pCalcTaskRelVOList) {
                    if(item.getTplID() == modelVO.getId()){
                        item.setIsSelect(1);
                    }else{
                        item.setIsSelect(0);
                        item.setRelID(null);
                        item.setTplID(null);
                    }
                }
            }
            return new HttpResultPagination(pCalcTaskRelVO, pCalcTaskRelVOList);
        } else {
            return new HttpResultPagination(null, null);
        }
    }

    /**
     * 获取计算任务数据类型
     *
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=getCalcTaskDataType")
    public HttpResult<?> getCalcTaskDataType() {
        List<PCalcTaskDataTypeVO> list = UtilityHelper.getDataType();
        return new HttpResult<>(HttpResult.SUCCESS, "获取成功", list);
    }
}
