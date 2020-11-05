
/**
 * 计算任务
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPCalcTaskService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PCalcTaskRelVO;
import org.fms.cim.common.vo.uas.PCalcTaskVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IPCalcTaskService {

    public int insert(PCalcTaskVO pCalcTaskVO);

    public int update(PCalcTaskVO pCalcTaskVO);

    public int delete(PCalcTaskVO pCalcTaskVO);

    public HttpResult deleteList(List<PCalcTaskVO> deleteList) throws Exception;

    public PCalcTaskVO findByKey(PCalcTaskVO pCalcTaskVO);

    public List<PCalcTaskVO> findByWhere(PCalcTaskVO pCalcTaskVO);

    public List<PCalcTaskRelVO> findByRelTpl(PCalcTaskRelVO pCalcTaskRelVO);
}
