/**
 * Author : czy
 * Date : 2019年8月23日 下午3:53:04
 * Title : com.riozenc.cim.webapp.archives.service.ITransformerMeterRelationService.java
 *
**/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.TransformerDomain;
import org.fms.cim.common.domain.archives.TransformerLineRelDomain;
import org.fms.cim.common.domain.archives.TransformerMeterRelationDomain;

import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface ITransformerMeterRelationService extends BaseService<TransformerMeterRelationDomain> {

	public List<TransformerMeterRelationDomain> getTransformerMeterRelationByWriteSectId(List<Long> writeSectIds);

	public List<TransformerMeterRelationDomain> getTransformerMeterRelationByMeterIds(List<Long> meterIds);

	public int insertList(List<TransformerMeterRelationDomain> tmrList);

	public List<TransformerMeterRelationDomain> getDistinctTransGroupNo(TransformerMeterRelationDomain t);

	public List<MeterDomain> getMeterByTransformer(TransformerDomain t);

	public int updateList(List<TransformerMeterRelationDomain> tmruList);

	public List<TransformerLineRelDomain> findTransformerLineByMeterIds(List<Long> meterIds);
}
