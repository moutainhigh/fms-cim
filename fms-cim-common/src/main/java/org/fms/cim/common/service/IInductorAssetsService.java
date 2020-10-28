/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:03
 *    Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.domain.assets.InductorAssetsDomain;
import org.fms.cim.common.domain.assets.InductorAssetsEntity;

import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface IInductorAssetsService extends BaseService<InductorAssetsDomain> {
	public List<InductorAssetsDomain> getInductorAssetsByManager(InductorAssetsDomain inductorAssetsDomain);
	public List<InductorAssetsDomain> getInductorAssetsByUser(UserDomain t);
	public List<InductorAssetsDomain> assetsNoDC(InductorAssetsDomain t);
	public int updateList(List<InductorAssetsDomain> l);
	public InductorAssetsEntity findInductEntityByWhere(String t);

}
