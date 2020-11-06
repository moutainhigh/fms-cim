/**
 * 计算任务类型定义表
 * Author :
 * Date :
 * Title : org.fms.cim.common.vo.uas.PWsdCalcTaskVO.java
 **/
package org.fms.cim.common.vo.uas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.uas.PWsdCalcTaskDomain;

import java.util.Date;

public class PWsdCalcTaskVO extends ManagerParamVO {

    private Integer id;    //任务类型标识
    private String name;    //名称
    private String schemeflag;    //关联计算方案(默认2--否 1－是（决定是否设置对应关联方案） 有些任务没有方案)
    private String uinttype;    //1000—电表类型 1001---水表类型
    private String status;    //可用标志
    private Long creatorId;    //创建者

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;    //创建时间
    private Long lastModifierId;    //最后修改者
    private String lastModifyTime;    //最后修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchemeflag() {
        return schemeflag;
    }

    public void setSchemeflag(String schemeflag) {
        this.schemeflag = schemeflag;
    }

    public String getUinttype() {
        return uinttype;
    }

    public void setUinttype(String uinttype) {
        this.uinttype = uinttype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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


    public PWsdCalcTaskDomain vo2Domain() {
        PWsdCalcTaskDomain pWsdCalcTaskDomain = ReflectUtil.cast(this, PWsdCalcTaskDomain.class);
        return pWsdCalcTaskDomain;
    }
}
