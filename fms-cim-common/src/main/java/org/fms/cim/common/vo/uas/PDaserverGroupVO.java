/**
 * 采集主机组
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.vo.PDaserverGroupVO.java
 **/
package org.fms.cim.common.vo.uas;

import java.util.Date;
import java.util.List;

import org.fms.cim.common.domain.uas.PDaserverGroupDomain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.riozenc.titanTool.common.reflect.ReflectUtil;

public class PDaserverGroupVO extends ManagerParamVO {

    private Long id;    //组编码
    private String code;    //编号
    private String name;    //组名称
    private String status;    //有效标识
    private Integer weight;    //排序
    private Long creatorId;    //创建者

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;    //创建时间
    private Long lastModifierId;    //最后修改者
    private String lastModifyTime;    //最后修改时间
    private List<PSysNodeVO> listSysNodeVO; //采集机组对应的主机

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


    public PDaserverGroupDomain vo2Domain() {
        PDaserverGroupDomain pDaserverGroupDomain = ReflectUtil.cast(this, PDaserverGroupDomain.class);
        return pDaserverGroupDomain;
    }

    public List<PSysNodeVO> getListSysNodeVO() {
        return listSysNodeVO;
    }

    public void setListSysNodeVO(List<PSysNodeVO> listSysNodeVO) {
        this.listSysNodeVO = listSysNodeVO;
    }
}
