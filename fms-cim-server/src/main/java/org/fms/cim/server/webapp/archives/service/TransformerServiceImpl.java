/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:23
 *    Title:com.riozenc.cim.webapp.service.impl.SettlementServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.fms.cim.common.domain.archives.CustomerDomain;
import org.fms.cim.common.domain.archives.TransformerDomain;
import org.fms.cim.common.domain.archives.TransformerLineRelDomain;
import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.domain.assets.TransformerAssetsDomain;
import org.fms.cim.common.service.ITransformerService;
import org.fms.cim.server.webapp.archives.dao.MeterDAO;
import org.fms.cim.server.webapp.archives.dao.TransformerDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class TransformerServiceImpl implements ITransformerService {

	@TransactionDAO("read")
	private TransformerDAO transformerReadDAO;
	
	@TransactionDAO("write")
	private TransformerDAO transformerWriteDAO;
	
	@TransactionDAO("read")
	private MeterDAO meterReadDAO;
	
	@TransactionDAO("write")
	private MeterDAO meterWriteDAO;

	@Override
	public int insert(TransformerDomain t) {

		int tc = transformerWriteDAO.insert(t);
		if(tc<=0) {
			return 0;
		}else if(t.getLineId()==null) {
			return 1;
		}
		//如果未关联线路直接返回1，如果关联了线路返回插入线路和变压器关系的结果
		return transformerWriteDAO.insertLineTransRela(t);
	}

	@Override
	public int delete(TransformerDomain t) {
		// TODO Auto-generated method stub
		return transformerWriteDAO.delete(t);
	}

	@Override
	public int update(TransformerDomain t) {
		int tc = transformerWriteDAO.update(t);
		//更新变压器档案时，如果无线路ID，不更新线路变压器关系表
		List<TransformerDomain> tt = transformerReadDAO.findRelByTranId(t);
		if(t.getLineId()==null) {
			return tc;
		}
		int rc = 0;
		if(tt.size()==0) {
			rc = transformerWriteDAO.insertLineTransRela(t);
		}

		rc = transformerWriteDAO.updateLineTransRela(t);
		return rc;
	}

	@Override
	public TransformerDomain findByKey(TransformerDomain t) {
		// TODO Auto-generated method stub
		return transformerReadDAO.findByKey(t);
	}

	@Override
	public List<TransformerDomain> findByWhere(TransformerDomain t) {
		// TODO Auto-generated method stub
		return transformerReadDAO.findByWhere(t);
	}

	@Override
	public List<TransformerDomain> findByNo(TransformerDomain t) {
		// TODO Auto-generated method stub
		return transformerReadDAO.findByNo(t);
	}

	@Override
	public List<TransformerDomain> getTransformerByUser(UserDomain userDomain) {
		// TODO Auto-generated method stub
		return transformerReadDAO.getTransformerByUser(userDomain);
	}

	@Override
	public List<TransformerDomain> getTransformerByAsset(TransformerAssetsDomain t) {
		// TODO Auto-generated method stub
		return transformerReadDAO.getTransformerByAsset(t);
	}

	@Override
	public List<TransformerDomain> getTransformerByMeterIds(List<Long> ids) {

		List<TransformerDomain> rList = new ArrayList<TransformerDomain>();
		//处理超过1000个id
		int len = ids.size();
		for(int m=0;m<len/999+1;m++) {//遍历次数

			List<Long> tl = ids.subList(m*999, (m+1)*999 > len ? len : (m+1)*999);

			List<TransformerDomain> tList = transformerReadDAO.getTransformerByMeterIds(tl);
			rList.addAll(tList);
		}

		return rList;
		
	}

	@Override
	public List<TransformerDomain> getTransformerByWriteSectIds(List<Long> ids) {
		return transformerReadDAO.getTransformerByWriteSectIds(ids);
	}

	@Override
	public List<TransformerDomain> findByNoId(TransformerDomain transformerDomain) {
		return transformerReadDAO.findByNoId(transformerDomain);

	}

	@Override
	public List<Map> getTransformerByRel(List<Long> ids) {
		return transformerReadDAO.getTransformerByRel(ids);

	}
    @Override
    public List<TransformerDomain> getAvaTransformerByWhere(TransformerDomain transformerDomain){
        return transformerReadDAO.getAvaTransformerByWhere(transformerDomain);
    }

	@Override
	public List<TransformerDomain> getTransformerByCustomer(CustomerDomain customerDomain) {
        return transformerReadDAO.getTransformerByCustomer(customerDomain);

	}
	@Override
	public List<TransformerLineRelDomain> findRelByTranformIds(TransformerLineRelDomain t) {
		return transformerReadDAO.findRelByTranformIds(t);
	}

	@Override
	public List<TransformerLineRelDomain> findRelByLineIds(TransformerLineRelDomain t) {
		return transformerReadDAO.findRelByLineIds(t);
	}

	@Override
	public List<TransformerDomain> getTransformerByNos(List<String> transformerNoList) {
		return transformerReadDAO.getTransformerByNos(transformerNoList);

	}

}
