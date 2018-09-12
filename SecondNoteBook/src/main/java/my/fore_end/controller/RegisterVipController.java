package my.fore_end.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.entity.MobilePhoneCode;
import my.common.entity.UserDetail;
import my.common.enums.PhoneCodeStatus;
import my.common.utils.DateTransformUtils;
import my.common.utils.DateUtils;
import my.common.utils.JsonResult;
import my.common.utils.RandomUtils;

import my.fore_end.service.RegisterVipService;

@Controller
@RequestMapping("/fore_end/")
public class RegisterVipController {
	
	@Resource
	private RegisterVipService service;
	/**
	 * 注册会员页面
	 * @return
	 */
	@RequestMapping("toRegistVip.do")
	@RequiresUser
	@RequiresRoles("user")
	public String toRegistVip(){
		return "fore_end/user/registVip";
	}
	/**
	 * 生产一个手机验证码
	 * method comments here
	 * @param phoneNumber
	 * @return
	 */
	@RequestMapping("toGetMobileCode.do")
	@ResponseBody
	public JsonResult toGetMobileCode(String phoneNumber){
		MobilePhoneCode code = new MobilePhoneCode();
		code.setPhoneNumber (phoneNumber);
		code.setPhoneCode (RandomUtils.getSixRandom ());
		code.setTitle ("注册vip会员验证码");
		code.setCreatedTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		//设置手机验证码状态为可用
		code.setStatus (PhoneCodeStatus.AVAILABLE.getCode ());
		//返回唯一验证号（uuid）
		String uuId = service.getMobilePhoneCode (code); 
		Map<String,String> maps = new HashMap<String, String> ();
		maps.put ("uuId", uuId);
		return new JsonResult (maps);
	}
	/**
	 * 校验手机号验证码
	 * method comments here
	 * @return
	 */
	@RequestMapping("toCheckPhoneCode.do")
	@ResponseBody
	public JsonResult toCheckPhoneCode(String uuId,String phoneNumber,String code){
		service.toCheckPhoneCode (phoneNumber, code,uuId);
		return new JsonResult ();
	}
	/**
	 * 提交注册会员信息
	 * @return
	 */
	@RequestMapping("toSubmitVipData.do")
	@RequiresUser
	@ResponseBody
	public JsonResult toSubmitVipData(UserDetail userDetail){
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		service.doRegistVip(userDetail, username);
		return new JsonResult();
	}
	
}
