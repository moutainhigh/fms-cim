/**
 * 终端对时日志表
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.vo.RCheckClockLogVO.java
 **/
package org.fms.cim.common.vo.uas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.uas.RCheckClockLogDomain;

import java.util.Date;
import java.math.BigDecimal;

public class RCheckClockLogVO extends ManagerParamVO {

    private Long cpId;    //采集点编号

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date execTime;    //执行时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sysTime;    //主站时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date tmnlTime;    //终端时间
    private BigDecimal timeGap;    //时钟差
    private String checkFlag;    //是否满足对钟
    private String exeResult;    //对钟结果 标准编码1.40
    private Long creatorId;    //创建者

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;    //创建时间
    private Long lastModifierId;    //最后修改者
    private String lastModifyTime;    //最后修改时间

    public Long getCpId() {
        return cpId;
    }

    public void setCpId(Long cpId) {
        this.cpId = cpId;
    }

    public Date getExecTime() {
        return execTime;
    }

    public void setExecTime(Date execTime) {
        this.execTime = execTime;
    }

    public Date getSysTime() {
        return sysTime;
    }

    public void setSysTime(Date sysTime) {
        this.sysTime = sysTime;
    }

    public Date getTmnlTime() {
        return tmnlTime;
    }

    public void setTmnlTime(Date tmnlTime) {
        this.tmnlTime = tmnlTime;
    }

    public BigDecimal getTimeGap() {
        return timeGap;
    }

    public void setTimeGap(BigDecimal timeGap) {
        this.timeGap = timeGap;
    }

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getExeResult() {
        return exeResult;
    }

    public void setExeResult(String exeResult) {
        this.exeResult = exeResult;
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


    public RCheckClockLogDomain vo2Domain() {
        RCheckClockLogDomain rCheckClockLogDomain = ReflectUtil.cast(this, RCheckClockLogDomain.class);
        return rCheckClockLogDomain;
    }
}
