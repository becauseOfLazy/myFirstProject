package my.fore_end.service;

import java.util.List;

import my.common.entity.Product;


public interface ProdCartService {
	
	/**
	 * 获取所有购物车商品数据
	 * @return
	 */
	List<Product> doGetCartList(String username);
	/**
	 * 删除商品根据id
	 */
	void delProdByProdIds(List<Integer> prodIds,String userName);
	/**
	 * 提交购物车商品到订单
	 */
	void insertProdToOrder(String prodIds,String userName);
}
