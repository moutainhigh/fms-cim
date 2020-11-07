/**
 * 通道使用日志
 * Author :
 * Date :
 * Title : org.fms.cim.common.domain.uas.RChannelUseLogDomain.java
 **/
package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.RChannelUseLogVO;

import java.util.Date;
import java.math.BigDecimal;

public class RChannelUseLogDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long chanId;    //通道编码
    private Date commTime;    //通讯时间
    private String chanName;    //通道名称
    private String chanType;    //通道类型
    private Long cpId;    //采集点编码
    private BigDecimal rtuchanProerty;    //通道组属性 11-主通道组主,12-主通道组备,21-备通道组主,22-备通道组备
    private BigDecimal result;    //使用结果 1-成功2-打开设备失败 3-通讯失败
    private Long creatorId;    //创建者
    private Date createDate;    //创建时间
    private Long lastModifierId;    //最后修改者
    private String lastModifyTime;    //最后修改时间

    public Long getChanId() {
        return chanId;
    }

    public void setChanId(Long chanId) {
        this.chanId = chanId;
    }

    public Date getCommTime() {
        return commTime;
    }

    public void setCommTime(Date commTime) {
        this.commTime = commTime;
    }

    public String getChanName() {
        return chanName;
    }

    public void setChanName(String chanName) {
        this.chanName = chanName;
    }

    public String getChanType() {
        return chanType;
    }

    public void setChanType(String chanType) {
        this.chanType = chanType;
    }

    public Long getCpId() {
        return cpId;
    }

    public void setCpId(Long cpId) {
        this.cpId = cpId;
    }

    public BigDecimal getRtuchanProerty() {
        return rtuchanProerty;
    }

    public void setRtuchanProerty(BigDecimal rtuchanProerty) {
        this.rtuchanProerty = rtuchanProerty;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getLastModifierId() {
        return lastModifierId;
    }

    public void setLastModifierId(Long lastModifierId) {
        this.lastModifierId = lastModifierId;
    }

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public RChannelUseLogVO domain2VO() {
        RChannelUseLogVO rChannelUseLogVO = ReflectUtil.cast(this, RChannelUseLogVO.class);
        return rChannelUseLogVO;
    }

}
