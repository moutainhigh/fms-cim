/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:22:58
 *    Title:com.riozenc.cim.webapp.domain.CustomerDomain.java
 **/
package org.fms.cim.common.domain.assets;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.fms.cim.common.domain.archives.ManagerParamEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.mybatis.MybatisEntity;

/**
 * 终端设备 A_TMNL
 *
 * @author riozenc
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ATmnlDomain extends ManagerParamEntity implements MybatisEntity {

	@TablePrimaryKey
	private Long id;// ID ID bigint TRUE FALSE TRUE
	
	
	
	private String code; // 出厂编号
	private String name; // 名称
	private String type; // 类型
	private String assetNo; // 资产编号
	private String terminalAddr; // 终端地址码
	private Integer protocolCode; // 采用通讯规约
	private String modelCode; // 型号
	private String lotId; // 批次
	private String manufacturer; // 制造单位
	private String collMode; // 采集方式
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date madeDate; // 出厂日期
	private Long businessPlaceCode; // 管理单位
	private Long depeId; // 管理部门
	private Long removeOperatorNo; // 拆回人
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date rmvDate; // 停运日期
	private Long installerNo; // 安装人
	private String instLoc; // 安装位置
	private Long checkerNo; // 校验人员
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date instDate; // 发出日期
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date chkDate; // 退回日期
	private Long descardOperatorNo; // 报废人
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date descardDate; // 报废日期
	private String curStatusCode; // 当前状态
	private Long personRespNo; // 责任人
	private String tel; // 电话号码
	private Integer lifeTime; // 使用年限
	private String remark; // 备注
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date deliverDate; // 投运时间
	
	private Integer weight; // 排序序号
	private Long creatorId; // 创建者
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createDate; // 创建日期
	private Long lastModifierId; // 最后修改者
	private String lastModifierTime; // 最后修改时间
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAssetNo() {
		return assetNo;
	}
	public void setAssetNo(String assetNo) {
		this.assetNo = assetNo;
	}
	public String getTerminalAddr() {
		return terminalAddr;
	}
	public void setTerminalAddr(String terminalAddr) {
		this.terminalAddr = terminalAddr;
	}
	public Integer getProtocolCode() {
		return protocolCode;
	}
	public void setProtocolCode(Integer protocolCode) {
		this.protocolCode = protocolCode;
	}
	public String getModelCode() {
		return modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	public String getLotId() {
		return lotId;
	}
	public void setLotId(String lotId) {
		this.lotId = lotId;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCollMode() {
		return collMode;
	}
	public void setCollMode(String collMode) {
		this.collMode = collMode;
	}
	public Date getMadeDate() {
		return madeDate;
	}
	public void setMadeDate(Date madeDate) {
		this.madeDate = madeDate;
	}
	
	public Long getBusinessPlaceCode() {
		return businessPlaceCode;
	}
	public void setBusinessPlaceCode(Long businessPlaceCode) {
		this.businessPlaceCode = businessPlaceCode;
	}
	public Long getDepeId() {
		return depeId;
	}
	public void setDepeId(Long depeId) {
		this.depeId = depeId;
	}
	public Long getRemoveOperatorNo() {
		return removeOperatorNo;
	}
	public void setRemoveOperatorNo(Long removeOperatorNo) {
		this.removeOperatorNo = removeOperatorNo;
	}
	public Date getRmvDate() {
		return rmvDate;
	}
	public void setRmvDate(Date rmvDate) {
		this.rmvDate = rmvDate;
	}
	public Long getInstallerNo() {
		return installerNo;
	}
	public void setInstallerNo(Long installerNo) {
		this.installerNo = installerNo;
	}
	public String getInstLoc() {
		return instLoc;
	}
	public void setInstLoc(String instLoc) {
		this.instLoc = instLoc;
	}
	public Long getCheckerNo() {
		return checkerNo;
	}
	public void setCheckerNo(Long checkerNo) {
		this.checkerNo = checkerNo;
	}
	public Date getInstDate() {
		return instDate;
	}
	public void setInstDate(Date instDate) {
		this.instDate = instDate;
	}
	public Date getChkDate() {
		return chkDate;
	}
	public void setChkDate(Date chkDate) {
		this.chkDate = chkDate;
	}
	public Long getDescardOperatorNo() {
		return descardOperatorNo;
	}
	public void setDescardOperatorNo(Long descardOperatorNo) {
		this.descardOperatorNo = descardOperatorNo;
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
	public Long getPersonRespNo() {
		return personRespNo;
	}
	public void setPersonRespNo(Long personRespNo) {
		this.personRespNo = personRespNo;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getLifeTime() {
		return lifeTime;
	}
	public void setLifeTime(Integer lifeTime) {
		this.lifeTime = lifeTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
