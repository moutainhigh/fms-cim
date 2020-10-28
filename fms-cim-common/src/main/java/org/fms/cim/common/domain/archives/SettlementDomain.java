/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午6:15:27
 *    Title:com.riozenc.cim.webapp.domain.SettlementDomain.java
 **/
package org.fms.cim.common.domain.archives;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.mybatis.MybatisEntity;

/**
 * 
 * 结算户 SETTLEMENT_INFO
 * 
 * @author riozenc
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SettlementDomain extends ManagerParamEntity implements MybatisEntity {

	@TablePrimaryKey
	private Long id;// ID ID bigint TRUE FALSE TRUE
	private Long customerId;// ID ID bigint TRUE FALSE TRUE
	private String settlementNo;// 结算户编号 SETTLEMENT_NO varchar(16) 16 FALSE FALSE FALSE
	private String settlementName;// 结算人 SETTLEMENT_NAME varchar(64) 64 FALSE FALSE FALSE
	private String settlementPhone;// 结算人电话 SETTLEMENT_PHONE varchar(11) 11 FALSE FALSE FALSE
	private Byte chargeModeType;// 收费方式 CHARGE_MODE_TYPE smallint FALSE FALSE FALSE
	private Byte connectBank;// 联网银行 CONNECT_BANK smallint FALSE FALSE FALSE
	private Integer opendingBank;// 开户银行
	private String bankNo;// 银行卡号 BANK_NO varchar(32) 32 FALSE FALSE FALSE
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createDate;// 创建时间 CREATE_DATE datetime FALSE FALSE FALSE
	private String remark;// 备注 REMARK varchar(256) 256 FALSE FALSE FALSE
	private Byte status;// 状态 STATUS smallint FALSE FALSE FALSE
	private String accountName; //对公账户名称
	private String accountNo;	//对公户号
	private String cuscc;		//统一社会信用代码
	private Long businessPlaceCode;		//结算区域 BUSINESS_PLACE_CODE
	private Byte invoiceType; // 发票类型
	private Byte invoicePrintType;//托收户发票打印方式
	
	private String address;
	

	
	/*--------------------------------------------------*/
	private Long settlementId;			//	结算户ID	SETTLEMENT_ID	bigint		
	private Long meterId;			//	计量点ID	METER_ID	bigint		
	private Byte deductionOrder;			//	扣减顺序	DEDUCTION_ORDER	int		
	private String customerNo;
	private String customerName;
	private List<Long> settlementIds;
	private List<String> settlementNos;
	private Byte unChargeModeType;
	private List<Long> businessPlaceCodes;
	private List<Long> meterIds;
	
	

	public List<Long> getBusinessPlaceCodes() {
		return businessPlaceCodes;
	}

	public void setBusinessPlaceCodes(List<Long> businessPlaceCodes) {
		this.businessPlaceCodes = businessPlaceCodes;
	}

	public Byte getUnChargeModeType() {
		return unChargeModeType;
	}

	public void setUnChargeModeType(Byte unChargeModeType) {
		this.unChargeModeType = unChargeModeType;
	}

	public List<String> getSettlementNos() {
		return settlementNos;
	}

	public void setSettlementNos(List<String> settlementNos) {
		this.settlementNos = settlementNos;
	}

	public List<Long> getSettlementIds() {
		return settlementIds;
	}

	public void setSettlementIds(List<Long> settlementIds) {
		this.settlementIds = settlementIds;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getCuscc() {
		return cuscc;
	}

	public void setCuscc(String cuscc) {
		this.cuscc = cuscc;
	}

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

	public Byte getDeductionOrder() {
		return deductionOrder;
	}

	public void setDeductionOrder(Byte deductionOrder) {
		this.deductionOrder = deductionOrder;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSettlementNo() {
		return settlementNo;
	}

	public void setSettlementNo(String settlementNo) {
		this.settlementNo = settlementNo;
	}

	public String getSettlementName() {
		return settlementName;
	}

	public void setSettlementName(String settlementName) {
		this.settlementName = settlementName;
	}

	public String getSettlementPhone() {
		return settlementPhone;
	}

	public void setSettlementPhone(String settlementPhone) {
		this.settlementPhone = settlementPhone;
	}

	public Byte getChargeModeType() {
		return chargeModeType;
	}

	public void setChargeModeType(Byte chargeModeType) {
		this.chargeModeType = chargeModeType;
	}

	public Byte getConnectBank() {
		return connectBank;
	}

	public void setConnectBank(Byte connectBank) {
		this.connectBank = connectBank;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
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

	public Long getBusinessPlaceCode() {
		return businessPlaceCode;
	}

	public void setBusinessPlaceCode(Long businessPlaceCode) {
		this.businessPlaceCode = businessPlaceCode;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Byte getInvoicePrintType() {
		return invoicePrintType;
	}

	public void setInvoicePrintType(Byte invoicePrintType) {
		this.invoicePrintType = invoicePrintType;
	}

	public Byte getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Byte invoiceType) {
		this.invoiceType = invoiceType;
	}

	public Integer getOpendingBank() {
		return opendingBank;
	}

	public void setOpendingBank(Integer opendingBank) {
		this.opendingBank = opendingBank;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Long> getMeterIds() {
		return meterIds;
	}

	public void setMeterIds(List<Long> meterIds) {
		this.meterIds = meterIds;
	}
}
