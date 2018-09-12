package my.back_end.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back_end/")
public class prodShelveReviewController {
	/**
	 * 前往商品审核页面
	 * method comments here
	 * @return
	 */
		@RequestMapping("tolistProdReviewUI.do")
		public String tolistProdReviewUI(){
			return "prodShelveReview/prodShelveReview";
		}
}
