package my.fore_end.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import my.common.entity.LeftMessage;
import my.fore_end.dao.MessageDao;
import my.fore_end.dao.UserDao;
import my.fore_end.exception.ServiceException;
import my.fore_end.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{
	@Resource
	private MessageDao mdao;
	@Resource
	private UserDao udao;

	public void doSaveSuggest(LeftMessage message, String userName) {
		int uId = udao.findIdbyUserName (userName);
		message.setuId (uId);
		int row = mdao.doSaveSuggest (message);
		if(row<1){
			throw new ServiceException ("保存留言失败!");
		}
	}

}
