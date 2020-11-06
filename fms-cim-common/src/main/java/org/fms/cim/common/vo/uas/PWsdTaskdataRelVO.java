package org.fms.cim.common.vo.uas;

import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.uas.PWsdTaskdataDomain;
import org.fms.cim.common.domain.uas.PWsdTaskdataRelDomain;

public class PWsdTaskdataRelVO extends PWsdTaskdataVO {
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

    public PWsdTaskdataRelDomain vo2Domain() {
        PWsdTaskdataRelDomain modelDomain = ReflectUtil.cast(this, PWsdTaskdataRelDomain.class);
        return modelDomain;
    }

    public Integer getRelWeight() {
        return relWeight;
    }

    public void setRelWeight(Integer relWeight) {
        this.relWeight = relWeight;
    }
}
