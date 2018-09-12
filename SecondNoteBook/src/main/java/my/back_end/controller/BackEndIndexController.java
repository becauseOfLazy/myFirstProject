package my.back_end.controller;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back_end/")
public class BackEndIndexController {
	/**
	 * 跳转主页
	 * @return
	 */
	@RequestMapping("toIndex.do")
	@RequiresUser
	public String toManagePage(){
		return "back_end/index";
	}
	
	
	/**
	 * 跳转留言页面
	 * @return
	 */
	@RequestMapping("toListMessageUI.do")
	@RequiresUser
	public String toListMessageUI(){
		return "back_end/suggestManager/suggest_list";
	}
	/**
	 * 跳转角色页面
	 * @return
	 */
	@RequestMapping("tolistRoleUI.do")
	@RequiresUser
	public String tolistTypeUI(){
		return "back_end/roleManager/role_list";
	}
}



