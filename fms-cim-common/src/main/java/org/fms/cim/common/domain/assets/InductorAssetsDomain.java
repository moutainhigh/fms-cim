/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:22:58
 *    Title:com.riozenc.cim.webapp.domain.CustomerDomain.java
 **/
package org.fms.cim.common.domain.assets;

import java.util.Date;

import org.fms.cim.common.domain.archives.ManagerParamEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.mybatis.MybatisEntity;

/**
 * 互感器资产 INDUCTOR_ASSETS_INFO
 *
 * @author riozenc
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InductorAssetsDomain extends ManagerParamEntity implements MybatisEntity {

	@TablePrimaryKey
	private Long id;// ID ID bigint TRUE FALSE TRUE
	private String inductorAssetsNo; // 资产编号
	private String inductorType; // 互感器类型
	private Long turns;	// 穿心匝数
	private Byte taCurntCode; // CT电流
	private String taVoltCode; // CT电压
	private Byte tvCurntCode; // PT电流
	private String tvVoltCode; // PT电压
	private String ratedTaCode; // CT变比
	private String ratedTvCode; // PT变比
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date madeDate; // 出厂日期
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date lastDetDate; // 上次检定日期
	private Integer detPeriod; // 检定周期(月)
	private Integer lifeSpan; // 使用寿命(月)
	private String accuLevelCode; // CT准确等级
	private String ptAccuLevelCode; // PT准确等级
	private Long deptId;	//部门id
	private Date createDate; // 创建时间
	private String remark; // 备注
	private String status; // 状态
	private String batchNo; // BATCH_NO 批次
	private String rightAttach; // 产权归属 RIGHT_ATTACH 
	private String manID; // 持有人MAN_ID 
	private String madeNo; //出厂编号 
	private Byte modelCode; // 型号 MODEL_CODE
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInductorAssetsNo() {
		return inductorAssetsNo;
	}
	public void setInductorAssetsNo(String inductorAssetsNo) {
		this.inductorAssetsNo = inductorAssetsNo;
	}
	public String getInductorType() {
		return inductorType;
	}
	public void setInductorType(String inductorType) {
		this.inductorType = inductorType;
	}
	public Long getTurns() {
		return turns;
	}
	public void setTurns(Long turns) {
		this.turns = turns;
	}
	
	public Byte getTaCurntCode() {
		return taCurntCode;
	}
	public void setTaCurntCode(Byte taCurntCode) {
		this.taCurntCode = taCurntCode;
	}
	public String getTaVoltCode() {
		return taVoltCode;
	}
	public void setTaVoltCode(String taVoltCode) {
		this.taVoltCode = taVoltCode;
	}
	public Byte getTvCurntCode() {
		return tvCurntCode;
	}
	public void setTvCurntCode(Byte tvCurntCode) {
		this.tvCurntCode = tvCurntCode;
	}
	public String getTvVoltCode() {
		return tvVoltCode;
	}
	public void setTvVoltCode(String tvVoltCode) {
		this.tvVoltCode = tvVoltCode;
	}
	public String getRatedTaCode() {
		return ratedTaCode;
	}
	public void setRatedTaCode(String ratedTaCode) {
		this.ratedTaCode = ratedTaCode;
	}
	public String getRatedTvCode() {
		return ratedTvCode;
	}
	public void setRatedTvCode(String ratedTvCode) {
		this.ratedTvCode = ratedTvCode;
	}
	public Date getMadeDate() {
		return madeDate;
	}
	public void setMadeDate(Date madeDate) {
		this.madeDate = madeDate;
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
	public Integer getLifeSpan() {
		return lifeSpan;
	}
	public void setLifeSpan(Integer lifeSpan) {
		this.lifeSpan = lifeSpan;
	}
	public String getAccuLevelCode() {
		return accuLevelCode;
	}
	public void setAccuLevelCode(String accuLevelCode) {
		this.accuLevelCode = accuLevelCode;
	}
	public String getPtAccuLevelCode() {
		return ptAccuLevelCode;
	}
	public void setPtAccuLevelCode(String ptAccuLevelCode) {
		this.ptAccuLevelCode = ptAccuLevelCode;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getRightAttach() {
		return rightAttach;
	}
	public void setRightAttach(String rightAttach) {
		this.rightAttach = rightAttach;
	}
	public String getManID() {
		return manID;
	}
	public void setManID(String manID) {
		this.manID = manID;
	}
	public String getMadeNo() {
		return madeNo;
	}
	public void setMadeNo(String madeNo) {
		this.madeNo = madeNo;
	}
	public Byte getModelCode() {
		return modelCode;
	}
	public void setModelCode(Byte modelCode) {
		this.modelCode = modelCode;
	}


	

}
