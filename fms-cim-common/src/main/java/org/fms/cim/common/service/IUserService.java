/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:15:06
 *    Title:com.riozenc.cim.webapp.service.IUserService.java
 **/
package org.fms.cim.common.service;

import java.util.List;

import org.fms.cim.common.domain.archives.CustomerDomain;
import org.fms.cim.common.domain.archives.UserDomain;

import com.riozenc.titanTool.spring.webapp.service.BaseService;

public interface IUserService extends BaseService<UserDomain> {

	public List<UserDomain> getUserAllInfo(UserDomain userDomain);

	public boolean updateUserCustomer(UserDomain userDomain, CustomerDomain customerDomain);

	public boolean addUserCustomer(UserDomain userDomain, CustomerDomain customerDomain);

	public List<UserDomain> getUserByIds(List<Long> s);

	
	/*@Deprecated
	public List<Long> getUserIdsByCustomerIds(List<Long> s);*/
	
	public List<UserDomain> getUserByCustomerIds(List<Long> customerIds);

	/**
	 * {@link #getUserByWriteSectIds(List)}
	 * @param ids
	 * @return
	 */
	@Deprecated
	public List<Long> getUserIdsByWriteSectIds(List<Long> ids);
	
	public List<UserDomain> getUserByWriteSectIds(List<Long> writeSectIds);

	public List<Long> getDeptIdsByUserIds(List<Long> ids);

	public List<UserDomain> getUsersByCustomerNo(UserDomain userDomain);

	public List<UserDomain> userNoDC(UserDomain userDomain);

	public List<UserDomain> findByNo(UserDomain tt);

	public int insertList(List<UserDomain> userList);

	public int updateList(List<UserDomain> userList);

}
