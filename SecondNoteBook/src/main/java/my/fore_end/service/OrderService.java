package my.fore_end.service;

import java.util.Map;
import my.common.entity.Order;

public interface OrderService {
	
	/**
	 * 获取所有订单
	 * @return
	 */
	Map<String,Object> doFindAllOrderProd(String userName);
	/**
	 * 修改订单状态
	 * method comments here
	 * @param order
	 */
	void toUpdateOrderObject(Order order,String userName);
	/**
	 * 取消订单
	 * method comments here
	 */
	void toCancleOrderObject(Order order,String userName);
	/**
	 * 获取所有订单列表
	 * method comments here
	 * @return
	 */
	Map<String,Object> toGetAllOrderList(String userName);
}
