/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.List;

import org.fms.cim.common.domain.archives.LineDomain;
import org.fms.cim.common.domain.archives.SubsLineRelaDomain;
import org.fms.cim.common.service.ILineService;
import org.fms.cim.server.webapp.archives.dao.LineDAO;
import org.fms.cim.server.webapp.archives.dao.SubsLineRelaDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class LineServiceImpl implements ILineService {

	@TransactionDAO("read")
	private LineDAO lineReadDAO;
	
	@TransactionDAO("write")
	private LineDAO lineWriteDAO;
	
	@TransactionDAO("read")
	private SubsLineRelaDAO subsLineRelaReadDAO;
	
	@TransactionDAO("write")
	private SubsLineRelaDAO subsLineRelaWriteDAO;


	@Override
	public int insert(LineDomain t) {
		// TODO Auto-generated method stub
		return lineWriteDAO.insert(t);
	}

	@Override
	public int delete(LineDomain t) {
		// TODO Auto-generated method stub
		return lineWriteDAO.delete(t);
	}

	@Override
	public int update(LineDomain t) {
		// TODO Auto-generated method stub
		return lineWriteDAO.update(t);
	}

	@Override
	public LineDomain findByKey(LineDomain t) {
		// TODO Auto-generated method stub
		return lineReadDAO.findByKey(t);
	}

	@Override
	public List<LineDomain> findByWhere(LineDomain t) {
		// TODO Auto-generated method stub
		return lineReadDAO.findByWhere(t);
	}

	@Override
	public List<LineDomain> findByLineCode(LineDomain t) {
		// TODO Auto-generated method stub
		return lineReadDAO.findByLineCode(t);
	}

	public boolean addLineAndSubsLineRela(LineDomain line,SubsLineRelaDomain t) {
		// TODO Auto-generated method stub
		int lcount =  lineWriteDAO.insert(line);

		if(lcount<=0) {
			return false;
		}

		t.setLineId(line.getId());
		int r = subsLineRelaWriteDAO.insert(t);
		if(r>0) {
			return true;

		}

		return true;
	}

	public boolean updateLineAndSubsLineRela(LineDomain line,SubsLineRelaDomain t) {


		int rcount = subsLineRelaWriteDAO.update(t);
		int lcount = lineWriteDAO.update(line);

		if(lcount>0) {
			return true;
		}

		return false;
	}

	@Override
	public List<LineDomain> findByLineIds(LineDomain e){
		return lineReadDAO.findByLineIds(e);
	}
}
