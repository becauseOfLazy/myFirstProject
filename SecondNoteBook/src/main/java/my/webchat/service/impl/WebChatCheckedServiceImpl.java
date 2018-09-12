package my.webchat.service.impl;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import my.fore_end.dao.UserDao;
import my.webchat.dao.WebChatContactsListDao;
import my.webchat.dao.WebChatGroupsListDao;
import my.webchat.service.WebChatCheckedService;

@Service
public class WebChatCheckedServiceImpl implements WebChatCheckedService{
	@Resource
	private UserDao udao;
	@Resource	
	private WebChatContactsListDao cdao;
	@Resource
	private WebChatGroupsListDao gdao;
	
	public Map<String, Object> toLoadCheckedListObject(String userName) {
		int uId = udao.findIdbyUserName (userName);
		
		return null;
	}

}
