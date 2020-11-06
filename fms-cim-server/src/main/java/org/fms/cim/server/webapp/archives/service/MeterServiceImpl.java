/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.ArrayList;
import java.util.List;

import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.MeterInformationEntity;
import org.fms.cim.common.domain.archives.MeterRelationDomain;
import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.domain.assets.InductorAssetsDomain;
import org.fms.cim.common.domain.assets.MeterAssetsDomain;
import org.fms.cim.common.service.IMeterService;
import org.fms.cim.server.webapp.archives.dao.MeterDAO;
import org.fms.cim.server.webapp.archives.dao.TransformerDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class MeterServiceImpl implements IMeterService {

	@TransactionDAO("read")
	private MeterDAO meterReadDAO;
	@TransactionDAO("write")
	private MeterDAO meterWriteDAO;
	
	@TransactionDAO("read")
	private TransformerDAO transformerReadDAO;
	@TransactionDAO("write")
	private TransformerDAO transformerWriteDAO;

	@Override
	public int insert(MeterDomain meterDomain) {
		return meterWriteDAO.insert(meterDomain);
	}

	@Override
	public int delete(MeterDomain t) {
		return meterWriteDAO.delete(t);
	}

	@Override
	public int update(MeterDomain meterDomain) {
		return meterWriteDAO.update(meterDomain);
	}

	@Override
	public MeterDomain findByKey(MeterDomain t) {
		return meterReadDAO.findByKey(t);
	}

	@Override
	public List<MeterDomain> findByNo(MeterDomain t) {
		return meterReadDAO.findByNo(t);
	}

	@Override
	public List<MeterDomain> findByWhere(MeterDomain t) {
		return meterReadDAO.findByWhere(t);
	}

	@Override
	public List<MeterDomain> getMeterByUser(UserDomain userDomain) {
		return meterReadDAO.getMeterByUser(userDomain);
	}

	@Override
	public int deleteMeterRelList(List<MeterRelationDomain> list) {
		return meterWriteDAO.deleteMeterRelList(list);
	}

	@Override
	public List<MeterDomain> getMeterByMeterAssestsNo(MeterAssetsDomain t) {
		return meterReadDAO.getMeterByMeterAssestsNo(t);
	}

	@Override
	public List<MeterDomain> getMeterByInductorAssestsNo(InductorAssetsDomain t) {
		return meterReadDAO.getMeterByInductorAssestsNo(t);
	}

	@Override
	public List<MeterDomain> getMeterByIds(List<Long> ids) {

		List<MeterDomain> rList = new ArrayList<MeterDomain>();

		// 处理超过1000个id
		int len = ids.size();
		for (int m = 0; m < len / 999 + 1; m++) {// 遍历次数

			List<Long> tl = ids.subList(m * 999, (m + 1) * 999 > len ? len : (m + 1) * 999);

			List<MeterDomain> tList = meterReadDAO.getMeterByIds(tl);

			rList.addAll(tList);

		}
		
		return rList;
	}

	@Override
	public List<MeterRelationDomain> getMeterRelByMeterIds(List<Long> ids) {

		List<MeterRelationDomain> rList = new ArrayList<MeterRelationDomain>();
		// 处理超过1000个id
		int len = ids.size();
		for (int m = 0; m < len / 999 + 1; m++) {// 遍历次数

			List<Long> tl = ids.subList(m * 999, (m + 1) * 999 > len ? len : (m + 1) * 999);

			List<MeterRelationDomain> tList = meterReadDAO.getMeterRelByMeterIds(tl);
			rList.addAll(tList);
		}

		return rList;
	}

	@Override
	public List<Long> getMeterIdsByWriteSectIds(List<Long> ids) {
		return meterReadDAO.getMeterIdsByWriteSectIds(ids);
	}

	@Override
	public List<Long> getMeterIdsByUserIds(List<Long> userIds) {

		List<Long> rl = new ArrayList<Long>();

		// 处理超过1000个id
		int len = userIds.size();
		for (int m = 0; m < len / 999 + 1; m++) {// 遍历次数
			// 根据用户ID获取计量点ID subList方法包含fromIndex, 不包含 toIndex
			List<Long> tl = userIds.subList(m * 999, (m + 1) * 999 > len ? len : (m + 1) * 999);

			List<Long> tempList = meterReadDAO.getMeterIdsByUserIds(tl);

			if (tempList.size() == 0 || tempList == null || tempList.get(0) == null) {
				continue;
			}

			rl.addAll(tempList);

			// 根据计量点ID和计量点关系关系获取meterIds
			List<Long> relList = meterReadDAO.getMeterIdsByMeterRel(tl);
			if (relList.size() == 0 || relList == null || relList.get(0) == null) {
				continue;
			}
			rl.addAll(relList);

		}

		return rl;
	}

	@Override
	public List<MeterDomain> getMeterByUserIds(List<Long> userIds) {
		
		List<MeterDomain> rList = new ArrayList<MeterDomain>();
		// 处理超过1000个id
		int len = userIds.size();
		for (int m = 0; m < len / 999 + 1; m++) {// 遍历次数

			List<Long> tl = userIds.subList(m * 999, (m + 1) * 999 > len ? len : (m + 1) * 999);

			List<MeterDomain> tList = meterReadDAO.getMeterByUserIds(tl);
			rList.addAll(tList);
			
//			//根据套口关系获取套扣计量点
//			List<Long> meterIdList = new ArrayList<Long>();
//			for(MeterDomain tm : tList) {
//				meterIdList.add(tm.getId());
//			}
//			
//			List<Long> relList = meterDAO.getMeterIdsByMeterRel(meterIdList);
//			List<MeterDomain> ttList = meterDAO.getMeterByIds(relList);
//			
//			if (ttList.size() == 0 || ttList == null || ttList.get(0) == null) {
//				continue;
//			}
//			rList.addAll(ttList);

		}
		
		return rList;
		
	}

	@Override
	public List<MeterDomain> meterNoDC(MeterDomain t) {
		return meterReadDAO.meterNoDC(t);
	}

	@Override
	public List<MeterDomain> getMeterByWriteSectIds(List<Long> writeSectIds) {
		
		return meterReadDAO.getMeterByWriteSectIds(writeSectIds);
		
	}

	@Override
	public List<MeterDomain> getMeterByCustomer(MeterDomain e) {
		return meterReadDAO.getMeterByCustomer(e);

	}

	public List<MeterInformationEntity> getMeterInformation(MeterInformationEntity e) {
		return meterReadDAO.getMeterInformation(e);

	}

	@Override
	public List<MeterDomain> findMetersByMeterIds(List<Long> meterIds) {
		return meterReadDAO.selectMetersByMeterIds(meterIds);
	}

	@Override
	public int updateList(List<MeterDomain> e) {
		return meterWriteDAO.updateList(e);
	}

	@Override
	public int insertList(List<MeterDomain> meterList) {
		return meterWriteDAO.insertList(meterList);

	}
	@Override
	public List<MeterDomain> getMeterByMeterIds(List<Long> tList){
		return meterReadDAO.getMeterByMeterIds(tList);
	}

	@Override
	public int updateWriteSectIdByUserId(MeterDomain meterDomain) {
		return meterWriteDAO.updateWriteSectIdByUserId(meterDomain);

	}
	@Override
	public List<MeterDomain> getMeterAndUserByIds(List<Long> meterIds) {
		return meterReadDAO.getMeterAndUserByIds(meterIds);

	}

	@Override
	public List<MeterDomain> getMeterByUserNos(List<UserDomain> userList) {
		return meterReadDAO.getMeterByUserNos(userList);

	}

	@Override
	public List<MeterDomain> getMeterByUserNo(UserDomain userDomain) {
		return meterReadDAO.getMeterByUserNo(userDomain);

	}

	@Override
	public List<MeterDomain> getMeterByMeterIdsWithoutStatus(List<Long> meterIds) {
		return meterReadDAO.getMeterByMeterIdsWithoutStatus(meterIds);

	}

	@Override
	public List<MeterDomain> getMeterByMeterNos(List<String> pMeterNoList) {
		return meterReadDAO.getMeterByMeterNos(pMeterNoList);
	}
	@Override
	public List<MeterDomain> findClearMeterDoaminByWhere(MeterDomain t) {
		return meterReadDAO.findClearMeterDoaminByWhere(t);
	}

	@Override
	public List<MeterDomain> getNolineMeter(MeterDomain t) {
		return meterReadDAO.getNolineMeter(t);
	}

}
