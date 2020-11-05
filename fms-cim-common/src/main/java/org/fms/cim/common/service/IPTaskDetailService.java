
/**
 * 采集任务明细
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPTaskDetailService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PTaskDetailVO;
import org.fms.cim.common.vo.uas.PWsdTaskdataRelVO;

public interface IPTaskDetailService {

    public int insert(PTaskDetailVO pTaskDetailVO);

    public int update(PTaskDetailVO pTaskDetailVO);

    public int delete(PTaskDetailVO pTaskDetailVO);

    public int deleteList(List<PTaskDetailVO> deleteList);

    public PTaskDetailVO findByKey(PTaskDetailVO pTaskDetailVO);

    public List<PTaskDetailVO> findByWhere(PTaskDetailVO pTaskDetailVO);

    public List<PWsdTaskdataRelVO> findByTaskRel(PWsdTaskdataRelVO modelVO);

    public List<PWsdTaskdataRelVO> findByTaskNoRel(PWsdTaskdataRelVO modelVO);
}
