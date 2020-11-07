
/**
 * 告警范围
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.IPAlarmDataService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.PAlarmDataVO;

import java.util.List;

public interface IPAlarmDataService {

    public int insert(PAlarmDataVO pAlarmDataVO);

    public int update(PAlarmDataVO pAlarmDataVO);

    public int delete(PAlarmDataVO pAlarmDataVO);

    public HttpResult deleteList(List<PAlarmDataVO> deleteList) throws Exception;

    public PAlarmDataVO findByKey(PAlarmDataVO pAlarmDataVO);

    public List<PAlarmDataVO> findByWhere(PAlarmDataVO pAlarmDataVO);
}
