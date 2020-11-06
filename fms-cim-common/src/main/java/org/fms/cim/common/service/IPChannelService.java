
/**
 * 通道参数表
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.IPChannelService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.PChannelVO;

import java.util.List;

public interface IPChannelService {

    public int insert(PChannelVO pChannelVO);

    public int update(PChannelVO pChannelVO);

    public int delete(PChannelVO pChannelVO);

    public HttpResult deleteList(List<PChannelVO> deleteList) throws Exception;

    public PChannelVO findByKey(PChannelVO pChannelVO);

    public List<PChannelVO> findByWhere(PChannelVO pChannelVO);

    public List<PChannelVO> findByRelGroup(String value);
}
