
/**
 * 多费率方案定义表
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPSysRateShemeService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PSysRateShemeVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IPSysRateShemeService {

    public int insert(PSysRateShemeVO pSysRateShemeVO);

    public int update(PSysRateShemeVO pSysRateShemeVO);

    public int delete(PSysRateShemeVO pSysRateShemeVO);

    public HttpResult deleteList(List<PSysRateShemeVO> deleteList) throws Exception;

    public PSysRateShemeVO findByKey(PSysRateShemeVO pSysRateShemeVO);

    public List<PSysRateShemeVO> findByWhere(PSysRateShemeVO pSysRateShemeVO);
}
