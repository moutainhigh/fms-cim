package org.fms.cim.common.domain.uas;

import org.fms.cim.common.vo.uas.PTaskRelVO;

import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;

public class PTaskRelDomain extends PTaskDomain implements MybatisEntity {
    private Integer isSelect;//是否选中 0-否 1-是
    private Long relID;//关联ID
    private Long tplID;//任务模板ID

    public Integer getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Integer isSelect) {
        this.isSelect = isSelect;
    }

    public Long getRelID() {
        return relID;
    }

    public void setRelID(Long relID) {
        this.relID = relID;
    }

    public Long getTplID() {
        return tplID;
    }

    public void setTplID(Long tplID) {
        this.tplID = tplID;
    }
    public PTaskRelVO domain2VO() {
        PTaskRelVO modelVO = ReflectUtil.cast(this, PTaskRelVO.class);
        return modelVO;
    }


}
