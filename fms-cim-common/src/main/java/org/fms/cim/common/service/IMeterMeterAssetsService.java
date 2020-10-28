/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:03
 *    Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.MeterMeterAssetsRelDomain;
import org.fms.cim.common.domain.archives.MeterWriteSnEntity;
import org.fms.cim.common.domain.archives.WriteSectDomain;

import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface IMeterMeterAssetsService extends BaseService<MeterMeterAssetsRelDomain> {
    public List<MeterMeterAssetsRelDomain> getMeterAssetsByMeterIds(List<Long> s);

    public List<MeterMeterAssetsRelDomain> getMeterEntityByMeterIds(String s);

    public Byte getNextMeterOrder(Long s);

    public List<MeterWriteSnEntity> getMeterOrderByWriteSect(WriteSectDomain tl);

    public List<MeterWriteSnEntity> generateWriteOrderAuto(WriteSectDomain tl);

    public int updateList(List<MeterMeterAssetsRelDomain> t);

	public int insertList(List<MeterMeterAssetsRelDomain> mmarList);

	public List<MeterMeterAssetsRelDomain> getMeterAssetsByWriteSectIds(List<Long> writeSectIds);

	public int updateByMeterAssetsId(MeterMeterAssetsRelDomain mmar);

	public int deleteByMeterIds(MeterDomain meter) throws Exception;

	public List<MeterMeterAssetsRelDomain> getmmarlByuserNos(List<String> userNos);
}
