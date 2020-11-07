
/**
 * 系统节点进程信息
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.IPNodeProcService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.PNodeProcVO;

import java.util.List;

public interface IPNodeProcService {

    public int insert(PNodeProcVO pNodeProcVO);

    public int update(PNodeProcVO pNodeProcVO);

    public int delete(PNodeProcVO pNodeProcVO);

    public HttpResult deleteList(List<PNodeProcVO> deleteList) throws Exception;

    public PNodeProcVO findByKey(PNodeProcVO pNodeProcVO);

    public List<PNodeProcVO> findByWhere(PNodeProcVO pNodeProcVO);
}
