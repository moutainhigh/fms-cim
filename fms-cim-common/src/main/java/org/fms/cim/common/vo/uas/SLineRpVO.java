/**
 * 旁路事件
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.vo.SLineRpVO.java
 **/
package org.fms.cim.common.vo.uas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.uas.SLineRpDomain;

import java.util.Date;
import java.math.BigDecimal;

public class SLineRpVO extends ManagerParamVO {

    private Long rpId;    //旁路事件标识 本实体记录的唯一标识
    private Long mpedId;    //线路测量点编码
    private Long rpMpedId;    //旁路测量点

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date rpRunTime;    //旁路闭合时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date rpOffTime;    //旁路断开时间
    private String rpDirection;    //旁路方向 FAR_FLAG（0，1）
    private BigDecimal prorate;    //电量分配比例
    private String endFlag;    //旁路结束标识 0开始1结束
    private String srcFlag;    //事件来源 01- 人工录入02- 自动产生
    private String operator;    //操作人员

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;    //产生时间
    private String createMachine;    //产生主机
    private Long creatorId;    //创建者
    private String createTime1;    //创建时间
    private Long lastModifierId;    //最后修改者
    private String lastModifyTime;    //最后修改时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;    //存盘时间

    public Long getRpId() {
        return rpId;
    }

    public void setRpId(Long rpId) {
        this.rpId = rpId;
    }

    public Long getMpedId() {
        return mpedId;
    }

    public void setMpedId(Long mpedId) {
        this.mpedId = mpedId;
    }

    public Long getRpMpedId() {
        return rpMpedId;
    }

    public void setRpMpedId(Long rpMpedId) {
        this.rpMpedId = rpMpedId;
    }

    public Date getRpRunTime() {
        return rpRunTime;
    }

    public void setRpRunTime(Date rpRunTime) {
        this.rpRunTime = rpRunTime;
    }

    public Date getRpOffTime() {
        return rpOffTime;
    }

    public void setRpOffTime(Date rpOffTime) {
        this.rpOffTime = rpOffTime;
    }

    public String getRpDirection() {
        return rpDirection;
    }

    public void setRpDirection(String rpDirection) {
        this.rpDirection = rpDirection;
    }

    public BigDecimal getProrate() {
        return prorate;
    }

    public void setProrate(BigDecimal prorate) {
        this.prorate = prorate;
    }

    public String getEndFlag() {
        return endFlag;
    }

    public void setEndFlag(String endFlag) {
        this.endFlag = endFlag;
    }

    public String getSrcFlag() {
        return srcFlag;
    }

    public void setSrcFlag(String srcFlag) {
        this.srcFlag = srcFlag;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateMachine() {
        return createMachine;
    }

    public void setCreateMachine(String createMachine) {
        this.createMachine = createMachine;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreateTime1() {
        return createTime1;
    }

    public void setCreateTime1(String createTime1) {
        this.createTime1 = createTime1;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public SLineRpDomain vo2Domain() {
        SLineRpDomain sLineRpDomain = ReflectUtil.cast(this, SLineRpDomain.class);
        return sLineRpDomain;
    }
}
