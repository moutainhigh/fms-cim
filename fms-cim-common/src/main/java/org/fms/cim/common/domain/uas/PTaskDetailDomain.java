/**
 * 采集任务明细
 * Author :
 * Date :
 * Title : org.fms.cim.common.domain.uas.PTaskDetailDomain.java
 **/
package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.PTaskDetailVO;

import java.util.Date;

public class PTaskDetailDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long id;    //编码
    private Long taskID;    //任务编码
    private String infopointType;    //信息点类型
    private Long dataId;    //数据单元编码
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

    public Long getTaskId() {
        return taskID;
    }

    public void setTaskId(Long taskID) {
        this.taskID = taskID;
    }

    public String getInfopointType() {
        return infopointType;
    }

    public void setInfopointType(String infopointType) {
        this.infopointType = infopointType;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
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

    public PTaskDetailVO domain2VO() {
        PTaskDetailVO pTaskDetailVO = ReflectUtil.cast(this, PTaskDetailVO.class);
        return pTaskDetailVO;
    }

}
