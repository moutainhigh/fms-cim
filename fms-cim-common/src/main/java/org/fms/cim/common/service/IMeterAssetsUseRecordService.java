/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:03
 *    Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.assets.MeterAssetsDomain;
import org.fms.cim.common.domain.assets.MeterAssetsUseRecordDomain;

import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface IMeterAssetsUseRecordService extends BaseService<MeterAssetsUseRecordDomain> {

	int addMeterAssetsUseRecord(List<MeterAssetsDomain> meterAssetsList,
			MeterAssetsUseRecordDomain meterAssetsUseRecord);
	
}
