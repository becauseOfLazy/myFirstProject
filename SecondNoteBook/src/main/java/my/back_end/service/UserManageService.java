package my.back_end.service;


import java.util.List;
import java.util.Map;
import my.common.entity.User;


public interface UserManageService {
	/**
	 * 加载用户信息对象
	 * method comments here
	 * @param pageCurrent
	 * @return
	 */
	public Map<String,Object> doLoadUserObject(Integer pageCurrent);

	/**
	 * 查询用户对象
	 * method comments here
	 * @param searchName
	 * @param roleId
	 * @return
	 */
	public List<User> toSearchUserObject(String searchName,Integer roleId);
	/**
	 * 通过用户Id获取用户信息
	 * method comments here
	 * @param id
	 * @return
	 */
	public User toGetUserObjectInfoById(Integer id);

}
