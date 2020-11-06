package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import org.fms.cim.common.vo.uas.PChnlGroupStaticVO;
import org.fms.cim.common.vo.uas.PDaserverGroupStaticVO;

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
