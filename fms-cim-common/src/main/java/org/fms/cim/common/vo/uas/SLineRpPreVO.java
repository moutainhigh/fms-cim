/**
 * 旁路事件审核表
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.vo.SLineRpPreVO.java
 **/
package org.fms.cim.common.vo.uas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.uas.SLineRpPreDomain;

import java.util.Date;
import java.math.BigDecimal;

public class SLineRpPreVO extends ManagerParamVO {

    private Long mpedId;    //线路测量点编码
    private Long rpMpedId;    //旁路测量点

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date eventTime;    //事件时间
    private String endFlag;    //旁路结束标识 0开始1结束
    private String rpDirection;    //旁路方向 FAR_FLAG（0，1）
    private BigDecimal prorate;    //电量分配比例
    private String srcFlag;    //事件来源 01- 人工录入
    private String operator;    //操作人员

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;    //产生时间
    private String createMachine;    //产生主机
    private String verifyFlag;    //状态 00-待审核
    private String auditor;    //审核员
    private String verifyMachine;    //审核主机
    private String remark;    //审核意见

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date verifyTime;    //审核时间
    private Long creatorId;    //创建者

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;    //创建时间
    private Long lastModifierId;    //最后修改者
    private String lastModifyTime;    //最后修改时间

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

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getEndFlag() {
        return endFlag;
    }

    public void setEndFlag(String endFlag) {
        this.endFlag = endFlag;
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

    public String getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(String verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getVerifyMachine() {
        return verifyMachine;
    }

    public void setVerifyMachine(String verifyMachine) {
        this.verifyMachine = verifyMachine;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
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


    public SLineRpPreDomain vo2Domain() {
        SLineRpPreDomain sLineRpPreDomain = ReflectUtil.cast(this, SLineRpPreDomain.class);
        return sLineRpPreDomain;
    }
}
