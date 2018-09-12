package my.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * web聊天室联系人消息实体
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class WebChatContactMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7783949665520868379L;
	//id
	private Integer id;
	//发送方id
	private Integer fromUserId;
	//接收方用户id
	private Integer toUserId;
	//关联id
	private String relatedId;
	//消息
	private String message;
	//创建时间
	private Timestamp createdTime;
	//消息状态
	private Integer status;
	//发送用户
	private User fromUser;
	//接收用户
	private User toUser;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(Integer fromUserId) {
		this.fromUserId = fromUserId;
	}
	public Integer getToUserId() {
		return toUserId;
	}
	public void setToUserId(Integer toUserId) {
		this.toUserId = toUserId;
	}
	public String getRelatedId() {
		return relatedId;
	}
	public void setRelatedId(String relatedId) {
		this.relatedId = relatedId;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public User getToUser() {
		return toUser;
	}
	public void setToUser(User toUser) {
		this.toUser = toUser;
	}
	@Override
	public String toString() {
		return "WebChatContactMessage [id=" + id + ", fromUserId=" + fromUserId + ", toUserId=" + toUserId + ", relatedId=" + relatedId
				+ ", message=" + message + ", createdTime=" + createdTime + ", status=" + status + ", fromUser=" + fromUser + ", toUser=" + toUser
				+ "]";
	}
	
}
