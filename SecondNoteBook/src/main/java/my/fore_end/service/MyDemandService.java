package my.fore_end.service;

import java.util.List;
import my.common.entity.Demand;


public interface MyDemandService {
	/**
	 * 获得所有需求单
	 * method comments here
	 * @return
	 */
		public List<Demand> toGetAllDemandObject(String userName);
		/**
		 * 删除需求单
		 * method comments here
		 * @param id
		 * @param userName
		 */
		public void toDeleteDemandObject(Integer id,String userName);
		/**
		 * 获取需求单根据Id
		 * method comments here
		 * @param id
		 * @param userName
		 * @return
		 */
		public Demand toGetDemandById(Integer id,String userName);
		/**
		 * 修改需求单信息
		 * method comments here
		 * @param demand
		 * @param userName
		 */
		public void toUpdateDemand(Demand demand,String userName);
}
