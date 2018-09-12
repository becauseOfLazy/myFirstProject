package my.fore_end.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import my.common.entity.LuceneObject;
import my.common.entity.Page;
import my.common.entity.ProdCart;
import my.common.entity.Product;


public interface ProdDao {
	/**
	 * 根据热门词查询商品
	 * method comments here
	 * @param prodType
	 * @param minPrice
	 * @param maxPrice
	 * @param buyType
	 * @return
	 */
	List<Product> doSearchProdByHot(@Param("prodType")String prodType,
			@Param("minPrice")double minPrice,
			@Param("maxPrice")double maxPrice,
			@Param("buyType")Integer buyType);
	/**
	 * 通过分页对象进行分页查询所有商品列表
	 * @return
	 */
	List<Product> togetProdListByPage(@Param("status")Integer status,
			@Param("page")Page page);
	/**
	 * 获取检索字段信息
	 * method comments here
	 * @return
	 */
	List<LuceneObject> toGetAllLuceneObject();
	/**
	 * 获取上架商品数量
	 * @return
	 */
	int doGetProdCount(@Param("status")Integer status);
	/**
	 * 查找商品根据Id
	 * @return
	 */
	Product doFindProdByprodId(@Param("prodId")int prodId);

	/**
	 * 查找商品数量
	 * @param prodId
	 * @return
	 */
	int toFindProdNumber(@Param("prodId")int prodId);
	/**
	 * 把商品加入购物车
	 * @return
	 */
	int insertObjectToCart(@Param("prodCart")ProdCart prodCart);
	/**
	 * 查找购物车商品
	 * @param prodId
	 * @return
	 */
	ProdCart findProdInCart(@Param("prodCart")ProdCart prodCart);
	/**
	 * 更新关注度
	 * @param prodId
	 * @return
	 */
	int updateAttenNumById(@Param("prodId")Integer prodId,
			@Param("attenNum")Integer attenNum);
	/**
	 * 获取关注度
	 * @param prodId
	 * @return
	 */
	int getAttenNumById(@Param("prodId")Integer prodId);
}
