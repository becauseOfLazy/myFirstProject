package my.fore_end.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import my.common.entity.Page;
import my.common.entity.ProdCart;
import my.common.entity.Product;
import my.common.enums.ProdStatus;
import my.common.utils.DateTransformUtils;
import my.common.utils.DateUtils;
import my.common.utils.ImgUtil;
import my.common.utils.JedisUtil;
import my.common.utils.LuceneUtil;
import my.common.utils.PageUtils;
import my.fore_end.dao.ProdDao;
import my.fore_end.dao.UserDao;

import my.fore_end.exception.ServiceException;
import my.fore_end.service.ProdService;

@Service
public class ProdServiceImpl implements ProdService{
	@Resource
	private ProdDao prodDao;
	@Resource
	private UserDao userDao;
	
	public Map<String,Object> togetProdList(Integer pageCurrent) {
		//获取上架商品数
		int prodCount = prodDao.doGetProdCount(ProdStatus.PUBLISHED.getCode ());
		Page page = new Page();
		//一页数量
		Integer pageSize = PageUtils.PAGE_SIZE_10;
		//总页数
		int pageCount = (prodCount-1)/pageSize+1;
		//开始点
		int start = (pageCurrent-1)*pageSize;
		page.setPageSize (pageSize);
		page.setPageCurrent (pageCurrent);
		page.setStart (start);
		page.setPageCount (pageCount);
		//上架中的商品状态
		Integer status = ProdStatus.PUBLISHED.getCode ();
		//查询商品
		List<Product> lists = prodDao.togetProdListByPage(status,page);
		if(lists==null){
			throw new ServiceException("查询商品失败");
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("page", page);
		for(Product prod:lists ){
			List<String> imgUrl = JedisUtil.getMapValue ("prod_"+prod.getId (), "img_0");
			prod.setImgUrl (ImgUtil.addHeadImg (imgUrl.get (0)));
		}
		map.put("lists", lists);
		return map;
	}

	public Map<String,Object> doFindProdByprodId(Integer prodId) {
		Product product = prodDao.doFindProdByprodId(prodId);
		Map<String,String> imgs = ImgUtil.addHeadImgForMap (JedisUtil.getAllMap ("prod_"+prodId));
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("product", product);
		maps.put ("imgs", imgs);
		return maps;
	}
	public void insertObjectToCart(Integer prodId,String userName) {
		int uId = userDao.findIdbyUserName(userName);
		ProdCart prodCart = new ProdCart();
		prodCart.setProdId (prodId);
		prodCart.setuId (uId);
		prodCart.setCreatedTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		ProdCart cart = prodDao.findProdInCart(prodCart);
		if(cart==null){
			//加入商品到购物车
			prodDao.insertObjectToCart(prodCart);
			//查询购物车关注度
			int attenNum = prodDao.getAttenNumById(prodId);
			//修改购物车关注度
			prodDao.updateAttenNumById(prodId, attenNum+1);
		}else{
			throw new ServiceException ("你已经添加商品到购物车了");
		}
	}
	public void updateAttenNum(Integer prodId) {
		int attenNum = prodDao.getAttenNumById(prodId);
		int row = prodDao.updateAttenNumById(prodId, attenNum+1);
		if(row < 1){
			throw new ServiceException("修改商品关注度失败");
		}
	}
	public Map<String,Object> doSearchProdlistByKey(String keyName) {
		Map<String,Object> maps = new HashMap<String, Object> ();
		List<Product> lists = new ArrayList<Product> ();
		List<Integer> ids = null;
		
		try {
			ids = LuceneUtil.search (keyName);
		}
		catch (Exception e) {
			throw new ServiceException ("查询失败（lucene）");
		}
		for(Integer id : ids){
			Product prod = prodDao.doFindProdByprodId (id);
			prod.setImgUrl (JedisUtil.getMapValue ("prod_"+id, "img_0").get (0));
			lists.add (prod);
		}
		maps.put ("pageCount", 1);
		maps.put ("lists", lists);
		return maps;
	}

	public Map<String, Object> doSearchProdByHot(String prodType, double minPrice,
			double maxPrice, Integer buyType) {
		
		List<Product> lists = prodDao.doSearchProdByHot(prodType, minPrice,maxPrice,buyType);
	
		if(lists==null){
			throw new ServiceException ("查询商品失败!");
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageCount", 1);
		
		for(Product prod : lists ){
			System.out.println (prod);
			List<String> imgUrl = JedisUtil.getMapValue ("prod_"+prod.getId (), "img_0");
			prod.setImgUrl (ImgUtil.addHeadImg (imgUrl.get (0)));
		}
		map.put("lists", lists);
		return map;
	}



}
