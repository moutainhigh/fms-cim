/**
 *    Auth:riozenc
 *    Date:2019年3月14日 上午8:50:19
 *    Title:com.riozenc.cim.webapp.action.MeterAction.java
 **/
package org.fms.cim.server.webapp.archives.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.fms.cim.common.domain.archives.DeptMonDomain;
import org.fms.cim.common.domain.archives.MeterMeterAssetsRelDomain;
import org.fms.cim.common.domain.archives.MeterReplaceDomain;
import org.fms.cim.common.domain.assets.MeterAssetsDomain;
import org.fms.cim.common.service.IExcelImportService;
import org.fms.cim.common.service.IMeterAssetsService;
import org.fms.cim.common.service.IMeterMeterAssetsService;
import org.fms.cim.common.service.IMeterReplaceInfoService;
import org.fms.cim.common.service.IMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.riozenc.titanTool.common.json.utils.JSONUtil;
import com.riozenc.titanTool.spring.web.client.TitanTemplate;
import com.riozenc.titanTool.spring.web.http.HttpResult;

/**
 * 增加换表电量
 * */
@ControllerAdvice
@RequestMapping("excelImport")
public class ExcelImportAction2 {

	@Autowired
	private TitanTemplate titanTemplate;
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
	//用于excel导入。批量换表
    @ResponseBody
    @PostMapping(params = "method=changeDevForExcel")
    public Object changeDevForExcel(@RequestBody String body) throws Exception {
        Date now = new Date(System.currentTimeMillis()-1000);
    	List<MeterAssetsDomain> meterAssetsDomains = 
        		JSONUtil.readValue(body, new TypeReference<List<MeterAssetsDomain>>() {});

    	if(meterAssetsDomains.size()==0) {
            return new HttpResult(HttpResult.ERROR, "数据为空" );
    	}
    	Set<Long> ids = new HashSet<>();
    	meterAssetsDomains.forEach(m->{
    		m.setMadeNo(m.getMeterAssetsNo());
        	m.setCreateDate(now);
        	m.setRemark("Excel导入"+now);
        	m.setStatus("8");
        	m.setRightAttach("0");
        	m.setPhaseLine("0");
        	m.setSetAddress("户号"+m.getUserNo());
        	ids.add(m.getDeptId());
    	});
    	
    	Map<Integer, String> monMap = getCurrentMon(ids);
    	
        // 资产编号查重
        List<MeterAssetsDomain> list = meterAssetsService.getMeterAssetsByNos(meterAssetsDomains);
        if (list.size() > 0) {
        	StringBuilder nos = new StringBuilder();
        	list.forEach(m -> {
        		nos.append(m.getMeterAssetsNo()).append(",");
        	});
            return new HttpResult(HttpResult.ERROR, "新增失败，资产编号重复：" + nos+"。	");
        }
        
        //根据用户户号查询用户的装表记录，只查有功表
        List<String> userNos = new ArrayList<>();
        meterAssetsDomains.forEach(m -> userNos.add(m.getUserNo()));

        List<MeterMeterAssetsRelDomain> mmarl = meterMeterAssetsService.getmmarlByuserNos(userNos);
        HashMap<String,MeterMeterAssetsRelDomain> userNo_mmar = new HashMap<>();
        for(MeterMeterAssetsRelDomain tt: mmarl) {
        	if(userNo_mmar.putIfAbsent(tt.getUserNo(), tt) != null) {
                return new HttpResult(HttpResult.ERROR, "用户：" + tt.getUserNo()+"存在多个有功表");
        	}
        }

        String massage = "以下用户无装表记录";
        //新换表方法，一次一条
        for(MeterAssetsDomain tt : meterAssetsDomains) {
        	HttpResult rh = new HttpResult();
        	rh.setStatusCode(HttpResult.ERROR);
        	
        	String userNo = tt.getUserNo();
        	if(userNo_mmar.get(userNo) == null ||userNo_mmar.get(userNo).getMeterId() ==null ) {
        		massage += userNo+",";
        		continue;
        	}
        	Long meterId = userNo_mmar.get(userNo).getMeterId();

        	//拆表
            MeterReplaceDomain mr = new MeterReplaceDomain();
            mr.setMeterId(meterId);
            mr.setMeterAssetsId(userNo_mmar.get(userNo).getMeterAssetsId());
            mr.setCreateDate(now);
            mr.setReplaceDate(now);
            mr.setReason("Excel导入，拆表"+now);
            mr.setEquipmentType((byte) 1);
            mr.setOperateType((byte) 2);
            mr.setOperator(tt.getManagerId()==null?0:Long.parseLong(tt.getManagerId()));
            mr.setFactorNum(tt.getFactor()==null?1:tt.getFactor().doubleValue());
            mr.setPhaseSeq((byte) 4);
            mr.setFunctionCode("1");
            mr.setPowerDirection("1");
            mr.setTsFlag((long) 0);
            mr.setMeterOrder((byte) 9);
            mr.setP1r0(tt.getEndNum());
            mr.setWriteSn(userNo_mmar.get(userNo).getWriteSn());
            mr.setStatus((byte) 1);
            mr.setCalcMon(tt.getCalcMon()==null?monAdd1(monMap.get(tt.getDeptId())):tt.getCalcMon());

            rh = excelImportService.changeDevExcel(mr);
            if(rh.getStatusCode()-HttpResult.ERROR==0) {
            	rh.setMessage("用户："+userNo+"拆表失败，请导入该户号之后剩余的换表档案"+rh.getMessage());
            	return rh;
            }
        	
        	//添加资产档案
        	int i = meterAssetsService.insert(tt);

        	if(i==1) {
            	mr.setMeterAssetsId(tt.getId());
                mr.setOperateType((byte) 1);
                mr.setP1r0(tt.getStartNum());
                mr.setReason("Excel导入，装表");
                mr.setReplaceDate(new Date());

                rh = excelImportService.changeDevExcel(mr);
                if(rh.getStatusCode()==HttpResult.ERROR) {
                	rh.setMessage("用户："+userNo+"装表失败，请导入该户号之后剩余的换表档案"+rh.getMessage());
                	return rh;
                }
        	}else {
        		rh.setMessage("资产号："+tt.getMeterAssetsNo()+"新增失败"+rh.getMessage());
        		return rh;
        	}

        }
     
		return new HttpResult<>(HttpResult.SUCCESS,"倒入完成"+massage);

    }
    
    private int monAdd1(String mon) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Date date1 = new Date();
		if(mon!=null&&!"".equals(mon)) {
		    date1 = sdf.parse(mon);
		}
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date1);
	    calendar.add(Calendar.MONTH, 1);
	    Date date2 = calendar.getTime();
	    String rs = sdf.format(date2);
    	
    	return Integer.parseInt(rs);
    }
    
    private Map<Integer, String> getCurrentMon(Set<Long> ids) {

		HashMap<String, Object> tempMap = new HashMap<String, Object>();
		
		tempMap.put("ids", ids);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		try {
			List<DeptMonDomain> deptMonDomains = titanTemplate.post("BILLING-SERVER",
					"billingServer/deptMon?method=getDeptCurrentMonById", httpHeaders, tempMap,
					new TypeReference<List<DeptMonDomain>>() {});

			Map<Integer, String> deptMon = deptMonDomains.stream()
	    			.collect(Collectors.toMap(DeptMonDomain::getDeptId, DeptMonDomain::getMon,(k1,k2) -> k1));
			
			return deptMon;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
