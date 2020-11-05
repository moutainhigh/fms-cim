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
 * SIM卡档案  P_SIM_CARD
 *
 * @author riozenc
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PSimCardDomain extends ManagerParamEntity implements MybatisEntity {
	
	private String cardNo;// SIM卡号
	
	private String gprsCode;
	private String cardType;
	private String telecomsOperator;
	private String ip;
	private String apn;
	private Long orgNo;
	private Date runDate;
	private Date stopDate;
	private String statusCode;
	private String lotId;
	private Long collarPerson;
	private Long collarOrgNo;
	private Date sendDate;
	private Date returnDate;
	private String remark;
	private Integer dispSn;
	private Date savedatetime;
	
	
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getGprsCode() {
		return gprsCode;
	}
	public void setGprsCode(String gprsCode) {
		this.gprsCode = gprsCode;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getTelecomsOperator() {
		return telecomsOperator;
	}
	public void setTelecomsOperator(String telecomsOperator) {
		this.telecomsOperator = telecomsOperator;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getApn() {
		return apn;
	}
	public void setApn(String apn) {
		this.apn = apn;
	}
	public Long getOrgNo() {
		return orgNo;
	}
	public void setOrgNo(Long orgNo) {
		this.orgNo = orgNo;
	}
	public Date getRunDate() {
		return runDate;
	}
	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}
	public Date getStopDate() {
		return stopDate;
	}
	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getLotId() {
		return lotId;
	}
	public void setLotId(String lotId) {
		this.lotId = lotId;
	}
	public Long getCollarPerson() {
		return collarPerson;
	}
	public void setCollarPerson(Long collarPerson) {
		this.collarPerson = collarPerson;
	}
	public Long getCollarOrgNo() {
		return collarOrgNo;
	}
	public void setCollarOrgNo(Long collarOrgNo) {
		this.collarOrgNo = collarOrgNo;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getDispSn() {
		return dispSn;
	}
	public void setDispSn(Integer dispSn) {
		this.dispSn = dispSn;
	}
	public Date getSavedatetime() {
		return savedatetime;
	}
	public void setSavedatetime(Date savedatetime) {
		this.savedatetime = savedatetime;
	}
	
	
}
