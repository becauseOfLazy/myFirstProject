package my.webchat.service;

import java.util.Map;

public interface WebChatCheckedService {
	/**
	 * 获取需要校验的联系请求
	 * method comments here
	 * @return
	 */
		public Map<String,Object> toLoadCheckedListObject(String userName);
}
