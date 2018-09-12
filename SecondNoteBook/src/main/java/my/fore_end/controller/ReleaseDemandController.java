package my.fore_end.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.entity.Demand;
import my.common.utils.JsonResult;

import my.fore_end.service.ReleaseDemandService;

@Controller
@RequestMapping("/fore_end/")
public class ReleaseDemandController {
	
	@Resource
	private ReleaseDemandService service;
	/**
	 * 发布需求单页面
	 * method comments here
	 * @return
	 */
	@RequestMapping("toGetReleaseDemandPage.do")
	@RequiresUser
	public String toGetReleaseDemandPage(){
		return "fore_end/release/releaseMyDemand";
	}
	/**
	 * 提交发布需求单
	 * method comments here
	 * @return
	 */
	@RequestMapping("toSubmitDemand.do")
	@RequiresUser
	@ResponseBody
	public JsonResult toGetReleaseDemandPage(Demand demand){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		
		service.saveMyDemandObject (demand, userName);
		return new JsonResult ();
	}
}
