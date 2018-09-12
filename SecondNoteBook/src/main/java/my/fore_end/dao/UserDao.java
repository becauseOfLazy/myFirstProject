package my.fore_end.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Param;
import my.common.entity.User;
/**
 * 用户dao
 * @author object
 *
 */
public interface UserDao {
	/**
	 * 保存用户对象
	 * @param user
	 * @return
	 */
	int saveUserObject(@Param("entity")User user);
	/**
	 * ͨ通过用户名获取用户昵称
	 * @param userName
	 * @return
	 */
	String getNickNameByUserName(@Param("userName")String userName);
	/**
	 * 通过用户名查找用户id
	 * @param userName
	 * @return
	 */
	int findIdbyUserName(@Param("userName")String userName);
	/**
	 * 通过用户名获取用户
	 * @param userName
	 * @return
	 */
	User getByUserName(@Param("userName")String userName);
	/**
	 * 通过用户id获取用户
	 * method comments here
	 * @param uId
	 * @return
	 */
	User getUserByuId(@Param("uId")Integer uId);
	/**
	 * ͨ获取角色
	 * @param userName
	 * @return
	 */
	Set<String> getRoles(@Param("userName")String userName);
	
	/**
	 * ͨ获取权限
	 * @param userName
	 * @return
	 */
	Set<String> getPermissions(@Param("userName")String userName);
	/**
	 * 修改用户上线状态
	 * method comments here
	 * @param user
	 * @return
	 */
	public int updateUserOnLine(@Param("entity")User user);
	/**
	 * 修改用户下线状态
	 * method comments here
	 * @param user
	 * @return
	 */
	public int updateUserOffLine(@Param("entity")User user);
}
