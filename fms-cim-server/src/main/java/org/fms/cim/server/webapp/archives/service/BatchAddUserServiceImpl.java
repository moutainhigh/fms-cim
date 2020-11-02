/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.Date;
import java.util.Map;

import org.fms.cim.common.domain.archives.BatchAddUserDomain;
import org.fms.cim.common.domain.archives.CustomerDomain;
import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.MeterMeterAssetsRelDomain;
import org.fms.cim.common.domain.archives.MeterRelationDomain;
import org.fms.cim.common.domain.archives.MeterReplaceDomain;
import org.fms.cim.common.domain.archives.SettlementDomain;
import org.fms.cim.common.domain.archives.SettlementMeterRelDomain;
import org.fms.cim.common.domain.archives.TransformerDomain;
import org.fms.cim.common.domain.archives.TransformerMeterRelationDomain;
import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.domain.archives.WriteSectDomain;
import org.fms.cim.common.domain.assets.MeterAssetsDomain;
import org.fms.cim.common.service.IBatchAddUserService;
import org.fms.cim.server.webapp.archives.dao.CustomerDAO;
import org.fms.cim.server.webapp.archives.dao.MeterDAO;
import org.fms.cim.server.webapp.archives.dao.MeterMeterAssetsRelDAO;
import org.fms.cim.server.webapp.archives.dao.MeterRelationDAO;
import org.fms.cim.server.webapp.archives.dao.MeterReplaceInfoDAO;
import org.fms.cim.server.webapp.archives.dao.SettlementDAO;
import org.fms.cim.server.webapp.archives.dao.SettlementMeterRelDAO;
import org.fms.cim.server.webapp.archives.dao.TransformerMeterRelationDAO;
import org.fms.cim.server.webapp.archives.dao.UserDAO;
import org.fms.cim.server.webapp.assets.dao.MeterAssetsDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.spring.web.http.HttpResult;

@TransactionService
public class BatchAddUserServiceImpl implements IBatchAddUserService {


	@TransactionDAO
	private CustomerDAO customerDAO;
	@TransactionDAO
	private UserDAO userDAO;
	@TransactionDAO
	private SettlementDAO settlementDAO;
	@TransactionDAO
	private MeterAssetsDAO meterAssetsDAO;
	@TransactionDAO
	private MeterDAO meterDAO;
	@TransactionDAO
	private SettlementMeterRelDAO settlementMeterRelDAO;
	@TransactionDAO
	private TransformerMeterRelationDAO transformerMeterRelationDAO;
	@TransactionDAO
	private MeterMeterAssetsRelDAO meterMeterAssetsDAO;
	@TransactionDAO
	private MeterReplaceInfoDAO meterReplaceInfoDAO;
	@TransactionDAO
	private MeterRelationDAO meterRelationDAO;

	@Override
	public HttpResult batchAddUser(BatchAddUserDomain tt, Long businessPlaceCode, String customerNo,
			Map<String, WriteSectDomain> writeSecNo_writeSecDomain,
			Map<String, TransformerDomain> transformerNo_transformerDomain,
			Map<String, MeterDomain> meterNo_MeterDomain) {
		Date now = new Date();

		CustomerDomain customerDomain = new CustomerDomain();    		
		customerDomain.setCustomerName(tt.getUserName());
		customerDomain.setAddress(tt.getAddress());
		customerDomain.setBusinessPlaceCode(businessPlaceCode);
		customerDomain.setCardType("0");
		customerDomain.setCardNo(tt.getCardNo());
		customerDomain.setLinkMan(tt.getUserName());
		customerDomain.setContactInformation(tt.getPhoneNo());
		customerDomain.setCreateDate(now);
		customerDomain.setRemark("excel导入");
		customerDomain.setStatus("1");
		customerDomain.setCustomerNo(customerNo);
		CustomerDomain tc = new CustomerDomain();
		tc.setCustomerNo(customerNo);
		if (customerDAO.getCustomerByNo(tc).size() > 0) {
			return new HttpResult(HttpResult.ERROR, "新增客户信息失败，户号重复");
		}
		if(customerDAO.insert(customerDomain)!=1) {
			return new HttpResult(HttpResult.ERROR, "新增客户信息失败,档案入库失败");
		}
		
		UserDomain userDomain = new UserDomain();
		userDomain.setUserName(tt.getUserName());
		userDomain.setAddress(tt.getAddress());
		userDomain.setWriteSectId(writeSecNo_writeSecDomain.get(tt.getWriteSectNo()).getId());
		userDomain.setLoadType("3");
		userDomain.setTempType("1");
		userDomain.setWriteType("1");
		userDomain.setElecType(tt.getElecType().toString());
		userDomain.setVoltLevelType("10");
		userDomain.setBusinessPlaceCode(businessPlaceCode);
		userDomain.setCustomerId(customerDomain.getId());
		userDomain.setUserNo(customerNo); //新生成的户号。不会重复
		userDomain.setRemark("excel导入");
		userDomain.setStatus("1");
		userDomain.setUserType(tt.getUserType()==null?"10":tt.getUserType().toString());
		
		UserDomain tu = new UserDomain();
		tu.setUserNo(userDomain.getUserNo());
		if (userDAO.findByNo(tu).size() > 0) {
			return new HttpResult(HttpResult.ERROR, "新增用电户信息失败，用户编号重复");
		}
		if(userDAO.insert(userDomain)!=1) {
			return new HttpResult(HttpResult.ERROR, "新增用电户信息失败,档案入库失败");
		}
		
		SettlementDomain settlementDomain = new SettlementDomain();
		settlementDomain.setSettlementNo(customerNo);
		settlementDomain.setCustomerId(customerDomain.getId());
		settlementDomain.setSettlementName(tt.getUserName());
		settlementDomain.setSettlementPhone(tt.getPhoneNo());
		settlementDomain.setChargeModeType("1");
		settlementDomain.setCreateDate(now);
		settlementDomain.setInvoiceType("1");
		settlementDomain.setRemark("excel导入");
		settlementDomain.setAddress(tt.getAddress());
		settlementDomain.setStatus("1");
		settlementDomain.setBusinessPlaceCode(businessPlaceCode);
		SettlementDomain ts = new SettlementDomain();
		ts.setSettlementNo(settlementDomain.getSettlementNo());
		//结算户编号查重
		if(settlementDAO.findByNo(ts).size()>0) {
			return new HttpResult<>(HttpResult.ERROR, "新增结算户信息失败,结算户编号重复");
		}
		if(settlementDAO.insert(settlementDomain)!=1) {
			return new HttpResult(HttpResult.ERROR, "新增结算户信息失败,档案入库失败");
		}
		
		MeterAssetsDomain meterAssetsDomain =new MeterAssetsDomain();
		meterAssetsDomain.setMeterAssetsNo(tt.getMadeNo());
		meterAssetsDomain.setMadeNo(tt.getMadeNo());
		meterAssetsDomain.setFuncKindCode((byte) 9);
		meterAssetsDomain.setPowerKindCode((byte) 10);
		meterAssetsDomain.setFixedAssetsFlag((byte) 1);
		meterAssetsDomain.setFacCode(tt.getFacCode());
		meterAssetsDomain.setModelCode(tt.getModelCode());
		meterAssetsDomain.setRatedVoltCode(tt.getRatedVoltCode());
		meterAssetsDomain.setRatedCurntCode(tt.getRatedCurntCode());
		meterAssetsDomain.setAccuLevelCode((byte) 13);
		meterAssetsDomain.setPhaseLine((byte) 0);
		meterAssetsDomain.setTsFlag((byte) 0);
		meterAssetsDomain.setFactor((long) 1);
		meterAssetsDomain.setNumDigit(tt.getNumDigit());
		meterAssetsDomain.setDeptId(businessPlaceCode);
		meterAssetsDomain.setCreateDate(now);
		meterAssetsDomain.setRemark("excel导入");
		meterAssetsDomain.setStatus((byte) 8);
		meterAssetsDomain.setSetAddress("户号"+customerNo);
		
		MeterAssetsDomain tma = new MeterAssetsDomain();
		tma.setMeterAssetsNo(meterAssetsDomain.getMeterAssetsNo());
        if (meterAssetsDAO.findByWhere(tma).size() > 0) {
            return new HttpResult(HttpResult.ERROR, "新增失败，资产编号重复");
        }
    	if(meterAssetsDAO.insert(meterAssetsDomain)!=1) {
			return new HttpResult(HttpResult.ERROR, "新增电能表资产信息失败,档案入库失败");
		}
    	
		MeterDomain meterDomain = new MeterDomain();
		meterDomain.setMeterNo(customerNo+"-1");
		meterDomain.setMeterName(tt.getUserName());
		meterDomain.setMeterOrder(1);
		meterDomain.setMeterSn(1);
		meterDomain.setSetAddress(tt.getAddress());
		meterDomain.setPriceType(tt.getPriceType());
		meterDomain.setUserId(userDomain.getId());
		meterDomain.setWriteSectionId(userDomain.getWriteSectId());
		meterDomain.setVoltLevelType((byte) 10);
		meterDomain.setMeterType((byte) 1);
		meterDomain.setElecTypeCode(tt.getElecType());
		meterDomain.setTradeType(tt.getTradeType());
		meterDomain.setBaseMoneyFlag((byte) 0);
		meterDomain.setTsType((byte) 0);
		meterDomain.setCountTimes((byte) 1);
		meterDomain.setLadderNum(1);
		meterDomain.setCreateDate(now);
		meterDomain.setRemark("excel导入");
		meterDomain.setStatus("1");
		
	    MeterDomain tm = new MeterDomain();
	    tm.setMeterNo(meterDomain.getMeterNo());
        if (meterDAO.findByNo(tm).size() > 0) {
            return new HttpResult<>(HttpResult.ERROR, "新增计量点信息失败，计量点号重复");
        }
        if (meterDAO.insert(meterDomain) != 1) {
            return new HttpResult<>(HttpResult.ERROR, "新增计量点信息失败，入库失败");
        }
		
        SettlementMeterRelDomain settlementMeterRelDomain = new SettlementMeterRelDomain();
        settlementMeterRelDomain.setSettlementId(settlementDomain.getId());
        settlementMeterRelDomain.setMeterId(meterDomain.getId());
        settlementMeterRelDomain.setCreateDate(now);
        settlementMeterRelDomain.setRemark("excel导入");
        settlementMeterRelDomain.setStatus((byte) 1);
        if (settlementMeterRelDAO.insert(settlementMeterRelDomain) != 1) {
            return new HttpResult<>(HttpResult.ERROR, "新增结算户与计量点关系信息失败，入库失败");
        }
        
        TransformerMeterRelationDomain transformerMeterRelationDomain = new TransformerMeterRelationDomain();
        transformerMeterRelationDomain.setTransformerId(
        		transformerNo_transformerDomain.get(tt.getTransformerNo()).getId());
        transformerMeterRelationDomain.setMeterId(meterDomain.getId());
        transformerMeterRelationDomain.setMsType((byte) 3);
        transformerMeterRelationDomain.setTransLostType((byte) 0);
        transformerMeterRelationDomain.setCreateDate(now);
        transformerMeterRelationDomain.setRemark("excel导入");
        transformerMeterRelationDomain.setStatus((byte) 1);
        if (transformerMeterRelationDAO.insert(transformerMeterRelationDomain) != 1) {
            return new HttpResult<>(HttpResult.ERROR, "新增变压器与计量点关系信息失败，入库失败");
        }
        
        MeterMeterAssetsRelDomain meterMeterAssetsRelDomain = new MeterMeterAssetsRelDomain();
        meterMeterAssetsRelDomain.setMeterId(meterDomain.getId());
        meterMeterAssetsRelDomain.setMeterAssetsId(meterAssetsDomain.getId());
        meterMeterAssetsRelDomain.setPhaseSeq((byte) 4);
        meterMeterAssetsRelDomain.setFunctionCode((long) 1);
        meterMeterAssetsRelDomain.setPowerDirection((byte) 1);
        meterMeterAssetsRelDomain.setMeterOrder((byte) 1);
        meterMeterAssetsRelDomain.setTsFlag((byte) 0);
        meterMeterAssetsRelDomain.setMeterSn(1);
        meterMeterAssetsRelDomain.setFactorNum((double) 1);
        meterMeterAssetsRelDomain.setCreateDate(now);
        meterMeterAssetsRelDomain.setStatus((byte) 1);
        if (meterMeterAssetsDAO.insert(meterMeterAssetsRelDomain) != 1) {
            return new HttpResult<>(HttpResult.ERROR, "新增电能表资产与计量点关系信息失败，入库失败");
        }
        
        MeterReplaceDomain meterReplaceDomain = new MeterReplaceDomain();
        meterReplaceDomain.setMeterId(meterDomain.getId());
        meterReplaceDomain.setMeterAssetsId(meterAssetsDomain.getId());
        meterReplaceDomain.setPhaseSeq((byte) 4);
        meterReplaceDomain.setFunctionCode((long) 1);
        meterReplaceDomain.setPowerDirection((byte) 1);
        meterReplaceDomain.setMeterOrder((byte) 1);
        meterReplaceDomain.setTsFlag((long) 0);
        meterReplaceDomain.setMeterSn(1);
        meterReplaceDomain.setCreateDate(now);
        meterReplaceDomain.setStatus((byte) 1);
        meterReplaceDomain.setReplaceDate(now);
        meterReplaceDomain.setCalcMon(2020);
        meterReplaceDomain.setReason("excel导入");
        if (meterReplaceInfoDAO.insert(meterReplaceDomain) != 1) {
            return new HttpResult<>(HttpResult.ERROR, "新增电能表资产与计量点关系信息失败，入库失败");
        }
        
        
        //TODO 套扣
        if(tt.getpMeterNo()!=null && !"".equals(tt.getpMeterNo())) {
        	
	        MeterRelationDomain meterRelationDomain = new MeterRelationDomain();
	        meterRelationDomain.setpMeterId(meterNo_MeterDomain.get(tt.getpMeterNo()).getId());
	        meterRelationDomain.setMeterId(meterDomain.getId());
	        meterRelationDomain.setMeterRelationType(tt.getMeterRelationType());
	        meterRelationDomain.setMeterRelationValue(tt.getMeterRelationValue());
	        meterRelationDomain.setStatus((byte) 1);
	        meterRelationDomain.setCreateDate(now);
	        meterRelationDomain.setRemark("excel导入");
	        if (meterRelationDAO.insert(meterRelationDomain) != 1) {
	            return new HttpResult<>(HttpResult.ERROR, "新增套扣关系信息失败，入库失败");
	        }
        }
		
        return new HttpResult(HttpResult.SUCCESS, "倒入完成");
	}







}
