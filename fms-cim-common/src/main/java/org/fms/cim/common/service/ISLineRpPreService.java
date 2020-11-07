
/**
 * 旁路事件审核表
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.ISLineRpPreService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.SLineRpPreVO;

import java.util.List;

public interface ISLineRpPreService {

    public int insert(SLineRpPreVO sLineRpPreVO);

    public int update(SLineRpPreVO sLineRpPreVO);

    public int delete(SLineRpPreVO sLineRpPreVO);

    public HttpResult deleteList(List<SLineRpPreVO> deleteList) throws Exception;

    public SLineRpPreVO findByKey(SLineRpPreVO sLineRpPreVO);

    public List<SLineRpPreVO> findByWhere(SLineRpPreVO sLineRpPreVO);
}
