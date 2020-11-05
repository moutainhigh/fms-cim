/**
 * 通道组
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.domain.PChnlGroupDomain.java
 **/
package org.fms.cim.common.domain.uas;

import org.fms.cim.common.vo.uas.PChnlGroupStaticVO;

import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;

public class PChnlGroupStaticDomain extends PChnlGroupDomain implements MybatisEntity {

    private Integer chnlCnt;    //通道数
    private Integer gpDasCnt;    //主机数

    public Integer getChnlCnt() {
        return chnlCnt;
    }

    public void setChnlCnt(Integer chnlCnt) {
        this.chnlCnt = chnlCnt;
    }

    public Integer getGpDasCnt() {
        return gpDasCnt;
    }

    public void setGpDasCnt(Integer gpDasCnt) {
        this.gpDasCnt = gpDasCnt;
    }

    public PChnlGroupStaticVO domain2VO() {
        PChnlGroupStaticVO pChnlGroupStaticVO = ReflectUtil.cast(this, PChnlGroupStaticVO.class);
        return pChnlGroupStaticVO;
    }

}
