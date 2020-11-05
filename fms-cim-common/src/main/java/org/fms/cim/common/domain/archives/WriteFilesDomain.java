package org.fms.cim.common.domain.archives;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.json.annotation.IgnorRead;
import com.riozenc.titanTool.mybatis.MybatisEntity;

//抄表单

@JsonIgnoreProperties(ignoreUnknown = true)
public class WriteFilesDomain extends ManagerParamEntity implements MybatisEntity {
	@TablePrimaryKey
	private String id;
	// 计量点ID
	private Long meterId;
	private String meterNo;
	private String madeNo;// 电能表表号
	private Long meterAssetsId;// 电能表ID
	// 月份
	private Integer mon;
	// 初始化时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date initDate;// 初始化时间 INIT_DATE datetime FALSE FALSE FALSE
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date writeDate;// 抄表日期 WRITE_DATE datetime FALSE FALSE FALSE
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastWriteDate;// 上次抄表日期 LAST_WRITE_DATE datetime FALSE FALSE FALSE
	private Byte sn;// 本月次数 SN smallint FALSE FALSE FALSE
	private Byte writeFlag;// 抄表标志 WRITE_FLAG smallint FALSE FALSE FALSE
	private Byte writeMethod;// 抄表方式 WRITE_METHOD smallint FALSE FALSE FALSE
	private Byte timeSeg;// 时段 TIME_SEG smallint FALSE FALSE FALSE
	private String functionCode;// 功能代码
	private String powerDirection;// 功率方向
	private BigDecimal startNum;// 起码 START_NUM decimal(12,2) 12 2 FALSE FALSE FALSE
	private BigDecimal endNum;// 止码 END_NUM decimal(12,2) 12 2 FALSE FALSE FALSE
	private BigDecimal diffNum;// 度差 DIFF_NUM decimal(12,2) 12 2 FALSE FALSE FALSE
	private BigDecimal writePower;// 抄见电量 WRITE_POWER decimal(12,2) 12 2 FALSE FALSE FALSE
	private BigDecimal chgPower;// 换表电量 CHG_POWER decimal(12,2) 12 2 FALSE FALSE FALSE
	private BigDecimal addPower;// 增减电量 ADD_POWER decimal(12,2) 12 2 FALSE FALSE FALSE
	// 录入人
	private String inputMan;
//-------------------------------以下字段用于页面查询传值查询，不计入数据库---------------------------------
	private String userNo;
	private Long writeSectionId;// 所属抄表区段
	private Long tgId; // 所属台区 TG_ID bigint
	private Long lineId; // 所属线路 LINE_ID bigint
	private Long subsId; // 所属厂站 SUBS_ID bigint
	private Long userId; // 所属用户 USER_ID bigint

	private String userName;
	private String address;
	@IgnorRead
	private Integer[] writeSectionIds;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getMeterId() {
		return meterId;
	}

	public void setMeterId(Long meterId) {
		this.meterId = meterId;
	}

	public Integer getMon() {
		return mon;
	}

	public void setMon(Integer mon) {
		this.mon = mon;
	}

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Date getLastWriteDate() {
		return lastWriteDate;
	}

	public void setLastWriteDate(Date lastWriteDate) {
		this.lastWriteDate = lastWriteDate;
	}

	public Byte getSn() {
		return sn;
	}

	public void setSn(Byte sn) {
		this.sn = sn;
	}

	public Byte getWriteFlag() {
		return writeFlag;
	}

	public void setWriteFlag(Byte writeFlag) {
		this.writeFlag = writeFlag;
	}

	public Byte getWriteMethod() {
		return writeMethod;
	}

	public void setWriteMethod(Byte writeMethod) {
		this.writeMethod = writeMethod;
	}

	public Byte getTimeSeg() {
		return timeSeg;
	}

	public void setTimeSeg(Byte timeSeg) {
		this.timeSeg = timeSeg;
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

	public BigDecimal getDiffNum() {
		return diffNum;
	}

	public void setDiffNum(BigDecimal diffNum) {
		this.diffNum = diffNum;
	}

	public BigDecimal getWritePower() {
		return writePower;
	}

	public void setWritePower(BigDecimal writePower) {
		this.writePower = writePower;
	}

	public BigDecimal getChgPower() {
		return chgPower;
	}

	public void setChgPower(BigDecimal chgPower) {
		this.chgPower = chgPower;
	}

	public BigDecimal getAddPower() {
		return addPower;
	}

	public void setAddPower(BigDecimal addPower) {
		this.addPower = addPower;
	}

	public String getInputMan() {
		return inputMan;
	}

	public void setInputMan(String inputMan) {
		this.inputMan = inputMan;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public Long getWriteSectionId() {
		return writeSectionId;
	}

	public void setWriteSectionId(Long writeSectionId) {
		this.writeSectionId = writeSectionId;
	}

	public Long getTgId() {
		return tgId;
	}

	public void setTgId(Long tgId) {
		this.tgId = tgId;
	}

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public Long getSubsId() {
		return subsId;
	}

	public void setSubsId(Long subsId) {
		this.subsId = subsId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Integer[] getWriteSectionIds() {
		return writeSectionIds;
	}

	public void setWriteSectionIds(Integer[] writeSectionIds) {
		this.writeSectionIds = writeSectionIds;
	}

	public String getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	public String getMadeNo() {
		return madeNo;
	}

	public void setMadeNo(String madeNo) {
		this.madeNo = madeNo;
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

	public Long getMeterAssetsId() {
		return meterAssetsId;
	}

	public void setMeterAssetsId(Long meterAssetsId) {
		this.meterAssetsId = meterAssetsId;
	}

}
