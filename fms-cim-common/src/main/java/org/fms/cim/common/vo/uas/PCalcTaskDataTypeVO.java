package org.fms.cim.common.vo.uas;

public class PCalcTaskDataTypeVO {

    public PCalcTaskDataTypeVO(Integer key, String value) {
        this.isSelect=0;
        this.key = key;
        this.value = value;
    }

    private Integer isSelect;//是否选中
    private Integer key;
    private String value;

    public Integer getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Integer isSelect) {
        this.isSelect = isSelect;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
