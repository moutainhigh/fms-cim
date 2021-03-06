/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午6:15:27
 *    Title:com.riozenc.cim.webapp.domain.SettlementDomain.java
 **/
package org.fms.cim.common.domain.archives;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.mybatis.MybatisEntity;

/**
 *
 * 结算户与计量点关系表SETTLEMENT_METER_REL
 *
 * @author riozenc
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SettlementMeterRelDomain extends ManagerParamEntity implements MybatisEntity {

	@TablePrimaryKey
	private Long id;// ID ID bigint TRUE FALSE TRUE
	private Long settlementId; // 结算户ID SETTLEMENT_ID bigint
	private Long meterId; // 计量点ID METER_ID bigint
	private String meterName; // 计量点名称
	private String meterNo; // 计量点编号
	private String deductionOrder; // 扣减顺序 DEDUCTION_ORDER int
	private Date createDate;// 创建时间 CREATE_DATE datetime FALSE FALSE FALSE
	private String remark;// 备注 REMARK varchar(256) 256 FALSE FALSE FALSE
	private String status;// 状态 STATUS smallint FALSE FALSE FALSE
	private String mpType; // 计量点类型 1电表 2水表 3燃气表 4住户
	/*--------------------------以下为非数据库字段-----------------------------------------*/
	private String voltLevelType; // 计量点电压
	private String setAddress; // 安装地点
	private Long customerId;
	private BigDecimal balance;// 锁定余额

	public Long getSettlementId() {
		return settlementId;
	}

	public void setSettlementId(Long settlementId) {
		this.settlementId = settlementId;
	}

	public Long getMeterId() {
		return meterId;
	}

	public void setMeterId(Long meterId) {
		this.meterId = meterId;
	}

	public String getMeterName() {
		return meterName;
	}

	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}

	public String getDeductionOrder() {
		return deductionOrder;
	}

	public void setDeductionOrder(String deductionOrder) {
		this.deductionOrder = deductionOrder;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	public String getSetAddress() {
		return setAddress;
	}

	public void setSetAddress(String setAddress) {
		this.setAddress = setAddress;
	}

	public String getVoltLevelType() {
		return voltLevelType;
	}

	public void setVoltLevelType(String voltLevelType) {
		this.voltLevelType = voltLevelType;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getMpType() {
		return mpType;
	}

	public void setMpType(String mpType) {
		this.mpType = mpType;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
