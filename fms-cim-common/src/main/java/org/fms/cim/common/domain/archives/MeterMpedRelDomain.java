package org.fms.cim.common.domain.archives;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.mybatis.MybatisEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeterMpedRelDomain extends ManagerParamEntity implements MybatisEntity{
	
	
	@TablePrimaryKey
	private Long id; //ID	ID	bigint
	private Long meterId;//计费点ID	METER_ID	bigint
	private Long mpedId;//计量点ID	MPED_ID	bigint
	private String phaseSeq;//相序	PHASE_SEQ	smallint
	private String functionCode;//功能代码	FUNCTION_CODE	smallint
	private String powerDirection;//功率方向	POWER_DIRECTION	smallint
	private String tsFlag;//分时标识	TS_FLAG	smallint
	private Date createDate;//创建时间	CREATE_DATE	datetime
	private String status;//状态	STATUS	smallint
	private BigDecimal factorNum;//综合倍率	FACTOR_NUM	decimal
	private Long writeSn;//抄表序号	WRITE_SN	bigint
	private String meterNo;
	
	public String getMeterNo() {
		return meterNo;
	}
	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMeterId() {
		return meterId;
	}
	public void setMeterId(Long meterId) {
		this.meterId = meterId;
	}
	public Long getMpedId() {
		return mpedId;
	}
	public void setMpedId(Long mpedId) {
		this.mpedId = mpedId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getPhaseSeq() {
		return phaseSeq;
	}
	public void setPhaseSeq(String phaseSeq) {
		this.phaseSeq = phaseSeq;
	}
	public String getFunctionCode() {
		return functionCode;
	}
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}
	public String getPowerDirection() {
		return powerDirection;
	}
	public void setPowerDirection(String powerDirection) {
		this.powerDirection = powerDirection;
	}
	public String getTsFlag() {
		return tsFlag;
	}
	public void setTsFlag(String tsFlag) {
		this.tsFlag = tsFlag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getFactorNum() {
		return factorNum;
	}
	public void setFactorNum(BigDecimal factorNum) {
		this.factorNum = factorNum;
	}
	public Long getWriteSn() {
		return writeSn;
	}
	public void setWriteSn(Long writeSn) {
		this.writeSn = writeSn;
	}

	
	
	
	
	
	
}
