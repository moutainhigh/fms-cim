/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:15:22
 *    Title:com.riozenc.cim.webapp.service.ISettlementService.java
 **/
package org.fms.cim.common.service;

import java.util.List;
import java.util.Map;

import org.fms.cim.common.domain.archives.CustomerDomain;
import org.fms.cim.common.domain.archives.TransformerDomain;
import org.fms.cim.common.domain.archives.TransformerLineRelDomain;
import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.domain.assets.TransformerAssetsDomain;

import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface ITransformerService extends BaseService<TransformerDomain>{

	public List<TransformerDomain> getTransformerByUser(UserDomain userDomain);

	public List<TransformerDomain> getTransformerByAsset(TransformerAssetsDomain t);

	public List<TransformerDomain> getTransformerByMeterIds(List<Long> s);

	public List<TransformerDomain> getTransformerByWriteSectIds(List<Long> s);

    public List<TransformerDomain> findByNo(TransformerDomain transformerDomain);

	public List<TransformerDomain> findByNoId(TransformerDomain transformerDomain);

	public List<Map> getTransformerByRel(List<Long> ids);

	public List<TransformerDomain> getAvaTransformerByWhere(TransformerDomain transformerDomain);

	public List<TransformerDomain> getTransformerByCustomer(CustomerDomain customerDomain);

	public List<TransformerLineRelDomain> findRelByTranformIds(TransformerLineRelDomain t);

	public List<TransformerLineRelDomain> findRelByLineIds(TransformerLineRelDomain t);

	public List<TransformerDomain> getTransformerByNos(List<String> transformerNoList);
}
