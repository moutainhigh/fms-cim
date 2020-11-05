package org.fms.cim.common.domain.uas;

import org.fms.cim.common.vo.uas.PWsdTaskdataRelVO;

import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;

public class PWsdTaskdataRelDomain extends PWsdTaskdataDomain implements MybatisEntity {

    private Long relID;//与任务的关联ID
    private Long taskID;//关联的任务ID
    private Integer relWeight;//关联表的排序

    public Long getRelID() {
        return relID;
    }

    public void setRelID(Long relID) {
        this.relID = relID;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public PWsdTaskdataRelVO domain2VO() {
        PWsdTaskdataRelVO modelVO = ReflectUtil.cast(this, PWsdTaskdataRelVO.class);
        return modelVO;
    }

    public Integer getRelWeight() {
        return relWeight;
    }

    public void setRelWeight(Integer relWeight) {
        this.relWeight = relWeight;
    }
}
