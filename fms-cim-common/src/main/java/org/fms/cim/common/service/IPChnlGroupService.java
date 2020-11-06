
/**
 * 通道组
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.IPChnlGroupService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.PChnlGroupStaticVO;
import org.fms.cim.common.vo.uas.PChnlGroupVO;
import org.fms.cim.common.vo.uas.PDaserverGroupStaticVO;

import java.util.List;

public interface IPChnlGroupService {

    public int insert(PChnlGroupVO pChnlGroupVO);

    public int update(PChnlGroupVO pChnlGroupVO);

    public int delete(PChnlGroupVO pChnlGroupVO);

    public HttpResult deleteList(List<PChnlGroupVO> deleteList) throws Exception;

    public PChnlGroupVO findByKey(PChnlGroupVO pChnlGroupVO);

    public List<PChnlGroupVO> findByWhere(PChnlGroupVO pChnlGroupVO);

    public List<PChnlGroupStaticVO> findByWhereStatic(PChnlGroupStaticVO pChnlGroupStaticVO);
}
