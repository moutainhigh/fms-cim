package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.assets.MeterAssetsDomain;
import org.fms.cim.common.domain.assets.MeterAssetsTestRecordDetailTpDomain;
import org.fms.cim.common.domain.assets.MeterAssetsTestRecordDetailUpDomain;
import org.fms.cim.common.domain.assets.MeterAssetsTestRecordDomain;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface IMeterAssetsTestRecordService extends BaseService<MeterAssetsTestRecordDomain> {

	HttpResult addMeterAssetsUseRecord(MeterAssetsTestRecordDomain matr, MeterAssetsTestRecordDetailUpDomain matrdu,
			MeterAssetsTestRecordDetailTpDomain matrdt);

	int testTemp(List<MeterAssetsDomain> meterAssetsList);

}
