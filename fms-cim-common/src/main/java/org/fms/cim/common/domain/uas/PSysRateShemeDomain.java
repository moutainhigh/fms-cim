/**
 * 多费率方案定义表
 * Author :
 * Date :
 * Title : org.fms.cim.common.domain.uas.PSysRateShemeDomain.java
 **/
package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.PSysRateShemeVO;

import java.util.Date;

public class PSysRateShemeDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long id;    //编码
    private String name;    //方案名称
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public PSysRateShemeVO domain2VO() {
        PSysRateShemeVO pSysRateShemeVO = ReflectUtil.cast(this, PSysRateShemeVO.class);
        return pSysRateShemeVO;
    }

}
