package my.fore_end.service;

import my.common.entity.LeftMessage;

public interface MessageService {
	/**
	 * 保存用户建议
	 * @param userName
	 */
	void doSaveSuggest(LeftMessage message,String userName);
}
