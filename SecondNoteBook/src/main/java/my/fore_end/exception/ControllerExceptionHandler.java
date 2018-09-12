package my.fore_end.exception;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import my.common.utils.JsonResult;


/**全局异常处理对象:
 * 希望通过此类实现所有Controller中的异常处理
 * @ControllerAdvice 声明的类可以作为统一异常处理对象
 */
@ControllerAdvice
public class ControllerExceptionHandler {
	/**
	 * service层异常
	 * @param e
	 * @return
	 */
	  @ExceptionHandler(ServiceException.class)
	  @ResponseBody
	  public JsonResult handleServiceException(
			  ServiceException e){
		     e.printStackTrace();
		     return new JsonResult(e);//state=0,message=e.getMessage();
	  }
	  /**
	   * 认证异常
	   */
	  @ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
	  @ResponseBody
	  public JsonResult handleShiroAuthcException(){
		  JsonResult jResult = new JsonResult();
		  jResult.setState(0);
		  jResult.setMessage("请先登录");
		  return jResult;
	  }
	  /**
	   * 权限异常
	   */
	  @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
	  @ResponseBody
	  public JsonResult handleShiroAuthzException(){
		  JsonResult jResult = new JsonResult();
		  jResult.setState(0);
		  jResult.setMessage("暂无权限");
		  return jResult;
	  }
	 /*@ExceptionHandler(Exception.class)
	  public ModelAndView handleException(
			  ServiceException e){
		     e.printStackTrace();
		     ModelAndView mv=new ModelAndView();
		     mv.setViewName("error");
		     mv.addObject("message", e.getMessage());
		     return mv;
	  }*/
}
