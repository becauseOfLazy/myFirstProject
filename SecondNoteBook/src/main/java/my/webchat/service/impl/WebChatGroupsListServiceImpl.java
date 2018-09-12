package my.webchat.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import my.common.entity.WebChatGroup;
import my.common.entity.WebChatGroupInfo;
import my.common.utils.RandomUtils;
import my.common.utils.StringUtil;
import my.fore_end.dao.UserDao;

import my.fore_end.exception.ServiceException;
import my.webchat.dao.WebChatGroupsListDao;
import my.webchat.service.WebChatGroupsListService;
@Service
public class WebChatGroupsListServiceImpl implements WebChatGroupsListService{
	@Resource
	private UserDao udao;
	@Resource
	private WebChatGroupsListDao gdao;
	
	public void toSaveGroupInfo(WebChatGroupInfo group, String userName) {
		int uId = udao.findIdbyUserName (userName);
		group.setGroupOwnerId (uId);
		group.setGroupId (RandomUtils.getGroupRandom ());
		group.setCreatedTime (new Date());
		int row = gdao.toSaveGroupInfo (group);
		if(row<1){
			throw new ServiceException ("创建联系群失败!");
		}
	}
	public List<WebChatGroupInfo> toGetGroupsBysearchName(String searchName) {
		List<WebChatGroupInfo> lists = null;
		if(!StringUtil.isEmpty (searchName) && StringUtil.isNumeric (searchName)){
				//根据群号查询群
				lists = gdao.toGetGroupsBygroupId (searchName);
		}else{
			//根据群名称模糊查询
			lists = gdao.toGetGroupsBygroupName (searchName);
		}
		if(lists==null){
			throw new ServiceException ("查询联系群失败!");
		}
		return lists;
	}
	public void toJoinGroup(String groupId, String userName) {
		int uId = udao.findIdbyUserName (userName);
		WebChatGroup group = new WebChatGroup();
		group.setuId (uId);
		group.setGroupId (groupId);
		group.setCreatedTime (new Date());
		group.setIsVerified (0);
		
		int row = gdao.toJoinGroup (group);
		if(row < 1){
			throw new ServiceException ("添加联系群失败");
		}
	}

}
