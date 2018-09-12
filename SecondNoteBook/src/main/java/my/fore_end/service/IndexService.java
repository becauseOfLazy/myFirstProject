package my.fore_end.service;

import java.util.List;
import java.util.Map;


public interface IndexService {
	/**
	 * 获取所有主页图片资源
	 * @return
	 */
	List<Map<String,String>> doGetAllImgs();
	
}
