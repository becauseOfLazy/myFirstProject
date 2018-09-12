package my.back_end.service;

import java.util.List;
import java.util.Map;
import my.common.entity.Demand;


public interface DemandManageService {
	/**
	 * 删除需求单通过ID
	 * method comments here
	 */
		public void toDelDemandObjectById(Integer id);
		/**
		 * 获取所有的需求单对象
		 * method comments here
		 * @return
		 */
		public Map<String,Object> toGetAllDemandObject(Integer pageCurrent);
		/**
		 * 查询需求单对象
		 * method comments here
		 * @param searchName
		 * @param valid
		 * @return
		 */
		public List<Demand> toSearchDemandObject(String searchName,Integer valid);
}
