/**
 * 通道参数表
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PChannelAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.fms.cim.common.service.IPChannelService;
import org.fms.cim.common.vo.uas.PChannelVO;
import org.fms.cim.common.vo.uas.PChnlGroupVO;
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
@RequestMapping("PChannel")
public class PChannelAction {

    @Autowired
    @Qualifier("PChannelServiceImpl")
    private IPChannelService pChannelService;

    /**
     * 保存通道时，先根据设备地址查询是否已存在，存在提示，不存在再保存
     *
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PChannelVO pChannelVO) {
        if(pChannelVO!=null){
            PChannelVO model;
            model=new PChannelVO();
            model.setDeviceAddr1(pChannelVO.getDeviceAddr1());//判断地址1
            model.setDeviceAddr2(null);
            if(pChannelService.findByWhere(model).size()>0){
                return new HttpResult<String>(HttpResult.ERROR, "新增失败,设备地址1重复", null);
            }
            model.setDeviceAddr1(null);
            model.setDeviceAddr2(pChannelVO.getDeviceAddr2());//判断地址2
            if(pChannelService.findByWhere(model).size()>0){
                return new HttpResult<String>(HttpResult.ERROR, "新增失败,设备地址2重复", null);
            }
            int i = pChannelService.insert(pChannelVO);
            if (i > 0) {
                return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
            } else {
                return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
            }
        }else{
            return new HttpResult<String>(HttpResult.ERROR, "参数传递错误", null);
        }
    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PChannelVO pChannelVO) {
        if(pChannelVO!=null){
            Long repeatNum;
            PChannelVO model=new PChannelVO();
            //判断地址1
            model.setDeviceAddr1(pChannelVO.getDeviceAddr1());
            repeatNum=pChannelService.findByWhere(model).stream()
                    .filter((PChannelVO s) -> s.getId()!=pChannelVO.getId()).count();
            if(repeatNum>0){
                return new HttpResult<String>(HttpResult.ERROR, "编辑失败,设备地址1重复", null);
            }
            //判断地址2
            model.setDeviceAddr1(null);
            model.setDeviceAddr1(pChannelVO.getDeviceAddr2());
            repeatNum=pChannelService.findByWhere(model).stream()
                    .filter((PChannelVO s) -> s.getId()!=pChannelVO.getId()).count();
            if(repeatNum>0){
                return new HttpResult<String>(HttpResult.ERROR, "编辑失败,设备地址2重复", null);
            }
            int i = pChannelService.update(pChannelVO);
            if (i > 0) {
                return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
            } else {
                return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
            }
        }else{
            return new HttpResult<String>(HttpResult.ERROR, "参数传递错误", null);
        }
    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PChannelVO> deleteList) throws Exception {
        HttpResult httpResult = pChannelService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PChannelVO pChannelVO) {
        PChannelVO modelVo = pChannelService.findByKey(pChannelVO);

        if (modelVo != null) {
            return new HttpResult<PChannelVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PChannelVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PChannelVO pChannelVO) {

        return new HttpResultPagination(pChannelVO, pChannelService.findByWhere(pChannelVO));
    }

    @ResponseBody
    @PostMapping(params = "method=findByChnlGroup")
    public HttpResultPagination<?> findByChnlGroup(@RequestBody PChnlGroupVO pChnlGroupVO) {
        PChannelVO pChannelVO=new PChannelVO();
        pChannelVO.setChnlGroupId(pChnlGroupVO.getId());
        return new HttpResultPagination(pChannelVO, pChannelService.findByWhere(pChannelVO));
    }
}
