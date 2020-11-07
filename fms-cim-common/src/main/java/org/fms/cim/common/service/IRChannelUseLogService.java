
/**
 * 通道使用日志
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.IRChannelUseLogService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.RChannelUseLogVO;

import java.util.List;

public interface IRChannelUseLogService {

    public int insert(RChannelUseLogVO rChannelUseLogVO);

    public int update(RChannelUseLogVO rChannelUseLogVO);

    public int delete(RChannelUseLogVO rChannelUseLogVO);

    public HttpResult deleteList(List<RChannelUseLogVO> deleteList) throws Exception;

    public RChannelUseLogVO findByKey(RChannelUseLogVO rChannelUseLogVO);

    public List<RChannelUseLogVO> findByWhere(RChannelUseLogVO rChannelUseLogVO);
}
