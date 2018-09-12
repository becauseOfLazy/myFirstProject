package my.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 群消息实体对象
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class WebChatGroupMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7513535961802654527L;
	//id
	private Integer id;
	//群号
	private String groupId;
	//发送者id
	private Integer fromId;
	//消息内容
	private String message;
	//发送时间
	private Timestamp createdTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public Integer getFromId() {
		return fromId;
	}
	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	
}
