package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.archives.DropSqlDomain;

public interface IDropSqlTwoService{
	public List<DropSqlDomain> findByWhere(DropSqlDomain dropSqlDomain);
}
