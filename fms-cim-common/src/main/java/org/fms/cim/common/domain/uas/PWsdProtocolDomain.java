/**
 * 规约定义表
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.domain.PWsdProtocolDomain.java
 **/
package org.fms.cim.common.domain.uas;

import java.util.Date;

import org.fms.cim.common.vo.uas.PWsdProtocolVO;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;

public class PWsdProtocolDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long id;    //编码
    private String code;    //编号
    private String name;    //名称
    private String status;    //可用标志
    private String subsFlag;    //厂站可用
    private String distFlag;    //配网可用
    private String lowFlag;    //低压可用
    private Integer beginSn;    //测量点编号开始数字(0或1)
    private String protocolType;    //规约分类（标准编码：1.80）
    private Integer byteNumLinkaddr;    //链路地址字节数（某些规约需要配置，比如104）
    private Integer byteNumCommaddr;    //公共地址字节数
    private Integer byteNumTransReas;    //传输原因字节数
    private Integer byteNumInfoaddr;    //信息体地址字节数
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubsFlag() {
        return subsFlag;
    }

    public void setSubsFlag(String subsFlag) {
        this.subsFlag = subsFlag;
    }

    public String getDistFlag() {
        return distFlag;
    }

    public void setDistFlag(String distFlag) {
        this.distFlag = distFlag;
    }

    public String getLowFlag() {
        return lowFlag;
    }

    public void setLowFlag(String lowFlag) {
        this.lowFlag = lowFlag;
    }

    public Integer getBeginSn() {
        return beginSn;
    }

    public void setBeginSn(Integer beginSn) {
        this.beginSn = beginSn;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public Integer getByteNumLinkaddr() {
        return byteNumLinkaddr;
    }

    public void setByteNumLinkaddr(Integer byteNumLinkaddr) {
        this.byteNumLinkaddr = byteNumLinkaddr;
    }

    public Integer getByteNumCommaddr() {
        return byteNumCommaddr;
    }

    public void setByteNumCommaddr(Integer byteNumCommaddr) {
        this.byteNumCommaddr = byteNumCommaddr;
    }

    public Integer getByteNumTransReas() {
        return byteNumTransReas;
    }

    public void setByteNumTransReas(Integer byteNumTransReas) {
        this.byteNumTransReas = byteNumTransReas;
    }

    public Integer getByteNumInfoaddr() {
        return byteNumInfoaddr;
    }

    public void setByteNumInfoaddr(Integer byteNumInfoaddr) {
        this.byteNumInfoaddr = byteNumInfoaddr;
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

    public PWsdProtocolVO domain2VO() {
        PWsdProtocolVO pWsdProtocolVO = ReflectUtil.cast(this, PWsdProtocolVO.class);
        return pWsdProtocolVO;
    }

}
