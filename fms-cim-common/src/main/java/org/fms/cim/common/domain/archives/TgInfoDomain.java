package org.fms.cim.common.domain.archives;

import java.util.Date;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import org.fms.cim.common.vo.uas.TgInfoVO;

/**
 * 台区	TG_INFO
 *
 * @author riozenc
 *
 */
public class TgInfoDomain extends ManagerParamEntity implements MybatisEntity {

	@TablePrimaryKey
	private Long id;    //台区标识
	private String tgName;    //名称
	private String status;//是否可用
	private String shortName;    //拼音简写
	private String tgNo;    //编码
	private String instAddr;    //台区位置
	private String orgNo;    //
	private String tgCap;    //容量（为可并列运行的变压器容量之和）
	private String isPubTrans;    //台区类型（标准编码：1.43变压器类型）
	private Long userId;    //大用户编码（用于专变台区）
	private Integer poweroffCheckid;    //停电判定条件ID
	private String vipCode;    //重点用户
	private Integer settlementDate;    //结算例日
	private String mrSectNo;    //抄表段编号
	private String mrMan;    //抄表员
	private String runStatusCode;    //运行状态（运行、停用、拆除）
	private String guid;    //GUID
	private Long businessPlaceCode;    //管理单位
	private Integer dispSn;    //显示顺序
	private Date createDate;    //创建时间
	private Long lineId;    //所属线路
	private String monitorFlag;    //是否监测
	private String areaType;    //地区属性
	private String dataId;//接口ID


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTgName() {
		return tgName;
	}

	public void setTgName(String tgName) {
		this.tgName = tgName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getTgNo() {
		return tgNo;
	}

	public void setTgNo(String tgNo) {
		this.tgNo = tgNo;
	}

	public String getInstAddr() {
		return instAddr;
	}

	public void setInstAddr(String instAddr) {
		this.instAddr = instAddr;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getTgCap() {
		return tgCap;
	}

	public void setTgCap(String tgCap) {
		this.tgCap = tgCap;
	}

	public String getIsPubTrans() {
		return isPubTrans;
	}

	public void setIsPubTrans(String isPubTrans) {
		this.isPubTrans = isPubTrans;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getPoweroffCheckid() {
		return poweroffCheckid;
	}

	public void setPoweroffCheckid(Integer poweroffCheckid) {
		this.poweroffCheckid = poweroffCheckid;
	}

	public String getVipCode() {
		return vipCode;
	}

	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}

	public Integer getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Integer settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getMrSectNo() {
		return mrSectNo;
	}

	public void setMrSectNo(String mrSectNo) {
		this.mrSectNo = mrSectNo;
	}

	public String getMrMan() {
		return mrMan;
	}

	public void setMrMan(String mrMan) {
		this.mrMan = mrMan;
	}

	public String getRunStatusCode() {
		return runStatusCode;
	}

	public void setRunStatusCode(String runStatusCode) {
		this.runStatusCode = runStatusCode;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Long getBusinessPlaceCode() {
		return businessPlaceCode;
	}

	public void setBusinessPlaceCode(Long businessPlaceCode) {
		this.businessPlaceCode = businessPlaceCode;
	}

	public Integer getDispSn() {
		return dispSn;
	}

	public void setDispSn(Integer dispSn) {
		this.dispSn = dispSn;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public String getMonitorFlag() {
		return monitorFlag;
	}

	public void setMonitorFlag(String monitorFlag) {
		this.monitorFlag = monitorFlag;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataID) {
		this.dataId = dataID;
	}

	public TgInfoVO domain2VO() {
		TgInfoVO tgInfoVO = ReflectUtil.cast(this, TgInfoVO.class);
		return tgInfoVO;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
