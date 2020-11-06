
/**
 * 规约数据单元组（※相当于原来变电站采集的规约信息体类型）
 * Author :
 * Date :
 * Title : org.fms.cim.common.service.IPWsdTaskdataGroupService.java
 **/
package org.fms.cim.common.service;

import com.riozenc.titanTool.spring.web.http.HttpResult;
import org.fms.cim.common.vo.uas.PWsdTaskdataGroupVO;

import java.util.List;

public interface IPWsdTaskdataGroupService {

    public int insert(PWsdTaskdataGroupVO pWsdTaskdataGroupVO);

    public int update(PWsdTaskdataGroupVO pWsdTaskdataGroupVO);

    public int delete(PWsdTaskdataGroupVO pWsdTaskdataGroupVO);

    public HttpResult deleteList(List<PWsdTaskdataGroupVO> deleteList) throws Exception;

    public PWsdTaskdataGroupVO findByKey(PWsdTaskdataGroupVO pWsdTaskdataGroupVO);

    public List<PWsdTaskdataGroupVO> findByWhere(PWsdTaskdataGroupVO pWsdTaskdataGroupVO);
}
