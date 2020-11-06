/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.ArrayList;
import java.util.List;

import org.fms.cim.common.domain.archives.MeterRelationDomain;
import org.fms.cim.common.service.IMeterRelationService;
import org.fms.cim.server.webapp.archives.dao.MeterRelationDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class MeterRelationServiceImpl implements IMeterRelationService {

	@TransactionDAO("read")
	private MeterRelationDAO meterRelationReadDAO;
	
	@TransactionDAO("write")
	private MeterRelationDAO meterRelationWriteDAO;

	@Override
	public int insert(MeterRelationDomain t) {
		return meterRelationWriteDAO.insert(t);
	}

	@Override
	public int delete(MeterRelationDomain t) {
		return meterRelationWriteDAO.delete(t);
	}

	@Override
	public int update(MeterRelationDomain t) {
		return meterRelationWriteDAO.update(t);
	}

	@Override
	public MeterRelationDomain findByKey(MeterRelationDomain t) {
		return meterRelationReadDAO.findByKey(t);
	}

	@Override
	public List<MeterRelationDomain> findByWhere(MeterRelationDomain t) {
		return meterRelationReadDAO.findByWhere(t);
	}

	@Override
	public int deleteList(List<MeterRelationDomain> meterRelList) {
		return meterRelationWriteDAO.deleteList(meterRelList);
	}

	@Override
	public List<MeterRelationDomain> getMeterRelationByWriteSectIds(List<Long> writeSectIds) {
		return meterRelationReadDAO.getMeterRelationByWriteSectId(writeSectIds);
	}

	@Override
	public int insertList(List<MeterRelationDomain> meterRelList) {
		return meterRelationWriteDAO.insertList(meterRelList);		
	}

	@Override
	public List<MeterRelationDomain> getMeterRelationByMeterIds(List<Long> MeterIds) {
		
		List<MeterRelationDomain> rList = new ArrayList<MeterRelationDomain>();

		// 处理超过1000个id
		int len = MeterIds.size();
		for (int m = 0; m < len / 999 + 1; m++) {// 遍历次数

			List<Long> tl = MeterIds.subList(m * 999, (m + 1) * 999 > len ? len : (m + 1) * 999);

			List<MeterRelationDomain> tList = meterRelationReadDAO.getMeterRelationByMeterIds(tl);

			rList.addAll(tList);

		}

		return rList;

	}

	@Override
	public int updateList(List<MeterRelationDomain> mreluList) {
		return meterRelationWriteDAO.updateList(mreluList);		

	}

	//查重
	@Override
	public List<MeterRelationDomain> cc(MeterRelationDomain t) {
		return meterRelationReadDAO.cc(t);		

	}

}
