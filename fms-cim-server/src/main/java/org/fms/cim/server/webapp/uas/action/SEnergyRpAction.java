/**
 * 电量替代
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.SEnergyRpAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.fms.cim.common.service.ISEnergyRpService;
import org.fms.cim.common.vo.uas.SEnergyRpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("SEnergyRp")
public class SEnergyRpAction {

    @Autowired
    @Qualifier("SEnergyRpServiceImpl")
    private ISEnergyRpService sEnergyRpService;

    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody SEnergyRpVO sEnergyRpVO) {
        int i = sEnergyRpService.insert(sEnergyRpVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody SEnergyRpVO sEnergyRpVO) {
        int i = sEnergyRpService.update(sEnergyRpVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<SEnergyRpVO> deleteList) throws Exception {
        HttpResult httpResult = sEnergyRpService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody SEnergyRpVO sEnergyRpVO) {
        SEnergyRpVO modelVo = sEnergyRpService.findByKey(sEnergyRpVO);

        if (modelVo != null) {
            return new HttpResult<SEnergyRpVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<SEnergyRpVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody SEnergyRpVO sEnergyRpVO) {

        return new HttpResultPagination(sEnergyRpVO, sEnergyRpService.findByWhere(sEnergyRpVO));
    }
}
