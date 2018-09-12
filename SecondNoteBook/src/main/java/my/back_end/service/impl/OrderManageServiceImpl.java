package my.back_end.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import my.back_end.dao.OrderManageDao;
import my.back_end.service.OrderManageService;
import my.common.entity.Order;
import my.common.entity.Page;
import my.common.utils.DateTransformUtils;
import my.common.utils.DateUtils;
import my.common.utils.PageUtils;
import my.fore_end.exception.ServiceException;

@Service
public class OrderManageServiceImpl implements OrderManageService{
	@Resource
	private OrderManageDao dao;

	public Map<String, Object> doGetAllOrderObject(Integer pageCurrent) {
		Page page = new Page();
		int pageSize = PageUtils.PAGE_SIZE_5;
		int orderCount = dao.dogetAllOrderCount();
		int pageCount = (orderCount-1)/pageSize+1;
		int start = (pageCurrent-1)*pageSize;
		page.setStart (start);
		page.setPageSize (pageSize);
		page.setPageCurrent (pageCurrent);
		page.setPageCount (pageCount);
		List<Order> lists = dao.doGetAllOrderObject(page);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("lists", lists);
		map.put("page", page);
		return map;
	}

	public List<Order> doSearchOrder(String key, Integer status) {
		return dao.doSearchOrder(key, status);
	}

	public Order doGetOrderByOrderId(String orderId) {
		Order order = dao.doGetOrderByOrderId(orderId);
		return order;
	}

	public void toUpdateOrderObject(Order order) {
		order.setUpdateTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		int row = dao.toUpdateOrderObject (order);
		if(row<1){
			throw new ServiceException ("修改订单对象失败!");
		}
	}
	
}
