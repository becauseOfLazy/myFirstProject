package my.websocket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import my.common.entity.User;
import my.common.entity.WebChatContactMessage;
import my.common.utils.DateUtils;

/**
 * Socket处理器
 * 
 * @author Goofy
 * @Date 2015年6月11日 下午1:19:50
 */
@Component
public class MyWebSocketHandler implements WebSocketHandler {
	public static final Map<Integer, WebSocketSession> userSocketSessionMap;
	static {
		userSocketSessionMap = new HashMap<Integer, WebSocketSession> ();
	}

	/**
	 * 建立连接后
	 */
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		User user = (User) session.getHandshakeAttributes ().get ("user");
		userSocketSessionMap.put (user.getId (), session);
		
		System.out.println (user.getNickName ()+"建立连接成功!!!!!");
	}

	/**
	 * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
	 */
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		User user = (User)session.getHandshakeAttributes ().get ("user");
		System.out.println (user.toString ());
		WebChatContactMessage msg = new Gson ().fromJson (message.getPayload ().toString (), WebChatContactMessage.class);
		msg.setCreatedTime (DateUtils.getCurrentTime ());
		msg.setFromUser (user);
		sendMessageToUser (msg.getToUserId (), new TextMessage (new GsonBuilder ().setDateFormat ("yyyy-MM-dd HH:mm:ss").create ().toJson (msg)));
	}

	/**
	 * 消息传输错误处理
	 */
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		if (session.isOpen ()) {
			session.close ();
		}
		Iterator<Entry<Integer, WebSocketSession>> it = userSocketSessionMap.entrySet ().iterator ();
		// 移除Socket会话
		while (it.hasNext ()) {
			Entry<Integer, WebSocketSession> entry = it.next ();
			if (entry.getValue ().getId ().equals (session.getId ())) {
				userSocketSessionMap.remove (entry.getKey ());
				System.out.println ("Socket会话已经移除:用户ID" + entry.getKey ());
				break;
			}
		}
	}

	/**
	 * 关闭连接后
	 */
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.out.println ("Websocket:" + session.getId () + "已经关闭");
		Iterator<Entry<Integer, WebSocketSession>> it = userSocketSessionMap.entrySet ().iterator ();
		// 移除Socket会话
		while (it.hasNext ()) {
			Entry<Integer, WebSocketSession> entry = it.next ();
			if (entry.getValue ().getId ().equals (session.getId ())) {
				userSocketSessionMap.remove (entry.getKey ());
				System.out.println ("Socket会话已经移除:用户ID" + entry.getKey ());
				break;
			}
		}
	}

	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 给所有在线用户发送消息
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void broadcast(final TextMessage message) throws IOException {
		Iterator<Entry<Integer, WebSocketSession>> it = userSocketSessionMap.entrySet ().iterator ();
		// 多线程群发
		while (it.hasNext ()) {
			final Entry<Integer, WebSocketSession> entry = it.next ();
			if (entry.getValue ().isOpen ()) {
				// entry.getValue().sendMessage(message);
				new Thread (new Runnable () {
					public void run() {
						try {
							if (entry.getValue ().isOpen ()) {
								entry.getValue ().sendMessage (message);
							}
						}
						catch (IOException e) {
							e.printStackTrace ();
						}
					}
				}).start ();
			}
		}
	}

	/**
	 * 给某个用户发送消息
	 * 
	 * @param userName
	 * @param message
	 * @throws IOException
	 */
	public void sendMessageToUser(Integer toUserId, TextMessage message) throws IOException {
		WebSocketSession session = userSocketSessionMap.get (toUserId);
		if (session != null && session.isOpen ()) {
			session.sendMessage (message);
		}
	}
}