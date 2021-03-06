package org.fms.cim.common.domain.archives;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.riozenc.titanTool.mybatis.MybatisEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BatchAddUserDomain extends ManagerParamEntity implements MybatisEntity{

    //	@ExcelProperty(value = "序号", index = 0)
    private Integer sn;
    
    //	@ExcelProperty(value = "用电地址", index = 2)
    private String address;

    //	@ExcelProperty(value = "用户名称", index = 3)
    private String userName;

    //	@ExcelProperty(value = "电话号码", index = 4)
    private String phoneNo;

   // @ExcelProperty(value = "用电分类", index = 5)
    private String elecType;

 //   @ExcelProperty(value = "抄表区段", index = 6)
    private String writeSectNo;

  //  @ExcelProperty(value = "变压器编号", index = 8)
    private String transformerNo;

//   @ExcelProperty(value = "行业用电分类", index = 10)
    private String tradeType;

//    @ExcelProperty(value = "目录电价", index = 12)
    private String priceType;
    
 //   @ExcelProperty(value = "父计量点号", index = 13)
    private String pMeterNo;
    private Long pMeterId;

  //  @ExcelProperty(value = "关系类型", index = 14)
    private Byte meterRelationType;
    
 //   @ExcelProperty(value = "关系值", index = 15)
    private BigDecimal meterRelationValue;
    
 //   @ExcelProperty(value = "身份证号", index = 16)
    private String cardNo;
    
 //   @ExcelProperty(value = "出厂编号", index = 17)
    private String madeNo;
    
 //   @ExcelProperty(value = "电表厂家", index = 18)
    private String facCode;
    
 //   @ExcelProperty(value = "型号", index = 19)
    private String modelCode;
    
 //   @ExcelProperty(value = "标定电流", index = 20)
    private String ratedCurntCode;
    
  //  @ExcelProperty(value = "表码位数", index = 21)
    private String numDigit;

 //   @ExcelProperty(value = "相线", index = 22)
    private Byte phaseLine;
    
 //   @ExcelProperty(value = "额定电压", index = 23)
    private String ratedVoltCode;

  //  @ExcelProperty(value = "分时表标志", index = 25)
    private Byte tsFlag;
    
    private Byte userType;//用电类别 


	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	

	public String getWriteSectNo() {
		return writeSectNo;
	}

	public void setWriteSectNo(String writeSectNo) {
		this.writeSectNo = writeSectNo;
	}

	public String getTransformerNo() {
		return transformerNo;
	}

	public void setTransformerNo(String transformerNo) {
		this.transformerNo = transformerNo;
	}


	

	

	public String getElecType() {
		return elecType;
	}

	public void setElecType(String elecType) {
		this.elecType = elecType;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getpMeterNo() {
		return pMeterNo;
	}

	public void setpMeterNo(String pMeterNo) {
		this.pMeterNo = pMeterNo;
	}

	public Byte getMeterRelationType() {
		return meterRelationType;
	}

	public void setMeterRelationType(Byte meterRelationType) {
		this.meterRelationType = meterRelationType;
	}

	public BigDecimal getMeterRelationValue() {
		return meterRelationValue;
	}

	public void setMeterRelationValue(BigDecimal meterRelationValue) {
		this.meterRelationValue = meterRelationValue;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getMadeNo() {
		return madeNo;
	}

	public void setMadeNo(String madeNo) {
		this.madeNo = madeNo;
	}

	public String getFacCode() {
		return facCode;
	}

	public void setFacCode(String facCode) {
		this.facCode = facCode;
	}

	

	public String getNumDigit() {
		return numDigit;
	}

	public void setNumDigit(String numDigit) {
		this.numDigit = numDigit;
	}

	public Byte getPhaseLine() {
		return phaseLine;
	}

	public void setPhaseLine(Byte phaseLine) {
		this.phaseLine = phaseLine;
	}

	

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getRatedCurntCode() {
		return ratedCurntCode;
	}

	public void setRatedCurntCode(String ratedCurntCode) {
		this.ratedCurntCode = ratedCurntCode;
	}

	public String getRatedVoltCode() {
		return ratedVoltCode;
	}

	public void setRatedVoltCode(String ratedVoltCode) {
		this.ratedVoltCode = ratedVoltCode;
	}

	public Byte getTsFlag() {
		return tsFlag;
	}

	public void setTsFlag(Byte tsFlag) {
		this.tsFlag = tsFlag;
	}

	public Long getpMeterId() {
		return pMeterId;
	}

	public void setpMeterId(Long pMeterId) {
		this.pMeterId = pMeterId;
	}

	public Byte getUserType() {
		return userType;
	}

	public void setUserType(Byte userType) {
		this.userType = userType;
	}

    
    
 
}
