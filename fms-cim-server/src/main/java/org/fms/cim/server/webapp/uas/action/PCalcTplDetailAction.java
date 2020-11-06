/**
 * 计算方案模板明细
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PCalcTplDetailAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPCalcTplDetailService;
import org.fms.cim.common.service.IPChnlGpDasRelaService;
import org.fms.cim.common.vo.uas.PCalcTaskRelVO;
import org.fms.cim.common.vo.uas.PCalcTplDetailVO;
import org.fms.cim.common.vo.uas.PTaskTplVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RequestMapping("PCalcTplDetail")
public class PCalcTplDetailAction {

    @Autowired
    @Qualifier("PCalcTplDetailServiceImpl")
    private IPCalcTplDetailService pCalcTplDetailService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PCalcTplDetailVO pCalcTplDetailVO) {
        int i = pCalcTplDetailService.insert(pCalcTplDetailVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PCalcTplDetailVO pCalcTplDetailVO) {
        int i = pCalcTplDetailService.update(pCalcTplDetailVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PCalcTplDetailVO> deleteList) throws Exception {
        int i = pCalcTplDetailService.deleteList(deleteList);
        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "删除成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "删除失败", null);
        }
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PCalcTplDetailVO pCalcTplDetailVO) {
        PCalcTplDetailVO modelVo = pCalcTplDetailService.findByKey(pCalcTplDetailVO);

        if (modelVo != null) {
            return new HttpResult<PCalcTplDetailVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PCalcTplDetailVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PCalcTplDetailVO pCalcTplDetailVO) {

        return new HttpResultPagination(pCalcTplDetailVO, pCalcTplDetailService.findByWhere(pCalcTplDetailVO));
    }

    /**
     * 保存任务模板明细
     *
     * @param pCalcTaskRelVOList
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=saveCalcTplDetailList")
    public HttpResult<?> saveCalcTplDetailList(@RequestBody List<PCalcTaskRelVO> pCalcTaskRelVOList) {
        if (pCalcTaskRelVOList != null && pCalcTaskRelVOList.size() > 0) {
            List<PCalcTplDetailVO> addList = new ArrayList<>();
            List<PCalcTplDetailVO> delList = new ArrayList<>();
            for (PCalcTaskRelVO item : pCalcTaskRelVOList) {
                if (item.getIsSelect() == 1 && item.getRelID() == null) {
                    //isSelect=1 tplID不为null relID为null 新增
                    if (item.getTplID() != null) {
                        PCalcTplDetailVO addModel = new PCalcTplDetailVO();
                        addModel.setTplId(item.getTplID());
                        addModel.setTaskId(item.getId());
                        addList.add(addModel);
                    } else {
                        return new HttpResult<String>(HttpResult.ERROR, "参数传递错误!", null);
                    }
                } else if (item.getIsSelect() == 0 && item.getRelID() != null) {
                    //isSelect=0 relID不为null 删除
                    PCalcTplDetailVO delModel = new PCalcTplDetailVO();
                    delModel.setId(item.getRelID());
                    delList.add(delModel);
                }
            }
            if (addList.size() > 0) {
                int addNum = pCalcTplDetailService.insertList(addList);
                if (addNum == 0) {
                    return new HttpResult<String>(HttpResult.ERROR, "批量插入关系时失败", null);
                }
            }
            if (delList.size() > 0) {
                int delNum = pCalcTplDetailService.deleteList(delList);
                if (delNum == 0) {
                    return new HttpResult<String>(HttpResult.ERROR, "批量删除关系时失败", null);
                }
            }
            return new HttpResult<String>(HttpResult.SUCCESS, "保存成功!", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "暂无要保存的数据!", null);
        }
    }
}
