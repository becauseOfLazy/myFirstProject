package my.back_end.controller;

import javax.annotation.Resource;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.back_end.service.ProdManageService;
import my.common.entity.Page;
import my.common.entity.Product;
import my.common.utils.JsonResult;

@Controller
@RequestMapping("/back_end/")
public class ProdManageController {
	@Resource
	private ProdManageService service;
	/**
	 * 跳转商品页面
	 */
	@RequestMapping("tolistProdUI.do")
	@RequiresUser
	public String tolistProdUI(){
		return "back_end/productManager/prod_list";
	}
	/**
	 * 跳转商品编辑页面
	 * @return
	 */
	@RequestMapping("toEditProdUI.do")
	@RequiresUser
	public String toEditProdUI(){
		return "back_end/productManager/prod_edit";
	}
	/**
	 * 获取商品管理页面
	 * @return
	 */
	@RequestMapping("toGetPageObjects.do")
	@ResponseBody
	public JsonResult doGetPageObjects(Page page){
		return new JsonResult(service.dogetAllProdsObject(page));
	}
	/**
	 * 根据id查询商品
	 * @return
	 */
	@RequestMapping("doFindObjectById.do")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id){
		return new JsonResult(service.doFindObjectById(id));
	}
	/**
	 * 更新商品
	 * @return
	 */
	@RequestMapping("doUpdateObject.do")
	@ResponseBody
	public JsonResult doUpdateObject(Product product){
		service.doUpdateObject(product);
		return new JsonResult();
	}
	/**
	 * 条件查询商品
	 * method comments here
	 * @param searchName
	 * @param valid
	 * @return
	 */
	@RequestMapping("doSearchProdObject.do")
	@ResponseBody
	public JsonResult doSearchProdObject(String searchName,Integer status){
		return new JsonResult(service.doSearchProdObject(searchName,status));
	}
	
}











