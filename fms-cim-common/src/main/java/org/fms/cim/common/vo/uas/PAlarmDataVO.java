/**
 * 告警范围
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.vo.PAlarmDataVO.java
 **/
package org.fms.cim.common.vo.uas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.uas.PAlarmDataDomain;

import java.util.Date;
import java.math.BigDecimal;

public class PAlarmDataVO extends ManagerParamVO {

    private Long id;    //标识 本实体记录的唯一标识
    private String sysUserName;    //系统用户名 P_SYS_USER
    private String objType;    //对象类型
    private String objId;    //对象编码
    private Long businessPlaceCode;    //管理单位 编码为-1表示该管理单位下所有采集点，包括子管理单位
    private Long cpId;    //采集点
    private String cpTypeCode;    //采集点类型
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

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public Long getBusinessPlaceCode() {
        return businessPlaceCode;
    }

    public void setBusinessPlaceCode(Long businessPlaceCode) {
        this.businessPlaceCode = businessPlaceCode;
    }

    public Long getCpId() {
        return cpId;
    }

    public void setCpId(Long cpId) {
        this.cpId = cpId;
    }

    public String getCpTypeCode() {
        return cpTypeCode;
    }

    public void setCpTypeCode(String cpTypeCode) {
        this.cpTypeCode = cpTypeCode;
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


    public PAlarmDataDomain vo2Domain() {
        PAlarmDataDomain pAlarmDataDomain = ReflectUtil.cast(this, PAlarmDataDomain.class);
        return pAlarmDataDomain;
    }
}
