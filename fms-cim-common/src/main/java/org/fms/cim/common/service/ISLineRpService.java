
/**
 * 旁路事件
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.ISLineRpService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.SLineRpVO;

import java.util.List;

public interface ISLineRpService {

    public int insert(SLineRpVO sLineRpVO);

    public int update(SLineRpVO sLineRpVO);

    public int delete(SLineRpVO sLineRpVO);

    public HttpResult deleteList(List<SLineRpVO> deleteList) throws Exception;

    public SLineRpVO findByKey(SLineRpVO sLineRpVO);

    public List<SLineRpVO> findByWhere(SLineRpVO sLineRpVO);
}
