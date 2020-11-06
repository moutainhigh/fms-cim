package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import org.fms.cim.common.vo.uas.PTaskDetailRelVO;

public class PTaskDetailRelDomain extends PTaskDetailDomain implements MybatisEntity {

    private String dataName;//数据任务项名称

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public PTaskDetailRelVO vo2Domain() {
        PTaskDetailRelVO pTaskDetailRelVO = ReflectUtil.cast(this, PTaskDetailRelVO.class);
        return pTaskDetailRelVO;
    }
}
