/**
 * 异常工单
 * Author :
 * Date :
 * Title : org.fms.cim.common.domain.uas.SWorkOrderDomain.java
 **/
package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.SWorkOrderVO;

import java.util.Date;
import java.math.BigDecimal;

public class SWorkOrderDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long orderId;    //工单编码
    private String orderNo;    //工单号 手动创建默认等于ORDER_ID
    private String orderType;    //工单类型 标准编码：
    private String execType;    //执行方式 标准编码：
    private Long businessPlaceCode;    //管理单位
    private String orderObjId;    //工单主体对象编码 与工单明细中有可能相同也可能不相同，比如主体是管理单位明细可包含多个对象
    private String orderObjType;    //工单主体对象类型
    private String orderObjName;    //工单主体对象名称
    private BigDecimal orderSetId;    //工单类型ID P_SYS_WORK_ORDER_SET
    private String orderSrc;    //工单来源 标准编码：
    private String orderContent;    // 工单描述 说明工单详细情况
    private String priority;    //优先级 工单处理优先级别：高中低。
    private String createUser;    //创建人
    private Date createTime;    //创建时间
    private String createMachine;    //创建主机
    private Date completeTime;    //完成期限
    private String alarmrea;    //故障原因
    private String dealtype;    //处理方式
    private String dealman;    //处理人
    private String verifyFlag;    //审核标志 标准编码：
    private String auditor;    //审核员
    private String verifyMachine;    //审核主机
    private String remark;    //审核意见
    private Date verifyTime;    //审核时间
    private Long creatorId;    //创建者
    private Long lastModifierId;    //最后修改者
    private String lastModifyTime;    //最后修改时间
    private Date createDate;    //存盘时间

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getExecType() {
        return execType;
    }

    public void setExecType(String execType) {
        this.execType = execType;
    }

    public Long getBusinessPlaceCode() {
        return businessPlaceCode;
    }

    public void setBusinessPlaceCode(Long businessPlaceCode) {
        this.businessPlaceCode = businessPlaceCode;
    }

    public String getOrderObjId() {
        return orderObjId;
    }

    public void setOrderObjId(String orderObjId) {
        this.orderObjId = orderObjId;
    }

    public String getOrderObjType() {
        return orderObjType;
    }

    public void setOrderObjType(String orderObjType) {
        this.orderObjType = orderObjType;
    }

    public String getOrderObjName() {
        return orderObjName;
    }

    public void setOrderObjName(String orderObjName) {
        this.orderObjName = orderObjName;
    }

    public BigDecimal getOrderSetId() {
        return orderSetId;
    }

    public void setOrderSetId(BigDecimal orderSetId) {
        this.orderSetId = orderSetId;
    }

    public String getOrderSrc() {
        return orderSrc;
    }

    public void setOrderSrc(String orderSrc) {
        this.orderSrc = orderSrc;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getAlarmrea() {
        return alarmrea;
    }

    public void setAlarmrea(String alarmrea) {
        this.alarmrea = alarmrea;
    }

    public String getDealtype() {
        return dealtype;
    }

    public void setDealtype(String dealtype) {
        this.dealtype = dealtype;
    }

    public String getDealman() {
        return dealman;
    }

    public void setDealman(String dealman) {
        this.dealman = dealman;
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

    public SWorkOrderVO domain2VO() {
        SWorkOrderVO sWorkOrderVO = ReflectUtil.cast(this, SWorkOrderVO.class);
        return sWorkOrderVO;
    }

}
