/**
 * 通道组
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.vo.PChnlGroupVO.java
 **/
package org.fms.cim.common.vo.uas;

import org.fms.cim.common.domain.uas.PChnlGroupStaticDomain;

import com.riozenc.titanTool.common.reflect.ReflectUtil;

public class PChnlGroupStaticVO extends PChnlGroupVO {

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

    public PChnlGroupStaticDomain vo2Domain() {
        PChnlGroupStaticDomain pChnlGroupStaticDomain = ReflectUtil.cast(this, PChnlGroupStaticDomain.class);
        return pChnlGroupStaticDomain;
    }
}
