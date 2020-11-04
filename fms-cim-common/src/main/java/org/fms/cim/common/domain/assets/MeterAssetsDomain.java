/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:22:58
 *    Title:com.riozenc.cim.webapp.domain.CustomerDomain.java
 **/
package org.fms.cim.common.domain.assets;

import java.math.BigDecimal;
import java.util.Date;

import org.fms.cim.common.domain.archives.ManagerParamEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.mybatis.MybatisEntity;

/**
 * 电表资产 METER_ASSETS_INFO
 *
 * @author riozenc
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeterAssetsDomain extends ManagerParamEntity implements MybatisEntity {

	@TablePrimaryKey
	private Long id;// ID ID bigint TRUE FALSE TRUE
	private String meterAssetsNo; // 资产编号
	private String madeNo; // 出厂编号
	private String funcKindCode; // 功能分类
	private String powerKindCode; // 功率性质*
	private String fixedAssetsFlag; // 是否固定资产
	private String facCode; // 制造厂家
	private String modelCode; // 型号 *
	private String ratedVoltCode; // 额定电压*
	private String ratedCurntCode; // 标定电流*
	private String accuLevelCode; // 准确度等级*
	private String phaseLine; // 相线
	private String tsFlag; // 分时表标志
	private String structCode; // 结构*
	private String meterConst; // 电表常数
	private String constUnit; // 常数单位
	private Long factor; // 表计倍率
	private Byte madeStdard; // 制造标准
	private Byte axeStructCode; // 轴承结构
	private String meteryardType; // 计度器类型
	private String noReturnFlag; // 有无止逆器
	private String isCard; // 是否卡表
	private String connectMode; // 接通方式
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date madeDate; // 出厂日期
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date bayDate; // 立帐日期
	private Integer lifeSpan; // 使用寿命(月)
	private String manId; // 持有人
	private Byte stateFlag; // 状态标志
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date statusChgDate; // 状态改变时间
	private String statusChgReason; // 状态改变原因
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
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
	private String batchNo; // BATCH_NO 批次
	private String setAddress; // 安装位置
	private String sealNo;

	private Integer assetsNum; //批量生成资产时的个数
	private String functionCode;
	private BigDecimal lastNum;
	private BigDecimal startNum;
	private BigDecimal endNum;
	private Integer calcMon;

	private String userNo;
	private String meterNo;

	
	private String type;// 类型
	private String commAddr1;// 通用地址1
	private String commAddr2;// 通讯地址2
	private String instLoc;// 安装位置
	private String sortCode;// 类别
	private String prepayFlag;// 是否预付费
	private String demandMeterFlag;// 需量表标志
	private Date latestChkDate;// 最近检定日期
	private Integer rotateCycle;// 轮换周期
	private String discardReason;// 报废原因
	private Date descardDate;// 报废日期
	private String curStatusCode;// 当前状态
	private String baudrateCode;// 波特率
	private String meterCloseMode;// 卡表跳闸方式
	private String commProtCode;// 通讯规约
	private String commMode;// 通讯方式
	private String switchStatus;// 开关状态
	private Integer weight;// 排序
	private Long creatorId;// 创建者
	private Long lastModifierId;// 最后修改者
	private String lastModifierTime;// 最后修改时间
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
	
	public String getPowerKindCode() {
		return powerKindCode;
	}
	public void setPowerKindCode(String powerKindCode) {
		this.powerKindCode = powerKindCode;
	}
	public String getFixedAssetsFlag() {
		return fixedAssetsFlag;
	}
	public void setFixedAssetsFlag(String fixedAssetsFlag) {
		this.fixedAssetsFlag = fixedAssetsFlag;
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
	
	public Long getFactor() {
		return factor;
	}
	public void setFactor(Long factor) {
		this.factor = factor;
	}
	public Byte getMadeStdard() {
		return madeStdard;
	}
	public void setMadeStdard(Byte madeStdard) {
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
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getSetAddress() {
		return setAddress;
	}
	public void setSetAddress(String setAddress) {
		this.setAddress = setAddress;
	}
	public String getSealNo() {
		return sealNo;
	}
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}
	public Integer getAssetsNum() {
		return assetsNum;
	}
	public void setAssetsNum(Integer assetsNum) {
		this.assetsNum = assetsNum;
	}
	
	public String getFuncKindCode() {
		return funcKindCode;
	}
	public void setFuncKindCode(String funcKindCode) {
		this.funcKindCode = funcKindCode;
	}
	public String getFacCode() {
		return facCode;
	}
	public void setFacCode(String facCode) {
		this.facCode = facCode;
	}
	public String getTsFlag() {
		return tsFlag;
	}
	public void setTsFlag(String tsFlag) {
		this.tsFlag = tsFlag;
	}
	public String getConstUnit() {
		return constUnit;
	}
	public void setConstUnit(String constUnit) {
		this.constUnit = constUnit;
	}
	public String getNoReturnFlag() {
		return noReturnFlag;
	}
	public void setNoReturnFlag(String noReturnFlag) {
		this.noReturnFlag = noReturnFlag;
	}
	public String getIsCard() {
		return isCard;
	}
	public void setIsCard(String isCard) {
		this.isCard = isCard;
	}
	public String getConnectMode() {
		return connectMode;
	}
	public void setConnectMode(String connectMode) {
		this.connectMode = connectMode;
	}
	public String getRightAttach() {
		return rightAttach;
	}
	public void setRightAttach(String rightAttach) {
		this.rightAttach = rightAttach;
	}
	public String getFunctionCode() {
		return functionCode;
	}
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}
	public BigDecimal getLastNum() {
		return lastNum;
	}
	public void setLastNum(BigDecimal lastNum) {
		this.lastNum = lastNum;
	}
	public BigDecimal getStartNum() {
		return startNum;
	}
	public void setStartNum(BigDecimal startNum) {
		this.startNum = startNum;
	}
	public BigDecimal getEndNum() {
		return endNum;
	}
	public void setEndNum(BigDecimal endNum) {
		this.endNum = endNum;
	}
	public Integer getCalcMon() {
		return calcMon;
	}
	public void setCalcMon(Integer calcMon) {
		this.calcMon = calcMon;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getMeterNo() {
		return meterNo;
	}
	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCommAddr1() {
		return commAddr1;
	}
	public void setCommAddr1(String commAddr1) {
		this.commAddr1 = commAddr1;
	}
	public String getCommAddr2() {
		return commAddr2;
	}
	public void setCommAddr2(String commAddr2) {
		this.commAddr2 = commAddr2;
	}
	public String getInstLoc() {
		return instLoc;
	}
	public void setInstLoc(String instLoc) {
		this.instLoc = instLoc;
	}
	public String getSortCode() {
		return sortCode;
	}
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	public String getPrepayFlag() {
		return prepayFlag;
	}
	public void setPrepayFlag(String prepayFlag) {
		this.prepayFlag = prepayFlag;
	}
	public String getDemandMeterFlag() {
		return demandMeterFlag;
	}
	public void setDemandMeterFlag(String demandMeterFlag) {
		this.demandMeterFlag = demandMeterFlag;
	}
	public Date getLatestChkDate() {
		return latestChkDate;
	}
	public void setLatestChkDate(Date latestChkDate) {
		this.latestChkDate = latestChkDate;
	}
	public Integer getRotateCycle() {
		return rotateCycle;
	}
	public void setRotateCycle(Integer rotateCycle) {
		this.rotateCycle = rotateCycle;
	}
	public String getDiscardReason() {
		return discardReason;
	}
	public void setDiscardReason(String discardReason) {
		this.discardReason = discardReason;
	}
	public Date getDescardDate() {
		return descardDate;
	}
	public void setDescardDate(Date descardDate) {
		this.descardDate = descardDate;
	}
	public String getCurStatusCode() {
		return curStatusCode;
	}
	public void setCurStatusCode(String curStatusCode) {
		this.curStatusCode = curStatusCode;
	}
	public String getBaudrateCode() {
		return baudrateCode;
	}
	public void setBaudrateCode(String baudrateCode) {
		this.baudrateCode = baudrateCode;
	}
	public String getMeterCloseMode() {
		return meterCloseMode;
	}
	public void setMeterCloseMode(String meterCloseMode) {
		this.meterCloseMode = meterCloseMode;
	}
	public String getCommProtCode() {
		return commProtCode;
	}
	public void setCommProtCode(String commProtCode) {
		this.commProtCode = commProtCode;
	}
	public String getCommMode() {
		return commMode;
	}
	public void setCommMode(String commMode) {
		this.commMode = commMode;
	}
	public String getSwitchStatus() {
		return switchStatus;
	}
	public void setSwitchStatus(String switchStatus) {
		this.switchStatus = switchStatus;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public Long getLastModifierId() {
		return lastModifierId;
	}
	public void setLastModifierId(Long lastModifierId) {
		this.lastModifierId = lastModifierId;
	}
	public String getLastModifierTime() {
		return lastModifierTime;
	}
	public void setLastModifierTime(String lastModifierTime) {
		this.lastModifierTime = lastModifierTime;
	}

}
