/**
 * 告警事项设置
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.vo.PAlarmItemVO.java
 **/
package org.fms.cim.common.vo.uas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.uas.PAlarmItemDomain;

import java.util.Date;
import java.math.BigDecimal;

public class PAlarmItemVO extends ManagerParamVO {

    private Long id;    //标识 本实体记录的唯一标识
    private String sysUserName;    //系统用户名 P_SYS_USER
    private Long eventNo;    //事件标识 P_WSD_EVENT_DEF中EVENT_NO
    private String soundFlag;    //是否声音
    private String popFlag;    //是否弹出
    private String smsFlag;    //是否短消息
    private String opengraphicFlag;    //是否推图 1.6.4增加
    private String mailFlag;    //是否邮件
    private String mailbox;    //邮件地址
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

    public Long getEventNo() {
        return eventNo;
    }

    public void setEventNo(Long eventNo) {
        this.eventNo = eventNo;
    }

    public String getSoundFlag() {
        return soundFlag;
    }

    public void setSoundFlag(String soundFlag) {
        this.soundFlag = soundFlag;
    }

    public String getPopFlag() {
        return popFlag;
    }

    public void setPopFlag(String popFlag) {
        this.popFlag = popFlag;
    }

    public String getSmsFlag() {
        return smsFlag;
    }

    public void setSmsFlag(String smsFlag) {
        this.smsFlag = smsFlag;
    }

    public String getOpengraphicFlag() {
        return opengraphicFlag;
    }

    public void setOpengraphicFlag(String opengraphicFlag) {
        this.opengraphicFlag = opengraphicFlag;
    }

    public String getMailFlag() {
        return mailFlag;
    }

    public void setMailFlag(String mailFlag) {
        this.mailFlag = mailFlag;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
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


    public PAlarmItemDomain vo2Domain() {
        PAlarmItemDomain pAlarmItemDomain = ReflectUtil.cast(this, PAlarmItemDomain.class);
        return pAlarmItemDomain;
    }
}
