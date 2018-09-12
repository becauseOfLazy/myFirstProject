package my.fore_end.controller;

import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.utils.JsonResult;
import my.fore_end.service.DemandService;

@Controller
@RequestMapping("/fore_end/")
public class DemandController {
	@Resource
	private DemandService service;
	/**
	 * 加载需求单页面
	 * method comments here
	 * @return
	 */
	  @RequestMapping("toDemandlistPage.do")
		public String toDemandlistPage(){
			return "fore_end/demand/demand_list";
		}
	  /**
	   * 加载需求单页面数据
	   * method comments here
	   * @return
	   */
	  @RequestMapping("toLoadDemandPageObject.do")
	  @ResponseBody
	 public JsonResult toLoadDemandPageObject(Integer pageCurrent){
	   
		 return new JsonResult (service.toGetAllDemandObject (pageCurrent));
	 }
	  /**
	   * 添加需求单到购物车
	   * method comments here
	   * @param id
	   * @return
	   */
	  @RequestMapping("toAddDemandToCart.do")
	  @ResponseBody
	  @RequiresUser
	  public JsonResult toAddDemandToCart(Integer id){
	  	String userName = (String) SecurityUtils.getSubject().getPrincipal();
	  	service.toAddDemandToCart (id, userName);
	  	return new JsonResult ();
	  }
	  /**
	   * 查询需求单
	   * method comments here
	   * @return
	   */
	  @RequestMapping("toSearchDemandObject.do")
	  @ResponseBody
	  public JsonResult toSearchDemandObject(String beginDate,String endDate,
	  		String searchName,Integer buyType){
	  	System.out.println (beginDate+","+endDate+","+searchName+","+buyType);
	  	return new JsonResult (service.toSearchDemandObject (beginDate, endDate, searchName, buyType));
	  }
}















