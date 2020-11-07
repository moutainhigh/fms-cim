
/**
 * 异常工单明细
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.ISWorkOrderDetailService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.SWorkOrderDetailVO;

import java.util.List;

public interface ISWorkOrderDetailService {

    public int insert(SWorkOrderDetailVO sWorkOrderDetailVO);

    public int update(SWorkOrderDetailVO sWorkOrderDetailVO);

    public int delete(SWorkOrderDetailVO sWorkOrderDetailVO);

    public HttpResult deleteList(List<SWorkOrderDetailVO> deleteList) throws Exception;

    public SWorkOrderDetailVO findByKey(SWorkOrderDetailVO sWorkOrderDetailVO);

    public List<SWorkOrderDetailVO> findByWhere(SWorkOrderDetailVO sWorkOrderDetailVO);
}
