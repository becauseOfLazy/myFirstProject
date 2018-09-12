package my.webchat.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import my.common.entity.Page;
import my.common.entity.User;
import my.common.entity.WebChatContract;
import my.common.utils.DateUtils;
import my.common.utils.PageUtils;
import my.fore_end.dao.UserDao;

import my.fore_end.exception.ServiceException;
import my.webchat.dao.WebChatContactsListDao;
import my.webchat.service.WebChatContactsListService;

@Service
public class WebChatContactsListServiceImpl implements WebChatContactsListService{
	@Resource	
	private WebChatContactsListDao cdao;
	@Resource
	private UserDao udao;
	
	public Map<String,Object> doGetAllContactWithMe(String userName,Integer pageCurrent) {
		int uId = udao.findIdbyUserName (userName);
		Page page = new Page();
		Integer contractNum = cdao.getContractsNumByuId (uId);
		Integer pageSize = PageUtils.PAGE_SIZE_10;
		Integer pageCount = contractNum/pageSize+1;
		Integer start = (pageCurrent-1)*pageSize;
		page.setPageCount (pageCount);
		page.setPageSize (pageSize);
		page.setPageCurrent (pageCurrent);
		page.setStart (start);
		List<WebChatContract> lists = cdao.doGetAllContactWithMe (uId,page);
		if(lists==null){
			throw new ServiceException ("获取联系人失败");
		}
		for(WebChatContract wcontract : lists){
			User currentUser = udao.getUserByuId (wcontract.getCurrentUserId ());
			User relatedUser = udao.getUserByuId (wcontract.getRelatedUserId ());
			wcontract.setCurrentUser (currentUser);
			wcontract.setRelatedUser (relatedUser);
		}
		Map<String,Object> map = new HashMap<String, Object> ();
		map.put ("lists", lists);
		map.put ("page", page);
		return map;
	}
	
	public List<WebChatContract> doSearchContactBysearchName(String searchName) {
		
		List<WebChatContract> lists= cdao.doSearchContactBysearchName (searchName);
		if(lists==null){
			throw new ServiceException("查询联系人失败");
		}
		return lists;
	}
	public void toAddContactObject(Integer contactId, String userName) {
		int uId = udao.findIdbyUserName (userName);
		String uuId = UUID.randomUUID ().toString ();
		WebChatContract contacts = new WebChatContract();
		contacts.setCurrentUserId (uId);
		contacts.setRelatedUserId (contactId);
		contacts.setCreatedTime (DateUtils.getCurrentTime ());
		contacts.setRelatedId (uuId);
		contacts.setStatus (1);
		
		int row = cdao.doAddOtherContact (contacts);
		if(row < 1){
			throw new ServiceException ("添加联系人失败");
		}
	}

	
}
