package org.fms.cim.server.strategy.no;

import org.fms.cim.common.domain.archives.SysSequenceNoDomain;
import org.fms.cim.common.service.ISysSequenceNoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.riozenc.titanTool.annotation.TransactionService;

/**
 * 抄表区段生成规则 营业区域+4位流水号 如2019000001
 */
@TransactionService
public class WriteSectNoSequenceStrategy implements SequenceStrategy{

    @Autowired
    @Qualifier("sysSequenceNoServiceImpl")
    private ISysSequenceNoService sysSequenceNoService;


    //抄表区段编号生成规则
    //营业区域后三位+七位自增长数字
    @Override
    public String generateSequenceNo(String busi) {
        String noPre=busi;
        String userNoCode = "WRITE_SECT_NO" + noPre;
        SysSequenceNoDomain sysSequenceNo = new SysSequenceNoDomain();
        sysSequenceNo.setCode(userNoCode);
        sysSequenceNo.setFormat("0000");
        sysSequenceNo.setPrefix(noPre);
        sysSequenceNo.setName("抄表区段编号(gddl)");
        String maxNo = sysSequenceNoService.genSequenceNo(sysSequenceNo);
        return noPre + maxNo;

    }

    //抄表区段编号生成规则
    //营业区域后三位+七位自增长数字
    @Override
    public String generateSequenceNo(String busi,int size) {
        String noPre=busi;
        String userNoCode = "WRITE_SECT_NO" + noPre;
        SysSequenceNoDomain sysSequenceNo = new SysSequenceNoDomain();
        sysSequenceNo.setCode(userNoCode);
        sysSequenceNo.setFormat("0000");
        sysSequenceNo.setPrefix(noPre);
        sysSequenceNo.setName("抄表区段编号(gddl)");

        String maxNo = sysSequenceNoService.genSequenceNo(sysSequenceNo,size);
        return noPre + maxNo;

    }
}
