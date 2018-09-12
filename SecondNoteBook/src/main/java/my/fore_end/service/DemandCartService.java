package my.fore_end.service;

import java.util.Map;

public interface DemandCartService {
	/**
	 * 获取所有需求单关注列表
	 * method comments here
	 * @return
	 */
	public Map<String,Object> toGetAllDemandCartObject(String userName);
	/**
	 * 删除需求单
	 * method comments here
	 * @param id
	 * @param userName
	 */
	public void toDelDemandCartObject(Integer id,String userName);
}
