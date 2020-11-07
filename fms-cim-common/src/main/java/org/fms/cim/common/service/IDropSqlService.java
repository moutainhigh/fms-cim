
/**
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IDropSqlService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.DropSqlVO;
import org.fms.cim.common.vo.uas.SystemCommonConfigVO;


import java.util.List;

public interface IDropSqlService {

    public int insert(DropSqlVO dropSqlVO);

    public int update(DropSqlVO dropSqlVO);

    public int delete(DropSqlVO dropSqlVO);

    public HttpResult deleteList(List<DropSqlVO> deleteList) throws Exception;

    public DropSqlVO findByKey(DropSqlVO dropSqlVO);

    public List<DropSqlVO> findByWhere(DropSqlVO dropSqlVO);

    public List<SystemCommonConfigVO> getBaseDropDict(String selectSql);
}
