/**
 * Author : chizf
 * Date : 2020年11月12日 下午5:09:21
 * Title : org.fms.cim.client.rpc.RCpServiceImpl.java
 *
**/
package org.fms.cim.client.rpc.impl;

import java.util.List;

import org.fms.cim.common.service.IRCpService;
import org.fms.cim.common.vo.uas.RCpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.riozenc.titanTool.spring.web.client.TitanTemplate;
import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;

@Service
public class RCpServiceImpl implements IRCpService {

	@Autowired
	private TitanTemplate titanTemplate;

	@Override
	public int insert(RCpVO rCpVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(RCpVO rCpVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(RCpVO rCpVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HttpResult deleteList(List<RCpVO> deleteList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RCpVO findByKey(RCpVO rCpVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RCpVO> findByWhere(RCpVO rCpVO) {

		try {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);

			HttpResultPagination<RCpVO> httpResultPagination = titanTemplate.post("CIM-SERVER",
					"cimServer/RCp?method=findByWhere", httpHeaders, rCpVO,
					new TypeReference<HttpResultPagination<RCpVO>>() {
					});
			return httpResultPagination.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
