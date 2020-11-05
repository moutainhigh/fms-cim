/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.assets.service;

import java.util.List;

import org.fms.cim.common.domain.assets.ATmnlDomain;
import org.fms.cim.common.domain.assets.PSimCardDomain;
import org.fms.cim.common.service.IAtmnlService;
import org.fms.cim.common.service.IPsimCardService;
import org.fms.cim.server.webapp.assets.dao.ATmnlDAO;
import org.fms.cim.server.webapp.assets.dao.PSimCardDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class PsimCardServiceImpl implements IPsimCardService {
	
	@TransactionDAO
	private PSimCardDAO psimcardlDAO;
	

	@Override
	public int insert(PSimCardDomain t) {
		// TODO Auto-generated method stub
		return psimcardlDAO.insert(t);
	}

	@Override
	public int delete(PSimCardDomain t) {
		// TODO Auto-generated method stub
		return psimcardlDAO.delete(t);
	}

	@Override
	public int update(PSimCardDomain t) {
		// TODO Auto-generated method stub
		return psimcardlDAO.update(t);
	}

	@Override
	public PSimCardDomain findByKey(PSimCardDomain t) {
		// TODO Auto-generated method stub
		return psimcardlDAO.findByKey(t);
	}

	@Override
	public List<PSimCardDomain> findByWhere(PSimCardDomain t) {
		// TODO Auto-generated method stub
		return psimcardlDAO.findByWhere(t);
	}

}
