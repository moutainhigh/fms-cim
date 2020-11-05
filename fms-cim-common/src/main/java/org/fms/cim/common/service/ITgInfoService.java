
/**
 * 台区表
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.ITgInfoService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.TgInfoVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface ITgInfoService {

    public int insert(TgInfoVO tgInfoVO);

    public int update(TgInfoVO tgInfoVO);

    public int delete(TgInfoVO tgInfoVO);

    public HttpResult deleteList(List<TgInfoVO> deleteList) throws Exception;

    public TgInfoVO findByKey(TgInfoVO tgInfoVO);

    public List<TgInfoVO> findByWhere(TgInfoVO tgInfoVO);
}
