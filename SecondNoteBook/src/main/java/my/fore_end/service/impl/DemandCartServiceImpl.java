package my.fore_end.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import my.common.entity.Demand;
import my.fore_end.dao.DemandCartDao;
import my.fore_end.dao.UserDao;

import my.fore_end.exception.ServiceException;
import my.fore_end.service.DemandCartService;

@Service
public class DemandCartServiceImpl implements DemandCartService{
		@Resource	
		private DemandCartDao ddao;
		@Resource
		private UserDao udao;
		public Map<String, Object> toGetAllDemandCartObject(String userName) {
			Map<String,Object> maps = new HashMap<String, Object>();
			Integer uId = udao.findIdbyUserName (userName);
			List<Demand> lists = ddao.toGetAllDemandCartObject (uId);
			maps.put ("lists", lists);
			return maps;
		}
		public void toDelDemandCartObject(Integer id, String userName) {
			Integer uId = udao.findIdbyUserName (userName);
			System.out.println (id+","+uId);
			int row = ddao.toDelDemandCartObject (id, uId);
			System.out.println (row);
			if(row<1){
				throw new ServiceException ("删除需求单失败");
			}
		}
		
}
