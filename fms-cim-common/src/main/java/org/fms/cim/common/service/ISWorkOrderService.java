
/**
 * 异常工单
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.ISWorkOrderService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.SWorkOrderVO;

import java.util.List;

public interface ISWorkOrderService {

    public int insert(SWorkOrderVO sWorkOrderVO);

    public int update(SWorkOrderVO sWorkOrderVO);

    public int delete(SWorkOrderVO sWorkOrderVO);

    public HttpResult deleteList(List<SWorkOrderVO> deleteList) throws Exception;

    public SWorkOrderVO findByKey(SWorkOrderVO sWorkOrderVO);

    public List<SWorkOrderVO> findByWhere(SWorkOrderVO sWorkOrderVO);
}
