package my.fore_end.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import my.common.entity.Demand;
import my.fore_end.dao.DemandDao;
import my.fore_end.dao.UserDao;

import my.fore_end.exception.ServiceException;
import my.fore_end.service.DemandService;

@Service
public class DemandServiceImpl implements DemandService{
	@Resource
	private DemandDao demandDao;
	@Resource
	private UserDao userDao;
	
	public Map<String, Object> toGetAllDemandObject(Integer pageCurrent) {
		Integer pageSize = 10;
		int start = (pageCurrent-1)*pageSize;
		List<Demand> lists = demandDao.toGetAllDemandObject (start, pageSize);
		Integer pageNumber = demandDao.toGetAllDemandNum ();
		Integer pageCount = (pageNumber-1)/pageSize+1;
		Map<String,Object> maps = new HashMap<String, Object>();
		maps.put ("lists", lists);
		maps.put ("pageCount", pageCount);
		return maps;
	}

	public void toAddDemandToCart(Integer id, String userName) {
		Integer uId = userDao.findIdbyUserName (userName);
		System.out.println (id+","+uId);
		int row = demandDao.saveDemandToCart (id, uId);
		
		if(row<1){
			throw new ServiceException ("添加购物车失败");
		}
	}

	public Map<String, Object> toSearchDemandObject(String beginDate, String endDate, String searchName, Integer buyType) {
		List<Demand> lists = demandDao.toSearchDemandObject (beginDate, endDate, buyType, searchName);
		int pageCount = 1;
		Map<String,Object> maps = new HashMap<String, Object> ();
		maps.put ("lists", lists);
		maps.put ("pageCount", pageCount);
		return maps;
	}



}
