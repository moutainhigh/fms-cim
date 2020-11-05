
/**
 * 计算任务类型定义表
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPWsdCalcTaskService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PWsdCalcTaskVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IPWsdCalcTaskService {

    public int insert(PWsdCalcTaskVO pWsdCalcTaskVO);

    public int update(PWsdCalcTaskVO pWsdCalcTaskVO);

    public int delete(PWsdCalcTaskVO pWsdCalcTaskVO);

    public HttpResult deleteList(List<PWsdCalcTaskVO> deleteList) throws Exception;

    public PWsdCalcTaskVO findByKey(PWsdCalcTaskVO pWsdCalcTaskVO);

    public List<PWsdCalcTaskVO> findByWhere(PWsdCalcTaskVO pWsdCalcTaskVO);
}
