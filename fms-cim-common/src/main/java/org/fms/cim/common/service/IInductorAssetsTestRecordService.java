/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:03
 *    Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.assets.InductorAssetsTestRecordDetailDomain;
import org.fms.cim.common.domain.assets.InductorAssetsTestRecordDomain;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface IInductorAssetsTestRecordService extends BaseService<InductorAssetsTestRecordDomain> {

	HttpResult addInductorAssetsUseRecord(InductorAssetsTestRecordDomain iatr,
			List<InductorAssetsTestRecordDetailDomain> iatrdList);

	
}
