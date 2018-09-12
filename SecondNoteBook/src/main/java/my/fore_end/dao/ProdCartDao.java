package my.fore_end.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import my.common.entity.Order;
import my.common.entity.ProdCart;
import my.common.entity.Product;


/**
 * 商品购物车Dao
 * @author object
 *
 */
public interface ProdCartDao {
	
	/**
	 * 获取所有购物车数据
	 * @return
	 */
	List<Product> doGetCartList(@Param("uId")Integer uId);

	/**
	 * 删除购物车商品根据Id
	 * @param prodId
	 * @return
	 */
	int delProdByProdId(@Param("entity")ProdCart prodCart);
	/**
	 * 提交购物车商品到订单
	 * @param prodId
	 * @return
	 */
	int insertProdToOrder(@Param("entity")Order order);
}
