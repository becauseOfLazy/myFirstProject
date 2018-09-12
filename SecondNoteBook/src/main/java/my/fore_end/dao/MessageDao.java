package my.fore_end.dao;

import org.apache.ibatis.annotations.Param;
import my.common.entity.LeftMessage;

public interface MessageDao {
	/**
	 * 保存用户建议
	 * @param userName
	 */
	int doSaveSuggest(@Param("entity")LeftMessage message);
}
