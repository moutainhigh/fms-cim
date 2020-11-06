package org.fms.cim.server.webapp.archives.service;

import java.util.List;

import org.fms.cim.common.domain.archives.MeterDomain;
import org.fms.cim.common.domain.archives.TransformerMeterRelationDomain;
import org.fms.cim.common.service.IMeterTransRelService;
import org.fms.cim.server.webapp.archives.dao.MeterTransRelDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class MeterTransRelServiceImpl implements IMeterTransRelService {
    @TransactionDAO("read")
    private MeterTransRelDAO meterTransRelReadDAO;
    
    @TransactionDAO("write")
    private MeterTransRelDAO meterTransRelWriteDAO;
    
    @Override
    public List<MeterDomain> getTransformerByNoMeterRel(MeterDomain t) {
        return meterTransRelReadDAO.getTransformerByNoMeterRel(t);
    }

    @Override
    public List<MeterDomain> getTransformerByMeterRel(MeterDomain t) {
        return meterTransRelReadDAO.getTransformerByMeterRel(t);
    }

    @Override
    public List<TransformerMeterRelationDomain> findTransformerGroupNo(TransformerMeterRelationDomain rel) {
        return meterTransRelReadDAO.findTransformerGroupNo(rel);
    }

    @Override
    public int addTransformerByMeterRel(List<TransformerMeterRelationDomain> list, MeterDomain deleteList) {
    	meterTransRelWriteDAO.deleteTransformerByMeterRel(deleteList);
        if(list!=null&&list.size()>0) {
            for(TransformerMeterRelationDomain tm:list) {
            	if(tm.getMsType()!=null && tm.getMsType()-2==0) {
                	tm.setTransLostType((byte) 2);
            	}else {
                	tm.setTransLostType((byte) 0);
            	}
            	tm.setStatus((byte) 1);
            }
        }
        return meterTransRelWriteDAO.addTransformerByMeterRel(list);
    }

    @Override
    public List<MeterDomain> getMeterByWriteSectionId(MeterDomain t) {
        return meterTransRelReadDAO.getMeterByWriteSectionId(t);
    }

	@Override
	public int updateTransLoss(TransformerMeterRelationDomain e) {
        return meterTransRelWriteDAO.updateTransLoss(e);

	}

	@Override
	public List<TransformerMeterRelationDomain> getMeterByTransRel(TransformerMeterRelationDomain e) {
        return meterTransRelReadDAO.getMeterByTransRel(e);

	}
}
