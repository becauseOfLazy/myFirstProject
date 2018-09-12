package my.back_end.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import my.common.entity.Page;
import my.common.entity.User;

public interface UserManageDao {
		/**
		 * 获取一页的用户对象信息
		 * method comments here
		 */
		public List<User> doGetOnePageUserObject(@Param("entity")Page page);
		/**
		 * 获取用户数量
		 * method comments here
		 * @return
		 */
		public int doGetAllUserObjectNum();

		/**
		 * 查询用户对象
		 * method comments here
		 * @param searchName
		 * @param roleId
		 * @return
		 */
		public List<User> toSearchUserObject(@Param("searchName")String searchName,
				@Param("roleId")Integer roleId);
		/**
		 * 通过用户Id获取用户信息
		 * method comments here
		 * @param id
		 * @return
		 */
		public User toGetUserObjectInfoById(@Param("id")Integer id);
}
