package my.common.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 群关联实体对象
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class WebChatGroup implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 3986587815093593190L;
	//id
		private Integer id;
		//群号
		private String groupId;
		//群成员id
		private Integer uId;
		//群角色id
		private Integer groupRoleId;
		//进群时间
		private Date createdTime;
		//是否验证通过
		private Integer isVerified;
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
		public Integer getuId() {
			return uId;
		}
		public void setuId(Integer uId) {
			this.uId = uId;
		}
		public Integer getGroupRoleId() {
			return groupRoleId;
		}
		public void setGroupRoleId(Integer groupRoleId) {
			this.groupRoleId = groupRoleId;
		}
		public Date getCreatedTime() {
			return createdTime;
		}
		public void setCreatedTime(Date createdTime) {
			this.createdTime = createdTime;
		}
		public Integer getIsVerified() {
			return isVerified;
		}
		public void setIsVerified(Integer isVerified) {
			this.isVerified = isVerified;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
}
