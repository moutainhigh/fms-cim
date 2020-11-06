/**
 * 计算任务
 * Author :
 * Date :
 * Title : org.fms.cim.common.domain.uas.PCalcTaskDomain.java
 **/
package org.fms.cim.common.domain.uas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.PCalcTaskVO;

import java.math.BigDecimal;
import java.util.Date;

public class PCalcTaskDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long id;    //任务标识
    private String name;    //名称
    private BigDecimal tasktypeid;    //任务类型
    private String objtype;    //对象类型(计算方案模板类型【TPL_TYPE】)
    private BigDecimal schemeId;    //计算方案
    private String primaryFlag;    //主方案标志
    private String dataSrc;    //数据源(日冻结、月冻结、终端冻结、曲线等)
    private String gltsFlag;    //功率、费率标识(每8位为一组，表示8个功率，每一组中的每一位代表8个费率)
    private BigDecimal tsSchemeid;    //后台分时方案(P_SYS_RATE_SHEME)
    private String triggerFlag;    //是否触发对象(01-是 02-否)
    private String qCalcFlag;    //无功计算方式(废弃：直接设置到点上)
    private String priority;    //优先级
    private String genedatetime;    //任务产生基准时间(05 00:00 日 小时:分钟)
    private BigDecimal genespanvalue;    //任务间隔值(>=1)
    private String genespantype;    //任务间隔类型
    private String status;    //任务状态(0---停止 1---使用)
    private BigDecimal weight;//排序

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date taskst;    //任务产生开始时间
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTasktypeid() {
        return tasktypeid;
    }

    public void setTasktypeid(BigDecimal tasktypeid) {
        this.tasktypeid = tasktypeid;
    }

    public String getObjtype() {
        return objtype;
    }

    public void setObjtype(String objtype) {
        this.objtype = objtype;
    }

    public BigDecimal getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(BigDecimal schemeId) {
        this.schemeId = schemeId;
    }

    public String getPrimaryFlag() {
        return primaryFlag;
    }

    public void setPrimaryFlag(String primaryFlag) {
        this.primaryFlag = primaryFlag;
    }

    public String getDataSrc() {
        return dataSrc;
    }

    public void setDataSrc(String dataSrc) {
        this.dataSrc = dataSrc;
    }

    public String getGltsFlag() {
        return gltsFlag;
    }

    public void setGltsFlag(String gltsFlag) {
        this.gltsFlag = gltsFlag;
    }

    public BigDecimal getTsSchemeid() {
        return tsSchemeid;
    }

    public void setTsSchemeid(BigDecimal tsSchemeid) {
        this.tsSchemeid = tsSchemeid;
    }

    public String getTriggerFlag() {
        return triggerFlag;
    }

    public void setTriggerFlag(String triggerFlag) {
        this.triggerFlag = triggerFlag;
    }

    public String getQCalcFlag() {
        return qCalcFlag;
    }

    public void setQCalcFlag(String qCalcFlag) {
        this.qCalcFlag = qCalcFlag;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getGenedatetime() {
        return genedatetime;
    }

    public void setGenedatetime(String genedatetime) {
        this.genedatetime = genedatetime;
    }

    public BigDecimal getGenespanvalue() {
        return genespanvalue;
    }

    public void setGenespanvalue(BigDecimal genespanvalue) {
        this.genespanvalue = genespanvalue;
    }

    public String getGenespantype() {
        return genespantype;
    }

    public void setGenespantype(String genespantype) {
        this.genespantype = genespantype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTaskst() {
        return taskst;
    }

    public void setTaskst(Date taskst) {
        this.taskst = taskst;
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

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public PCalcTaskVO domain2VO() {
        PCalcTaskVO pCalcTaskVO = ReflectUtil.cast(this, PCalcTaskVO.class);
        return pCalcTaskVO;
    }

}
