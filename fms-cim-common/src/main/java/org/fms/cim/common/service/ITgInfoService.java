package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.archives.TgInfoDomain;

import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface ITgInfoService extends BaseService<TgInfoDomain> {
    public List<TgInfoDomain> findByNo(TgInfoDomain t);
}
