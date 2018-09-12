package my.fore_end.controller;


import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.utils.JsonResult;
import my.fore_end.service.DemandCartService;

@Controller
@RequestMapping("/fore_end/")
public class DemandCartController {
	@Resource
	private DemandCartService dService;
	/**
	 * 跳转需求单购关注列表
	 * method comments here
	 * @return
	 */
	@RequestMapping("toGetDemandCartPage.do")
	public String toGetDemandCartPage(){
		return "fore_end/cart/demandCart";
	}
	
	/**
	 * 获取需求单关注列表
	 * method comments here
	 * @return
	 */
	@RequestMapping("toGetDemandCartObject.do")
	@ResponseBody
	@RequiresUser
	public JsonResult toGetDemandCartObject(){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		
		return new JsonResult (dService.toGetAllDemandCartObject (userName));
	}
	/**
	 * 删除需求单对象
	 * method comments here
	 * @param id
	 * @return
	 */
	@RequestMapping("toDelDemandCartObject.do")
	@ResponseBody
	@RequiresUser
	public JsonResult toDelDemandCartObject(Integer id){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		dService.toDelDemandCartObject (id, userName);
		return new JsonResult ();
	}
	
}
