package my.back_end.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back_end/")
public class UserReviewController {
		/**
		 * 用户审核页面
		 * method comments here
		 * @return
		 */
		@RequestMapping("tolistUserReviewUI.do")
		public String tolistUserReviewUI(){
			return "userReviewManager/userReview";
		}
}
