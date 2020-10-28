/**
 * Author : czy
 * Date : 2019年11月21日 下午2:26:03
 * Title : com.riozenc.cim.webapp.archives.service.impl.TransformerLossTableParamServiceImpl.java
 *
**/
package org.fms.cim.server.webapp.archives.service;

import java.util.List;

import org.fms.cim.common.domain.archives.TransformerLossTableParamDomain;
import org.fms.cim.common.service.ITransformerLossTableParamService;
import org.fms.cim.server.webapp.archives.dao.TransformerLossTableParamDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class TransformerLossTableParamServiceImpl implements ITransformerLossTableParamService {

	@TransactionDAO
	private TransformerLossTableParamDAO transformerLossTableParamDAO;

	@Override
	public int insert(TransformerLossTableParamDomain t) {
		return transformerLossTableParamDAO.insert(t);
	}

	@Override
	public int delete(TransformerLossTableParamDomain t) {
		return transformerLossTableParamDAO.delete(t);
	}

	@Override
	public int update(TransformerLossTableParamDomain t) {
		return transformerLossTableParamDAO.update(t);
	}

	@Override
	public TransformerLossTableParamDomain findByKey(TransformerLossTableParamDomain t) {
		return transformerLossTableParamDAO.findByKey(t);
	}

	@Override
	public List<TransformerLossTableParamDomain> findByWhere(TransformerLossTableParamDomain t) {
		return transformerLossTableParamDAO.findByWhere(t);
	}

}
