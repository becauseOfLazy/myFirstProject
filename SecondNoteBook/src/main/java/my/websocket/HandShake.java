package my.websocket;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import my.common.entity.User;

/**
 * Socket建立连接（握手）和断开
 * 
 * @author Goofy
 * @Date 2015年6月11日 下午2:23:09
 */
public class HandShake implements HandshakeInterceptor {
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
	
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpSession session = servletRequest.getServletRequest ().getSession (false);
			// 标记用户
			User user = (User) session.getAttribute ("user");
			System.out.println ("聊天用户："+user.getNickName ()+"连接成功!");
			if (user != null) {
				attributes.put ("user", user);
			}else {
				return false;
			}
		}
		return true;
	}

	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
	}
}