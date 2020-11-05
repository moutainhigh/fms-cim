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
	private Byte ctCurntCode; // CT电流
	private String ctVoltCode; // CT电压
	private Byte ptCurntCode; // PT电流
	private String ptVoltCode; // PT电压
	private String ratedCtCode; // CT变比
	private String ratedPtCode; // PT变比
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date madeDate; // 出厂日期
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
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
	public Byte getCtCurntCode() {
		return ctCurntCode;
	}
	public void setCtCurntCode(Byte ctCurntCode) {
		this.ctCurntCode = ctCurntCode;
	}
	public String getCtVoltCode() {
		return ctVoltCode;
	}
	public void setCtVoltCode(String ctVoltCode) {
		this.ctVoltCode = ctVoltCode;
	}
	public Byte getPtCurntCode() {
		return ptCurntCode;
	}
	public void setPtCurntCode(Byte ptCurntCode) {
		this.ptCurntCode = ptCurntCode;
	}
	public String getPtVoltCode() {
		return ptVoltCode;
	}
	public void setPtVoltCode(String ptVoltCode) {
		this.ptVoltCode = ptVoltCode;
	}
	public String getRatedCtCode() {
		return ratedCtCode;
	}
	public void setRatedCtCode(String ratedCtCode) {
		this.ratedCtCode = ratedCtCode;
	}
	public String getRatedPtCode() {
		return ratedPtCode;
	}
	public void setRatedPtCode(String ratedPtCode) {
		this.ratedPtCode = ratedPtCode;
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
