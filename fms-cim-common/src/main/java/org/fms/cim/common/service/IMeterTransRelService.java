package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.TransformerMeterRelationDomain;

public interface IMeterTransRelService {

    public List<MeterDomain> getTransformerByNoMeterRel(MeterDomain t);

    public List<MeterDomain> getTransformerByMeterRel(MeterDomain t);

    public int addTransformerByMeterRel(List<TransformerMeterRelationDomain> list, MeterDomain deleteList);

    List<TransformerMeterRelationDomain> findTransformerGroupNo(TransformerMeterRelationDomain rel);

    public List<MeterDomain> getMeterByWriteSectionId(MeterDomain e);

	public int updateTransLoss(TransformerMeterRelationDomain e);

	public List<TransformerMeterRelationDomain> getMeterByTransRel(TransformerMeterRelationDomain e);
}
