/**
 *    Auth:riozenc
 *    Date:2019年3月12日 下午7:16:33
 *    Title:com.riozenc.cim.webapp.service.impl.UserServiceImpl.java
 **/
package org.fms.cim.server.webapp.archives.service;

import java.util.ArrayList;
import java.util.List;

import org.fms.cim.common.domain.archives.CustomerDomain;
import org.fms.cim.common.domain.archives.UserDomain;
import org.fms.cim.common.service.IUserService;
import org.fms.cim.server.webapp.archives.dao.CustomerDAO;
import org.fms.cim.server.webapp.archives.dao.UserDAO;

import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

@TransactionService
public class UserServiceImpl implements IUserService {

	@TransactionDAO("read")
	private UserDAO userReadDAO;
	
	@TransactionDAO("write")
	private UserDAO userWriteDAO;
	
	@TransactionDAO("read")
	private CustomerDAO customerReadDAO;
	
	@TransactionDAO("write")
	private CustomerDAO customerWriteDAO;

	@Override
	public int insert(UserDomain t) {
		return userWriteDAO.insert(t);
	}

	@Override
	public int delete(UserDomain t) {
		return userWriteDAO.delete(t);
	}

	@Override
	public int update(UserDomain t) {
		return userWriteDAO.update(t);
	}

	@Override
	public UserDomain findByKey(UserDomain t) {
		return userReadDAO.findByKey(t);
	}

	@Override
	public List<UserDomain> findByWhere(UserDomain t) {
		return userReadDAO.findByWhere(t);
	}

	@Override
	public List<UserDomain> findByNo(UserDomain t) {
		return userReadDAO.findByNo(t);
	}

	@Override
	public List<UserDomain> getUserAllInfo(UserDomain userDomain) {
		return userReadDAO.getUserAllInfo(userDomain);
	}

	@Override
	public boolean updateUserCustomer(UserDomain userDomain, CustomerDomain customerDomain) {
		int userCount = userWriteDAO.update(userDomain);
		int customerCount = customerWriteDAO.update(customerDomain);
		if (userCount == 1 || customerCount == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addUserCustomer(UserDomain userDomain, CustomerDomain customerDomain) {
		int userCount = userWriteDAO.insert(userDomain);
		int customerCount = customerWriteDAO.insert(customerDomain);
		if (userCount == 1 || customerCount == 1) {
			return true;
		}
		return false;

	}

	@Override
	public List<UserDomain> getUserByIds(List<Long> ids) {

		List<UserDomain> rl = new ArrayList<UserDomain>();

		// 处理超过1000个id
		int len = ids.size();
		for (int m = 0; m < len / 999 + 1; m++) {// 遍历次数
			// 根据用户ID获取用户档案 subList方法包含fromIndex, 不包含 toIndex
			List<Long> tl = ids.subList(m * 999, (m + 1) * 999 > len ? len : (m + 1) * 999);

			List<UserDomain> tempList = userReadDAO.getUserByIds(tl);

			if (tempList.size() == 0 || tempList == null || tempList.get(0) == null) {
				continue;
			}

			rl.addAll(tempList);

		}
		return rl;

	}

	/*@Override
	public List<Long> getUserIdsByCustomerIds(List<Long> ids) {
		return userDAO.getUserIdsByCustomerIds(ids);
	}*/
	
	public List<UserDomain> getUserByCustomerIds(List<Long> customerIds){
		return userReadDAO.getUserByCustomerIds(customerIds);
	}

	@Override
	public List<Long> getUserIdsByWriteSectIds(List<Long> ids) {
		return userReadDAO.getUserIdsByWriteSectIds(ids);

	}

	public List<UserDomain> getUserByWriteSectIds(List<Long> writeSectIds) {
		return userReadDAO.getUserByWriteSectIds(writeSectIds);
	}

	@Override
	public List<Long> getDeptIdsByUserIds(List<Long> idsList) {
		return userReadDAO.getDeptIdsByUserIds(idsList);
	}

	@Override
	public List<UserDomain> getUsersByCustomerNo(UserDomain userDomain) {
		return userReadDAO.getUsersByCustomerNo(userDomain);
	}

	@Override
	public List<UserDomain> userNoDC(UserDomain userDomain) {
		return userReadDAO.userNoDC(userDomain);
	}

	@Override
	public int insertList(List<UserDomain> userList) {
		return userWriteDAO.insertList(userList);
	}
	@Override
	public int updateList(List<UserDomain> t) {
		return userWriteDAO.updateList(t);
	}

}
