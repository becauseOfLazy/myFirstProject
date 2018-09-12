package my.back_end.service;

import java.util.List;
import java.util.Map;
import my.common.entity.Page;
import my.common.entity.Product;

public interface ProdManageService {
	/**
	 * 获取所有的商品消息
	 * @return
	 */
	Map<String,Object> dogetAllProdsObject(Page page);
	/**
	 * 根据id查找商品
	 * @param id
	 * @return
	 */
	Product doFindObjectById(Integer id);
	/**
	 * 更新商品
	 * @param product
	 * @return
	 */
	void doUpdateObject(Product product);
	
	/**
	 * 查询商品
	 * @param searchName
	 * @return
	 */
	List<Product> doSearchProdObject(String searchName,Integer status);

}
