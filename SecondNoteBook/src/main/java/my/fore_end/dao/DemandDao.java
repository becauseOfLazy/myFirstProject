package my.fore_end.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import my.common.entity.Demand;


public interface DemandDao {
	/**
	 * 获取所有的需求单数据
	 * method comments here
	 * @return
	 */
	public List<Demand> toGetAllDemandObject(@Param("start")Integer start,
			@Param("pageSize")Integer pageSize);
	/**
	 * 获取需求单数量
	 * method comments here
	 * @return
	 */
	public Integer toGetAllDemandNum();
	/**
	 * 保存需求单到购物车中
	 * method comments here
	 * @param demandId
	 * @param uId
	 * @return
	 */
	public int saveDemandToCart(@Param("demandId")Integer demandId,
			@Param("uId")Integer uId);
	/**
	 * 查询需求单商品
	 * method comments here
	 * @param beginDate
	 * @param endDate
	 * @param buyType
	 * @param searchName
	 * @return
	 */
	public List<Demand> toSearchDemandObject(@Param("beginDate")String beginDate,
			@Param("endDate")String endDate,@Param("buyType")Integer buyType,
			@Param("searchName")String searchName);
}
