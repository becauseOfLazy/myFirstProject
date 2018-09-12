package my.webchat.service;

import my.common.entity.User;

public interface WebChatIndexService {
	/**
	 * 通过用户名获取用户
	 * method comments here
	 * @param username
	 * @return
	 */
		public User getUserByUserName(String username);
}
