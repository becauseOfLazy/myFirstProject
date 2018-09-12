package my.fore_end.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import my.common.entity.Demand;

public interface DemandCartDao {
	/**
	 * 获取所有需求单关注列表
	 * method comments here
	 * @return
	 */
	public List<Demand> toGetAllDemandCartObject(@Param("uId")Integer uId);
	/**
	 * 删除需求单
	 * method comments here
	 * @param id
	 * @param userName
	 */
	public int toDelDemandCartObject(@Param("id")Integer id,
			@Param("uId")Integer uId);
}
