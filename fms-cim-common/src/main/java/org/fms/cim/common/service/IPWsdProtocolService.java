
/**
 * 规约定义表
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPWsdProtocolService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PWsdProtocolVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IPWsdProtocolService {

    public int insert(PWsdProtocolVO pWsdProtocolVO);

    public int update(PWsdProtocolVO pWsdProtocolVO);

    public int delete(PWsdProtocolVO pWsdProtocolVO);

    public HttpResult deleteList(List<PWsdProtocolVO> deleteList) throws Exception;

    public PWsdProtocolVO findByKey(PWsdProtocolVO pWsdProtocolVO);

    public List<PWsdProtocolVO> findByWhere(PWsdProtocolVO pWsdProtocolVO);
}
