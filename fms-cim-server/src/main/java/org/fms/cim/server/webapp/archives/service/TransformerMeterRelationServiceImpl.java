/**
 * Author : czy
 * Date : 2019年8月23日 下午3:54:16
 * Title : com.riozenc.cim.webapp.archives.service.impl.TransformerMeterRelationServiceImpl.java
 *
**/
package org.fms.cim.server.webapp.archives.service;

import java.util.ArrayList;
import java.util.List;

import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.TransformerDomain;
import org.fms.cim.common.domain.archives.TransformerLineRelDomain;
import org.fms.cim.common.domain.archives.TransformerMeterRelationDomain;
import org.fms.cim.common.service.ITransformerMeterRelationService;
import org.fms.cim.server.webapp.archives.dao.TransformerMeterRelationDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class TransformerMeterRelationServiceImpl implements ITransformerMeterRelationService {
	@TransactionDAO("read")
	private TransformerMeterRelationDAO transformerMeterRelationReadDAO;
	
	@TransactionDAO("write")
	private TransformerMeterRelationDAO transformerMeterRelationWriteDAO;

	@Override
	public int insert(TransformerMeterRelationDomain t) {
		return transformerMeterRelationWriteDAO.insert(t);
	}

	@Override
	public int delete(TransformerMeterRelationDomain t) {
		return transformerMeterRelationWriteDAO.delete(t);
	}

	@Override
	public int update(TransformerMeterRelationDomain t) {
		return transformerMeterRelationWriteDAO.update(t);
	}

	@Override
	public TransformerMeterRelationDomain findByKey(TransformerMeterRelationDomain t) {
		return transformerMeterRelationReadDAO.findByKey(t);
	}

	@Override
	public List<TransformerMeterRelationDomain> findByWhere(TransformerMeterRelationDomain t) {
		return transformerMeterRelationReadDAO.findByWhere(t);
	}

	@Override
	public List<TransformerMeterRelationDomain> getTransformerMeterRelationByWriteSectId(List<Long> writeSectIds) {
		return transformerMeterRelationReadDAO.getTransformerMeterRelationByWriteSectId(writeSectIds);
	}

	@Override
	public List<TransformerMeterRelationDomain> getTransformerMeterRelationByMeterIds(List<Long> meterIds) {

		List<TransformerMeterRelationDomain> rList = new ArrayList<TransformerMeterRelationDomain>();
		// 处理超过1000个id
		int len = meterIds.size();
		for (int m = 0; m < len / 999 + 1; m++) {// 遍历次数

			List<Long> tl = meterIds.subList(m*999, (m+1)*999 > len ? len : (m+1)*999);

			List<TransformerMeterRelationDomain> tList = transformerMeterRelationReadDAO.getTransformerMeterRelationByMeterIds(tl);
			rList.addAll(tList);
		}
		//去重
		
		return rList;
		
	}

	@Override
	public int insertList(List<TransformerMeterRelationDomain> tmrList) {
		return transformerMeterRelationWriteDAO.insertList(tmrList);

	}
	@Override
	public List<TransformerMeterRelationDomain> getDistinctTransGroupNo(TransformerMeterRelationDomain t) {
		return transformerMeterRelationReadDAO.getDistinctTransGroupNo(t);

	}
	@Override
	public List<MeterDomain> getMeterByTransformer(TransformerDomain t) {
		return transformerMeterRelationReadDAO.getMeterByTransformer(t);

	}

	@Override
	public int updateList(List<TransformerMeterRelationDomain> tmruList) {
		return transformerMeterRelationWriteDAO.updateList(tmruList);

	}
	@Override
	public List<TransformerLineRelDomain> findTransformerLineByMeterIds(List<Long> meterIds) {
		return transformerMeterRelationReadDAO.findTransformerLineByMeterIds(meterIds);

	}
	

}
