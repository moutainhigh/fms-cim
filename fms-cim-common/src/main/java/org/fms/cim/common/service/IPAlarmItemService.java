
/**
 * 告警事项设置
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.IPAlarmItemService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.PAlarmItemVO;

import java.util.List;

public interface IPAlarmItemService {

    public int insert(PAlarmItemVO pAlarmItemVO);

    public int update(PAlarmItemVO pAlarmItemVO);

    public int delete(PAlarmItemVO pAlarmItemVO);

    public HttpResult deleteList(List<PAlarmItemVO> deleteList) throws Exception;

    public PAlarmItemVO findByKey(PAlarmItemVO pAlarmItemVO);

    public List<PAlarmItemVO> findByWhere(PAlarmItemVO pAlarmItemVO);
}
