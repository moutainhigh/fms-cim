package org.fms.cim.common.vo.uas;

import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.uas.PDaserverGroupStaticDomain;
import org.fms.cim.common.domain.uas.PTaskDetailDomain;
import org.fms.cim.common.domain.uas.PTaskDetailRelDomain;

public class PTaskDetailRelVO extends PTaskDetailVO {

    private String dataName;//数据任务项名称

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public PTaskDetailRelDomain vo2Domain() {
        PTaskDetailRelDomain pTaskDetailRelDomain = ReflectUtil.cast(this, PTaskDetailRelDomain.class);
        return pTaskDetailRelDomain;
    }
}
