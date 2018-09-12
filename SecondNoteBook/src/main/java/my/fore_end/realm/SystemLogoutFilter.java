package my.fore_end.realm;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.stereotype.Service;
import my.common.entity.User;
import my.common.enums.UserStatus;
import my.common.utils.DateTransformUtils;
import my.common.utils.DateUtils;
import my.fore_end.dao.UserDao;

@Service
public class SystemLogoutFilter extends LogoutFilter  {
	@Resource
	private UserDao udao;
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		 		//获取当前对象
        Subject subject=getSubject(request,response);  
        //获取跳转url
        String redirectUrl=getRedirectUrl(request,response,subject); 
        ServletContext context= request.getServletContext(); 
        try {  
        //注销用户成功后，改变用户状态
          User user = new User();
          String userName = (String) SecurityUtils.getSubject().getPrincipal();
          user.setUserName (userName);
          user.setOfflineTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
          user.setStatus (UserStatus.OFFLINE.getCode ());
          udao.updateUserOffLine (user);
            //下线
	          subject.logout();
            context.removeAttribute("error");  
        }catch (SessionException e){  
            e.printStackTrace();  
        }  
        issueRedirect(request,response,redirectUrl);  
        return false;  
	}
	
}
