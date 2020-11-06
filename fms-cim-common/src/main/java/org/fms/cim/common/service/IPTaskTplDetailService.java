
/**
 * 采集任务模板明细
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.IPTaskTplDetailService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.PTaskDetailVO;
import org.fms.cim.common.vo.uas.PTaskTplDetailVO;

import java.util.List;

public interface IPTaskTplDetailService {

    public int insert(PTaskTplDetailVO pTaskTplDetailVO);

    public int update(PTaskTplDetailVO pTaskTplDetailVO);

    public int delete(PTaskTplDetailVO pTaskTplDetailVO);

    public int deleteList(List<PTaskTplDetailVO> deleteList);

    public PTaskTplDetailVO findByKey(PTaskTplDetailVO pTaskTplDetailVO);

    public List<PTaskTplDetailVO> findByWhere(PTaskTplDetailVO pTaskTplDetailVO);

    public int insertList(List<PTaskTplDetailVO> insertList);
}
