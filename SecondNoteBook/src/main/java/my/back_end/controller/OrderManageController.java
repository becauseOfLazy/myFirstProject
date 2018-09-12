package my.back_end.controller;

import java.util.Map;

import javax.annotation.Resource;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import my.back_end.service.OrderManageService;
import my.common.entity.Order;
import my.common.utils.JsonResult;

@Controller
@RequestMapping("/back_end/")
public class OrderManageController {
	@Resource
	private OrderManageService service;
	/**
	 * 跳转订单页面
	 * @return
	 */
	@RequestMapping("tolistOrderUI.do")
	@RequiresUser
	public String tolistOrderUI(){
		return "back_end/orderManager/order_list";
	}
	/**
	 * 跳转编辑订单页面
	 * method comments here
	 * @return
	 */
	@RequestMapping("toGetOrderInfoPage.do")
	public String toGetOrderInfoPage(){
		return "back_end/orderManager/order_edit";
	}
	/**
	 * 获取订单对象
	 * method comments here
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("toGetOrderObjects.do")
	@ResponseBody
	public JsonResult toGetOrderObjects(Integer pageCurrent){
		Map<String,Object> maps = service.doGetAllOrderObject(pageCurrent);
		return new JsonResult(maps);
	}
	/**
	 * 查询订单对象
	 * method comments here
	 * @param searchOrderId
	 * @param isPay
	 * @return
	 */
	@RequestMapping("doSearchOrderObject.do")
	@ResponseBody
	public JsonResult doSearchOrderObject(String key,Integer status){
		return new JsonResult(service.doSearchOrder(key,status));
	}

	/**
	 * 加载编辑订单详情
	 * method comments here
	 * @return
	 */
	@RequestMapping("toLoadOrderObjectInfo.do")
	@ResponseBody
	public JsonResult doGetOrderByOrderId(String orderId){
		return new JsonResult (service.doGetOrderByOrderId (orderId));
	}
	/**
	 * 修改订单对象
	 * method comments here
	 * @param order
	 * @return
	 */
	@RequestMapping("toUpdateOrderObject.do")
	@ResponseBody
	public JsonResult toUpdateOrderObject(Order order){
		service.toUpdateOrderObject (order);
		return new JsonResult ();
	}

}






