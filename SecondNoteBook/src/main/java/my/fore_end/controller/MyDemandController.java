package my.fore_end.controller;

import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.entity.Demand;
import my.common.utils.JsonResult;

import my.fore_end.service.MyDemandService;

@Controller
@RequestMapping("/fore_end/")
public class MyDemandController {
	@Resource
	private MyDemandService service;
	/**
	 * 我的需求单页面
	 * method comments here
	 * @return
	 */
	@RequestMapping("toGetDemandPage.do")
	public String toGetDemandPage(){
		return "fore_end/my/myDemand_list";
	}
	/**
	 * 需求单编辑页面
	 * method comments here
	 * @return
	 */
	@RequestMapping("toLoadEditDemandPage.do")
	public String toLoadEditDemandPage(){
		return "fore_end/my/edit_myDemand";
	}
	/**
	 * 获取需求单信息
	 * method comments here
	 * @return
	 */
	@RequestMapping("toGetAllMyDemandObject.do")
	@ResponseBody
	public JsonResult toGetAllMyDemandObject(){
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		return new JsonResult (service.toGetAllDemandObject (username));
	}
	/**
	 * 删除需求单
	 * method comments here
	 * @param id
	 * @return
	 */
	@RequestMapping("toDeleteMyDemand.do")
	@ResponseBody
	public JsonResult toDeleteMyDemand(Integer demandId){
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		service.toDeleteDemandObject (demandId, username);
		return new JsonResult ();
	}
	/**
	 * 获取需求单根据
	 * method comments here
	 * @return
	 */
	@RequestMapping("dogetDemandObject.do")
	@ResponseBody
	public JsonResult dogetDemandObject(Integer demandId){
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		return new JsonResult (service.toGetDemandById (demandId, username));
	}
	/**
	 * 修改需求单
	 * method comments here
	 * @param demand
	 * @return
	 */
	@RequestMapping("toUpdateDemandInfo.do")
	@ResponseBody
	public JsonResult toUpdateDemandInfo(Demand demand){
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		service.toUpdateDemand (demand, username);
		return new JsonResult ();
	}
}
