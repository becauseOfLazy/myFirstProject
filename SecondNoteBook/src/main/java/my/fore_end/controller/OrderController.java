package my.fore_end.controller;

import java.util.Map;
import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.entity.Order;
import my.common.utils.JsonResult;
import my.fore_end.service.OrderService;

@Controller
@RequestMapping("/fore_end/")
public class OrderController {
	@Resource
	private OrderService oService;
	/**
	 * 获取商品订单设置数据
	 * @return
	 */
	@RequestMapping("toGetSetOrderObject.do")
	@RequiresUser
	@ResponseBody
	public JsonResult toGetOrder(){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		Map<String,Object> lists = oService.doFindAllOrderProd(userName);
		return new JsonResult(lists);
	}
	/**
	 * 修改订单，添加地址
	 * method comments here
	 * @return
	 */
	@RequestMapping("toUpdateOrderStatus.do")
	@RequiresUser
	@ResponseBody
	public JsonResult toUpdateOrderObject(Order order){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		oService.toUpdateOrderObject (order, userName);
		return new JsonResult ();
	}
	/**
	 * 取消订单
	 * method comments here
	 * @return
	 */
	@RequestMapping("toCancelOrderObject.do")
	@RequiresUser
	@ResponseBody
	public JsonResult toCancelOrderObject(Order order){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		oService.toCancleOrderObject (order, userName);
		return new JsonResult ();
	}
	/**
	 * 获取所有订单列表（未付款和已付款和签收）
	 * method comments here
	 * @return
	 */
	@RequestMapping("toGetOrderlist.do")
	@RequiresUser
	@ResponseBody
	public JsonResult toGetOrderlist(){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		
		return new JsonResult ();
	}
}
