/**
 * 规约数据单元组（※相当于原来变电站采集的规约信息体类型）
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.vo.PWsdTaskdataGroupVO.java
 **/
package org.fms.cim.common.vo.uas;

import java.util.Date;

import org.fms.cim.common.domain.uas.PWsdTaskdataGroupDomain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.riozenc.titanTool.common.reflect.ReflectUtil;

public class PWsdTaskdataGroupVO extends ManagerParamVO {

    private Long id;    //唯一标识
    private Long protocolId;    //规约编码
    private Long taskId;    //任务类型
    private Long groupId;    //编码
    private String name;    //名称
    private String status;    //可用标志
    private Integer infoaddrBegin;    //信息体起始地址(Default:0)
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

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getInfoaddrBegin() {
        return infoaddrBegin;
    }

    public void setInfoaddrBegin(Integer infoaddrBegin) {
        this.infoaddrBegin = infoaddrBegin;
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


    public PWsdTaskdataGroupDomain vo2Domain() {
        PWsdTaskdataGroupDomain pWsdTaskdataGroupDomain = ReflectUtil.cast(this, PWsdTaskdataGroupDomain.class);
        return pWsdTaskdataGroupDomain;
    }
}
