package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import org.fms.cim.common.vo.uas.PCalcTaskRelVO;
import org.fms.cim.common.vo.uas.PCalcTaskVO;

public class PCalcTaskRelDomain extends PCalcTaskDomain implements MybatisEntity {
    private Long relID;//P_CALC_TPL_DETAIL表ID
    private Long tplID;//P_CALC_TPL表的ID

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

    public PCalcTaskRelVO domain2VO() {
        PCalcTaskRelVO modelVO = ReflectUtil.cast(this, PCalcTaskRelVO.class);
        return modelVO;
    }
}
