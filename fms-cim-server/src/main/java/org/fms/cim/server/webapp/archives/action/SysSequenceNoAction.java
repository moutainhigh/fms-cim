package org.fms.cim.server.webapp.archives.action;

import org.fms.cim.common.service.ISysSequenceNoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.riozenc.cim.web.strategy.SequenceEnvironment;
import com.riozenc.cim.web.strategy.SequenceStrategy;

@ControllerAdvice
@RequestMapping("sysSequenceNo")
public class SysSequenceNoAction {
    @Autowired
    @Qualifier("sysSequenceNoServiceImpl")
    private ISysSequenceNoService iSysSequenceNoService;

    @Autowired
    @Qualifier("appNoSequenceStrategy")
    private SequenceStrategy appNoSequenceStrategy;

    @Autowired
    @Qualifier("userNoSequenceStrategy")
    private SequenceStrategy userNoSequenceStrategy;

    //户号生成规则
    //营业区域后三位+七位自增长数字
    @ResponseBody
    @RequestMapping(params = "method=generateUserNo")
    public synchronized String getUserNo(@RequestBody String busi) {
        JsonObject jsonObject=new JsonParser().parse(busi).getAsJsonObject();
        SequenceEnvironment appNoEnvironment=new SequenceEnvironment(appNoSequenceStrategy);
        return appNoEnvironment.generateSequenceNo(jsonObject.get("busi").getAsString());
    }

    //户号生成规则
    //营业区域后三位+年+月+日+自增长四位
    @ResponseBody
    @RequestMapping(params = "method=generateAppNo")
    public synchronized String getAppNo(@RequestBody String busi) {
        JsonObject jsonObject=new JsonParser().parse(busi).getAsJsonObject();
        SequenceEnvironment appNoEnvironment=new SequenceEnvironment(userNoSequenceStrategy);
        return userNoSequenceStrategy.generateSequenceNo(jsonObject.get("busi").getAsString());
    }

}
