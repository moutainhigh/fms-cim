/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.assets.service;

import java.util.List;

import org.fms.cim.common.domain.assets.MeterAssetsDomain;
import org.fms.cim.common.domain.assets.MeterAssetsUseRecordDomain;
import org.fms.cim.common.service.IMeterAssetsUseRecordService;
import org.fms.cim.server.webapp.assets.dao.MeterAssetsDAO;
import org.fms.cim.server.webapp.assets.dao.MeterAssetsUseRecordDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class MeterAssetsUseRecordServiceImpl implements IMeterAssetsUseRecordService {
	
	@TransactionDAO
	private MeterAssetsUseRecordDAO meterAssetsUseRecordDAO;
	@TransactionDAO
	private MeterAssetsDAO meterAssetsDAO;
	
	@Override
	public int insert(MeterAssetsUseRecordDomain t) {
		//添加领用记录
		int ur = meterAssetsUseRecordDAO.insert(t);
		
		//更新状态为领出待装
		if(ur==1) {
			MeterAssetsDomain mad = new MeterAssetsDomain();
			mad.setId(t.getMeterAssetsId());
			mad.setStatus((byte)6); //领出待装
			ur = meterAssetsDAO.update(mad);
		}
	
		return ur;
	}

	@Override
	public int delete(MeterAssetsUseRecordDomain t) {
		// TODO Auto-generated method stub
		return meterAssetsUseRecordDAO.delete(t);
	}

	@Override
	public int update(MeterAssetsUseRecordDomain t) {
		// TODO Auto-generated method stub
		return meterAssetsUseRecordDAO.update(t);
	}

	@Override
	public MeterAssetsUseRecordDomain findByKey(MeterAssetsUseRecordDomain t) {
		// TODO Auto-generated method stub
		return meterAssetsUseRecordDAO.findByKey(t);
	}

	@Override
	public List<MeterAssetsUseRecordDomain> findByWhere(MeterAssetsUseRecordDomain t) {
		// TODO Auto-generated method stub
		return meterAssetsUseRecordDAO.findByWhere(t);
	}

	@Override
	public int addMeterAssetsUseRecord(List<MeterAssetsDomain> meterAssetsList,
			MeterAssetsUseRecordDomain meterAssetsUseRecord) {
		
		int ur = 0;
		
		for(MeterAssetsDomain meterAssets : meterAssetsList) {
			
			meterAssetsUseRecord.setMeterAssetsId(meterAssets.getId());
			//添加领用记录
			ur = meterAssetsUseRecordDAO.insert(meterAssetsUseRecord);
			
			//更新状态为领出待装
			if(ur==1) {
				meterAssets.setStatus((byte)6); //领出待装
				meterAssets.setDeptId(meterAssetsUseRecord.getRequisitionDept());
				ur = meterAssetsDAO.update(meterAssets);
			}
		}
		return ur;
	}


}
