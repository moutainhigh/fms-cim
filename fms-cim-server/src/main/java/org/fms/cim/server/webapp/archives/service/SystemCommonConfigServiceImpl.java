/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:49
 *    Title:com.riozenc.cim.webapp.service.impl.CustomerServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.List;

import org.fms.cim.common.domain.archives.SystemCommonConfigDomain;
import org.fms.cim.common.service.ISystemCommonConfigService;
import org.fms.cim.common.vo.uas.SystemCommonConfigVO;
import org.fms.cim.server.webapp.archives.dao.SystemCommonConfigDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;
import com.riozenc.titanTool.spring.web.http.HttpResult;

@TransactionService
public class SystemCommonConfigServiceImpl implements ISystemCommonConfigService {

	@TransactionDAO("master")
	private SystemCommonConfigDAO systemCommonConfigDAO;
	@Override
	public int insert(SystemCommonConfigVO t) {
		// TODO Auto-generated method stub
		return systemCommonConfigDAO.insert(t);
	}
	@Override
	public int delete(SystemCommonConfigVO t) {
		// TODO Auto-generated method stub
		return systemCommonConfigDAO.delete(t);
	}
	@Override
	public int update(SystemCommonConfigVO t) {
		// TODO Auto-generated method stub
		return systemCommonConfigDAO.update(t);
	}
	@Override
	public SystemCommonConfigVO findByKey(SystemCommonConfigVO t) {
		// TODO Auto-generated method stub
		return systemCommonConfigDAO.findByKey(t);
	}
	@Override
	public List<SystemCommonConfigVO> findByWhere(SystemCommonConfigVO t) {
		// TODO Auto-generated method stub
		return systemCommonConfigDAO.findByWhere(t);
	}
	@Override
	public SystemCommonConfigVO findByKeyValue(String type,String key){
		return systemCommonConfigDAO.findByKeyValue(type,key);
	}
	//TODO
	@Override
	public HttpResult deleteList(List<SystemCommonConfigVO> deleteList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
