
/**
 * Auth:riozenc
 * Date:2019年3月14日 上午8:50:19
 * Title:com.riozenc.cim.webapp.action.MeterAction.java
 **/
package org.fms.cim.server.webapp.archives.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.fms.cim.common.domain.archives.PMpedDomain;
import org.fms.cim.common.service.IPmpedService;
import org.fms.cim.common.vo.uas.RCpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.riozenc.titanTool.common.json.utils.GsonUtils;
import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;

import reactor.core.publisher.Mono;

@ControllerAdvice
@RequestMapping("pmped")
public class PmpedAction {

    @Autowired
    @Qualifier("pmpedServiceImpl")
    private IPmpedService pmpedService;

    @ResponseBody
    @PostMapping(params = "method=getPmped")
    public HttpResultPagination<?> getAllPmped(@RequestBody String body)
            throws JsonParseException, JsonMappingException, IOException {
        PMpedDomain t = GsonUtils.readValue(body, PMpedDomain.class);

        return new HttpResultPagination(t, pmpedService.findByWhere(t));
    }
    
    @ResponseBody
    @PostMapping(params = "method=getPMpedBySDevIr")
    public HttpResultPagination<?> getPMpedBySDevIr(@RequestBody String body)
            throws JsonParseException, JsonMappingException, IOException {
        PMpedDomain t = GsonUtils.readValue(body, PMpedDomain.class);

        return new HttpResultPagination(t, pmpedService.getPMpedBySDevIr(t));
    }

    @ResponseBody
    @PostMapping(params = "method=getPmpedByKey")
    public PMpedDomain getPmpedByKey(@RequestBody String body)
            throws JsonParseException, JsonMappingException, IOException {
        PMpedDomain t = GsonUtils.readValue(body, PMpedDomain.class);

        return pmpedService.findByKey(t);
    }

    @ResponseBody
    @PostMapping(params = "method=addPmped")
    public Mono<HttpResult> addPmped(@RequestBody String body)
            throws JsonParseException, JsonMappingException, IOException {
        PMpedDomain t = GsonUtils.readValue(body, PMpedDomain.class);

        int count = pmpedService.insert(t);
        if (count > 0) {
            return Mono.just(new HttpResult(HttpResult.SUCCESS, "新增计量点信息成功"));
        }
        return Mono.just(new HttpResult(HttpResult.ERROR, "新增计量点信息失败"));

    }

    @ResponseBody
    @PostMapping(params = "method=updatePmped")
    public Mono<HttpResult> updatePmped(@RequestBody String body)
            throws JsonParseException, JsonMappingException, IOException {
        PMpedDomain t = GsonUtils.readValue(body, PMpedDomain.class);
        int count = pmpedService.update(t);
        if (count > 0) {
            return Mono.just(new HttpResult(HttpResult.SUCCESS, "更新计量点信息成功"));
        }
        return Mono.just(new HttpResult(HttpResult.ERROR, "更新计量点信息失败"));
    }


    /**
     * 通过采集点获取关联的测量点对象
     *
     * @param rCpVO 采集点对象
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=findByRelRCp")
    public HttpResult<?> findByRelRCp(@RequestBody RCpVO rCpVO) {
        if (rCpVO != null) {
            PMpedDomain model = new PMpedDomain();
            model.setTgId(rCpVO.getRelaObjId());
            model.setCpId(rCpVO.getId());
            model.setPageSize(-1);//不分页
            List<PMpedDomain> pMpedList = pmpedService.findByWhere(model);//获取该采集点下的测量点
            return new HttpResult<>(HttpResult.SUCCESS, "获取成功", pMpedList);
        } else {
            return new HttpResult<>(HttpResult.ERROR, "参数传递错误!", null);
        }
    }

    /**
     * 通过采集点获取未关联的测量点对象
     *
     * @param rCpVO 采集点对象
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=findByNoRelRCp")
    public HttpResult<?> findByNoRelRCp(@RequestBody RCpVO rCpVO) {
        if (rCpVO != null) {
            PMpedDomain model = new PMpedDomain();
            model.setTgId(rCpVO.getRelaObjId());
            model.setPageSize(-1);
            List<PMpedDomain> list = pmpedService.findByWhere(model);//获取该台区下的所有测量点
            List<PMpedDomain> pMpedList = new ArrayList<>();
            if (list.size() > 0) {
                pMpedList = list.stream()
                        .filter((PMpedDomain s) -> s.getCpId() != rCpVO.getId())
                        .collect(Collectors.toList());//不存在关系
            }
            return new HttpResult<>(HttpResult.SUCCESS, "获取成功", pMpedList);
        } else {
            return new HttpResult<>(HttpResult.ERROR, "参数传递错误!", null);
        }
    }

    /**
     * 批量更新测量点与采集点关系
     *
     * @param list 测量点集合
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=updateList")
    public HttpResult<?> updateList(@RequestBody List<PMpedDomain> list) {
        if (list != null) {
            if (list.size() > 0) {
                int i = pmpedService.updateList(list);
                if (i > 0) {
                    return new HttpResult<String>(HttpResult.SUCCESS, "保存成功", null);
                } else {
                    return new HttpResult<String>(HttpResult.ERROR, "保存失败", null);
                }
            } else {
                return new HttpResult<String>(HttpResult.ERROR, "暂无保存内容", null);
            }
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "参数传递错误", null);
        }
    }

}


