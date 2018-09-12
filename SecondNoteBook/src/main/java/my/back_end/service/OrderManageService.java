package my.back_end.service;


import java.util.List;
import java.util.Map;
import my.common.entity.Order;

public interface OrderManageService {
	/**
	 * 分页获取订单对象
	 * method comments here
	 * @param pageCurrent
	 * @return
	 */
	Map<String,Object> doGetAllOrderObject(Integer pageCurrent);
	/**
	 * 条件查询订单
	 * method comments here
	 * @param searchOrderId
	 * @param isPay
	 * @return
	 */
	List<Order> doSearchOrder(String key,Integer isPay);
	/**
	 * 获取订单对象根据订单id
	 * method comments here
	 * @param orderId
	 * @return
	 */
	Order doGetOrderByOrderId(String orderId);
	/**
	 * 修改订单状态
	 * method comments here
	 * @param order
	 */
	void toUpdateOrderObject(Order order);
}
