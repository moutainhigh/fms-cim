/**
 * Auth:riozenc
 * Date:2019年3月8日 下午3:38:03
 * Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import org.fms.cim.common.domain.archives.PMpedDomain;

import com.riozenc.titanTool.spring.webapp.service.BaseService;

import java.util.List;

public interface IPmpedService extends BaseService<PMpedDomain> {

    public int updateList(List<PMpedDomain> updateList);

	public List<PMpedDomain> getPMpedBySDevIr(PMpedDomain t);

}
