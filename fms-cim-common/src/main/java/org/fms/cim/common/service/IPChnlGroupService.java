
/**
 * 通道组
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPChnlGroupService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PChnlGroupStaticVO;
import org.fms.cim.common.vo.uas.PChnlGroupVO;

import com.riozenc.titanTool.spring.web.http.HttpResult;

public interface IPChnlGroupService {

    public int insert(PChnlGroupVO pChnlGroupVO);

    public int update(PChnlGroupVO pChnlGroupVO);

    public int delete(PChnlGroupVO pChnlGroupVO);

    public HttpResult deleteList(List<PChnlGroupVO> deleteList) throws Exception;

    public PChnlGroupVO findByKey(PChnlGroupVO pChnlGroupVO);

    public List<PChnlGroupVO> findByWhere(PChnlGroupVO pChnlGroupVO);

    public List<PChnlGroupStaticVO> findByWhereStatic(PChnlGroupStaticVO pChnlGroupStaticVO);
}
