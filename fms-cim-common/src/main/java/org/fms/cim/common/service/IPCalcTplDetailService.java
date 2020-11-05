
/**
 * 计算方案模板明细
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.service.IPCalcTplDetailService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.vo.uas.PCalcTplDetailVO;

public interface IPCalcTplDetailService {

    public int insert(PCalcTplDetailVO pCalcTplDetailVO);

    public int update(PCalcTplDetailVO pCalcTplDetailVO);

    public int delete(PCalcTplDetailVO pCalcTplDetailVO);

    public int deleteList(List<PCalcTplDetailVO> deleteList);

    public PCalcTplDetailVO findByKey(PCalcTplDetailVO pCalcTplDetailVO);

    public List<PCalcTplDetailVO> findByWhere(PCalcTplDetailVO pCalcTplDetailVO);

    public int insertList(List<PCalcTplDetailVO> insertList);
}
