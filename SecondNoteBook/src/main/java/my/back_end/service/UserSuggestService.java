package my.back_end.service;

import java.util.List;
import java.util.Map;
import my.common.entity.LeftMessage;

public interface UserSuggestService {
	/**
	 * 获取所有的用户留言
	 * @return
	 */
	Map<String,Object> doGetAllUserSuggest(Integer pageCurrent);
	/**
	 * 获取留言详情״̬
	 */
	LeftMessage doGetAllSuggestInfo(Integer id);
	/**
	 * 根据状态查询留言״̬
	 * @param state
	 * @return
	 */
	List<LeftMessage> doSearchSuggestByState(Integer state,Integer times);
}
