package my.fore_end.service;

import java.util.Map;

public interface DemandService {
	/**
	 * 获取所有的需求单数据
	 * method comments here
	 * @return
	 */
	public Map<String,Object> toGetAllDemandObject(Integer pageCurrent);
	/**
	 * 添加需求单到购物车中
	 * method comments here
	 * @param id
	 * @param userName
	 */
	public void toAddDemandToCart(Integer id,String userName);
	/**
	 * 条件查询需求单数据
	 * method comments here
	 * @return
	 */
	public Map<String,Object> toSearchDemandObject(String beginDate,String endDate,
			String searchName,Integer buyType);

}
