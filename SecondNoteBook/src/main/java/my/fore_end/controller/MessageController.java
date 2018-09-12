package my.fore_end.controller;


import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.entity.LeftMessage;
import my.common.enums.MessageStatus;
import my.common.utils.DateTransformUtils;
import my.common.utils.DateUtils;
import my.common.utils.JsonResult;
import my.fore_end.service.MessageService;

/**
 * 留言
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
@Controller
@RequestMapping("/fore_end/")
public class MessageController {
	@Resource
	private MessageService service;
	/**
	 * 提交留言
	 * @param text
	 * @return
	 */
	@RequestMapping("toSubmitSuggest.do")
	@ResponseBody
	public JsonResult toSubmitSuggest(String text){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		LeftMessage message = new LeftMessage();
		message.setSuggestText (text);
		message.setUpdateTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		message.setStatus (MessageStatus.READ_NO.getCode ());
		service.doSaveSuggest(message,userName);
		return new JsonResult();
	}
	
	
}
