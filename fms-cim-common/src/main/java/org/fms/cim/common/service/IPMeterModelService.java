
/**
 * 
 * Author : 
 * Date : 
 * Title : org.fms.eis.webapp.service.IPMeterModelService.java
 *
**/
package org.fms.cim.common.service;
import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.PMeterModelVO;


import java.util.List;

public interface IPMeterModelService {

	public int insert(PMeterModelVO pMeterModelVO);

	public int update(PMeterModelVO pMeterModelVO);

	public int delete(PMeterModelVO pMeterModelVO);

	public HttpResult deleteList(List<PMeterModelVO> deleteList) throws Exception;

	public PMeterModelVO findByKey(PMeterModelVO pMeterModelVO);

	public List<PMeterModelVO> findByWhere(PMeterModelVO pMeterModelVO);
}
