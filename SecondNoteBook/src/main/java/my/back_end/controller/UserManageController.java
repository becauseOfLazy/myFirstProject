package my.back_end.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import my.back_end.service.UserManageService;
import my.common.utils.JsonResult;

@Controller
@RequestMapping("/back_end/")
public class UserManageController {
	@Resource
	private UserManageService userService;
	/**
	 * 前往用户管理界面
	 * method comments here
	 * @return
	 */
	@RequestMapping("tolistUserUI.do")
	public String tolistUserUI(){
		return "back_end/userManager/user_list";
	}
	/**
	 * 用户详情编辑页面
	 * method comments here
	 * @return
	 */
	@RequestMapping("toGetUserInfoPage.do")
	public String toGetUserInfoPage(){
		return "back_end/userManager/user_edit";
	}
	/**
	 * 加载用户信息
	 * method comments here
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("doLoadUserObject.do")
	@ResponseBody
	public JsonResult doLoadUserObject(Integer pageCurrent){
		return new JsonResult(userService.doLoadUserObject(pageCurrent));
	}
	
	/**
	 * 查询用户对象
	 * method comments here
	 * @param searchName
	 * @param roleId
	 * @return
	 */
	@RequestMapping("toSearchUserObject.do")
	@ResponseBody
	public JsonResult toSearchUserObject(String searchName,Integer roleId){
		return new JsonResult (userService.toSearchUserObject (searchName, roleId));
	}
	/**
	 * 获取用户信息详情
	 * method comments here
	 * @param id
	 * @return
	 */
	@RequestMapping("toGetUserObjectInfo.do")
	@ResponseBody
	public JsonResult toGetUserObjectInfo(Integer id){
		return new JsonResult (userService.toGetUserObjectInfoById (id));
	}
}













