
/**
 * 计算任务
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.IPCalcTaskService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.PCalcTaskRelVO;
import org.fms.cim.common.vo.uas.PCalcTaskVO;

import java.util.List;

public interface IPCalcTaskService {

    public int insert(PCalcTaskVO pCalcTaskVO);

    public int update(PCalcTaskVO pCalcTaskVO);

    public int delete(PCalcTaskVO pCalcTaskVO);

    public HttpResult deleteList(List<PCalcTaskVO> deleteList) throws Exception;

    public PCalcTaskVO findByKey(PCalcTaskVO pCalcTaskVO);

    public List<PCalcTaskVO> findByWhere(PCalcTaskVO pCalcTaskVO);

    public List<PCalcTaskRelVO> findByRelTpl(PCalcTaskRelVO pCalcTaskRelVO);
}
