package my.fore_end.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import my.common.entity.Order;
import my.common.entity.Product;
import my.common.enums.OrderStatus;
import my.common.utils.DateTransformUtils;
import my.common.utils.DateUtils;
import my.common.utils.ImgUtil;
import my.common.utils.JedisUtil;
import my.common.utils.StringUtil;
import my.fore_end.dao.OrderDao;
import my.fore_end.dao.UserDao;
import my.fore_end.exception.ServiceException;
import my.fore_end.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Resource
	private OrderDao orderDao;
	@Resource
	private UserDao userDao;
	
	public Map<String,Object> doFindAllOrderProd(String userName) {
		Map<String,Object> map = new HashMap<String, Object> ();
		List<Product> lists = new ArrayList<Product> ();
		int uId = userDao.findIdbyUserName(userName);
		Order order = new Order();
		order.setuId (uId);
		order.setStatus (OrderStatus.PAID_NO_SET.getCode ());
		Order os = orderDao.findOrderWithNoSet(order);
		List<Integer> prodIds = StringUtil.strToListArr (os.getProdIds (), ",");
		
		for(Integer prodId : prodIds){
				Product prod = orderDao.getProdByProdId (prodId);
				prod.setImgUrl (ImgUtil.addHeadImg (JedisUtil.getMapValue ("prod_"+prod.getId (), "img_0").get (0)));
				lists.add (prod);
		}
		map.put ("order", order);
		map.put ("lists", lists);
		return map;
	}

	public void toUpdateOrderObject(Order order,String userName) {
		int uId = userDao.findIdbyUserName(userName);
		order.setuId (uId);
		order.setUpdateTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		order.setStatus (OrderStatus.PAID_NO.getCode ());
		int row = orderDao.toUpdateOrderObject (order);
		if(row<1){
			throw new ServiceException("修改订单对象");
		}
	}

	public void toCancleOrderObject(Order order, String userName) {
		int uId = userDao.findIdbyUserName(userName);
		order.setuId (uId);
		order.setUpdateTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		order.setStatus (OrderStatus.PAID_CANCEL.getCode ());
		int row = orderDao.toUpdateOrderObject (order);
		if(row<1){
			throw new ServiceException("取消订单对象");
		}
	}

	public Map<String, Object> toGetAllOrderList(String userName) {
		int uId = userDao.findIdbyUserName(userName);
		Order order = new Order();
		order.setuId (uId);
		order.setStatus (OrderStatus.PAID_NO.getCode ());
		return null;
	}

}
