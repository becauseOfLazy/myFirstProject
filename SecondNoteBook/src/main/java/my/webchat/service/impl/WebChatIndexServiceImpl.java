package my.webchat.service.impl;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;
import org.springframework.stereotype.Service;
import my.common.entity.User;
import my.fore_end.dao.UserDao;
import my.fore_end.exception.ServiceException;
import my.webchat.service.WebChatIndexService;

@Service
public class WebChatIndexServiceImpl implements WebChatIndexService{

	@Resource
	private UserDao udao;
	
	public User getUserByUserName(String username) {
		User user = udao.getByUserName (username);
		if(user==null){
			throw new ServiceException ("用户不存在!");
		}
		return user;
	}

}
