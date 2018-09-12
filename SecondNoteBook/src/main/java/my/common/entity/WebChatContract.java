package my.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
/**
 * 聊天室联系人实体
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class WebChatContract implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1682953304292099366L;
	//id
		private Integer id;
		//关联用户一id
		private Integer currentUserId;
		//关联用户二id
		private Integer relatedUserId;
		//关联id
		private String relatedId;
		//创建时间
		private Timestamp createdTime;
		//状态
		private Integer status;
		//当前用户
		private User currentUser;
		//关联用户
		private User relatedUser;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getCurrentUserId() {
			return currentUserId;
		}
		public void setCurrentUserId(Integer currentUserId) {
			this.currentUserId = currentUserId;
		}
		public Integer getRelatedUserId() {
			return relatedUserId;
		}
		public void setRelatedUserId(Integer relatedUserId) {
			this.relatedUserId = relatedUserId;
		}
		public String getRelatedId() {
			return relatedId;
		}
		public void setRelatedId(String relatedId) {
			this.relatedId = relatedId;
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
		public User getCurrentUser() {
			return currentUser;
		}
		public void setCurrentUser(User currentUser) {
			this.currentUser = currentUser;
		}
		public User getRelatedUser() {
			return relatedUser;
		}
		public void setRelatedUser(User relatedUser) {
			this.relatedUser = relatedUser;
		}
		
}
