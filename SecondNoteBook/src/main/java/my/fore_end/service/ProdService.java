package my.fore_end.service;

import java.util.Map;


public interface ProdService {
	
	/**
	 * 通过搜索栏关键字查询商品
	 * @param searchName
	 * @return
	 */
	Map<String,Object> doSearchProdlistByKey(String keyName);
	/**
	 * 根据热门词查询商品
	 * method comments here
	 * @param prodType
	 * @param minPrice
	 * @param maxPrice
	 * @param buyType
	 * @return
	 */
	Map<String,Object> doSearchProdByHot(String prodType,double minPrice,
			double maxPrice,Integer buyType);
	/**
	 * 获取一页的商品
	 * @return
	 */
	Map<String,Object> togetProdList(Integer pageCurrent);
	/**
	 * 通过id获取商品
	 * @return
	 */
	Map<String,Object> doFindProdByprodId(Integer prodId);
	
	/**
	 * 保存商品
	 * @param prodId
	 * @return
	 */
	void insertObjectToCart(Integer prodId,String username);
	/**
	 * 更新商品关注度
	 * @param prodId
	 */
	void updateAttenNum(Integer prodId);
}
