
/**
 * 计算方案
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPSysCalcSchemeService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PSysCalcSchemeVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IPSysCalcSchemeService {

    public int insert(PSysCalcSchemeVO pSysCalcSchemeVO);

    public int update(PSysCalcSchemeVO pSysCalcSchemeVO);

    public int delete(PSysCalcSchemeVO pSysCalcSchemeVO);

    public HttpResult deleteList(List<PSysCalcSchemeVO> deleteList) throws Exception;

    public PSysCalcSchemeVO findByKey(PSysCalcSchemeVO pSysCalcSchemeVO);

    public List<PSysCalcSchemeVO> findByWhere(PSysCalcSchemeVO pSysCalcSchemeVO);
}
