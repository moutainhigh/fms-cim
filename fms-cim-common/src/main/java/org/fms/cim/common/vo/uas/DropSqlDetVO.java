package org.fms.cim.common.vo.uas;

import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.archives.TgInfoDomain;
import org.fms.cim.common.domain.uas.DropSqlDetDomain;

public class DropSqlDetVO extends ManagerParamVO {
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

    public DropSqlDetDomain vo2Domain() {
        DropSqlDetDomain modelDomain = ReflectUtil.cast(this, DropSqlDetDomain.class);
        return modelDomain;
    }
}
