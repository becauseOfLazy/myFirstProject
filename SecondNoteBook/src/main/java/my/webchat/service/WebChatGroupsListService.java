package my.webchat.service;

import java.util.List;
import my.common.entity.WebChatGroupInfo;


public interface WebChatGroupsListService {
	/**
	 * 用户创建联系群信息
	 * method comments here
	 * @param group
	 * @param userName
	 */
		public void toSaveGroupInfo(WebChatGroupInfo group,String userName);
		/**
		 * 根据群名模糊查询群
		 * method comments here
		 * @param searchName
		 * @return
		 */
		public List<WebChatGroupInfo> toGetGroupsBysearchName(String searchName);
		/**
		 * 用户添加联系群
		 * method comments here
		 * @param groupId
		 * @param userName
		 */
		public void toJoinGroup(String groupId,String userName);
}
