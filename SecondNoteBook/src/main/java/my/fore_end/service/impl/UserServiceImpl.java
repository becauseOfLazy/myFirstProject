package my.fore_end.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import my.common.entity.User;
import my.fore_end.dao.UserDao;
import my.fore_end.exception.ServiceException;
import my.fore_end.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao dao;
	
	public void saveUser(User user) {
		//保存用户信息
		int count = dao.saveUserObject(user);
		if(count==0){
			throw new ServiceException("保存用户信息失败");
		}
	}
	
	public User getByUserName(String userName) {
		User user = dao.getByUserName(userName);
		return user;
	}
	public Set<String> getRoles(String userName) {
		Set<String> roles = dao.getRoles(userName);
		return roles;
	}
	public Set<String> getPermissions(String userName) {
		Set<String> permissions = dao.getPermissions(userName);
		return permissions;
	}

	public String getNickNameByUserName(String userName) {
		String nickName = dao.getNickNameByUserName(userName);
		return nickName;
	}

	public void updateUserOnLine(User user) {
		int row = dao.updateUserOnLine (user);
		if(row<1){
			throw new ServiceException ("修改用户状态失败!");
		}
	}

}
