package my.fore_end.dao;

import org.apache.ibatis.annotations.Param;
import my.common.entity.Demand;

public interface ReleaseDemandDao {
	
	/**
	 * 保存需求单信息
	 * method comments here
	 * @param demand
	 * @return
	 */
	int saveDemandObject(@Param("entity")Demand demand);
}
