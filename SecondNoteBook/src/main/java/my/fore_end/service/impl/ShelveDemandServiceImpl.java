package my.fore_end.service.impl;


import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import my.common.entity.Demand;
import my.common.enums.DemandStatus;
import my.common.utils.DateTransformUtils;
import my.common.utils.DateUtils;
import my.fore_end.dao.ReleaseDemandDao;
import my.fore_end.dao.UserDao;

import my.fore_end.exception.ServiceException;
import my.fore_end.service.ReleaseDemandService;

@Service
public class ShelveDemandServiceImpl implements ReleaseDemandService{
	@Resource
	private UserDao userDao;
	@Resource
	private ReleaseDemandDao shelveDao;
	/**
	 * 保存需求单
	 */
	public void saveMyDemandObject(Demand demand, String userName) {
		Integer uId = userDao.findIdbyUserName(userName);
		demand.setuId (uId);
		demand.setBeginTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		demand.setEndTime (DateTransformUtils.TimestampToString (DateUtils.getNextTime (0, 3, 0,0,0,0)));
		demand.setUpdateTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		demand.setStatus (DemandStatus.RELEASE_YES.getCode ());
		int row = shelveDao.saveDemandObject (demand);
		if(row<1){
			throw new ServiceException ("发布需求单失败");
		}
	}



}
