/**
 *    Auth:riozenc
 *    Date:2019年3月14日 上午8:50:19
 *    Title:com.riozenc.cim.webapp.action.MeterAction.java
 **/
package org.fms.cim.server.webapp.archives.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.fms.cim.common.domain.archives.BatchAddUserDomain;
import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.TransformerDomain;
import org.fms.cim.common.domain.archives.WriteSectDomain;
import org.fms.cim.common.service.IBatchAddUserService;
import org.fms.cim.common.service.IMeterService;
import org.fms.cim.common.service.ISysSequenceNoService;
import org.fms.cim.common.service.ITransformerService;
import org.fms.cim.common.service.IWriteSectService;
import org.fms.cim.server.strategy.no.SequenceEnvironment;
import org.fms.cim.server.strategy.no.SequenceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.riozenc.titanTool.common.json.utils.JSONUtil;
import com.riozenc.titanTool.spring.web.http.HttpResult;


@ControllerAdvice
@RequestMapping("batchAddUser")
public class BatchAddUserAction {

	@Autowired
    private RestTemplate restTemplate;
    
    @Autowired
	@Qualifier("writeSectServiceImpl")
	private IWriteSectService writeSectService;
    
	@Autowired
	@Qualifier("sysSequenceNoServiceImpl")
	private ISysSequenceNoService sysSequenceNoService;
	
	@Autowired
    @Qualifier("appNoSequenceStrategy")
    private SequenceStrategy appNoSequenceStrategy;
	
	@Autowired
	@Qualifier("transformerServiceImpl")
	private ITransformerService transformerService;

    @Autowired
    @Qualifier("batchAddUserServiceImpl")
    private IBatchAddUserService batchAddUserService;

    @Autowired
    @Qualifier("meterServiceImpl")
    private IMeterService meterService;
	
    /**
     * 
     * 手动建区段、变压器
     * 
     * 1.新增三户
     * 2.新增计量点
     * 3.新增资产
     * 4.新增结算户和计量点关系
     * 5.新增计量点和变压器关系
     * 6.装表
     * 7.处理套扣
     * @throws Exception 
     * 
     * */
	
    @ResponseBody
    @PostMapping(params = "method=batchAddUser")
    public HttpResult batchAddUser(@RequestBody String body) throws Exception {
		
    	List<BatchAddUserDomain> batchAddUserDomainList = 
    			JSONUtil.readValue(body, new TypeReference<List<BatchAddUserDomain>>() {});
    	
    	TreeSet<String> writeSectNoSet = new TreeSet<String>();
    	TreeSet<String> transformerNoSet = new TreeSet<String>();
    	TreeSet<String> pMeterNos = new TreeSet<String>(); 
 

    	batchAddUserDomainList.stream()
    		.filter(m -> m.getWriteSectNo()!=null && m.getTransformerNo()!=null)
    		.forEach(m -> {
	    		writeSectNoSet.add(m.getWriteSectNo());
	    		transformerNoSet.add(m.getTransformerNo());
	    		if(m.getpMeterNo()!=null) {
		    		pMeterNos.add(m.getpMeterNo());
	    		}
    		});
    	List<String> writeSectNoList = new ArrayList<>(writeSectNoSet);
    	List<String> transformerNoList = new ArrayList<>(transformerNoSet);
    	List<String> pMeterNoList = new ArrayList<>(pMeterNos);
    	List<WriteSectDomain> writeSectDomainList = writeSectService.getWriteSectByNos(writeSectNoList);
    	List<TransformerDomain> transformerDomainList = transformerService.getTransformerByNos(transformerNoList);
    	List<MeterDomain> meterDomainList = meterService.getMeterByMeterNos(pMeterNoList);
    	
    	Map<String,WriteSectDomain> writeSecNo_writeSecDomain = writeSectDomainList.stream()
    			.collect(Collectors.toMap(WriteSectDomain::getWriteSectNo, m->m,(k1,k2) -> k1));
    	for(String ts : writeSectNoList) {
    		if(writeSecNo_writeSecDomain.get(ts)==null) {
    			return new HttpResult(HttpResult.ERROR,"抄表区段未创建，区段号为："+ts+"档案未创建");
    		}
    	}
    	Map<String,TransformerDomain> transformerNo_transformerDomain = transformerDomainList.stream()
    			.collect(Collectors.toMap(TransformerDomain::getTransformerNo, m->m,(k1,k2) -> k1));
    	for(String ts : transformerNoList) {
    		if(transformerNo_transformerDomain.get(ts)==null) {
    			return new HttpResult(HttpResult.ERROR,"变压器未创建，变压器号为："+ts+"档案未创建");
    		}
    	}
    	Map<String,MeterDomain> meterNo_MeterDomain = meterDomainList.stream()
    			.collect(Collectors.toMap(MeterDomain::getMeterNo, m->m,(k1,k2) -> k1));
    	for(String ts : pMeterNoList) {
    		if(meterNo_MeterDomain.get(ts)==null) {
    			return new HttpResult(HttpResult.ERROR,"父计量点未创建，父计量点号为："+ts+"档案未创建");
    		}
    	}
    	
    	
    	for(BatchAddUserDomain tt : batchAddUserDomainList) {
    		
    		Date now = new Date();
    		Long businessPlaceCode = writeSecNo_writeSecDomain.get(tt.getWriteSectNo()).getBusinessPlaceCode();
    		String customerNo = newCustomerNo(businessPlaceCode);
    		
    		if(customerNo==null) {
    			return new HttpResult(HttpResult.ERROR,"客户户号生成失败，用户名为："+tt.getUserName());
    		}
    		
    		HttpResult rh = batchAddUserService.batchAddUser(tt, businessPlaceCode, customerNo,
    				writeSecNo_writeSecDomain,transformerNo_transformerDomain,meterNo_MeterDomain);
    		if(rh.getStatusCode() - HttpResult.ERROR==0) {
    			rh.setMessage(rh.getMessage()+"档案已创建："+customerNo);
    			return rh;
    		}
   
    	}
    	    	
    	return new HttpResult(HttpResult.SUCCESS, "倒入完成");
      
    }
    
	//户号生成
	public String newCustomerNo(Long businessPlaceCode) throws JsonParseException, JsonMappingException, IOException {
		
		String resultJson = restTemplate.getForObject("http://AUTH-CENTER/auth/dept/getDeptById/" + businessPlaceCode,
                String.class);
        HttpResult<HashMap<String,Object>> httpResult2 = JSONUtil.readValue(resultJson,
                new TypeReference<HttpResult<HashMap<String,Object>>>() {});		
        String deptId = httpResult2.getResultData().get("deptId").toString();
		
    	if(deptId.length()!=4) {
			return null;
		}
    	
        SequenceEnvironment appNoEnvironment=new SequenceEnvironment(appNoSequenceStrategy);
        return appNoEnvironment.generateSequenceNo(deptId);

	}
	
}
