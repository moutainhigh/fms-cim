
/**
 * 计算任务类型定义表
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.IPWsdCalcTaskService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.PWsdCalcTaskVO;

import java.util.List;

public interface IPWsdCalcTaskService {

    public int insert(PWsdCalcTaskVO pWsdCalcTaskVO);

    public int update(PWsdCalcTaskVO pWsdCalcTaskVO);

    public int delete(PWsdCalcTaskVO pWsdCalcTaskVO);

    public HttpResult deleteList(List<PWsdCalcTaskVO> deleteList) throws Exception;

    public PWsdCalcTaskVO findByKey(PWsdCalcTaskVO pWsdCalcTaskVO);

    public List<PWsdCalcTaskVO> findByWhere(PWsdCalcTaskVO pWsdCalcTaskVO);
}
