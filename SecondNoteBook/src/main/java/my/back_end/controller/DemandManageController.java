package my.back_end.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.back_end.service.DemandManageService;
import my.common.utils.JsonResult;

@Controller
@RequestMapping("/back_end/")
public class DemandManageController {
	@Resource
	private DemandManageService service;
	/**
	 * 前往需求单管理界面
	 * method comments here
	 * @return
	 */
	@RequestMapping("tolistDemandUI.do")
	public String tolistDemandUI(){
		return "back_end/demandManager/demand_list";
	}
	/**
	 * 获取一页需求单对象数据
	 * method comments here
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("toLoadDemandListObject.do")
	@ResponseBody
	public JsonResult toLoadDemandListObject(Integer pageCurrent){
		
		return new JsonResult (service.toGetAllDemandObject (pageCurrent));
	}
	/**
	 * 删除需求单通过Id
	 * method comments here
	 * @param id
	 * @return
	 */
	@RequestMapping("toDelDemandObjectById.do")
	@ResponseBody
	public JsonResult toDelDemandObjectById(Integer id){
		service.toDelDemandObjectById (id);
		return new JsonResult ();
	}
	/**
	 * 查询需求单对象
	 * method comments here
	 * @return
	 */
	@RequestMapping("toSearchDemandObject.do")
	@ResponseBody
	public JsonResult toSearchDemandObject(String searchName,Integer status){
		
		return new JsonResult (service.toSearchDemandObject (searchName, status));
	}
	
}












