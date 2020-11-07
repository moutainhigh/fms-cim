/**
 * 采集任务执行日志表
 * Author :
 * Date :
 * Title : org.fms.cim.common.domain.uas.RDaTaskLogDomain.java
 **/
package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.RDaTaskLogVO;

import java.util.Date;
import java.math.BigDecimal;

public class RDaTaskLogDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long cpId;    //终端编号
    private Long mpedId;    //测量点标识
    private String tmnlFlag;    //终端测量点标识 01-终端 02-表计
    private Long cpTaskId;    //任务编码 采集任务模板明细【P_TASK_TPL_DETAIL】
    private String cpTaskDescribe;    //任务描述
    private Date createtm;    //产生时间
    private Date taskst;    //起始时间
    private Date tasket;    //终止时间
    private Date datatm;    //数据时间
    private String succFlag;    //完成情况 暂不处理
    private String execStatus;    //执行状态 1.40参数下发成功标志
    private Long creatorId;    //创建者
    private Date createDate;    //创建时间
    private Long lastModifierId;    //最后修改者
    private String lastModifyTime;    //最后修改时间

    public Long getCpId() {
        return cpId;
    }

    public void setCpId(Long cpId) {
        this.cpId = cpId;
    }

    public Long getMpedId() {
        return mpedId;
    }

    public void setMpedId(Long mpedId) {
        this.mpedId = mpedId;
    }

    public String getTmnlFlag() {
        return tmnlFlag;
    }

    public void setTmnlFlag(String tmnlFlag) {
        this.tmnlFlag = tmnlFlag;
    }

    public Long getCpTaskId() {
        return cpTaskId;
    }

    public void setCpTaskId(Long cpTaskId) {
        this.cpTaskId = cpTaskId;
    }

    public String getCpTaskDescribe() {
        return cpTaskDescribe;
    }

    public void setCpTaskDescribe(String cpTaskDescribe) {
        this.cpTaskDescribe = cpTaskDescribe;
    }

    public Date getCreatetm() {
        return createtm;
    }

    public void setCreatetm(Date createtm) {
        this.createtm = createtm;
    }

    public Date getTaskst() {
        return taskst;
    }

    public void setTaskst(Date taskst) {
        this.taskst = taskst;
    }

    public Date getTasket() {
        return tasket;
    }

    public void setTasket(Date tasket) {
        this.tasket = tasket;
    }

    public Date getDatatm() {
        return datatm;
    }

    public void setDatatm(Date datatm) {
        this.datatm = datatm;
    }

    public String getSuccFlag() {
        return succFlag;
    }

    public void setSuccFlag(String succFlag) {
        this.succFlag = succFlag;
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

    public RDaTaskLogVO domain2VO() {
        RDaTaskLogVO rDaTaskLogVO = ReflectUtil.cast(this, RDaTaskLogVO.class);
        return rDaTaskLogVO;
    }

}
