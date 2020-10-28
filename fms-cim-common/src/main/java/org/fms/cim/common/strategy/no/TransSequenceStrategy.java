package org.fms.cim.common.strategy.no;

import org.fms.cim.common.domain.archives.SysSequenceNoDomain;
import org.fms.cim.common.service.ISysSequenceNoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 变压器号生成规则 6位流水号 如000001
 */
@Service
public class TransSequenceStrategy implements SequenceStrategy{

    @Autowired
    @Qualifier("sysSequenceNoServiceImpl")
    private ISysSequenceNoService sysSequenceNoService;
    @Override
    public String generateSequenceNo(String condition) {
        SysSequenceNoDomain sysSequenceNo = new SysSequenceNoDomain();
        sysSequenceNo.setCode("TRANS");
        sysSequenceNo.setFormat("000000");
        sysSequenceNo.setName("变压器号规则(HG)");
        //sysSequenceNo.setMon(CommonUtil.getYMD().get(0)+CommonUtil.getYMD()
        // .get(1));
        String maxNo = sysSequenceNoService.genSequenceNo(sysSequenceNo);
        return maxNo;
    }

    @Override
    public String generateSequenceNo(String condition,int size) {
        SysSequenceNoDomain sysSequenceNo = new SysSequenceNoDomain();
        sysSequenceNo.setCode("TRANS");
        sysSequenceNo.setFormat("000000");
        sysSequenceNo.setName("变压器号规则(HG)");
        //sysSequenceNo.setMon(CommonUtil.getYMD().get(0)+CommonUtil.getYMD()
        // .get(1));
        String maxNo =  sysSequenceNoService.genSequenceNo(sysSequenceNo, size);
        return maxNo;
    }

}
