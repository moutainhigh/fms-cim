/**
 * 规约数据单元
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.vo.PWsdTaskdataVO.java
 **/
package org.fms.cim.common.vo.uas;

import java.util.Date;

import org.fms.cim.common.domain.uas.PWsdTaskdataDomain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.riozenc.titanTool.common.reflect.ReflectUtil;

public class PWsdTaskdataVO extends ManagerParamVO {

    private Long id;    //唯一标识
    private String dataId;    //数据单元编码
    private String name;    //名称
    private Long protocolId;    //规约编码
    private Long groupId;    //数据单元组
    private String infopointType;    //信息点类型(标准编码1.66)
    private String infopointDatatype;    //信息点数据属性(标准编码1.67)
    private String status;    //可用标志
    private Integer weight;    //排序
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

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getInfopointType() {
        return infopointType;
    }

    public void setInfopointType(String infopointType) {
        this.infopointType = infopointType;
    }

    public String getInfopointDatatype() {
        return infopointDatatype;
    }

    public void setInfopointDatatype(String infopointDatatype) {
        this.infopointDatatype = infopointDatatype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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


    public PWsdTaskdataDomain vo2Domain() {
        PWsdTaskdataDomain pWsdTaskdataDomain = ReflectUtil.cast(this, PWsdTaskdataDomain.class);
        return pWsdTaskdataDomain;
    }
}
