package my.back_end.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back_end/")
public class GroupsManagerController {
	/**
	 * 前往联系群管理界面
	 * method comments here
	 * @return
	 */
		@RequestMapping("tolistGroupsUI.do")
		public String tolistGroupsUI(){
			return "groupManager/groups";
		}
}
