/**
 * 系统节点
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.action.PSysNodeAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import java.util.List;
import java.util.stream.Collectors;

import org.fms.cim.common.service.IPSysNodeService;
import org.fms.cim.common.vo.uas.PDaserverGroupVO;
import org.fms.cim.common.vo.uas.PSysNodeVO;
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
@RequestMapping("PSysNode")
public class PSysNodeAction {

    @Autowired
    @Qualifier("PSysNodeServiceImpl")
    private IPSysNodeService pSysNodeService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PSysNodeVO pSysNodeVO) {
        if (pSysNodeVO != null) {
            if (pSysNodeVO.getName() == pSysNodeVO.getNeta()) {
                return new HttpResult<String>(HttpResult.ERROR, "新增失败,名称和A网地址不能重复", null);
            } else {
                int i = pSysNodeService.insert(pSysNodeVO);
                if (i > 0) {
                    return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
                } else {
                    return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
                }
            }
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "参数传递错误", null);
        }
    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PSysNodeVO pSysNodeVO) {
        if (pSysNodeVO != null) {
            if (pSysNodeVO.getName() == pSysNodeVO.getNeta()) {
                return new HttpResult<String>(HttpResult.ERROR, "编辑失败,名称和A网地址不能重复", null);
            } else {
                int i = pSysNodeService.update(pSysNodeVO);
                if (i > 0) {
                    return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
                } else {
                    return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
                }
            }
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "参数传递错误", null);
        }
    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PSysNodeVO> deleteList) throws Exception {
        //已关联通道组不允许删除--此处在数据库处理
        HttpResult httpResult = pSysNodeService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PSysNodeVO pSysNodeVO) {
        PSysNodeVO modelVo = pSysNodeService.findByKey(pSysNodeVO);

        if (modelVo != null) {
            return new HttpResult<PSysNodeVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PSysNodeVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PSysNodeVO pSysNodeVO) {

        return new HttpResultPagination(pSysNodeVO, pSysNodeService.findByWhere(pSysNodeVO));
    }

    /**
     * 通过采集机组获取分配主机
     *
     * @param pDaserverGroupVO 采集机组ID
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=findByDaserverGroup")
    public HttpResultPagination<?> findByDaserverGroup(@RequestBody PDaserverGroupVO pDaserverGroupVO) {
        PSysNodeVO pSysNodeVO = new PSysNodeVO();
        pSysNodeVO.setPageCurrent(pDaserverGroupVO.getPageCurrent());
        pSysNodeVO.setPageSize(pDaserverGroupVO.getPageSize());

        List<PSysNodeVO> listVo = pSysNodeService.findByWhere(pSysNodeVO);
        if (pDaserverGroupVO != null && listVo != null && listVo.size() > 0) {
            for (PSysNodeVO item : listVo) {
                //比较采集主机分组 0-未选中 1-选中
                int isSelect = item.getDaGroup() == pDaserverGroupVO.getId() ? 1 : 0;
                item.setIsSelect(isSelect);
            }
        }
        return new HttpResultPagination(pSysNodeVO, listVo);
    }

    /**
     * 批量更新主机的采集机组
     * @param pDaserverGroupVO 采集机组以及其选中的子集主机
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=updateListDaserverGroup")
    public HttpResult<?> updateListDaserverGroup(@RequestBody PDaserverGroupVO pDaserverGroupVO) {
        if (pDaserverGroupVO != null) {
            PSysNodeVO pSysNodeVO = new PSysNodeVO();
            pSysNodeVO.setDaGroup(pDaserverGroupVO.getId());
            List<PSysNodeVO> sysNodeVOList = pSysNodeService.findByWhere(pSysNodeVO);//更新前
            List<Long> childIDList = pDaserverGroupVO.getListSysNodeVO().stream().map(PSysNodeVO::getId).collect(Collectors.toList());//设置选中的
            if (sysNodeVOList != null && sysNodeVOList.size() > 0) {
                for (PSysNodeVO item : sysNodeVOList) {
                    Long daserverGroupID = childIDList.contains(item.getId()) ? item.getDaGroup() : null;
                    item.setDaGroup(daserverGroupID);
                }
                int num = pSysNodeService.updateListDaserverGroup(sysNodeVOList);
                if (num == sysNodeVOList.size()) {
                    return new HttpResult<String>(HttpResult.SUCCESS, "保存成功，保存条数：" + num, null);
                } else {
                    return new HttpResult<String>(HttpResult.ERROR, "保存失败", null);
                }
            } else {
                return new HttpResult<String>(HttpResult.ERROR, "暂无保存内容", null);
            }
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "参数传递错误!", null);
        }
    }
}
