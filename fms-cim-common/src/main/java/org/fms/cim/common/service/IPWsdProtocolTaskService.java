
/**
 * 规约任务类型（※相当于原来变电站采集的规约数据类型表与负控采集的任务类型合并的表。对于厂站系列为电量、15分钟电量、瞬时量等；对于负荷、低压系列为一类、二类数据等）
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPWsdProtocolTaskService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PWsdProtocolTaskVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IPWsdProtocolTaskService {

    public int insert(PWsdProtocolTaskVO pWsdProtocolTaskVO);

    public int update(PWsdProtocolTaskVO pWsdProtocolTaskVO);

    public int delete(PWsdProtocolTaskVO pWsdProtocolTaskVO);

    public HttpResult deleteList(List<PWsdProtocolTaskVO> deleteList) throws Exception;

    public PWsdProtocolTaskVO findByKey(PWsdProtocolTaskVO pWsdProtocolTaskVO);

    public List<PWsdProtocolTaskVO> findByWhere(PWsdProtocolTaskVO pWsdProtocolTaskVO);
}
