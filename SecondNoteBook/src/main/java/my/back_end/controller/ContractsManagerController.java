package my.back_end.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back_end/")
public class ContractsManagerController {
	/**
	 * 前往联系人管理界面
	 * method comments here
	 * @return
	 */
		@RequestMapping("tolistContactsUI.do")
		public String tolistContactsUI(){
			return "contractsManager/contracts";
		}
}
