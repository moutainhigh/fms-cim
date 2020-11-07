/**
 * 异常工单明细
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.vo.SWorkOrderDetailVO.java
 **/
package org.fms.cim.common.vo.uas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.uas.SWorkOrderDetailDomain;

import java.util.Date;
import java.math.BigDecimal;

public class SWorkOrderDetailVO extends ManagerParamVO {

    private Long id;    //标识
    private Long orderId;    //工单编码
    private String objId;    //对象编码 根据工单类型确定
    private String objType;    //对象类型 根据工单类型确定，可为空
    private String objName;    //对象名称
    private BigDecimal eventNo;    //事件编码 15．3.7增加
    private String chkCycle;    //检查周期 15. 3.7增加

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date execTime;    //执行时间
    private String execStatus;    //执行状态 标准编码：
    private Long creatorId;    //创建者

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;    //创建时间
    private Long lastModifierId;    //最后修改者
    private String lastModifyTime;    //最后修改时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public BigDecimal getEventNo() {
        return eventNo;
    }

    public void setEventNo(BigDecimal eventNo) {
        this.eventNo = eventNo;
    }

    public String getChkCycle() {
        return chkCycle;
    }

    public void setChkCycle(String chkCycle) {
        this.chkCycle = chkCycle;
    }

    public Date getExecTime() {
        return execTime;
    }

    public void setExecTime(Date execTime) {
        this.execTime = execTime;
    }

    public String getExecStatus() {
        return execStatus;
    }

    public void setExecStatus(String execStatus) {
        this.execStatus = execStatus;
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


    public SWorkOrderDetailDomain vo2Domain() {
        SWorkOrderDetailDomain sWorkOrderDetailDomain = ReflectUtil.cast(this, SWorkOrderDetailDomain.class);
        return sWorkOrderDetailDomain;
    }
}
