package my.fore_end.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.entity.Product;
import my.common.utils.JsonResult;
import my.fore_end.service.MyProdService;

@Controller
@RequestMapping("/fore_end/")
public class MyProdController {
	@Resource
	private MyProdService myService;
	/**
	 * 我的商品列表页面
	 * method comments here
	 * @return
	 */
	@RequestMapping("toGetProdPage.do")
	public String toGetProdPage(){
		return "fore_end/my/myProd_list";
	}
	/**
	 * 编辑我的商品列表页面
	 * method comments here
	 * @return
	 */
	@RequestMapping("toLoadEditMyProdPage.do")
	public String toLoadEditMyProdPage(){
		return "fore_end/my/edit_myProdList";
	}
	/**
	 * 获取我的商品信息
	 * method comments here
	 * @return
	 */
	@RequestMapping("doGetMyProdObject.do")
	@ResponseBody
	public JsonResult doGetMyProdObject(){
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		return new JsonResult(myService.doGetMyProdObject(username));
	}
	/**
	 * 获取商品详情
	 * method comments here
	 * @param id
	 * @return
	 */
	@RequestMapping("doGetProdInfo.do")
	@ResponseBody
	public JsonResult doGetProdInfo(Integer id){
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		return new JsonResult(myService.doGetProdInfoById(id,username));
	}
	/**
	 * 更新商品
	 * method comments here
	 * @param prod
	 * @return
	 */
	@RequestMapping("toUpdateProd.do")
	@ResponseBody
	public JsonResult toUnderProd(Product prod){
		myService.doUpdateMyProdObject(prod);
		return new JsonResult();
	}
	
	
}








