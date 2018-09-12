package my.back_end.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import my.back_end.dao.UserSuggestDao;
import my.back_end.service.UserSuggestService;
import my.common.entity.LeftMessage;
import my.common.entity.Page;
import my.common.enums.MessageStatus;
import my.common.enums.TimeStatus;
import my.common.utils.DateTransformUtils;
import my.common.utils.DateUtils;
import my.common.utils.PageUtils;
import my.fore_end.exception.ServiceException;
@Service
public class UserSuggestServiceImpl implements UserSuggestService{
	@Resource
	private UserSuggestDao dao;
	
	public Map<String,Object> doGetAllUserSuggest(Integer pageCurrent) {
		Page page = new Page();
		int pageSize = PageUtils.PAGE_SIZE_5;
		int suggestCount = dao.getAllSuggestCount();
		int pageCount = (suggestCount-1)/5+1;
		int start = (pageCurrent-1)*5;
		page.setStart (start);
		page.setPageSize (pageSize);
		page.setPageCount (pageCount);
		page.setPageCurrent (pageCurrent);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", dao.doGetAllUserSuggest(page));
		map.put("page", page);
		return map;
	}


	public LeftMessage doGetAllSuggestInfo(Integer id) {
		LeftMessage obj = dao.doGetSuggestInfoById(id);
		LeftMessage message = new LeftMessage();
		message.setId (id);
		message.setUpdateTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		message.setStatus (MessageStatus.READ_YES.getCode ());
		int row = dao.doUpdateSuggestState(message);
		if(row <1 ){
			throw new ServiceException("获取留言详情失败");
		}
		return obj;
	}


	public List<LeftMessage> doSearchSuggestByState(Integer status,Integer times) {
		TimeStatus timeStatus = TimeStatus.find (times);
		Timestamp lastTime = DateUtils.getTimeStatus (timeStatus);
		List<LeftMessage> lists = dao.doSearchSuggestByState(status,lastTime);
		return lists;
	}

}
