/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.assets.service;

import java.util.List;

import org.fms.cim.common.domain.archives.TransformerDomain;
import org.fms.cim.common.domain.assets.TransformerAssetsDomain;
import org.fms.cim.common.service.ITransformerAssetsService;
import org.fms.cim.server.webapp.archives.dao.TransformerDAO;
import org.fms.cim.server.webapp.assets.dao.TransformerAssetsDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class TransformerAssetsServiceImpl implements ITransformerAssetsService {
	
	@TransactionDAO
	private TransformerAssetsDAO transformerAssetsDAO;
	@TransactionDAO
	private TransformerDAO transformerDAO;

	@Override
	public int insert(TransformerAssetsDomain t) {
		// TODO Auto-generated method stub
		return transformerAssetsDAO.insert(t);
	}

	@Override
	public int delete(TransformerAssetsDomain t) {
		// TODO Auto-generated method stub
		return transformerAssetsDAO.delete(t);
	}

	@Override
	public int update(TransformerAssetsDomain t) {
		TransformerDomain transformer = new TransformerDomain();
		transformer.setTransformerAssetsId(t.getId());
		transformer.setCapacity(t.getRatedCapacity());
		transformer.setTransformerModelType(t.getTransformerModelType());
		transformer.setVoltType(t.getRatedVoltage());
		
		transformerDAO.updateByTransformerAssetsId(transformer);
		
		return transformerAssetsDAO.update(t);
	}

	@Override
	public TransformerAssetsDomain findByKey(TransformerAssetsDomain t) {
		// TODO Auto-generated method stub
		return transformerAssetsDAO.findByKey(t);
	}

	@Override
	public List<TransformerAssetsDomain> findByWhere(TransformerAssetsDomain t) {
		// TODO Auto-generated method stub
		return transformerAssetsDAO.findByWhere(t);
	}

	@Override
	public List<TransformerAssetsDomain> getTransformerAssetsByManager(
			TransformerAssetsDomain transformerAssetsDomain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransformerAssetsDomain> getTransformerAssetsByWhere(TransformerAssetsDomain t) {
		// TODO Auto-generated method stub
		return transformerAssetsDAO.getTransformerAssetsByWhere(t);
	}

	@Override
	public List<TransformerAssetsDomain> findByNoId(TransformerAssetsDomain e) {
		return transformerAssetsDAO.findByNoId(e);

	}

}
