/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:03
 *    Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import java.util.List;
import java.util.Map;

import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.domain.assets.MeterAssetsDomain;
import org.fms.cim.common.domain.assets.MeterAssetsEntity;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface IMeterAssetsService extends BaseService<MeterAssetsDomain> {

	public List<MeterAssetsDomain> getMeterAssetsByManager(MeterAssetsDomain meterAssetsDomain);

	public List<Map<String, Object>> getAssetsByUser(UserDomain t);

	public HttpResult addAssetsList(MeterAssetsDomain t);

	public List<MeterAssetsDomain> findByWhereDC(MeterAssetsDomain tt);

	public int updateList(List<MeterAssetsDomain> l);

	public MeterAssetsEntity findMeterEntityByWhere(Long id);

	public List<MeterAssetsDomain> getMeterAssetsByAssetsIds(List<Long> idsList);

	public List<MeterAssetsEntity> getMeterAssetsByFunctionCode(Map ids);
	
	public int insertList(List<MeterAssetsDomain> rl);

	public List<MeterAssetsDomain> getMeterAssetsByNos( List<MeterAssetsDomain> meterAssetsNos);

	public HttpResult deleteList(List<MeterAssetsDomain> deleteList) throws Exception;


	}
