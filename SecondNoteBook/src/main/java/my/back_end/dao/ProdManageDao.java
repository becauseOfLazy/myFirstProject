package my.back_end.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import my.common.entity.Page;
import my.common.entity.Product;

public interface ProdManageDao {
	/**
	 * 分页获取所有商品
	 * @return
	 */
	List<Product> dogetAllProdsObject(@Param("entity")Page page);
	/**
	 * 查询商品根据id
	 * @param id
	 * @return
	 */
	Product doFindObjectById(@Param("id")Integer id);
	/**
	 * 更新商品
	 * @param product
	 * @return
	 */
	int doUpdateObject(@Param("entity")Product product);
	/**
	 * 获取总商品数
	 * @return
	 */
	int dogetAllProdNumber();
	/**
	 * 查询商品
	 * @param searchName
	 * @return
	 */
	List<Product> doSearchProdObject(@Param("searchName")String searchName,
			@Param("status")Integer status);
	
}
