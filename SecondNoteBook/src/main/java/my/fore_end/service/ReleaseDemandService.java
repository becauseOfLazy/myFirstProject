package my.fore_end.service;

import my.common.entity.Demand;

public interface ReleaseDemandService {
	/**
	 * 保存需求单信息
	 * method comments here
	 * @param demand
	 * @return
	 */
	void saveMyDemandObject(Demand demand,String userName);

}
