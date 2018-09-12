package my.webchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.utils.JsonResult;

@Controller
@RequestMapping("/web_chat/")
public class WebChatCheckedController {
	/**
	 * 加载需要验证的对象
	 * method comments here
	 * @return
	 */
		@RequestMapping("toLoadCheckedListObject.do")
		@ResponseBody
		public JsonResult toLoadCheckedListObject(){
			return new JsonResult ();
		}
}
