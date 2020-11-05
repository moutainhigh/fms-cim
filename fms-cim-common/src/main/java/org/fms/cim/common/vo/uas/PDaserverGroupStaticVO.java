package org.fms.cim.common.vo.uas;

import org.fms.cim.common.domain.uas.PDaserverGroupStaticDomain;

import com.riozenc.titanTool.common.reflect.ReflectUtil;

public class PDaserverGroupStaticVO extends PDaserverGroupVO {

    private Integer sysNodeNum;    //主机数

    public Integer getSysNodeNum() {
        return sysNodeNum;
    }

    public void setSysNodeNum(Integer sysNodeNum) {
        this.sysNodeNum = sysNodeNum;
    }

    public PDaserverGroupStaticDomain vo2Domain() {
        PDaserverGroupStaticDomain pDaserverGroupStaticDomain = ReflectUtil.cast(this, PDaserverGroupStaticDomain.class);
        return pDaserverGroupStaticDomain;
    }


}
