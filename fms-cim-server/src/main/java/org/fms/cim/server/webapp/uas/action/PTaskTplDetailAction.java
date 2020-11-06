/**
 * 采集任务模板明细
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PTaskTplDetailAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPTaskTplDetailService;
import org.fms.cim.common.vo.uas.PCalcTplDetailVO;
import org.fms.cim.common.vo.uas.PTaskRelVO;
import org.fms.cim.common.vo.uas.PTaskTplDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RequestMapping("PTaskTplDetail")
public class PTaskTplDetailAction {

    @Autowired
    @Qualifier("PTaskTplDetailServiceImpl")
    private IPTaskTplDetailService pTaskTplDetailService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PTaskTplDetailVO pTaskTplDetailVO) {
        int i = pTaskTplDetailService.insert(pTaskTplDetailVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PTaskTplDetailVO pTaskTplDetailVO) {
        int i = pTaskTplDetailService.update(pTaskTplDetailVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PTaskTplDetailVO> deleteList) throws Exception {
        int i = pTaskTplDetailService.deleteList(deleteList);
        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PTaskTplDetailVO pTaskTplDetailVO) {
        PTaskTplDetailVO modelVo = pTaskTplDetailService.findByKey(pTaskTplDetailVO);

        if (modelVo != null) {
            return new HttpResult<PTaskTplDetailVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PTaskTplDetailVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PTaskTplDetailVO pTaskTplDetailVO) {

        return new HttpResultPagination(pTaskTplDetailVO, pTaskTplDetailService.findByWhere(pTaskTplDetailVO));
    }

    /**
     * 保存采集任务模板明细
     *
     * @param pTaskRelVOList
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=saveTaskTplDetailList")
    public HttpResult<?> saveTaskTplDetailList(@RequestBody List<PTaskRelVO> pTaskRelVOList) {
        if (pTaskRelVOList != null && pTaskRelVOList.size() > 0) {
            List<PTaskTplDetailVO> addList = new ArrayList<>();
            List<PTaskTplDetailVO> delList = new ArrayList<>();
            for (PTaskRelVO item : pTaskRelVOList) {
                if (item.getIsSelect() == 1 && item.getRelID() == null) {
                    //isSelect=1 tplID不为null relID为null 新增
                    if (item.getTplID() != null) {
                        PTaskTplDetailVO addModel = new PTaskTplDetailVO();
                        addModel.setTplId(item.getTplID());
                        addModel.setTaskId(item.getId());
                        addList.add(addModel);
                    } else {
                        return new HttpResult<String>(HttpResult.ERROR, "参数传递错误!", null);
                    }
                } else if (item.getIsSelect() == 0 && item.getRelID() != null) {
                    //isSelect=0 relID不为null 删除
                    PTaskTplDetailVO delModel = new PTaskTplDetailVO();
                    delModel.setId(item.getRelID());
                    delList.add(delModel);
                }
            }
            if (addList.size() > 0) {
                int addNum = pTaskTplDetailService.insertList(addList);
                if (addNum == 0) {
                    return new HttpResult<String>(HttpResult.ERROR, "批量插入关系时失败", null);
                }
            }
            if (delList.size() > 0) {
                int delNum = pTaskTplDetailService.deleteList(delList);
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
