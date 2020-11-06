/**
 * 通道组
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PChnlGroupAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPChannelService;
import org.fms.cim.common.service.IPChnlGpDasRelaService;
import org.fms.cim.common.service.IPChnlGroupService;
import org.fms.cim.common.vo.uas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PChnlGroup")
public class PChnlGroupAction {

    @Autowired
    @Qualifier("PChnlGroupServiceImpl")
    private IPChnlGroupService pChnlGroupService;

    @Autowired
    @Qualifier("PChnlGpDasRelaServiceImpl")
    private IPChnlGpDasRelaService pChnlGpDasRelaService;

    @Autowired
    @Qualifier("PChannelServiceImpl")
    private IPChannelService pChannelService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PChnlGroupVO pChnlGroupVO) {
        int i = pChnlGroupService.insert(pChnlGroupVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }
    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PChnlGroupVO pChnlGroupVO) {
        int i = pChnlGroupService.update(pChnlGroupVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    /**
     * 已维护通道不允许删除，已关联采集主机不允许删除
     *
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PChnlGroupVO> deleteList) throws Exception {
        if (deleteList != null) {
            if (deleteList.size() > 0) {
                String value = "";
                for (PChnlGroupVO item : deleteList) {
                    value += item.getId() + ",";
                }
                value = value.substring(0, value.length() - 1);

                if (pChnlGpDasRelaService.findByRelGroup(value).size() > 0) {
                    return new HttpResult<String>(HttpResult.ERROR, "已关联采集主机不允许删除", null);
                } else {
                    if (pChannelService.findByRelGroup(value).size() > 0) {
                        return new HttpResult<String>(HttpResult.ERROR, "已维护通道不允许删除", null);
                    } else {
                        return pChnlGroupService.deleteList(deleteList);
                    }
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
    public HttpResult<?> findByKey(@RequestBody PChnlGroupVO pChnlGroupVO) {
        PChnlGroupVO modelVo = pChnlGroupService.findByKey(pChnlGroupVO);

        if (modelVo != null) {
            return new HttpResult<PChnlGroupVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PChnlGroupVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PChnlGroupVO pChnlGroupVO) {

        return new HttpResultPagination(pChnlGroupVO, pChnlGroupService.findByWhere(pChnlGroupVO));
    }

    @ResponseBody
    @PostMapping(params = "method=findByWhereStatic")
    public HttpResultPagination<?> findByWhereStatic(@RequestBody PChnlGroupStaticVO pChnlGroupStaticVO) {

        return new HttpResultPagination(pChnlGroupStaticVO, pChnlGroupService.findByWhereStatic(pChnlGroupStaticVO));
    }
}
