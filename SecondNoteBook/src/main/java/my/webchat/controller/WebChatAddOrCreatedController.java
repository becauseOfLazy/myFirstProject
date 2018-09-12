package my.webchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web_chat/")
public class WebChatAddOrCreatedController {
		/**
		 * 跳转添加页面
		 * method comments here
		 * @return
		 */
		@RequestMapping("toAddOrCreatedContactPage.do")
		public String toAddOrCreatedContactPage(){
			return "web_chat/addMain";
		}
		/**
		 * 跳转添加联系人/群页面
		 * method comments here
		 * @return
		 */
		@RequestMapping("toLoadAddContractsOrGroupPage.do")
		public String toLoadAddContractsOrGroupPage(){
			return "web_chat/addContactsOrGroup";
		}
		/**
		 * 跳转创建联系群的界面
		 * method comments here
		 * @return
		 */
		@RequestMapping("toLoadCreatedGroupPage.do")
		public String toLoadCreatedGroupPage(){
			return "web_chat/createdGroup";
		}
		/**
		 * 加载验证页面
		 * method comments here
		 * @return
		 */
		@RequestMapping("toLoadContactGroupPage.do")
		public String toLoadContactGroupPage(){
			return "web_chat/checkContactOrGroup";
		}
}
