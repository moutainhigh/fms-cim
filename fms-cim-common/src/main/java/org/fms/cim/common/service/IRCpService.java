
/**
 * 采集点
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IRCpService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.RCpVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IRCpService {

    public int insert(RCpVO rCpVO);

    public int update(RCpVO rCpVO);

    public int delete(RCpVO rCpVO);

    public HttpResult deleteList(List<RCpVO> deleteList) throws Exception;

    public RCpVO findByKey(RCpVO rCpVO);

    public List<RCpVO> findByWhere(RCpVO rCpVO);
}
