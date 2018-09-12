package my.back_end.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import my.back_end.dao.UserManageDao;
import my.back_end.service.UserManageService;
import my.common.entity.Page;
import my.common.entity.User;
import my.common.utils.PageUtils;

import my.fore_end.exception.ServiceException;

@Service
public class UserManageServiceImpl implements UserManageService{
	@Resource
	private UserManageDao userManageDao;

	public Map<String, Object> doLoadUserObject(Integer pageCurrent) {
		Page page = new Page();
		Integer pageSize = PageUtils.PAGE_SIZE_5;
		Integer userNumber = userManageDao.doGetAllUserObjectNum ();
		Integer pageCount = (userNumber-1)/pageSize+1;
		Integer start = (pageCurrent-1)*pageSize;
		page.setStart (start);
		page.setPageSize (pageSize);
		page.setPageCurrent (pageCurrent);
		page.setPageCount (pageCount);
		List<User> lists = userManageDao.doGetOnePageUserObject (page);
		if(lists==null){
			throw new ServiceException ("查询用户对象失败!");
		}
		Map<String,Object> map = new HashMap<String, Object> ();
		map.put ("lists", lists);
		map.put ("page", page);
		
		return map;
	}



	public List<User> toSearchUserObject(String searchName, Integer roleId) {
		List<User> lists = userManageDao.toSearchUserObject (searchName, roleId);
		if(lists==null){
			throw new ServiceException ("查询用户对象失败");
		}
		return lists;
	}

	public User toGetUserObjectInfoById(Integer id) {
		User user = userManageDao.toGetUserObjectInfoById(id);
		if(user==null){
			throw new ServiceException ("获取用户详情失败");
		}
		return user;
	}

}
