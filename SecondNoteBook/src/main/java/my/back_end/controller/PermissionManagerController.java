package my.back_end.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back_end/")
public class PermissionManagerController {
	/**
	 * 前往角色权限页面
	 * method comments here
	 * @return
	 */
  	@RequestMapping("tolistPermissionUI.do")
		public String tolistPermissionUI(){
			return "permissionManager/permission";
		}
}
