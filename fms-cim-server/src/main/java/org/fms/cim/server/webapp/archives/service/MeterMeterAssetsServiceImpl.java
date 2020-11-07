/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.ArrayList;
import java.util.List;

import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.MeterMeterAssetsRelDomain;
import org.fms.cim.common.domain.archives.MeterWriteSnEntity;
import org.fms.cim.common.domain.archives.WriteSectDomain;
import org.fms.cim.common.service.IMeterMeterAssetsService;
import org.fms.cim.server.webapp.archives.dao.MeterMeterAssetsRelDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class MeterMeterAssetsServiceImpl implements IMeterMeterAssetsService {

	@TransactionDAO("read")
	private MeterMeterAssetsRelDAO meterMeterAssetsReadDAO;
	
	@TransactionDAO("write")
	private MeterMeterAssetsRelDAO meterMeterAssetsWriteDAO;

	@Override
	public int insert(MeterMeterAssetsRelDomain t) {
		return meterMeterAssetsWriteDAO.insert(t);
	}

	@Override
	public int delete(MeterMeterAssetsRelDomain t) {
		return meterMeterAssetsWriteDAO.delete(t);
	}

	@Override
	public int update(MeterMeterAssetsRelDomain t) {
		return meterMeterAssetsWriteDAO.update(t);
	}

	@Override
	public MeterMeterAssetsRelDomain findByKey(MeterMeterAssetsRelDomain t) {
		return meterMeterAssetsReadDAO.findByKey(t);
	}

	@Override
	public List<MeterMeterAssetsRelDomain> findByWhere(MeterMeterAssetsRelDomain t) {
		return meterMeterAssetsReadDAO.findByWhere(t);
	}

	@Override
	public List<MeterMeterAssetsRelDomain> getMeterAssetsByMeterIds(List<Long> ids) {

		List<MeterMeterAssetsRelDomain> rList = new ArrayList<MeterMeterAssetsRelDomain>();
		//处理超过1000个id
		int len = ids.size();
		for(int m=0;m<len/999+1;m++) {//遍历次数

			List<Long> tl = ids.subList(m*999, (m+1)*999 > len ? len : (m+1)*999);

			List<MeterMeterAssetsRelDomain> tList = meterMeterAssetsReadDAO.getMeterAssetsByMeterIds(tl);
			rList.addAll(tList);
		}

		return rList;
	}
	@Override
	public List<MeterMeterAssetsRelDomain> getMeterEntityByMeterIds(String s){
		return meterMeterAssetsReadDAO.getMeterEntityByMeterIds(s);
	}

	@Override
	public Byte getNextMeterOrder(Long s){
		return meterMeterAssetsReadDAO.getNextMeterOrder(s);
	}

	public List<MeterWriteSnEntity> getMeterOrderByWriteSect(WriteSectDomain tl){
		return meterMeterAssetsReadDAO.getMeterOrderByWriteSect(tl);
	}

	public List<MeterWriteSnEntity> generateWriteOrderAuto(WriteSectDomain tl){
		return meterMeterAssetsReadDAO.generateWriteOrderAuto(tl);
	}

	public int updateList(List<MeterMeterAssetsRelDomain> t){
		return meterMeterAssetsWriteDAO.updateList(t);
	}

	@Override
	public int insertList(List<MeterMeterAssetsRelDomain> mmarList) {
		return meterMeterAssetsWriteDAO.insertList(mmarList);
	}

	@Override
	public List<MeterMeterAssetsRelDomain> getMeterAssetsByWriteSectIds(List<Long> writeSectIds) {
		return meterMeterAssetsReadDAO.getMeterAssetsByWriteSectIds(writeSectIds);

	}

	@Override
	public int updateByMeterAssetsId(MeterMeterAssetsRelDomain mmar) {
		return meterMeterAssetsWriteDAO.updateByMeterAssetsId(mmar);

	}

	@Override
	public int deleteByMeterIds(MeterDomain meter) throws Exception {
		int i = meterMeterAssetsWriteDAO.deleteByMeterIds(meter);
		if(i>1000) {
			throw new Exception("删除数量超过1000！！！！");
		}
		return i;

	}

	@Override
	public List<MeterMeterAssetsRelDomain> getmmarlByuserNos(List<String> userNos) {
		if(userNos==null || userNos.size()==0) {
			return new ArrayList<MeterMeterAssetsRelDomain>();
		}
		return meterMeterAssetsReadDAO.getmmarlByuserNos(userNos);

	}

}
