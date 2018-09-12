package my.fore_end.service;

import java.util.Set;
import my.common.entity.User;



public interface UserService {
	/**
	 * 保存用户
	 * method comments here
	 * @param user
	 */
	void saveUser(User user);
	
	/**
	 * ͨ通过用户名获取昵称
	 * @param userName
	 * @return
	 */
	String getNickNameByUserName(String userName);
	
	/**
	 * 获取用户通过用户名
	 * @param userName
	 * @return
	 */
	User getByUserName(String userName);
	/**
	 * ͨ通过用户名获取角色
	 * @param userName
	 * @return
	 */
	Set<String> getRoles(String userName);
	
	/**
	 * ͨ通过用户名获取权限
	 * @param userName
	 * @return
	 */
	Set<String> getPermissions(String userName);
	/**
	 * 更改用户登录状态
	 * method comments here
	 */
	public void updateUserOnLine(User user);

}
