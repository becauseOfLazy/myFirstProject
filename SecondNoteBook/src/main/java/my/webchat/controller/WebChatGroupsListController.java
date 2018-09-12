package my.webchat.controller;

import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.entity.WebChatGroupInfo;
import my.common.utils.JsonResult;

import my.webchat.service.WebChatGroupsListService;

@Controller
@RequestMapping("/web_chat/")
public class WebChatGroupsListController {
	@Resource
	private WebChatGroupsListService service;
	/**
	 * 获取群组列表
	 * method comments here
	 * @return
	 */
	@RequestMapping("toGetGroupsListObjects.do")
	@ResponseBody
	public JsonResult toGetGroupsListObjects(){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		
		return new JsonResult ();
	}
	/**
	 * 创建联系群
	 * method comments here
	 * @return
	 */
	@RequestMapping("toSubmitGroupInfo.do")
	@ResponseBody
	public JsonResult toSubmitGroupInfo(WebChatGroupInfo group){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		service.toSaveGroupInfo (group, userName);
		return new JsonResult ();
	}
	/**
	 * 查询联系群
	 * method comments here
	 * @return
	 */
	@RequestMapping("doSearchGroupsObjects.do")
	@ResponseBody
	public JsonResult doSearchGroupsObjects(String searchName){
		return new JsonResult (service.toGetGroupsBysearchName (searchName));
	}
	/**
	 * 添加联系群
	 * method comments here
	 * @return
	 */
	@RequestMapping("toAddGroupObject.do")
	@ResponseBody
	public JsonResult toAddGroupObject(String groupId){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		service.toJoinGroup (groupId, userName);
		return new JsonResult ();
	}
	
}
