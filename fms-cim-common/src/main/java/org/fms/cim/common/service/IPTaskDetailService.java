
/**
 * 采集任务明细
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.IPTaskDetailService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.PTaskDetailRelVO;
import org.fms.cim.common.vo.uas.PTaskDetailVO;
import org.fms.cim.common.vo.uas.PTaskTplDetailVO;
import org.fms.cim.common.vo.uas.PWsdTaskdataRelVO;

import java.util.List;

public interface IPTaskDetailService {

    public int insert(PTaskDetailVO pTaskDetailVO);

    public int update(PTaskDetailVO pTaskDetailVO);

    public int delete(PTaskDetailVO pTaskDetailVO);

    public int deleteList(List<PTaskDetailVO> deleteList);

    public PTaskDetailVO findByKey(PTaskDetailVO pTaskDetailVO);

    public List<PTaskDetailVO> findByWhere(PTaskDetailVO pTaskDetailVO);

    public List<PWsdTaskdataRelVO> findByTaskRel(PWsdTaskdataRelVO modelVO);

    public int insertList(List<PTaskDetailVO> insertList);
}
