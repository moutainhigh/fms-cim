/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:03
 *    Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.MeterInformationEntity;
import org.fms.cim.common.domain.archives.MeterRelationDomain;
import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.domain.assets.InductorAssetsDomain;
import org.fms.cim.common.domain.assets.MeterAssetsDomain;

import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface IMeterService extends BaseService<MeterDomain> {

	public List<MeterDomain> getMeterByUser(UserDomain userDomain);

	public List<MeterDomain> getMeterByWriteSectIds(List<Long> writeSectIds);

	public int deleteMeterRelList(List<MeterRelationDomain> list);

	public List<MeterDomain> getMeterByMeterAssestsNo(MeterAssetsDomain t);

	public List<MeterDomain> getMeterByInductorAssestsNo(InductorAssetsDomain t);

	public List<MeterDomain> getMeterByIds(List<Long> s);

	public List<MeterRelationDomain> getMeterRelByMeterIds(List<Long> s);

	public List<MeterDomain> getMeterByMeterIds(List<Long> tList);

	@Deprecated
	public List<Long> getMeterIdsByWriteSectIds(List<Long> ids);

	/**
	 * {@link #getMeterByUserIds(List)}
	 * 
	 * @param userIds
	 * @return
	 */
	@Deprecated
	public List<Long> getMeterIdsByUserIds(List<Long> userIds);
	
	public List<MeterDomain> getMeterByUserIds(List<Long> userIds);

	public List<MeterDomain> meterNoDC(MeterDomain t);

	public List<MeterDomain> findByNo(MeterDomain tt);

	public List<MeterDomain> getMeterByCustomer(MeterDomain e);

	public List<MeterInformationEntity> getMeterInformation(MeterInformationEntity e);
	List<MeterDomain> findMetersByMeterIds(List<Long> meterIds);

	public int updateList(List<MeterDomain> e);

	public int insertList(List<MeterDomain> meterList);

	public int updateWriteSectIdByUserId(MeterDomain meterDomain);

	public List<MeterDomain> getMeterAndUserByIds(List<Long> meterIds);

	public List<MeterDomain> getMeterByUserNos(List<UserDomain> userList);

	public List<MeterDomain> getMeterByUserNo(UserDomain userDomain);

	public List<MeterDomain> getMeterByMeterIdsWithoutStatus(List<Long> meterIds);

	public List<MeterDomain> getMeterByMeterNos(List<String> pMeterNoList);

	public List<MeterDomain> getNolineMeter(MeterDomain t);

	public List<MeterDomain> findClearMeterDoaminByWhere(MeterDomain t);

}
