package my.fore_end.dao;

import org.apache.ibatis.annotations.Param;
import my.common.entity.Order;
import my.common.entity.Product;

public interface OrderDao {
	
	/**
	 * 查询所有未设置的订单
	 * @return
	 */
	Order findOrderWithNoSet(@Param("entity")Order order);
	/**
	 * 通过id获取商品
	 * method comments here
	 * @param prodId
	 * @return
	 */
	Product getProdByProdId(@Param("prodId")Integer prodId);
	/**
	 * 提交收货地址，更新订单对象
	 * method comments here
	 * @param order
	 * @return
	 */
	int toUpdateOrderObject(@Param("entity")Order order);
}
