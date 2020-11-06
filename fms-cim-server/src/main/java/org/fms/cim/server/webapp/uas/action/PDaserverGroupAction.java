/**
 * 采集主机组
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PDaserverGroupAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPDaserverGroupService;
import org.fms.cim.common.service.IPSysNodeService;
import org.fms.cim.common.vo.uas.PChnlGroupVO;
import org.fms.cim.common.vo.uas.PDaserverGroupStaticVO;
import org.fms.cim.common.vo.uas.PDaserverGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PDaserverGroup")
public class PDaserverGroupAction {

    @Autowired
    @Qualifier("PDaserverGroupServiceImpl")
    private IPDaserverGroupService pDaserverGroupService;

    @Autowired
    @Qualifier("PSysNodeServiceImpl")
    private IPSysNodeService pSysNodeService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PDaserverGroupVO pDaserverGroupVO) {
        int i = pDaserverGroupService.insert(pDaserverGroupVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PDaserverGroupVO pDaserverGroupVO) {
        int i = pDaserverGroupService.update(pDaserverGroupVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    /**
     * 已关联采集主机的不能删除
     *
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PDaserverGroupVO> deleteList) throws Exception {
        if (deleteList != null) {
            if (deleteList.size() > 0) {
                String value = "";
                for (PDaserverGroupVO item : deleteList) {
                    value += item.getId() + ",";
                }
                value = value.substring(0, value.length() - 1);
                if (pSysNodeService.findByRelDasGroup(value).size() > 0) {
                    return new HttpResult<String>(HttpResult.ERROR, "已关联采集主机的不能删除", null);
                } else {
                    return pDaserverGroupService.deleteList(deleteList);
                }
            } else {
                return new HttpResult<String>(HttpResult.ERROR, "暂无要删除的内容", null);
            }
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "参数传递错误", null);
        }
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PDaserverGroupVO pDaserverGroupVO) {
        PDaserverGroupVO modelVo = pDaserverGroupService.findByKey(pDaserverGroupVO);

        if (modelVo != null) {
            return new HttpResult<PDaserverGroupVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PDaserverGroupVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PDaserverGroupVO pDaserverGroupVO) {

        return new HttpResultPagination(pDaserverGroupVO, pDaserverGroupService.findByWhere(pDaserverGroupVO));
    }

    @ResponseBody
    @PostMapping(params = "method=findByWhereStatic")
    public HttpResultPagination<?> findByWhereStatic(@RequestBody PDaserverGroupStaticVO pDaserverGroupStaticVO) {

        return new HttpResultPagination(pDaserverGroupStaticVO, pDaserverGroupService.findByWhereStatic(pDaserverGroupStaticVO));
    }
}
