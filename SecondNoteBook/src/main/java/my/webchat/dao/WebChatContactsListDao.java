package my.webchat.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import my.common.entity.Page;
import my.common.entity.WebChatContract;


/**
 * 联系人
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public interface WebChatContactsListDao {
	/**
	 * 获取用户id关联的用户数
	 * method comments here
	 * @param uId
	 * @return
	 */
	public Integer getContractsNumByuId(@Param("uId")Integer uId);
	/**
	 * 获取自己所有的联系人
	 * method comments here
	 * @param userName
	 * @return
	 */
	public List<WebChatContract> doGetAllContactWithMe(@Param("uId")Integer uId,@Param("page")Page page);
	/**
	 * 通过用户名昵称查找联系人
	 * method comments here
	 * @param searchName
	 * @return
	 */
	 public	List<WebChatContract> doSearchContactBysearchName(@Param("name")String searchName);
	 /**
	  * 添加其他联系人
	  * method comments here
	  * @param user
	  * @return
	  */
	 public int doAddOtherContact(@Param("entity")WebChatContract user);
	 /**
	  * 获取需要检验的联系人
	  * method comments here
	  * @param uId
	  * @return
	  */
	 public List<WebChatContract> doGetCheckedContact(@Param("uId")Integer uId);
}
