package my.fore_end.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.entity.User;
import my.common.enums.UserRole;
import my.common.enums.UserStatus;
import my.common.utils.DateTransformUtils;
import my.common.utils.DateUtils;
import my.common.utils.JsonResult;
import my.fore_end.service.UserService;

@Controller
@RequestMapping("/fore_end/")
public class UserController {
	@Resource
	private UserService userService;
	
	/**
	 * 跳转注册页面
	 * @return
	 */
	@RequestMapping("toRegiste.do")
	public String toRegistePage(){
		return "fore_end/user/registe";
	}
	/**
	 * 跳转登录界面
	 * @return
	 */
	@RequestMapping("toLogin.do")
	public String toLoginPage(){
		return "fore_end/user/login";
	}
	/**
	 * 登录
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping("login.do")
	@ResponseBody
	public JsonResult getLogin(HttpServletRequest httpServletRequest){
		String userName = httpServletRequest.getParameter("userName");
		String password = httpServletRequest.getParameter("password");	
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		subject.login(token);
		Session session = subject.getSession();
		session.setAttribute("nickName",userService.getNickNameByUserName(userName));
		//修改用户上线状态
		User user = new User();
		user.setUserName (userName);
		user.setStatus (UserStatus.ONLINE.getCode ());
		user.setOnlineTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		userService.updateUserOnLine (user);
		return new JsonResult();
	}
	/**
	 * 注册
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping("registe.do")
	@ResponseBody
	public JsonResult getRegiste(HttpServletRequest httpServletRequest){
		String userName = httpServletRequest.getParameter("userName");
		String password = httpServletRequest.getParameter("password");
		String nickName = httpServletRequest.getParameter("nickName");
		String email = httpServletRequest.getParameter("email");
		User user = new User();
		//设置用户名
		user.setUserName(userName);
		//设置密码
		user.setPassword(password);
		//设置昵称
		user.setNickName(nickName);
		//设置邮箱
		user.setEmail (email);
		//设置用户注册时间
		user.setCreatedTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		//设置用户角色id
		user.setRoleId (UserRole.USER.getCode ());
		//设置用户状态
		user.setStatus (UserStatus.OFFLINE.getCode ());
		//修改时间
		user.setUpdateTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		//保存用户信息
		userService.saveUser(user);
		return new JsonResult();
	}
	
}
