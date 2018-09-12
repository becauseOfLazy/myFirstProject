package my.fore_end.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import my.common.entity.Demand;


public interface MyDemandDao {
	/**
	 * 获取所有的需求单
	 * method comments here
	 * @return
	 */
		public List<Demand> toGetAllDemandObject(@Param("uId")Integer uId);
		/**
		 *根据id删除需求单
		 * method comments here
		 * @param id
		 * @param userName
		 */
		public int toDeleteDemandObject(@Param("id")Integer id,@Param("uId")Integer uId);
		/**
		 * 根据id获取需求单
		 * method comments here
		 * @param id
		 * @param userName
		 * @return
		 */
		public Demand toGetDemandById(@Param("id")Integer id,@Param("uId")Integer uId);
		/**
		 * 修改需求单信息
		 * method comments here
		 * @param demand
		 * @param userName
		 */
		public int toUpdateDemand(@Param("entity")Demand demand);

}
