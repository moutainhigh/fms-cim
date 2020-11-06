/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.assets.service;

import java.util.List;

import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.domain.assets.InductorAssetsDomain;
import org.fms.cim.common.domain.assets.InductorAssetsEntity;
import org.fms.cim.common.service.IInductorAssetsService;
import org.fms.cim.server.webapp.assets.dao.InductorAssetsDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class InductorAssetsServiceImpl implements IInductorAssetsService {
	
	@TransactionDAO("read")
	private InductorAssetsDAO inductorAssetsReadDAO;
	
	@TransactionDAO("write")
	private InductorAssetsDAO inductorAssetsWriteDAO;

	@Override
	public int insert(InductorAssetsDomain t) {
		// TODO Auto-generated method stub
		return inductorAssetsWriteDAO.insert(t);
	}

	@Override
	public int delete(InductorAssetsDomain t) {
		// TODO Auto-generated method stub
		return inductorAssetsWriteDAO.delete(t);
	}

	@Override
	public int update(InductorAssetsDomain t) {
		// TODO Auto-generated method stub
		return inductorAssetsWriteDAO.update(t);
	}

	@Override
	public InductorAssetsDomain findByKey(InductorAssetsDomain t) {
		// TODO Auto-generated method stub
		return inductorAssetsReadDAO.findByKey(t);
	}

	@Override
	public List<InductorAssetsDomain> findByWhere(InductorAssetsDomain t) {
		// TODO Auto-generated method stub
		return inductorAssetsReadDAO.findByWhere(t);
	}

	@Override
	public List<InductorAssetsDomain> getInductorAssetsByManager(InductorAssetsDomain inductorAssetsDomain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InductorAssetsDomain> getInductorAssetsByUser(UserDomain t) {
		// TODO Auto-generated method stub
		return inductorAssetsReadDAO.getInductorAssetsByUser(t);
	}

	@Override
	public List<InductorAssetsDomain> assetsNoDC(InductorAssetsDomain t) {
		// TODO Auto-generated method stub
		return inductorAssetsReadDAO.assetsNoDC(t);
	}

	@Override
	public int updateList(List<InductorAssetsDomain> l) {
		// TODO Auto-generated method stub
		return inductorAssetsWriteDAO.updateList(l);
	}

	@Override
	public InductorAssetsEntity findInductEntityByWhere(String t) {
		// TODO Auto-generated method stub
		return inductorAssetsReadDAO.findInductEntityByWhere(t);
	}

}
