package my.fore_end.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.entity.Product;
import my.common.utils.JsonResult;
import my.common.utils.StringUtil;

import my.fore_end.service.ProdCartService;

@Controller
@RequestMapping("/fore_end/")
public class ProdCartController {
	@Resource
	private ProdCartService cService;
	/**
	 * 跳转商品购物车页面
	 * method comments here
	 * @return
	 */
	@RequestMapping("toGetProdCartPage.do")
	@RequiresUser
	public String toGetProdCartPage(){
		return "fore_end/cart/prodCart";
	}
	/**
	 * 提交购物车商品数据
	 * @return
	 */
	@RequestMapping("toSubmitCartProd.do")
	@RequiresUser
	@ResponseBody
	public JsonResult toSubmitCartProd(String prodIds){
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		cService.insertProdToOrder(prodIds,username);
		return new JsonResult();
	}
	
	/**
	 * 获取购物车商品数据
	 * @return
	 */
	@RequestMapping("toGetCartList.do")
	@RequiresUser
	@ResponseBody
	public JsonResult toGetCartList(){
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		List<Product> lists = cService.doGetCartList(username);
		return new JsonResult(lists);
	}
	
	/**
	 * 删除选中商品
	 * @return
	 */
	@RequestMapping("toDelProdBySelect.do")
	@RequiresUser
	@ResponseBody
	public JsonResult toDelProdBySelect(String prodIds){
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		cService.delProdByProdIds(StringUtil.strToListArr (prodIds, ","),username);
		return new JsonResult();
	}

}
