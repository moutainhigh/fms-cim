package org.fms.cim.common.vo.uas;

import org.fms.cim.common.domain.uas.PCalcTaskRelDomain;

import com.riozenc.titanTool.common.reflect.ReflectUtil;

public class PCalcTaskRelVO extends PCalcTaskVO {
    private Long relID;//P_CALC_TPL_DETAIL表ID
    private Integer tplID;//P_CALC_TPL表的ID
    private Integer isSelect;//是否选中 0-否 1-是

    public Long getRelID() {
        return relID;
    }

    public void setRelID(Long relID) {
        this.relID = relID;
    }

    public Integer getTplID() {
        return tplID;
    }

    public void setTplID(Integer tplID) {
        this.tplID = tplID;
    }

    public Integer getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Integer isSelect) {
        this.isSelect = isSelect;
    }

    public PCalcTaskRelDomain vo2Domain() {
        PCalcTaskRelDomain modelDomain = ReflectUtil.cast(this, PCalcTaskRelDomain.class);
        return modelDomain;
    }
}
