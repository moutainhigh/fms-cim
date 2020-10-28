/**
 * Auth:riozenc
 * Date:2019年3月14日 下午8:26:01
 * Title:com.riozenc.cim.webapp.action.MeterAssetsAction.java
 **/
package org.fms.cim.server.webapp.assets.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.fms.cim.common.domain.archives.MeterMeterAssetsRelDomain;
import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.domain.assets.MeterAssetsDomain;
import org.fms.cim.common.domain.assets.MeterAssetsEntity;
import org.fms.cim.common.service.IMeterAssetsService;
import org.fms.cim.common.service.IMeterMeterAssetsService;
import org.fms.cim.common.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.riozenc.titanTool.common.json.utils.GsonUtils;
import com.riozenc.titanTool.common.json.utils.JSONUtil;
import com.riozenc.titanTool.mybatis.pagination.Page;
import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;

import reactor.core.publisher.Mono;

/**
 * 电能表资产
 *
 * @author yhx
 */
@ControllerAdvice(assignableTypes = MeterAssetsAction.class)
@RequestMapping("meterAssets")
public class MeterAssetsAction {

    @Autowired
    @Qualifier("meterAssetsServiceImpl")
    private IMeterAssetsService meterAssetsService;

    @Autowired
    @Qualifier("meterMeterAssetsServiceImpl")
    private IMeterMeterAssetsService meterMeterAssetsService;

    /**
     * 新增电表资产
     *
     * @param meterAssetsDomain
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=addAssets")
    public Object addAssets(@RequestBody String body) {
        MeterAssetsDomain meterAssetsDomain = GsonUtils.readValue(body, MeterAssetsDomain.class);

        //TODO 给高彩虹留得后门,正常运行后取消注释
//        if(meterAssetsDomain.getMeterAssetsNo()==null) {
//		  	meterAssetsDomain.setMeterAssetsNo(meterAssetsDomain.getMadeNo());

//        }

        meterAssetsDomain.setMeterAssetsNo(meterAssetsDomain.getMadeNo());
        // 资产编号查重
        MeterAssetsDomain m = new MeterAssetsDomain();
        m.setMeterAssetsNo(meterAssetsDomain.getMeterAssetsNo());
        List<MeterAssetsDomain> list = meterAssetsService.findByWhere(m);
        if (list.size() > 0) {
            return new HttpResult(HttpResult.ERROR, "新增失败，资产编号重复");
        }
        if (meterAssetsDomain.getStatus() == null) {
            meterAssetsDomain.setStatus((byte) 0);

        }
        meterAssetsDomain.setCreateDate(new Date());
        int i = meterAssetsService.insert(meterAssetsDomain);
        if (i > 0)
            return new HttpResult(HttpResult.SUCCESS, "新增成功.");
        else
            return new HttpResult(HttpResult.ERROR, "新增失败.");
    }

    /**
     * 查询电表资产信息
     *
     * @param meterAssetsDomain
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @ResponseBody
    @PostMapping(params = "method=getMeterAssetsByManager")
    public Mono<List<MeterAssetsDomain>> getAssetsByManager(@RequestBody MeterAssetsDomain meterAssetsDomain) {
        // TODO Auto-generated method stub
        List<MeterAssetsDomain> list = meterAssetsService.getMeterAssetsByManager(meterAssetsDomain);
        return Mono.just(list);
    }

    /**
     * 查询电能表资产findByWhere 精确查询
     */
    @ResponseBody
    @PostMapping(params = "method=getMeterAssets")
    public Mono<HttpResultPagination<?>> getMeterAssets(@RequestBody String body) {
        MeterAssetsDomain t = GsonUtils.readValue(body, MeterAssetsDomain.class);

        List<MeterAssetsDomain> list = meterAssetsService.findByWhere(t);

        HttpResultPagination<?> grid = new HttpResultPagination(t, list);

        return Mono.just(grid);
    }

    //装无功表
    @ResponseBody
    @PostMapping(params = "method=getMeterAssetsByFunctionCode")
    public Mono<HttpResultPagination<?>> getMeterAssetsByFunctionCode(@RequestBody String body) throws IOException {
        Page page = GsonUtils.readValue(body, Page.class);
        //筛选 该计量点下的有功表
        String meterId = JSONUtil.readValue(body, JsonNode.class).get("meterId").toString();

        Map<String, String> map = new HashMap<>();
        map.put("meterId", meterId);
        map.put("functionCode", "1");

        List<MeterAssetsEntity> meterAssetsEntities =
                meterAssetsService.getMeterAssetsByFunctionCode(map);

        if (null == meterAssetsEntities || meterAssetsEntities.size() < 1) {
            meterAssetsEntities = null;
        } else {
            meterAssetsEntities.stream().forEach(t -> {
                t.setFunctionCode(new Long("2"));
            });
        }

        HttpResultPagination<?> grid = new HttpResultPagination(page, meterAssetsEntities);

        return Mono.just(grid);
    }


    /**
     * 查询电能表资产findByWhere 精确查询 不分页    业扩用
     */
    @ResponseBody
    @PostMapping(params = "method=getMeterAssetsByAssetsNo")
    public Mono<List<MeterAssetsDomain>> getMeterAssetsByAssetsNo(@RequestBody String body) {
        MeterAssetsDomain t = GsonUtils.readValue(body, MeterAssetsDomain.class);

        List<MeterAssetsDomain> list = meterAssetsService.findByWhere(t);
        return Mono.just(list);

    }

    /**
     * 通过用户获取资产档案和计量点ID jd专用方法
     */
    @ResponseBody
    @PostMapping(params = "method=getAssetsByUser")
    public Mono<List<Map<String, Object>>> getAssetsByUser(@RequestBody UserDomain t) {

        List<Map<String, Object>> list = meterAssetsService.getAssetsByUser(t);
        return Mono.just(list);
    }

    /**
     * 通过资产IDS获取档案
     *
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @ResponseBody
    @PostMapping(params = "method=getMeterAssetsByAssetsIds")
    public List<MeterAssetsDomain> getMeterAssetsByAssetsIds(@RequestBody String body)
            throws JsonParseException, JsonMappingException, IOException {
        HashMap<String,Object> map=  GsonUtils.readValue(body, HashMap.class);
        List<Long> ids=
                GsonUtils.readValueToList(GsonUtils.toJson(map.get("ids")),Long.class);
        
        if(ids != null && ids.size()>0) {
  //          List<Long> idsList = GsonUtils.readValueToList(ids,Long.class);
            List<MeterAssetsDomain> list = meterAssetsService.getMeterAssetsByAssetsIds(ids);
            return list;

        }else {
        	return null;
        }

    }


    /**
     * 更新资产信息（所有属性）
     *
     * @param body
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=update")
    public Object update(@RequestBody String body) {

        MeterAssetsDomain t = GsonUtils.readValue(body, MeterAssetsDomain.class);
        t.setCreateDate(new Date());
        
        t.setMeterAssetsNo(
                CommonUtil.generateFormatNo(t.getMadeNo(), 13, "0", true));
        
        MeterAssetsDomain tt = new MeterAssetsDomain();
        tt.setMeterAssetsNo(t.getMeterAssetsNo());
        tt.setId(t.getId());
        List<MeterAssetsDomain> list = meterAssetsService.findByWhereDC(tt);
        if (list.size() > 0) {
            return new HttpResult(HttpResult.ERROR, "更新失败.资产号重复");
        }

        MeterMeterAssetsRelDomain mmar = new MeterMeterAssetsRelDomain();
        mmar.setMeterAssetsId(t.getId());
        mmar.setTsFlag(t.getTsFlag());
        meterMeterAssetsService.updateByMeterAssetsId(mmar);
        
        int i = meterAssetsService.update(t);
        if (i > 0)
            return new HttpResult(HttpResult.SUCCESS, "更新成功.");
        else
            return new HttpResult(HttpResult.ERROR, "更新失败.");
    }

    /**
     * 批量增加资产
     */
    @ResponseBody
    @PostMapping(params = "method=addList")
    public Mono<HttpResult> addList(@RequestBody String body)
            throws JsonParseException, JsonMappingException, IOException {

        MeterAssetsDomain t = JSONUtil.readValue(body, MeterAssetsDomain.class);

        return Mono.just(meterAssetsService.addAssetsList(t));

    }
    
    //删除资产，只删除拆除和报废的
    @ResponseBody
    @PostMapping(params = "method=deleteList")
    public HttpResult deleteList(@RequestBody String body)
            throws Exception {

        List<MeterAssetsDomain> meterAssetsList = JSONUtil.readValue(body, new TypeReference<List<MeterAssetsDomain>>(){});
        
        List<MeterAssetsDomain> deleteList = meterAssetsList.stream().
        		filter(m ->	m.getStatus()-9 ==0 || m.getStatus()-17 ==0).collect(Collectors.toList());
        
        if(meterAssetsList.size()>0 && deleteList.size()==0) {
        	return new HttpResult(HttpResult.ERROR,"只允许删除拆回和报废的资产");
        }
        return meterAssetsService.deleteList(deleteList);

    }

}
