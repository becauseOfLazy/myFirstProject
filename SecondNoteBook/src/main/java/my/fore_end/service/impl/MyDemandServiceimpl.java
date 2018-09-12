package my.fore_end.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import my.common.entity.Demand;
import my.fore_end.dao.MyDemandDao;
import my.fore_end.dao.UserDao;

import my.fore_end.exception.ServiceException;
import my.fore_end.service.MyDemandService;
@Service
public class MyDemandServiceimpl implements MyDemandService{
	@Resource
	private UserDao userDao;
	@Resource
	private MyDemandDao myDao;

	public List<Demand> toGetAllDemandObject(String userName) {
		Integer uId = userDao.findIdbyUserName (userName);
		List<Demand> lists = myDao.toGetAllDemandObject (uId);
		if(lists==null){
			throw new ServiceException ();
		}
		return lists;
	}

	public void toDeleteDemandObject(Integer id, String userName) {
		Integer uId = userDao.findIdbyUserName (userName);
		int row = myDao.toDeleteDemandObject (id, uId);
		if(row<1){
			throw new ServiceException ("删除需求单失败");
		}
	}

	public Demand toGetDemandById(Integer id, String userName) {
		Integer uId = userDao.findIdbyUserName (userName);
		Demand demand = myDao.toGetDemandById (id, uId);
		if(demand==null){
			throw new ServiceException ("获取需求单失败");
		}
		return demand;
	}

	public void toUpdateDemand(Demand demand, String userName) {
		Integer uId = userDao.findIdbyUserName (userName);
		demand.setuId (uId);
		int row = myDao.toUpdateDemand (demand);
		if(row < 1){
			throw new ServiceException("修改需求单失败");
		}
		
	}

}
