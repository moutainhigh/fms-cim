
/**
 * 通道参数表
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPChannelService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PChannelVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IPChannelService {

    public int insert(PChannelVO pChannelVO);

    public int update(PChannelVO pChannelVO);

    public int delete(PChannelVO pChannelVO);

    public HttpResult deleteList(List<PChannelVO> deleteList) throws Exception;

    public PChannelVO findByKey(PChannelVO pChannelVO);

    public List<PChannelVO> findByWhere(PChannelVO pChannelVO);
}
