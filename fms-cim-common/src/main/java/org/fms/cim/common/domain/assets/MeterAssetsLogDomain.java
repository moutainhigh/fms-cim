/**
 *    Auth:riozenc
 *    Date:2019年3月21日 下午4:38:53
 *    Title:com.riozenc.cim.webapp.assets.domain.MeterAssetsLogDomain.java
 **/
package org.fms.cim.common.domain.assets;

import java.math.BigDecimal;
import java.util.Date;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;

public class MeterAssetsLogDomain extends Page implements MybatisEntity {

	@TablePrimaryKey
	private Long id;// ID ID bigint TRUE FALSE TRUE
	private String meterAssetsNo; // 资产编号
	private String madeNo; // 出厂编号
	private String funcKindCode; // 功能分类
	private String powerKindCode; // 功率性质
	private Byte fixedAssetsFlag; // 是否固定资产
	private String facCode; // 制造厂家
	private String modelCode; // 型号
	private String ratedVoltCode; // 额定电压
	private String ratedCurntCode; // 标定电流
	private String accuLevelCode; // 准确度等级
	private String phaseLine; // 相线
	private Byte isTsMeter; // 分时表标志
	private String structCode; // 结构
	private String meterConst; // 电表常数
	private String constUnit; // 常数单位
	private BigDecimal factor; // 表计倍率
	private String madeStdard; // 制造标准
	private Byte axeStructCode; // 轴承结构
	private String meteryardType; // 计度器类型
	private Byte noReturnFlag; // 有无止逆器
	private Byte isCard; // 是否卡表
	private Byte connectMode; // 接通方式
	private Date madeDate; // 出厂日期
	private Date bayDate; // 立帐日期
	private Integer lifeSpan; // 使用寿命(月)
	private String manId; // 持有人
	private Byte stateFlag; // 状态标志
	private Date statusChgDate; // 状态改变时间
	private String statusChgReason; // 状态改变原因
	private Date lastDetDate; // 上次检定日期
	private Integer detPeriod; // 检定周期(月)
	private String rightAttach; // 产权归属
	private String simNo; // SIM卡号
	private String numDigit; // 表码位数
	private String barCode; // 条形码
	private Long deptId; // 营业区域
	private Date createDate; // 创建时间
	private String remark; // 备注
	private Byte status; // 状态
	private String operation;// 操作 OPERATION varchar(32) 32 FALSE FALSE FALSE
	private Long operator;// 操作人 OPERATOR bigint FALSE FALSE FALSE
	private Date operationDate;// 操作时间 OPERATION_DATE datetime FALSE FALSE FALSE

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMeterAssetsNo() {
		return meterAssetsNo;
	}

	public void setMeterAssetsNo(String meterAssetsNo) {
		this.meterAssetsNo = meterAssetsNo;
	}

	public String getMadeNo() {
		return madeNo;
	}

	public void setMadeNo(String madeNo) {
		this.madeNo = madeNo;
	}

	public String getFuncKindCode() {
		return funcKindCode;
	}

	public void setFuncKindCode(String funcKindCode) {
		this.funcKindCode = funcKindCode;
	}

	public String getPowerKindCode() {
		return powerKindCode;
	}

	public void setPowerKindCode(String powerKindCode) {
		this.powerKindCode = powerKindCode;
	}

	public Byte getFixedAssetsFlag() {
		return fixedAssetsFlag;
	}

	public void setFixedAssetsFlag(Byte fixedAssetsFlag) {
		this.fixedAssetsFlag = fixedAssetsFlag;
	}

	public String getFacCode() {
		return facCode;
	}

	public void setFacCode(String facCode) {
		this.facCode = facCode;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getRatedVoltCode() {
		return ratedVoltCode;
	}

	public void setRatedVoltCode(String ratedVoltCode) {
		this.ratedVoltCode = ratedVoltCode;
	}

	public String getRatedCurntCode() {
		return ratedCurntCode;
	}

	public void setRatedCurntCode(String ratedCurntCode) {
		this.ratedCurntCode = ratedCurntCode;
	}

	public String getAccuLevelCode() {
		return accuLevelCode;
	}

	public void setAccuLevelCode(String accuLevelCode) {
		this.accuLevelCode = accuLevelCode;
	}

	public String getPhaseLine() {
		return phaseLine;
	}

	public void setPhaseLine(String phaseLine) {
		this.phaseLine = phaseLine;
	}

	public Byte getIsTsMeter() {
		return isTsMeter;
	}

	public void setIsTsMeter(Byte isTsMeter) {
		this.isTsMeter = isTsMeter;
	}

	public String getStructCode() {
		return structCode;
	}

	public void setStructCode(String structCode) {
		this.structCode = structCode;
	}

	public String getMeterConst() {
		return meterConst;
	}

	public void setMeterConst(String meterConst) {
		this.meterConst = meterConst;
	}

	public String getConstUnit() {
		return constUnit;
	}

	public void setConstUnit(String constUnit) {
		this.constUnit = constUnit;
	}

	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public String getMadeStdard() {
		return madeStdard;
	}

	public void setMadeStdard(String madeStdard) {
		this.madeStdard = madeStdard;
	}

	public Byte getAxeStructCode() {
		return axeStructCode;
	}

	public void setAxeStructCode(Byte axeStructCode) {
		this.axeStructCode = axeStructCode;
	}

	public String getMeteryardType() {
		return meteryardType;
	}

	public void setMeteryardType(String meteryardType) {
		this.meteryardType = meteryardType;
	}

	public Byte getNoReturnFlag() {
		return noReturnFlag;
	}

	public void setNoReturnFlag(Byte noReturnFlag) {
		this.noReturnFlag = noReturnFlag;
	}

	public Byte getIsCard() {
		return isCard;
	}

	public void setIsCard(Byte isCard) {
		this.isCard = isCard;
	}

	public Byte getConnectMode() {
		return connectMode;
	}

	public void setConnectMode(Byte connectMode) {
		this.connectMode = connectMode;
	}

	public Date getMadeDate() {
		return madeDate;
	}

	public void setMadeDate(Date madeDate) {
		this.madeDate = madeDate;
	}

	public Date getBayDate() {
		return bayDate;
	}

	public void setBayDate(Date bayDate) {
		this.bayDate = bayDate;
	}

	public Integer getLifeSpan() {
		return lifeSpan;
	}

	public void setLifeSpan(Integer lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public String getManId() {
		return manId;
	}

	public void setManId(String manId) {
		this.manId = manId;
	}

	public Byte getStateFlag() {
		return stateFlag;
	}

	public void setStateFlag(Byte stateFlag) {
		this.stateFlag = stateFlag;
	}

	public Date getStatusChgDate() {
		return statusChgDate;
	}

	public void setStatusChgDate(Date statusChgDate) {
		this.statusChgDate = statusChgDate;
	}

	public String getStatusChgReason() {
		return statusChgReason;
	}

	public void setStatusChgReason(String statusChgReason) {
		this.statusChgReason = statusChgReason;
	}

	public Date getLastDetDate() {
		return lastDetDate;
	}

	public void setLastDetDate(Date lastDetDate) {
		this.lastDetDate = lastDetDate;
	}

	public Integer getDetPeriod() {
		return detPeriod;
	}

	public void setDetPeriod(Integer detPeriod) {
		this.detPeriod = detPeriod;
	}

	public String getRightAttach() {
		return rightAttach;
	}

	public void setRightAttach(String rightAttach) {
		this.rightAttach = rightAttach;
	}

	public String getSimNo() {
		return simNo;
	}

	public void setSimNo(String simNo) {
		this.simNo = simNo;
	}

	public String getNumDigit() {
		return numDigit;
	}

	public void setNumDigit(String numDigit) {
		this.numDigit = numDigit;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

}
