package my.fore_end.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.utils.JsonResult;
import my.fore_end.service.ProdService;

@Controller
@RequestMapping("/fore_end/")
public class ProductController {
	
	@Resource
	private ProdService service;
	/**
	 * 前往商品页面
	 * @return
	 */
	@RequestMapping("toProdlistPage.do")
	public String toProductPage(){
		return "fore_end/product/prod_list";
	}
	/**
	 * 通过搜索栏关键字，查询商品
	 * @return
	 */
	@RequestMapping("toSearchProdlistByKey.do")
	@ResponseBody
	public JsonResult toSearchProdlistByKey(String keyName){
		return new JsonResult(service.doSearchProdlistByKey(keyName));
	}
	/**
	 * 通过热门词查询商品
	 * @return
	 */
	@RequestMapping("toSearchProdByHot.do")
	@ResponseBody
	public JsonResult toSearchProdByHot(String prodType,String minPrice,
			String maxPrice,Integer buyType){

		return new JsonResult (service.doSearchProdByHot (prodType, 
				Double.parseDouble (minPrice), 
				Double.parseDouble (maxPrice),
				buyType));
	}
	/**
	 * 获取商品列表
	 * @return
	 */
	@RequestMapping("togetProdList.do")
	@ResponseBody
	public JsonResult togetProdList(Integer pageCurrent){
		Map<String,Object> maps = service.togetProdList(pageCurrent);
		return new JsonResult(maps);
	}
	/**
	 * 获取商品详情
	 * @return
	 */
	@RequestMapping("toGetProdInfo.do")
	@ResponseBody
	public JsonResult toProduct_infoPage(Integer prodId){
		return new JsonResult(service.doFindProdByprodId(prodId));
	}
	
	/**
	 * 添加商品到购物车
	 * @param prodId
	 * @param prodNumber
	 * @return
	 */
	@RequestMapping("toAddProdToCart.do")
	@RequiresUser
	@ResponseBody
	public JsonResult toAddcartbut(Integer prodId){
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		service.insertObjectToCart(prodId,username);
		return new JsonResult();
	}
	
}
