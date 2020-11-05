
/**
 * 下拉表 -迟子曰改
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.ISystemCommonConfigService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.SystemCommonConfigVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface ISystemCommonConfigService {

    public int insert(SystemCommonConfigVO systemCommonConfigVO);

    public int update(SystemCommonConfigVO systemCommonConfigVO);

    public int delete(SystemCommonConfigVO systemCommonConfigVO);

    public HttpResult deleteList(List<SystemCommonConfigVO> deleteList) throws Exception;

    public SystemCommonConfigVO findByKey(SystemCommonConfigVO systemCommonConfigVO);

    public List<SystemCommonConfigVO> findByWhere(SystemCommonConfigVO systemCommonConfigVO);
    
    public SystemCommonConfigVO findByKeyValue(String type, String key);
}
