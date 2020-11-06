/**
 * 通道组主机关系
 * Author :
 * Date :
 * Title : org.fms.cim.common.domain.uas.PChnlGpDasRelaDomain.java
 **/
package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.PChnlGpDasRelaVO;

import java.util.Date;

public class PChnlGpDasRelaDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long id;    //关系标识(系统内部标识)
    private Long chnlGroupId;    //通道组标识
    private Long dasId;    //采集主机标识
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

    public Long getChnlGroupId() {
        return chnlGroupId;
    }

    public void setChnlGroupId(Long chnlGroupId) {
        this.chnlGroupId = chnlGroupId;
    }

    public Long getDasId() {
        return dasId;
    }

    public void setDasId(Long dasId) {
        this.dasId = dasId;
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

    public PChnlGpDasRelaVO domain2VO() {
        PChnlGpDasRelaVO pChnlGpDasRelaVO = ReflectUtil.cast(this, PChnlGpDasRelaVO.class);
        return pChnlGpDasRelaVO;
    }

}
