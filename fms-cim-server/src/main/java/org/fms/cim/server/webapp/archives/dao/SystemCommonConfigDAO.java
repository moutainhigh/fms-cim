/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:28:46
 *    Title:com.riozenc.cim.webapp.dao.CustomerDAO.java
 **/
package org.fms.cim.server.webapp.archives.dao;

import java.util.List;

import org.fms.cim.common.vo.uas.SystemCommonConfigVO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;
import com.riozenc.titanTool.spring.webapp.dao.BaseDAO;

@TransactionDAO
public class SystemCommonConfigDAO extends AbstractTransactionDAOSupport implements BaseDAO<SystemCommonConfigVO> {

	@Override
	public int insert(SystemCommonConfigVO t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().insert(getNamespace() + ".insert", t);
	}

	@Override
	public int delete(SystemCommonConfigVO t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().delete(getNamespace() + ".delete", t);
	}

	@Override
	public int update(SystemCommonConfigVO t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().update(getNamespace() + ".update", t);
	}

	@Override
	public SystemCommonConfigVO findByKey(SystemCommonConfigVO t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().load(getNamespace() + ".findByKey", t);
	}
	
	@Override
	public List<SystemCommonConfigVO> findByWhere(SystemCommonConfigVO t) {
		// TODO Auto-generated method stub
		return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
	}

	public SystemCommonConfigVO findByKeyValue(String type,String key){
		SystemCommonConfigVO  inductorConfig=new SystemCommonConfigVO();
		inductorConfig.setType(type);
		inductorConfig.setParamKey(key);
		List<SystemCommonConfigVO> systemCommonConfigDomains=findByWhere(inductorConfig);
		if(null==systemCommonConfigDomains || systemCommonConfigDomains.size()<1){
			return new SystemCommonConfigVO();
		}else{
			return systemCommonConfigDomains.get(0);
		}
	}

}
