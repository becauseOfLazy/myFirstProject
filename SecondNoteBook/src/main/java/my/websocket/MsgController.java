package my.websocket;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/msg")
public class MsgController {
	@Resource
	MyWebSocketHandler handler;

}