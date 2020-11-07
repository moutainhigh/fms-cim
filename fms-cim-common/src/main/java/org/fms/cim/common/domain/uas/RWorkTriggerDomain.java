/**
 * 计量业务触发表
 * Author :
 * Date :
 * Title : org.fms.cim.common.domain.uas.RWorkTriggerDomain.java
 **/
package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.RWorkTriggerVO;

import java.util.Date;
import java.math.BigDecimal;

public class RWorkTriggerDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long trgId;    //事件标识 本实体记录的唯一标识
    private Long objId;    //对象编码
    private String objType;    //对象类型
    private String triggerType;    //触发类型 标准编码1.120
    private Date beginTime;    //开始时间
    private Date endTime;    //结束时间
    private String dealflag;    //处理标志 00未处理01已处理
    private Long creatorId;    //创建者
    private Date createDate;    //创建时间
    private Long lastModifierId;    //最后修改者
    private String lastModifyTime;    //最后修改时间

    public Long getTrgId() {
        return trgId;
    }

    public void setTrgId(Long trgId) {
        this.trgId = trgId;
    }

    public Long getObjId() {
        return objId;
    }

    public void setObjId(Long objId) {
        this.objId = objId;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
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

    public String getDealflag() {
        return dealflag;
    }

    public void setDealflag(String dealflag) {
        this.dealflag = dealflag;
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

    public RWorkTriggerVO domain2VO() {
        RWorkTriggerVO rWorkTriggerVO = ReflectUtil.cast(this, RWorkTriggerVO.class);
        return rWorkTriggerVO;
    }

}
