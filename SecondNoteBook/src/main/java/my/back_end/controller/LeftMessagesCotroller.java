package my.back_end.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import my.back_end.service.UserSuggestService;
import my.common.utils.JsonResult;

@Controller
@RequestMapping("/back_end/")
public class LeftMessagesCotroller {
	@Resource
	private UserSuggestService service;
	/**
	 * 获取所有的留言
	 * method comments here
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("doGetAllSuggest.do")
	@ResponseBody
	public JsonResult doGetAllSuggest(Integer pageCurrent){
		
		return new JsonResult(service.doGetAllUserSuggest(pageCurrent));
	}
	/**
	 * 获取留言详情
	 * method comments here
	 * @param id
	 * @return
	 */
	@RequestMapping("doGetAllSuggestInfo.do")
	@ResponseBody
	public JsonResult doGetAllSuggestInfo(Integer id){
		return new JsonResult(service.doGetAllSuggestInfo(id));
	}
	/**
	 * 根据留言状态查询留言
	 * method comments here
	 * @param state
	 * @return
	 */
	@RequestMapping("doSearchSuggestByState.do")
	@ResponseBody
	public JsonResult doSearchSuggestByState(Integer status,Integer times){
		return new JsonResult(service.doSearchSuggestByState(status,times));
	}
	
}
