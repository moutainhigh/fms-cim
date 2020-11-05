/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:49
 *    Title:com.riozenc.cim.webapp.service.impl.CustomerServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.List;

import org.fms.cim.common.domain.archives.SystemCommonConfigDomain;
import org.fms.cim.common.service.ISystemCommonConfigService;
import org.fms.cim.server.webapp.archives.dao.SystemCommonConfigDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class SystemCommonConfigServiceImpl implements ISystemCommonConfigService {

	@TransactionDAO("master")
	private SystemCommonConfigDAO systemCommonConfigDAO;

	@Override
	public int insert(SystemCommonConfigDomain t) {
		// TODO Auto-generated method stub
		return systemCommonConfigDAO.insert(t);
	}

	@Override
	public int delete(SystemCommonConfigDomain t) {
		// TODO Auto-generated method stub
		return systemCommonConfigDAO.delete(t);
	}

	@Override
	public int update(SystemCommonConfigDomain t) {
		// TODO Auto-generated method stub
		return systemCommonConfigDAO.update(t);
	}

	@Override
	public SystemCommonConfigDomain findByKey(SystemCommonConfigDomain t) {
		// TODO Auto-generated method stub
		return systemCommonConfigDAO.findByKey(t);
	}

	@Override
	public List<SystemCommonConfigDomain> findByWhere(SystemCommonConfigDomain t) {
		// TODO Auto-generated method stub
		return systemCommonConfigDAO.findByWhere(t);
	}
	@Override
	public SystemCommonConfigDomain findByKeyValue(String type,String key){
		return systemCommonConfigDAO.findByKeyValue(type,key);
	}


}
