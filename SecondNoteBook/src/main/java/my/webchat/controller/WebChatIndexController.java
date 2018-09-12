package my.webchat.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import my.webchat.service.WebChatIndexService;

@Controller
@RequestMapping("/web_chat/")
public class WebChatIndexController {
	@Resource
	private WebChatIndexService service;
	/**
	 * 前往web在线聊天系统
	 * method comments here
	 * @return
	 */
	@RequestMapping("toWebChatPages.do")
	@RequiresUser
	public String toWebChatPage(HttpServletRequest request){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		request.getSession ().setAttribute ("user", service.getUserByUserName (userName));
		return "web_chat/main";
	}
	/**
	 * 建立消息发送页面
	 * method comments here
	 * @return
	 */
	@RequestMapping("toloadSendPage.do")
	@RequiresUser
	public String toloadSendPage(){
		return "web_chat/send/sendMessage_user";
	}
}
