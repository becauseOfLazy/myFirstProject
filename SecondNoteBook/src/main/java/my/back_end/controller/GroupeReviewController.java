package my.back_end.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back_end/")
public class GroupeReviewController {
	/**
	 * 前往群审核管理界面
	 * method comments here
	 * @return
	 */
		@RequestMapping("tolistGroupRevicewUI.do")
		public String tolistGroupRevicewUI(){
			return "contractsManager/contracts";
		}
}
