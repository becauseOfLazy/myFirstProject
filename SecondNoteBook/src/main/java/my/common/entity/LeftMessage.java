package my.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 留言对象
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class LeftMessage implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 4581943290808121648L;
	//id
		private Integer id;
		//用户id
		private Integer uId;
		//留言内容
		private String suggestText;
		//创建时间
		private String createdTime;
		//读取时间
		private String updateTime;
		//留言状态
		private Integer status;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getuId() {
			return uId;
		}
		public void setuId(Integer uId) {
			this.uId = uId;
		}
		public String getSuggestText() {
			return suggestText;
		}
		public void setSuggestText(String suggestText) {
			this.suggestText = suggestText;
		}
		public String getCreatedTime() {
			return createdTime;
		}
		public void setCreatedTime(String createdTime) {
			this.createdTime = createdTime;
		}
		public String getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
	
		
}
