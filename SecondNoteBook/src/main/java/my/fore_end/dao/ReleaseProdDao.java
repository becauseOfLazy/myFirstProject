package my.fore_end.dao;

import org.apache.ibatis.annotations.Param;
import my.common.entity.Product;


public interface ReleaseProdDao {
	/**
	 * 保存商品信息
	 * @return
	 */
	int saveProdObject(@Param("entity")Product product);
	/**
	 * 根据商品名查找商品Id
	 * @param prodName
	 * @return
	 */
	int findIdByProdName(@Param("prodName")String prodName,
			@Param("uId")Integer uId);
	
}
