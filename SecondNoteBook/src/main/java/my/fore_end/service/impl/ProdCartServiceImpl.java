package my.fore_end.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import my.common.entity.Order;
import my.common.entity.ProdCart;
import my.common.entity.Product;
import my.common.enums.OrderStatus;
import my.common.enums.ProdBuyType;
import my.common.utils.DateTransformUtils;
import my.common.utils.DateUtils;
import my.common.utils.ImgUtil;
import my.common.utils.JedisUtil;
import my.common.utils.RandomUtils;
import my.common.utils.StringUtil;
import my.fore_end.dao.ProdCartDao;
import my.fore_end.dao.UserDao;
import my.fore_end.exception.ServiceException;
import my.fore_end.service.ProdCartService;

@Service
public class ProdCartServiceImpl implements ProdCartService{
	@Resource
	private ProdCartDao cartDao;
	@Resource
	private UserDao userDao;
	
	public List<Product> doGetCartList(String userName) {
		int uId = userDao.findIdbyUserName(userName);
		List<Product> lists = cartDao.doGetCartList(uId);
		for(Product prod : lists){
			prod.setImgUrl (ImgUtil.addHeadImg (JedisUtil.getMapValue ("prod_"+prod.getId (), "img_0").get (0)));
		}
		if(lists==null||lists.isEmpty()){
			throw new ServiceException("获取购物车商品信息失败");
		}
		return lists;
	}

	public void delProdByProdIds(List<Integer> prodIds,String userName) {
		int uId = userDao.findIdbyUserName(userName);
		for(Integer prodId:prodIds){
			ProdCart cart = new ProdCart();
			cart.setProdId (prodId);
			cart.setuId (uId);
			int row = cartDao.delProdByProdId(cart);
			if(row < 1){
				throw new ServiceException("删除商品失败");
			}
		}
	}

	public void insertProdToOrder(String prodIds,String userName) {
		int uId = userDao.findIdbyUserName(userName);
		Order order = new Order();
		order.setuId (uId);
		order.setOrderId (RandomUtils.getGroupRandom ());
		order.setBuyType (ProdBuyType.BUY_ONLINE.getCode ());
		order.setStatus (OrderStatus.PAID_NO_SET.getCode ());
		order.setProdIds (prodIds);
		order.setCreatedTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		//有效时间为30分钟
		order.setCancelTime(DateTransformUtils.TimestampToString (DateUtils.getNextTime (0, 0, 0, 0, 30, 0)));
		order.setUpdateTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		int row = cartDao.insertProdToOrder (order);
		if(row < 1){
			throw new ServiceException ("提交订单失败");
		}
		//根据prodIds，删除购物车内的商品
		List<Integer> ids = StringUtil.strToListArr (prodIds, ",");
		for(Integer id : ids){
			ProdCart cart = new ProdCart();
			cart.setProdId (id);
			cart.setuId (uId);
			cartDao.delProdByProdId (cart);
		}
	}

}
