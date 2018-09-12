package my.webchat.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import my.common.entity.WebChatGroup;
import my.common.entity.WebChatGroupInfo;

/**
 * 联系群
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public interface WebChatGroupsListDao {
	/**
	 * 添加联系群信息
	 * method comments here
	 * @param group
	 * @return
	 */
		public int toSaveGroupInfo(@Param("entity")WebChatGroupInfo group);
		/**
		 * 根据群名模糊查询群
		 * method comments here
		 * @param searchName
		 * @return
		 */
		public List<WebChatGroupInfo> toGetGroupsBygroupName(@Param("searchName")String searchName);
		/**
		 * 根据群号查询群
		 * method comments here
		 * @param searchName
		 * @return
		 */
		public List<WebChatGroupInfo> toGetGroupsBygroupId(@Param("groupId")String groupId);
		/**
		 * 用户加入群
		 * method comments here
		 * @param groupId
		 * @param uId
		 * @param createdTime
		 * @param state
		 * @return
		 */
		public int toJoinGroup(@Param("entity")WebChatGroup group);

}
