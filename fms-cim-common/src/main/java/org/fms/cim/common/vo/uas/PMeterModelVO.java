/**
 * Author :
 * Date :
 * Title : org.fms.cim.common.vo.uas.PMeterModelVO.java
 **/
package org.fms.cim.common.vo.uas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import org.fms.cim.common.domain.uas.PMeterModelDomain;

import java.util.Date;
import java.math.BigDecimal;

public class PMeterModelVO extends ManagerParamVO {

    private Long id;    //
    private String name;    //
    private String validFlag;    //
    private BigDecimal maxValue;    //
    private BigDecimal apCoef;    //有功电量
    private BigDecimal rpCoef;    //无功有功
    private BigDecimal pCoef;    //有功
    private BigDecimal qCoef;    //无功
    private BigDecimal vCoef;    //电压
    private BigDecimal cCoef;    //电流
    private BigDecimal demandCoef;    //需量
    private BigDecimal factorCoef;    //功率因数

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date savedatetime;    //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public BigDecimal getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    public BigDecimal getApCoef() {
        return apCoef;
    }

    public void setApCoef(BigDecimal apCoef) {
        this.apCoef = apCoef;
    }

    public BigDecimal getRpCoef() {
        return rpCoef;
    }

    public void setRpCoef(BigDecimal rpCoef) {
        this.rpCoef = rpCoef;
    }

    public BigDecimal getPCoef() {
        return pCoef;
    }

    public void setPCoef(BigDecimal pCoef) {
        this.pCoef = pCoef;
    }

    public BigDecimal getQCoef() {
        return qCoef;
    }

    public void setQCoef(BigDecimal qCoef) {
        this.qCoef = qCoef;
    }

    public BigDecimal getVCoef() {
        return vCoef;
    }

    public void setVCoef(BigDecimal vCoef) {
        this.vCoef = vCoef;
    }

    public BigDecimal getCCoef() {
        return cCoef;
    }

    public void setCCoef(BigDecimal cCoef) {
        this.cCoef = cCoef;
    }

    public BigDecimal getDemandCoef() {
        return demandCoef;
    }

    public void setDemandCoef(BigDecimal demandCoef) {
        this.demandCoef = demandCoef;
    }

    public BigDecimal getFactorCoef() {
        return factorCoef;
    }

    public void setFactorCoef(BigDecimal factorCoef) {
        this.factorCoef = factorCoef;
    }

    public Date getSavedatetime() {
        return savedatetime;
    }

    public void setSavedatetime(Date savedatetime) {
        this.savedatetime = savedatetime;
    }


    public PMeterModelDomain vo2Domain() {
        PMeterModelDomain pMeterModelDomain = ReflectUtil.cast(this, PMeterModelDomain.class);
        return pMeterModelDomain;
    }
}
