package my.back_end.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import my.common.entity.Demand;
import my.common.entity.Page;


public interface DemandManageDao {
		/**
		 * 删除需求单通过id
		 * method comments here
		 * @param id
		 */
		public int delDemandObjectById(@Param("id")Integer id);
		/**
		 * 获取需求单总数量
		 * method comments here
		 * @return
		 */
		public int doGetDemandCount();
		/**
		 * 分页查询获取一页需求单对象s
		 * method comments here
		 * @param start
		 * @param pageSize
		 * @return
		 */
		public List<Demand> doGetDemandList(@Param("entity")Page page);
		/**
		 * 查询需求单
		 * method comments here
		 * @param searchName
		 * @param valid
		 * @return
		 */
		public List<Demand> doSearchDemandObject(@Param("searchName")String searchName,
				@Param("status")Integer status);
}
