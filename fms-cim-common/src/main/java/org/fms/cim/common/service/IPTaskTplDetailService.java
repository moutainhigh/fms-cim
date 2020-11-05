
/**
 * 采集任务模板明细
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPTaskTplDetailService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PTaskTplDetailVO;

public interface IPTaskTplDetailService {

    public int insert(PTaskTplDetailVO pTaskTplDetailVO);

    public int update(PTaskTplDetailVO pTaskTplDetailVO);

    public int delete(PTaskTplDetailVO pTaskTplDetailVO);

    public int deleteList(List<PTaskTplDetailVO> deleteList);

    public PTaskTplDetailVO findByKey(PTaskTplDetailVO pTaskTplDetailVO);

    public List<PTaskTplDetailVO> findByWhere(PTaskTplDetailVO pTaskTplDetailVO);

    public int insertList(List<PTaskTplDetailVO> insertList);
}
