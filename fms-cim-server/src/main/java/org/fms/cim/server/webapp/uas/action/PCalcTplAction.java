/**
 * 计算方案模板
 * Author :
 * Date :
 * Title : org.fms.cim.server.webapp.uas.action.PCalcTplAction.java
 **/
package org.fms.cim.server.webapp.uas.action;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;
import org.apache.commons.lang3.StringUtils;
import org.fms.cim.common.service.IPCalcTplService;
import org.fms.cim.common.vo.uas.PCalcTplVO;
import org.fms.cim.common.vo.uas.PSysNodeVO;
import org.fms.cim.server.webapp.uas.helper.MessageuUtil;
import org.fms.cim.server.webapp.uas.helper.UtilityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@RequestMapping("PCalcTpl")
public class PCalcTplAction {

    @Autowired
    @Qualifier("PCalcTplServiceImpl")
    private IPCalcTplService pCalcTplService;

    /**
     * 同一个适用范围下，只允许一个默认
     *
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody PCalcTplVO pCalcTplVO) {
        MessageuUtil msg = verificationObj(pCalcTplVO);
        if (msg.getCode() == 1) {
            int i = pCalcTplService.insert(pCalcTplVO);
            if (i > 0) {
                return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
            } else {
                return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
            }
        } else {
            return new HttpResult<String>(HttpResult.ERROR, msg.getMsg(), null);
        }
    }

    /**
     * 同一个适用范围下，只允许一个默认
     *
     * @return
     */
    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody PCalcTplVO pCalcTplVO) {
        MessageuUtil msg = verificationObj(pCalcTplVO);
        if (msg.getCode() == 1) {
            int i = pCalcTplService.update(pCalcTplVO);
            if (i > 0) {
                return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
            } else {
                return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
            }
        } else {
            return new HttpResult<String>(HttpResult.ERROR, msg.getMsg(), null);
        }
    }

    /**
     * 适用范围不能为空，
     * 同一适用范围下，只允许一个默认
     *
     * @param modelVO
     * @return
     */
    private MessageuUtil verificationObj(PCalcTplVO modelVO) {
        MessageuUtil msg = new MessageuUtil();
        if (modelVO != null) {
            if (StringUtils.isNotBlank(modelVO.getType())) {
                if (modelVO.getDefaultFlag().equals("1")) {//是否通用下拉  1-是 0-否
                    int repeatNum = pCalcTplService.verifyDefaultUniqueness(modelVO);
                    if(repeatNum>0){
                        msg.setCode(0);
                        msg.setMsg("同一适用范围下只允许存在一个默认任务模板");
                    }else{
                        msg.setCode(1);
                        msg.setMsg("设置默认，同一适用范围下无重复");
                    }
                } else {
                    msg.setCode(1);
                    msg.setMsg("未设置默认，不验证");
                }
            } else {
                msg.setCode(0);
                msg.setMsg("适用范围不能为空");
            }
        } else {
            msg.setCode(0);
            msg.setMsg("参数传递错误");
        }
        return msg;
    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<PCalcTplVO> deleteList) throws Exception {
        HttpResult httpResult = pCalcTplService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody PCalcTplVO pCalcTplVO) {
        PCalcTplVO modelVo = pCalcTplService.findByKey(pCalcTplVO);

        if (modelVo != null) {
            return new HttpResult<PCalcTplVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<PCalcTplVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody PCalcTplVO modelVO) {
        modelVO.setPageSize(-1);//此处不分页
        return new HttpResultPagination(modelVO, pCalcTplService.findByWhere(modelVO));
    }
}
