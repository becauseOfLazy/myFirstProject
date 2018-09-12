package my.common.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 群详情实体对象
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class WebChatGroupInfo implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = -4815481735972987945L;
		//id
		private Integer id;
		//群号
		private String groupId;
		//群名称
		private String groupName;
		//群主id
		private Integer groupOwnerId;
		//最大人数
		private Integer maxNumber;
		//群地点
		private String groupLocal;
		//创建时间
		private Date createdTime;
		//验证方式
		private Integer verifyType;
		//群简介
		private String note;
		//状态
		private Integer status;
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
		public String getGroupName() {
			return groupName;
		}
		public void setGroupName(String groupName) {
			this.groupName = groupName;
		}
		public Integer getGroupOwnerId() {
			return groupOwnerId;
		}
		public void setGroupOwnerId(Integer groupOwnerId) {
			this.groupOwnerId = groupOwnerId;
		}
		public Integer getMaxNumber() {
			return maxNumber;
		}
		public void setMaxNumber(Integer maxNumber) {
			this.maxNumber = maxNumber;
		}
		public String getGroupLocal() {
			return groupLocal;
		}
		public void setGroupLocal(String groupLocal) {
			this.groupLocal = groupLocal;
		}
		public Date getCreatedTime() {
			return createdTime;
		}
		public void setCreatedTime(Date createdTime) {
			this.createdTime = createdTime;
		}
		public Integer getVerifyType() {
			return verifyType;
		}
		public void setVerifyType(Integer verifyType) {
			this.verifyType = verifyType;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		
}
