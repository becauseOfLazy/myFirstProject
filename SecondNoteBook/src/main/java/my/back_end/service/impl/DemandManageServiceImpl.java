package my.back_end.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import my.back_end.dao.DemandManageDao;
import my.back_end.service.DemandManageService;
import my.common.entity.Demand;
import my.common.entity.Page;
import my.fore_end.exception.ServiceException;
@Service
public class DemandManageServiceImpl implements DemandManageService{
	@Resource
	private DemandManageDao dao;
	public void toDelDemandObjectById(Integer id) {
		int row = dao.delDemandObjectById (id);
		if(row<1){
			throw new ServiceException ("删除需求单失败!");
		}
	}
	public Map<String, Object> toGetAllDemandObject(Integer pageCurrent) {
		Map<String,Object> map = new HashMap<String, Object> ();
		Page page = new Page();
		Integer pageSize = 5;
		Integer start = (pageCurrent-1)*pageSize;
		Integer demandCount = dao.doGetDemandCount ();
		Integer pageCount = (demandCount-1)/pageSize+1;
		page.setStart (start);
		page.setPageSize (pageSize);
		page.setPageCurrent (pageCurrent);
		page.setPageCount (pageCount);
		List<Demand> lists = dao.doGetDemandList (page);
		if(lists==null){
			throw new ServiceException ("查询需求单列表失败!");
		}
		map.put ("lists", lists);
		map.put ("page", page);
		return map;
	}
	public List<Demand> toSearchDemandObject(String searchName, Integer status) {
		List<Demand> lists = dao.doSearchDemandObject (searchName, status);
		if(lists==null){
			throw new ServiceException ("查询需求单失败");
		}
		return lists;
	}

	
	
	
	
	
	
	
	
	
	
	

}
