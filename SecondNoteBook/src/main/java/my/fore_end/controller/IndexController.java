package my.fore_end.controller;

import javax.annotation.Resource;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.utils.JsonResult;
import my.fore_end.service.IndexService;

@Controller
@RequestMapping("/fore_end/")
public class IndexController {
	@Resource
	private IndexService service;
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping("toIndex.do")
	public String toIndexPage(){
		return "fore_end/index";
	}
	
	/**
	 * 主页内容
	 * @return
	 */
	@RequestMapping("toMain.do")
	public String toMainPage(){
		return "fore_end/main";
	}
	/**
	 * 获取主页图片
	 * @return
	 */
	@RequestMapping("togetIndexImg.do")
	@ResponseBody
	public JsonResult togetIndexImg(){
		return new JsonResult(service.doGetAllImgs());
	}

	
	/**
	 * 前往商品详情页面
	 * @return
	 */
	@RequestMapping("toProdInfoPage.do")
	@RequiresUser
	public String toProdInfoPage(){
		return "fore_end/product/prod_info";
	}
	/**
	 * 前往购物车页面
	 * @return
	 */
	@RequestMapping("toCartPage.do")
	@RequiresUser
	public String toCartPage(){
		return "fore_end/cart/demandCartOrProdCart";
	}
	/**
	 * 前往订单设置页面
	 * @return
	 */
	@RequestMapping("toOrderSetPage.do")
	@RequiresUser
	public String toOrderAddPage(){
		return "fore_end/order/order_set";
	}
	/**
	 * 前往订单列表页面
	 * @return
	 */
	@RequestMapping("toOrderListPage.do")
	@RequiresUser
	public String toOrderPage(){
		return "fore_end/order/order_list";
	}
	/**
	 * 我的页面
	 * @return
	 */
	@RequestMapping("toMyProdListPage.do")
	@RequiresUser
	public String toMyProdListPage(){
		return "fore_end/my/demandOrProdList";
	}
	/**
	 * 发布页面
	 * @return
	 */
	@RequestMapping("toShelve_Prod.do")
	@RequiresUser
	@RequiresPermissions("user:sell")
	public String toShelve_Prod(){
		return "fore_end/release/releaseDemandOrProd";
	}
	
	/**
	 * 留言板页面
	 * @return
	 */
	@RequestMapping("toMessageBorad.do")
	@RequiresUser
	public String toMessageBorad(){
		return "fore_end/other/suggest";
	}
	
	/**
	 * 暂无商品
	 * @return
	 */
	@RequestMapping("toNoInfo.do")
	public String toNoInfo(){
		return "fore_end/no_info";
	}
	/**
	 * 后台页面
	 * @return
	 */
	@RequestMapping("toBackEndIndex.do")
	@RequiresUser
	@RequiresPermissions("super:login")
	@ResponseBody
	public JsonResult toBackEndIndex(){
		return new JsonResult();
	}
	
}
