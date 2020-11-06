/**
 * 采集任务
 * Author :
 * Date :
 * Title : org.fms.cim.common.domain.uas.PTaskDomain.java
 **/
package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.PTaskVO;

import java.util.Date;

public class PTaskDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long id;    //任务编码
    private String code;    //编号
    private String name;    //任务名称
    private Long protocolId;    //规约编码
    private Long taskId;    //任务类型
    private Integer taskNo;    //任务号
    private String pnType;    //信息点类型
    private String objProp;    //对象属性
    private Date taskBegintime;    //任务起始时间
    private Integer taskCycle;    //任务执行周期
    private String cycleUnit;    //周期单位
    private String dataDensity;    //数据密度
    private String freezeType;    //冻结类型
    private Integer maxDatacycle;    //采集最多数据周期
    private Integer maxFailnum;    //允许失败次数
    private Integer repeatCycle;    //执行间隔
    private String priority;    //优先级
    private String taskSrc;    //任务来源
    private String status;    //可用标志
    private Integer weight;    //排序
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(Integer taskNo) {
        this.taskNo = taskNo;
    }

    public String getPnType() {
        return pnType;
    }

    public void setPnType(String pnType) {
        this.pnType = pnType;
    }

    public String getObjProp() {
        return objProp;
    }

    public void setObjProp(String objProp) {
        this.objProp = objProp;
    }

    public Date getTaskBegintime() {
        return taskBegintime;
    }

    public void setTaskBegintime(Date taskBegintime) {
        this.taskBegintime = taskBegintime;
    }

    public Integer getTaskCycle() {
        return taskCycle;
    }

    public void setTaskCycle(Integer taskCycle) {
        this.taskCycle = taskCycle;
    }

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit;
    }

    public String getDataDensity() {
        return dataDensity;
    }

    public void setDataDensity(String dataDensity) {
        this.dataDensity = dataDensity;
    }

    public String getFreezeType() {
        return freezeType;
    }

    public void setFreezeType(String freezeType) {
        this.freezeType = freezeType;
    }

    public Integer getMaxDatacycle() {
        return maxDatacycle;
    }

    public void setMaxDatacycle(Integer maxDatacycle) {
        this.maxDatacycle = maxDatacycle;
    }

    public Integer getMaxFailnum() {
        return maxFailnum;
    }

    public void setMaxFailnum(Integer maxFailnum) {
        this.maxFailnum = maxFailnum;
    }

    public Integer getRepeatCycle() {
        return repeatCycle;
    }

    public void setRepeatCycle(Integer repeatCycle) {
        this.repeatCycle = repeatCycle;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTaskSrc() {
        return taskSrc;
    }

    public void setTaskSrc(String taskSrc) {
        this.taskSrc = taskSrc;
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

    public PTaskVO domain2VO() {
        PTaskVO pTaskVO = ReflectUtil.cast(this, PTaskVO.class);
        return pTaskVO;
    }

}
