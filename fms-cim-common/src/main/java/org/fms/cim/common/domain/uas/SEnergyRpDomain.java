/**
 * 电量替代
 * Author :
 * Date :
 * Title : org.fms.cim.common.domain.uas.SEnergyRpDomain.java
 **/
package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.SEnergyRpVO;

import java.util.Date;
import java.math.BigDecimal;

public class SEnergyRpDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long id;    //事件标识 本实体记录的唯一标识
    private Long masterMpedId;    //主测量点编码
    private Long spareMpedId;    //备测量点
    private Date beginTime;    //开始时间
    private Date endTime;    //结束时间
    private String rpType;    //替代类型
    private String rpDirection;    //替代方向
    private BigDecimal prorate;    //电量分配比例
    private String operator;    //操作人员
    private Date createTime;    //产生时间
    private String createMachine;    //产生主机
    private String verifyFlag;    //状态 00-待审核
    private String auditor;    //审核员
    private Date verifyTime;    //审核时间
    private String verifyMachine;    //审核主机
    private String validFlag;    //有效标识
    private Long creatorId;    //创建者
    private Date createDate;    //创建时间
    private Long lastModifierId;    //最后修改者
    private String lastModifyTime;    //最后修改时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMasterMpedId() {
        return masterMpedId;
    }

    public void setMasterMpedId(Long masterMpedId) {
        this.masterMpedId = masterMpedId;
    }

    public Long getSpareMpedId() {
        return spareMpedId;
    }

    public void setSpareMpedId(Long spareMpedId) {
        this.spareMpedId = spareMpedId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRpType() {
        return rpType;
    }

    public void setRpType(String rpType) {
        this.rpType = rpType;
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

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    public String getVerifyMachine() {
        return verifyMachine;
    }

    public void setVerifyMachine(String verifyMachine) {
        this.verifyMachine = verifyMachine;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
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

    public SEnergyRpVO domain2VO() {
        SEnergyRpVO sEnergyRpVO = ReflectUtil.cast(this, SEnergyRpVO.class);
        return sEnergyRpVO;
    }

}
