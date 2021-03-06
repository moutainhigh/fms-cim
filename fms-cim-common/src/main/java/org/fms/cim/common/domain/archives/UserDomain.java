/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午5:40:37
 *    Title:com.riozenc.cim.webapp.domain.UserDomain.java
 **/
package org.fms.cim.common.domain.archives;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.mybatis.MybatisEntity;

/**
 * 用电户 USER_INFO
 *
 * @author riozenc
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDomain extends ManagerParamEntity implements MybatisEntity {

	@TablePrimaryKey
	private Long id;			// ID ID bigint
	private Long customerId;	// 对应 CUSTOMER_INFO中的ID 客户ID
	private String userNo;		// 客户编号 USER_NO varchar(16)
	private String userName;	// 客户名称 USER_NAME varchar(64)
	private String address;		// 用电地址 ADDRESS varchar(64)
	private Long businessPlaceCode;// 营业区域 BUSINESS_PLACE_CODE varchar(8)
	private Long writeSectId;	// 抄表区段 WRITE_SECT_ID varchar(8)
	private BigDecimal allCapacity;// 合同容量 ALL_CAPACITY decimal(10,2)
	private String loadType;// 负荷类别 LOAD_TYPE smallint FALSE FALSE FALSE
	private Byte isHighType;// 高可靠性标志 IS_HIGH_TYPE smallint FALSE FALSE FALSE
	private String tempType;// 临时用电标志 TEMP_TYPE smallint FALSE FALSE FALSE
	private String creditRankType;// 信誉等级 CREDIT_RANK_TYPE smallint FALSE FALSE FALSE
	private String writeType;// 抄表周期 WRITE_TYPE smallint FALSE FALSE FALSE
	private String userType;// 分类标识 USER_TYPE smallint FALSE FALSE FALSE
	private String elecType;// 用电类别 ELEC_TYPE_TYPE smallint FALSE FALSE FALSE
	private String voltLevelType;// 电压等级 VOLT_LEVEL_TYPE smallint FALSE FALSE FALSE
	private Long tgId;// 所属台区
	private Long guid; // 原系统用户ID
	private String meterBoxNumber; // 表箱号 METER_BOX_NUMBER
	private Date createDate;// 创建日期 CREATE_DATE datetime FALSE FALSE FALSE
	private String remark;// 备注 REMARK varchar(256) 256 FALSE FALSE FALSE
	private String status;// 客户状态 STATUS smallint
	private String writeSectNo; // 抄表段号
	private String writeSectName;// 抄表段名称
	private Byte sectUserType;// 区段用户类型 SECT_USER_TYPE smallint FALSE FALSE FALSE
	private String customerNo;
	private String customerName;
	private String tgName; // 台区名称
	private String lineCode;
	private String lineName;//线路名称LINE_NAME 
	private Integer startMon;
	private Integer endMon;
	private Date endDate;
	private List<Long> customerIds;
	private String type;//类型TYPE varchar(8) 
	private Long lineId;//线路编码LINE_ID bigint 
	private String rrioCode;//重要性等级RRIO_CODE varchar(8) 
	private String transferCode;//转供标志TRANSFER_CODE varchar(8) 
	private String linkMan;//联系人LINK_MAN varchar(32) 
	private String tel1;//联系电话1TEL1 varchar(256) 
	private String tel2;//联系电话2TEL2 varchar(256) 
	private String vipCode;//重点用户VIP_CODE varchar(8) 
	private Integer weight;//排序WEIGHT int
	private Long creatorId;//创建者CREATOR_ID bigint 
	private Long lastModifierId;//最后修改者LAST_MODIFIER_ID bigint 
	private String lastModifierTime;//最后修改时间LAST_MODIFIER_TIME varchar(20) 
	
	
	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public String getRrioCode() {
		return rrioCode;
	}

	public void setRrioCode(String rrioCode) {
		this.rrioCode = rrioCode;
	}

	public String getTransferCode() {
		return transferCode;
	}

	public void setTransferCode(String transferCode) {
		this.transferCode = transferCode;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}


	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getVipCode() {
		return vipCode;
	}

	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
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

	public String getTgName() {
		return tgName;
	}

	public void setTgName(String tgName) {
		this.tgName = tgName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getBusinessPlaceCode() {
		return businessPlaceCode;
	}

	public void setBusinessPlaceCode(Long businessPlaceCode) {
		this.businessPlaceCode = businessPlaceCode;
	}

	public Long getWriteSectId() {
		return writeSectId;
	}

	public void setWriteSectId(Long writeSectId) {
		this.writeSectId = writeSectId;
	}

	public BigDecimal getAllCapacity() {
		return allCapacity;
	}

	public void setAllCapacity(BigDecimal allCapacity) {
		this.allCapacity = allCapacity;
	}

	public Byte getIsHighType() {
		return isHighType;
	}

	public void setIsHighType(Byte isHighType) {
		this.isHighType = isHighType;
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
	
	
	public String getLoadType() {
		return loadType;
	}

	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}

	public String getTempType() {
		return tempType;
	}

	public void setTempType(String tempType) {
		this.tempType = tempType;
	}

	public String getCreditRankType() {
		return creditRankType;
	}

	public void setCreditRankType(String creditRankType) {
		this.creditRankType = creditRankType;
	}

	public String getWriteType() {
		return writeType;
	}

	public void setWriteType(String writeType) {
		this.writeType = writeType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getElecType() {
		return elecType;
	}

	public void setElecType(String elecType) {
		this.elecType = elecType;
	}

	public String getVoltLevelType() {
		return voltLevelType;
	}

	public void setVoltLevelType(String voltLevelType) {
		this.voltLevelType = voltLevelType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getMeterBoxNumber() {
		return meterBoxNumber;
	}

	public void setMeterBoxNumber(String meterBoxNumber) {
		this.meterBoxNumber = meterBoxNumber;
	}

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public Long getTgId() {
		return tgId;
	}

	public void setTgId(Long tgId) {
		this.tgId = tgId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getWriteSectNo() {
		return writeSectNo;
	}

	public void setWriteSectNo(String writeSectNo) {
		this.writeSectNo = writeSectNo;
	}

	public String getWriteSectName() {
		return writeSectName;
	}

	public void setWriteSectName(String writeSectName) {
		this.writeSectName = writeSectName;
	}

	public Byte getSectUserType() {
		return sectUserType;
	}

	public void setSectUserType(Byte sectUserType) {
		this.sectUserType = sectUserType;
	}

	public String getLineCode() {
		return lineCode;
	}

	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}

	public Integer getStartMon() {
		return startMon;
	}

	public void setStartMon(Integer startMon) {
		this.startMon = startMon;
	}

	public Integer getEndMon() {
		return endMon;
	}

	public void setEndMon(Integer endMon) {
		this.endMon = endMon;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Long> getCustomerIds() {
		return customerIds;
	}

	public void setCustomerIds(List<Long> customerIds) {
		this.customerIds = customerIds;
	}
}
