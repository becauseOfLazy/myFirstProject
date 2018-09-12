package my.webchat.controller;

import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.utils.JsonResult;
import my.webchat.service.WebChatContactsListService;

@Controller
@RequestMapping("/web_chat/")
public class WebChatContactsListController {
	@Resource
	private WebChatContactsListService service;
	/**
	 * 获取联系人列表
	 * method comments here
	 * @return
	 */
		@RequestMapping("toGetContactsListObjects.do")
		@ResponseBody
		public JsonResult toGetContactsListPage(Integer pageCurrent){
			String userName = (String) SecurityUtils.getSubject().getPrincipal();
			return new JsonResult (service.doGetAllContactWithMe (userName,pageCurrent));
		}
		/**
		 * 查询联系人对象
		 * method comments here
		 * @return
		 */
		@RequestMapping("doSearchContractsObjects.do")
		@ResponseBody
		public JsonResult doSearchContractsObjects(String searchName){
			return new JsonResult (service.doSearchContactBysearchName (searchName));
		}
		/**
		 * 添加联系人
		 * method comments here
		 * @return
		 */
		@RequestMapping("toAddContactsObject.do")
		@ResponseBody
		public JsonResult toAddContactsObject(Integer contactId){
			String userName = (String) SecurityUtils.getSubject().getPrincipal();
			service.toAddContactObject (contactId, userName);
			return new JsonResult ();
		}
		
}














