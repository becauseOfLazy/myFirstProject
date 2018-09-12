package my.fore_end.service;

import java.util.List;
import my.common.entity.Product;



public interface MyProdService {
	/**
	 * 获取我的商品信息
	 * @param userName
	 * @return
	 */
	List<Product> doGetMyProdObject(String userName);
	/**
	 * 获取商品详情
	 * @param id
	 * @return
	 */
	Product doGetProdInfoById(Integer id,String userName);
	/**
	 * 更新商品
	 */
	void doUpdateMyProdObject(Product product);
}
