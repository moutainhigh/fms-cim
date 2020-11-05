
/**
 * 采集任务
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPTaskService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PTaskRelVO;
import org.fms.cim.common.vo.uas.PTaskVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IPTaskService {

    public int insert(PTaskVO pTaskVO);

    public int update(PTaskVO pTaskVO);

    public int delete(PTaskVO pTaskVO);

    public HttpResult deleteList(List<PTaskVO> deleteList) throws Exception;

    public PTaskVO findByKey(PTaskVO pTaskVO);

    public List<PTaskVO> findByWhere(PTaskVO pTaskVO);

    public List<PTaskRelVO> findByTaskTpl(PTaskRelVO pTaskVO);
}
