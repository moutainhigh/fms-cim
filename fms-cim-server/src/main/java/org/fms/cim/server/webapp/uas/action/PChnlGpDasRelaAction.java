/**
 * 通道组主机关系
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PChnlGpDasRelaAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.IPChnlGpDasRelaService;
import org.fms.cim.common.vo.uas.PChnlGpDasRelaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PChnlGpDasRela")
public class PChnlGpDasRelaAction {

    @Autowired
    @Qualifier("PChnlGpDasRelaServiceImpl")
    private IPChnlGpDasRelaService pChnlGpDasRelaService;

    /**
     * 主机对通道组是一对多的关系，保存时校验已存在对应关系的要提醒。
     *
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PChnlGpDasRelaVO pChnlGpDasRelaVO) {
        if (pChnlGpDasRelaVO != null) {
            PChnlGpDasRelaVO relVO = new PChnlGpDasRelaVO();
            relVO.setChnlGroupId(pChnlGpDasRelaVO.getChnlGroupId());
            int num = pChnlGpDasRelaService.findByWhere(relVO).size();
            if (num > 0) {
                return new HttpResult<String>(HttpResult.ERROR, "该通道组已关联主机，新增失败", null);
            } else {
                int i = pChnlGpDasRelaService.insert(pChnlGpDasRelaVO);

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

    /**
     * 主机对通道组是一对多的关系，保存时校验已存在对应关系的要提醒。
     *
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PChnlGpDasRelaVO pChnlGpDasRelaVO) {
        if (pChnlGpDasRelaVO != null) {
            PChnlGpDasRelaVO relVO = new PChnlGpDasRelaVO();
            relVO.setChnlGroupId(pChnlGpDasRelaVO.getChnlGroupId());
            Long num = pChnlGpDasRelaService.findByWhere(relVO).stream()
                    .filter(s -> s.getId() != pChnlGpDasRelaVO.getId()).count();
            if (num > 0) {
                return new HttpResult<String>(HttpResult.ERROR, "该通道组已关联主机，编辑失败", null);
            } else {
                int i = pChnlGpDasRelaService.update(pChnlGpDasRelaVO);
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
    public HttpResult<?> delete(@RequestBody List<PChnlGpDasRelaVO> deleteList) throws Exception {
        HttpResult httpResult = pChnlGpDasRelaService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PChnlGpDasRelaVO pChnlGpDasRelaVO) {
        PChnlGpDasRelaVO modelVo = pChnlGpDasRelaService.findByKey(pChnlGpDasRelaVO);

        if (modelVo != null) {
            return new HttpResult<PChnlGpDasRelaVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PChnlGpDasRelaVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PChnlGpDasRelaVO pChnlGpDasRelaVO) {

        return new HttpResultPagination(pChnlGpDasRelaVO, pChnlGpDasRelaService.findByWhere(pChnlGpDasRelaVO));
    }
}
