/**
 * 采集日志表
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.vo.RDaLogVO.java
 **/
package org.fms.cim.common.vo.uas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.uas.RDaLogDomain;

import java.util.Date;
import java.math.BigDecimal;

public class RDaLogVO extends ManagerParamVO {

    private Long cpId;    //终端编码
    private String objid;    //使用对象编码 -1/-2/-3   逻辑设备, 0---终端,  〉=1   计量点编码
    private String datatype;    //明细类型 0---当前数据,1---周期性历史数据(形成日志),2---历史数据终端任务(形成日志)
    private String dataid;    //明细数据类型 明细数据类型
    private BigDecimal datatm;    //历史数据时间 历史数据时间
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

    public String getObjid() {
        return objid;
    }

    public void setObjid(String objid) {
        this.objid = objid;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getDataid() {
        return dataid;
    }

    public void setDataid(String dataid) {
        this.dataid = dataid;
    }

    public BigDecimal getDatatm() {
        return datatm;
    }

    public void setDatatm(BigDecimal datatm) {
        this.datatm = datatm;
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


    public RDaLogDomain vo2Domain() {
        RDaLogDomain rDaLogDomain = ReflectUtil.cast(this, RDaLogDomain.class);
        return rDaLogDomain;
    }
}
