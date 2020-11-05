
/**
 * 采集主机组
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPDaserverGroupService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PDaserverGroupStaticVO;
import org.fms.cim.common.vo.uas.PDaserverGroupVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IPDaserverGroupService {

    public int insert(PDaserverGroupVO pDaserverGroupVO);

    public int update(PDaserverGroupVO pDaserverGroupVO);

    public int delete(PDaserverGroupVO pDaserverGroupVO);

    public HttpResult deleteList(List<PDaserverGroupVO> deleteList) throws Exception;

    public PDaserverGroupVO findByKey(PDaserverGroupVO pDaserverGroupVO);

    public List<PDaserverGroupVO> findByWhere(PDaserverGroupVO pDaserverGroupVO);

    public List<PDaserverGroupStaticVO> findByWhereStatic(PDaserverGroupStaticVO pDaserverGroupStaticVO);
}
