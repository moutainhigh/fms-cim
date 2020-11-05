/**
 * 规约任务类型（※相当于原来变电站采集的规约数据类型表与负控采集的任务类型合并的表。对于厂站系列为电量、15分钟电量、瞬时量等；对于负荷、低压系列为一类、二类数据等）
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.domain.PWsdProtocolTaskDomain.java
 **/
package org.fms.cim.common.domain.uas;

import java.util.Date;

import org.fms.cim.common.vo.uas.PWsdProtocolTaskVO;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;

public class PWsdProtocolTaskDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long id;    //唯一标识
    private Long code;    //编号
    private String name;    //名称
    private Long protocolId;    //规约编码
    private String status;    //可用标志
    private String hisFlag;    //历史数据标志
    private String nowFlag;    //当前数据标志
    private String infoaddrFlag;    //是否使用信息体
    private Long groupId;    //任务数据单元组（关联P_WSD_TASKDATA_GROUP）
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

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHisFlag() {
        return hisFlag;
    }

    public void setHisFlag(String hisFlag) {
        this.hisFlag = hisFlag;
    }

    public String getNowFlag() {
        return nowFlag;
    }

    public void setNowFlag(String nowFlag) {
        this.nowFlag = nowFlag;
    }

    public String getInfoaddrFlag() {
        return infoaddrFlag;
    }

    public void setInfoaddrFlag(String infoaddrFlag) {
        this.infoaddrFlag = infoaddrFlag;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    public PWsdProtocolTaskVO domain2VO() {
        PWsdProtocolTaskVO pWsdProtocolTaskVO = ReflectUtil.cast(this, PWsdProtocolTaskVO.class);
        return pWsdProtocolTaskVO;
    }

}
