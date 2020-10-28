/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:03
 *    Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.archives.LineDomain;
import org.fms.cim.common.domain.archives.SubsLineRelaDomain;

import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface ILineService extends BaseService<LineDomain> {
	public boolean addLineAndSubsLineRela(LineDomain line,SubsLineRelaDomain t);

	public boolean updateLineAndSubsLineRela(LineDomain line,SubsLineRelaDomain t);

    public List<LineDomain> findByLineCode(LineDomain e);

	public List<LineDomain> findByLineIds(LineDomain e);

}
