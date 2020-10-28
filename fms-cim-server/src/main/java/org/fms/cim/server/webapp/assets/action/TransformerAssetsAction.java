/**
 *    Auth:riozenc
 *    Date:2019年3月18日 下午2:00:49
 *    Title:com.riozenc.cim.webapp.assets.action.TransformerAssetsAction.java
 **/
package org.fms.cim.server.webapp.assets.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.fms.cim.common.domain.assets.TransformerAssetsDomain;
import org.fms.cim.common.service.ITransformerAssetsService;
import org.fms.cim.common.strategy.no.SequenceEnvironment;
import org.fms.cim.common.strategy.no.SequenceStrategy;
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
import com.riozenc.cim.web.config.JsonGrid;
import com.riozenc.titanTool.common.json.utils.GsonUtils;
import com.riozenc.titanTool.common.json.utils.JSONUtil;
import com.riozenc.titanTool.spring.web.http.HttpResult;

import reactor.core.publisher.Mono;

/**
 * 变压器资产
 *
 * @author riozenc
 *
 */
@ControllerAdvice(assignableTypes = TransformerAssetsAction.class)
@RequestMapping("transformerAssets")
public class TransformerAssetsAction {

	@Autowired
	@Qualifier("transformerAssetsServiceImpl")
	private ITransformerAssetsService transformerAssetsService;

	@Autowired
	@Qualifier("transSequenceStrategy")
	private SequenceStrategy transSequenceStrategy;

	@Autowired
	private RestTemplate restTemplate;
	/**
	 * 新增资产
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@ResponseBody
	@PostMapping(params = "method=addAssets")
	public Object addAssets(@RequestBody String body) throws JsonParseException, JsonMappingException, IOException {

		TransformerAssetsDomain t = GsonUtils.readValue(body, TransformerAssetsDomain.class);

		String transformerAssetsNo = newTransformerNo(t);
		
		// 资产编号查重
		TransformerAssetsDomain e = new TransformerAssetsDomain();
		e.setTransformerAssetsNo(transformerAssetsNo);
		List<TransformerAssetsDomain> list = transformerAssetsService.findByWhere(e);
		if (list.size() > 0) {
			return new HttpResult<>(HttpResult.ERROR, "新增失败，资产编号重复");
		}
		t.setTransformerAssetsNo(transformerAssetsNo);

		if(t.getStatus()==null) {
			t.setStatus((byte) 0);
		}
		t.setCreateDate(new Date());
		int i = transformerAssetsService.insert(t);
		if (i > 0)
			return new HttpResult<>(HttpResult.SUCCESS, "新增成功.");
		else
			return new HttpResult<>(HttpResult.ERROR, "新增失败.");
	}

	/**
	 * 获取资产  不分页
	 */
	@ResponseBody
	@PostMapping(params = "method=getTransformerAssets")
	public Mono<List<TransformerAssetsDomain>> getTransformerAssets(
			@RequestBody TransformerAssetsDomain transformerAssetsDomain) {

		List<TransformerAssetsDomain> list = transformerAssetsService.findByWhere(transformerAssetsDomain);
		return Mono.just(list);
	}



	/**
	 * 使用findbywhere 相同的方法
	 * */
	@ResponseBody
	@PostMapping(params = "method=getTransformerAssetsByWhere")
	public Mono<JsonGrid> getTransformerAssetsByWhere(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException{

		TransformerAssetsDomain t = GsonUtils.readValue(body, TransformerAssetsDomain.class);

		return Mono.just(new JsonGrid(t,transformerAssetsService.getTransformerAssetsByWhere(t)));
	}


	/**
	 * 更新资产信息（所有属性）
	 *
	 * @param inductorAssetsDomain
	 * @return
	 */
	@ResponseBody
	@PostMapping(params = "method=update")
	public Object update(@RequestBody String body) {

		TransformerAssetsDomain t = GsonUtils.readValue(body, TransformerAssetsDomain.class);
		// 资产编号查重
		TransformerAssetsDomain e = new TransformerAssetsDomain();
		e.setTransformerAssetsNo(t.getTransformerAssetsNo());
		List<TransformerAssetsDomain> list = transformerAssetsService.findByNoId(e);
		if (list.size() > 0) {
			return new HttpResult<>(HttpResult.ERROR, "更新失败，资产编号重复");
		}

		int i = transformerAssetsService.update(t);
		if (i > 0)
			return new HttpResult<>(HttpResult.SUCCESS, "更新成功.");
		else
			return new HttpResult<>(HttpResult.ERROR, "更新失败.");
	}
	
	public String newTransformerNo (TransformerAssetsDomain t) throws JsonParseException, JsonMappingException, IOException {
		String resultJson = restTemplate.getForObject("http://AUTH-CENTER/auth/dept/getDeptById/" + t.getDeptId(),String.class);
	    HttpResult<HashMap<String,Object>> httpResult2 = JSONUtil.readValue(resultJson,
	    		new TypeReference<HttpResult<HashMap<String,Object>>>() {});		
	    String deptCode = httpResult2.getResultData().get("deptId").toString();
		
	    if(deptCode.length()!=4) {
			return "11111111";
		}

		SequenceEnvironment transformernvironment=new SequenceEnvironment(transSequenceStrategy);
		String seqNo = transformernvironment.generateSequenceNo(null);
		String transformerAssetsNo = deptCode+seqNo;
		
		return transformerAssetsNo;
	}
	
	
}
