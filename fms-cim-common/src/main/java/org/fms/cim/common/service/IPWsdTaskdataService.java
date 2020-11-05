
/**
 * 规约数据单元
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPWsdTaskdataService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PWsdTaskdataVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IPWsdTaskdataService {

    public int insert(PWsdTaskdataVO pWsdTaskdataVO);

    public int update(PWsdTaskdataVO pWsdTaskdataVO);

    public int delete(PWsdTaskdataVO pWsdTaskdataVO);

    public HttpResult deleteList(List<PWsdTaskdataVO> deleteList) throws Exception;

    public PWsdTaskdataVO findByKey(PWsdTaskdataVO pWsdTaskdataVO);

    public List<PWsdTaskdataVO> findByWhere(PWsdTaskdataVO pWsdTaskdataVO);
}
