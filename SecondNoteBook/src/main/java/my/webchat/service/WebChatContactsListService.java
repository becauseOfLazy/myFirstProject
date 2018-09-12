package my.webchat.service;

import java.util.List;
import java.util.Map;
import my.common.entity.WebChatContract;

public interface WebChatContactsListService {
	/**
	 * 获取自己所有的联系人
	 * method comments here
	 * @param userName
	 * @return
	 */
	public Map<String,Object> doGetAllContactWithMe(String userName,Integer pageCurrent);
	/**
	 * 通过用户名昵称查找联系人
	 * method comments here
	 * @param searchName
	 * @return
	 */
	 public	List<WebChatContract> doSearchContactBysearchName(String searchName);
	 /**
	  * 添加联系人
	  * method comments here
	  * @param contactId
	  * @param userName
	  */
	 public void toAddContactObject(Integer contactId ,String userName);
}
