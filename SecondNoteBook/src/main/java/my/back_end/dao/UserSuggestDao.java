package my.back_end.dao;

import java.sql.Timestamp;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import my.common.entity.LeftMessage;
import my.common.entity.Page;

public interface UserSuggestDao {
	/**
	 * 分页查询留言对象
	 * @return
	 */
	List<LeftMessage> doGetAllUserSuggest(@Param("entity")Page page);
	/**
	 * 获取留言总数
	 * @return
	 */
	int getAllSuggestCount();
	
	/**
	 * 更新留言状态״̬
	 */
	int doUpdateSuggestState(@Param("entity")LeftMessage message);
	/**
	 * 通过id获取留言对象
	 * @param id
	 * @return
	 */
	LeftMessage doGetSuggestInfoById(@Param("id")Integer id);
	/**
	 * 查询留言根据状态
	 * method comments here
	 * @param state
	 * @return
	 */
	List<LeftMessage> doSearchSuggestByState(@Param("status")Integer status,
			@Param("lastTime")Timestamp lastTime);
}
