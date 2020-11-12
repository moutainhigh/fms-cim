package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.DropSqlDetVO;
import org.fms.cim.common.vo.uas.PAlarmDataVO;

public class DropSqlDetDomain extends Page implements MybatisEntity {
    private long paramKey;    //
    private String paramValue;    //
    private String filter;    //

    public long getParamKey() {
        return paramKey;
    }

    public void setParamKey(long paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public DropSqlDetVO domain2VO() {
        DropSqlDetVO modelVO = ReflectUtil.cast(this, DropSqlDetVO.class);
        return modelVO;
    }
}
