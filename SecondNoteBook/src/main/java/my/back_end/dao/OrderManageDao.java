package my.back_end.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import my.common.entity.Order;
import my.common.entity.Page;

public interface OrderManageDao {
	/**
	 * 分页查询订单对象
	 * method comments here
	 * @param page
	 * @return
	 */
	List<Order> doGetAllOrderObject(@Param("entity")Page page);
	/**
	 * 查询订单总数
	 * method comments here
	 * @return
	 */
	int dogetAllOrderCount();
	/**
	 * 条件查询订单
	 * method comments here
	 * @param key
	 * @param status
	 * @return
	 */
	List<Order> doSearchOrder(@Param("key")String key,
			@Param("status")Integer status);
	/**
	 * 根据订单id查询订单详情
	 * method comments here
	 * @param orderId
	 * @return
	 */
	Order doGetOrderByOrderId(@Param("orderId")String orderId);
	/**
	 * 修改订单对象
	 * method comments here
	 * @param order
	 * @return
	 */
	int toUpdateOrderObject(@Param("entity")Order order);
}
