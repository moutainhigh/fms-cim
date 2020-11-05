/**
 * 通道参数表
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.domain.PChannelDomain.java
 **/
package org.fms.cim.common.domain.uas;

import java.util.Date;

import org.fms.cim.common.vo.uas.PChannelVO;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;

public class PChannelDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long id;    //通道标识
    private String code;    //编号
    private String name;    //通道名称
    private Long chnlGroupId;    //通道组标识
    private String deviceAddr1;    //设备地址1
    private String deviceAddr2;    //设备地址2
    private Integer ctrlhostId;    //控制主机
    private Integer baud;    //波特率
    private Integer databit;    //数据位
    private Integer stopbit;    //停止位
    private Integer checkbit;    //校验位
    private String initstr;    //初始化串
    private Long protocolId;    //监听规约
    private String normalopen;    //是否常开
    private String status;    //有效标识
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

    public Long getChnlGroupId() {
        return chnlGroupId;
    }

    public void setChnlGroupId(Long chnlGroupId) {
        this.chnlGroupId = chnlGroupId;
    }

    public String getDeviceAddr1() {
        return deviceAddr1;
    }

    public void setDeviceAddr1(String deviceAddr1) {
        this.deviceAddr1 = deviceAddr1;
    }

    public String getDeviceAddr2() {
        return deviceAddr2;
    }

    public void setDeviceAddr2(String deviceAddr2) {
        this.deviceAddr2 = deviceAddr2;
    }

    public Integer getCtrlhostId() {
        return ctrlhostId;
    }

    public void setCtrlhostId(Integer ctrlhostId) {
        this.ctrlhostId = ctrlhostId;
    }

    public Integer getBaud() {
        return baud;
    }

    public void setBaud(Integer baud) {
        this.baud = baud;
    }

    public Integer getDatabit() {
        return databit;
    }

    public void setDatabit(Integer databit) {
        this.databit = databit;
    }

    public Integer getStopbit() {
        return stopbit;
    }

    public void setStopbit(Integer stopbit) {
        this.stopbit = stopbit;
    }

    public Integer getCheckbit() {
        return checkbit;
    }

    public void setCheckbit(Integer checkbit) {
        this.checkbit = checkbit;
    }

    public String getInitstr() {
        return initstr;
    }

    public void setInitstr(String initstr) {
        this.initstr = initstr;
    }

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public String getNormalopen() {
        return normalopen;
    }

    public void setNormalopen(String normalopen) {
        this.normalopen = normalopen;
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

    public PChannelVO domain2VO() {
        PChannelVO pChannelVO = ReflectUtil.cast(this, PChannelVO.class);
        return pChannelVO;
    }

}
