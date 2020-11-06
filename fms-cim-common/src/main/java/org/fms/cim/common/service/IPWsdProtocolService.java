
/**
 * 规约定义表
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.IPWsdProtocolService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.PWsdProtocolVO;

import java.util.List;

public interface IPWsdProtocolService {

    public int insert(PWsdProtocolVO pWsdProtocolVO);

    public int update(PWsdProtocolVO pWsdProtocolVO);

    public int delete(PWsdProtocolVO pWsdProtocolVO);

    public HttpResult deleteList(List<PWsdProtocolVO> deleteList) throws Exception;

    public PWsdProtocolVO findByKey(PWsdProtocolVO pWsdProtocolVO);

    public List<PWsdProtocolVO> findByWhere(PWsdProtocolVO pWsdProtocolVO);
}
