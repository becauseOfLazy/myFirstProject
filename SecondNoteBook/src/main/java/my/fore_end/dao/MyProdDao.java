package my.fore_end.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import my.common.entity.Product;


public interface MyProdDao {
	/**
	 * 获取我的商品信息
	 * @param userName
	 * @return
	 */
	List<Product> doGetMyProdObject(@Param("uId")Integer uId);
	/**
	 *根据id获取商品
	 * @param id
	 * @return
	 */
	Product doGetProdInfoById(@Param("id")Integer id,
			@Param("uId")Integer uId);
	/**
	 * 更新我的商品对象信息
	 */
	int doUpdateMyProdObject(@Param("entity")Product prod);
}
