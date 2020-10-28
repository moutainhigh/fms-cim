/**
 *    Auth:riozenc
 *    Date:2019年3月14日 上午8:50:19
 *    Title:com.riozenc.cim.webapp.action.MeterAction.java
 **/
package org.fms.cim.server.webapp.archives.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.MeterMeterAssetsRelDomain;
import org.fms.cim.common.domain.archives.MeterReplaceDomain;
import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.domain.assets.MeterAssetsDomain;
import org.fms.cim.common.service.IExcelImportService;
import org.fms.cim.common.service.IMeterAssetsService;
import org.fms.cim.common.service.IMeterMeterAssetsService;
import org.fms.cim.common.service.IMeterReplaceInfoService;
import org.fms.cim.common.service.IMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.riozenc.titanTool.common.json.utils.JSONUtil;
import com.riozenc.titanTool.spring.web.http.HttpResult;

@ControllerAdvice
@RequestMapping("excelImport1")
public class ExcelImportAction {

	
    @Autowired
    @Qualifier("meterAssetsServiceImpl")
    private IMeterAssetsService meterAssetsService;
    
    @Autowired
    @Qualifier("meterServiceImpl")
    private IMeterService meterService;

    @Autowired
    @Qualifier("meterReplaceInfoServiceImpl")
    private IMeterReplaceInfoService meterReplaceInfoService;
    
    @Autowired
    @Qualifier("meterMeterAssetsServiceImpl")
    private IMeterMeterAssetsService meterMeterAssetsService;
    
    @Autowired
    @Qualifier("excelImportServiceImpl")
    private IExcelImportService excelImportService;
    
    
    /**
     * 1.新增资产
     * 2.换表
     * @throws Exception 
     * 
     * */
	//用于excel导入。批量新增
    @ResponseBody
    @PostMapping(params = "method=changeDevForExcel")
    public Object changeDevForExcel(@RequestBody String body) throws Exception {
        Date now = new Date();
    	List<MeterAssetsDomain> meterAssetsDomains = 
        		JSONUtil.readValue(body, new TypeReference<List<MeterAssetsDomain>>() {});

    	if(meterAssetsDomains.size()==0) {
            return new HttpResult(HttpResult.ERROR, "数据为空" );

    	}
    	meterAssetsDomains.forEach(m->{
    		m.setMadeNo(m.getMeterAssetsNo());
    	});
    	    	
        // 资产编号查重
        List<MeterAssetsDomain> list = meterAssetsService.getMeterAssetsByNos(meterAssetsDomains);
        if (list.size() > 0) {
        	StringBuilder nos = new StringBuilder();
        	list.forEach(m -> {
        		nos.append(m.getMeterAssetsNo()).append(",");
        	});
            return new HttpResult(HttpResult.ERROR, "新增失败，资产编号重复：" + nos);
        }

        for(MeterAssetsDomain tt :meterAssetsDomains) {
        	tt.setCreateDate(now);
        	tt.setRemark("Excel导入"+now);
        }
        //插入
        int i = meterAssetsService.insertList(meterAssetsDomains);
        
        
    	//户号-表计资产号
        HashMap<String,String> userNo_meterAssetsNo = new HashMap<String,String>();
		for(MeterAssetsDomain tt : meterAssetsDomains) {
		   	if(userNo_meterAssetsNo.putIfAbsent(tt.getUserNo(), tt.getMeterAssetsNo())!=null) {
        		return new HttpResult<>(HttpResult.ERROR,"该用户下存在多个资产"+tt.getUserNo());
        	}
		}

		//资产号-资产ID
        List<MeterAssetsDomain> newMeterAssetsList = meterAssetsService.getMeterAssetsByNos(meterAssetsDomains);
        if(newMeterAssetsList.size()==0) {
    		return new HttpResult<>(HttpResult.ERROR,"新增资产为空");
        }
        HashMap<String,Long> meterAssetsNo_meterAssetsId = new HashMap<String,Long>();
        for(MeterAssetsDomain tt : newMeterAssetsList) {
        	if(meterAssetsNo_meterAssetsId.putIfAbsent(tt.getMeterAssetsNo(), tt.getId())!=null) {
        		return new HttpResult<>(HttpResult.ERROR,"资产号重复"+tt.getMeterAssetsNo());
        	}
        }
        

        //户号-计量点ID
        List<UserDomain> userList = new ArrayList<UserDomain>();
        for(MeterAssetsDomain tt: meterAssetsDomains) {
        	UserDomain userDomain = new UserDomain();
        	userDomain.setUserNo(tt.getUserNo());
        	userList.add(userDomain);
        }
        List<MeterDomain> meterList = meterService.getMeterByUserNos(userList);
        if(meterList.size()==0) {
    		return new HttpResult<>(HttpResult.ERROR,"本次导入的用户无计量点");
        }
        List<Long> meterIds = new ArrayList<>();
        HashMap<String,Long> userNo_mpedId = new HashMap<String,Long>();
        for(MeterDomain tt : meterList) {
        	if(userNo_mpedId.putIfAbsent(tt.getUserNo(), tt.getId())!=null) {
        		return new HttpResult<>(HttpResult.ERROR,"该用户下存在多个计量点"+tt.getUserNo());
        	}
        	meterIds.add(tt.getId());
        }

        if(meterIds!=null && meterIds.size()>1000) {
    		return new HttpResult<>(HttpResult.ERROR,"删除数量超过1000！！！！");
        }
        //TODO 拆表操作，生成换表电量
        List<MeterMeterAssetsRelDomain> mmarlold = meterMeterAssetsService.getMeterAssetsByMeterIds(meterIds);
        //计量点id-MeterMeterAssetsRelDomain
        HashMap<Long,MeterMeterAssetsRelDomain> meterId_mmar = new HashMap<Long,MeterMeterAssetsRelDomain>();
        for(MeterMeterAssetsRelDomain tt : mmarlold) {
        	meterId_mmar.put(tt.getMeterId(),tt);
        }
        
        
//        
//        MeterDomain meter = new MeterDomain();
//        meter.setIdList(meterIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
//        int oldmmarl = meterMeterAssetsService.deleteByMeterIds(meter);
   
        //根据计量点的 BusinessPlaceCode 更新资产的deptId
        Long deptId = meterList.get(0).getBusinessPlaceCode();
        for(MeterAssetsDomain ntt : newMeterAssetsList) {
        	ntt.setDeptId(deptId);
        }
        meterAssetsService.updateList(newMeterAssetsList);
        
       //装表
        List<MeterMeterAssetsRelDomain> mmarl = new ArrayList<MeterMeterAssetsRelDomain>();
        List<MeterReplaceDomain> mrl = new ArrayList<MeterReplaceDomain>();

        for(MeterAssetsDomain tt : meterAssetsDomains) {

        	Long meterId = userNo_mpedId.get(tt.getUserNo());
        	Long meterAssetsId = meterAssetsNo_meterAssetsId.get(tt.getMeterAssetsNo());

        	MeterMeterAssetsRelDomain mmar = meterId_mmar.get(meterId);
        	MeterReplaceDomain mr = new MeterReplaceDomain();
        	mmar.setMeterId(meterId);
        	mmar.setMeterAssetsId(meterAssetsId);
        	mmar.setCreateDate(now);
        	mmar.setMeterSn(9);
        	mmar.setFactorNum(tt.getFactor()==null?0:tt.getFactor().doubleValue());
        	
        	mr.setMeterId(meterId);
        	mr.setMeterAssetsId(meterAssetsId);
        	mr.setReplaceDate(now);
        	mr.setReason("Excel批量导入");
        	mr.setEquipmentType((byte) 1);
        	mr.setOperateType((byte) 1);
        	mr.setCreateDate(now);
        	mr.setPhaseSeq((byte) 4);
        	mr.setFunctionCode((long) 1);
        	mr.setPowerDirection((byte) 1);
        	mr.setStatus((byte) 1);
        	
        	mmarl.add(mmar);
        	mrl.add(mr);
        	
        }
        //TODO 装拆表记录入库
        int mmarNum = meterMeterAssetsService.updateList(mmarl);
        int mrNum = meterReplaceInfoService.insertList(mrl);
        
        
        System.out.println("数据插入完成");
          
		return new HttpResult<>(HttpResult.SUCCESS,"倒入完成，新增资产数量为："+i);

    }
    
	

}
