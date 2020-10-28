/**
 *    Auth:riozenc
 *    Date:2019年3月8日 下午3:38:03
 *    Title:com.riozenc.cim.webapp.service.ICustomerService.java
 **/
package org.fms.cim.common.service;

import org.fms.cim.common.domain.archives.SysSequenceNoDomain;

import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface ISysSequenceNoService extends BaseService<SysSequenceNoDomain> {
    public String genSequenceNo(SysSequenceNoDomain inputSys);
    public String genSequenceNo(SysSequenceNoDomain inputSys,int size);
}
