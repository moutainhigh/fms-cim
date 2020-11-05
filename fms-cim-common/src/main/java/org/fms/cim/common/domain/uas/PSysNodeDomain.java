/**
 * 系统节点
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.domain.PSysNodeDomain.java
 **/
package org.fms.cim.common.domain.uas;

import java.util.Date;

import org.fms.cim.common.vo.uas.PSysNodeVO;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;

public class PSysNodeDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long id;    //编码
    private String code;    //编号
    private String name;    //名称
    private String alias;    //别名
    private String status;    //是否可用
    private String type;    //节点类型
    private String wherein;    //部署区域
    private String neta;    //A网地址
    private String netb;    //B网地址
    private String netd;    //C网地址
    private String nete;    //D网地址
    private String dactrlFlag;    //采集控制中心标识
    private String daFlag;    //前置机标识
    private String calcctrlFlag;    //计算任务中心标识
    private String calcFlag;    //计算服务
    private Integer comport1;    //计算通信端口1
    private Integer comport2;    //计算通信端口2
    private Integer hbPort1;    //心跳端口1
    private Integer hbPort2;    //心跳端口2
    private String mqFlag;    //MQ中心标识
    private String webFlag;    //WEB主机标识
    private String eventFlag;    //事项服务器标识
    private Integer dbFlag;    //数据库服务器标识
    private String remark;    //备注
    private Long daGroup;    //采集机组
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWherein() {
        return wherein;
    }

    public void setWherein(String wherein) {
        this.wherein = wherein;
    }

    public String getNeta() {
        return neta;
    }

    public void setNeta(String neta) {
        this.neta = neta;
    }

    public String getNetb() {
        return netb;
    }

    public void setNetb(String netb) {
        this.netb = netb;
    }

    public String getNetd() {
        return netd;
    }

    public void setNetd(String netd) {
        this.netd = netd;
    }

    public String getNete() {
        return nete;
    }

    public void setNete(String nete) {
        this.nete = nete;
    }

    public String getDactrlFlag() {
        return dactrlFlag;
    }

    public void setDactrlFlag(String dactrlFlag) {
        this.dactrlFlag = dactrlFlag;
    }

    public String getDaFlag() {
        return daFlag;
    }

    public void setDaFlag(String daFlag) {
        this.daFlag = daFlag;
    }

    public String getCalcctrlFlag() {
        return calcctrlFlag;
    }

    public void setCalcctrlFlag(String calcctrlFlag) {
        this.calcctrlFlag = calcctrlFlag;
    }

    public String getCalcFlag() {
        return calcFlag;
    }

    public void setCalcFlag(String calcFlag) {
        this.calcFlag = calcFlag;
    }

    public Integer getComport1() {
        return comport1;
    }

    public void setComport1(Integer comport1) {
        this.comport1 = comport1;
    }

    public Integer getComport2() {
        return comport2;
    }

    public void setComport2(Integer comport2) {
        this.comport2 = comport2;
    }

    public Integer getHbPort1() {
        return hbPort1;
    }

    public void setHbPort1(Integer hbPort1) {
        this.hbPort1 = hbPort1;
    }

    public Integer getHbPort2() {
        return hbPort2;
    }

    public void setHbPort2(Integer hbPort2) {
        this.hbPort2 = hbPort2;
    }

    public String getMqFlag() {
        return mqFlag;
    }

    public void setMqFlag(String mqFlag) {
        this.mqFlag = mqFlag;
    }

    public String getWebFlag() {
        return webFlag;
    }

    public void setWebFlag(String webFlag) {
        this.webFlag = webFlag;
    }

    public String getEventFlag() {
        return eventFlag;
    }

    public void setEventFlag(String eventFlag) {
        this.eventFlag = eventFlag;
    }

    public Integer getDbFlag() {
        return dbFlag;
    }

    public void setDbFlag(Integer dbFlag) {
        this.dbFlag = dbFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getDaGroup() {
        return daGroup;
    }

    public void setDaGroup(Long daGroup) {
        this.daGroup = daGroup;
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

    public PSysNodeVO domain2VO() {
        PSysNodeVO pSysNodeVO = ReflectUtil.cast(this, PSysNodeVO.class);
        return pSysNodeVO;
    }

}
