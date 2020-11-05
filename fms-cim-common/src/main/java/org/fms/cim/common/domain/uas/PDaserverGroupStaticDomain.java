package org.fms.cim.common.domain.uas;

import org.fms.cim.common.vo.uas.PDaserverGroupStaticVO;

import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;

public class PDaserverGroupStaticDomain extends PDaserverGroupDomain implements MybatisEntity {

    private Integer sysNodeNum;    //主机数

    public Integer getSysNodeNum() {
        return sysNodeNum;
    }

    public void setSysNodeNum(Integer sysNodeNum) {
        this.sysNodeNum = sysNodeNum;
    }

    public PDaserverGroupStaticVO domain2VO() {
        PDaserverGroupStaticVO pDaserverGroupStaticVO = ReflectUtil.cast(this, PDaserverGroupStaticVO.class);
        return pDaserverGroupStaticVO;
    }
}
