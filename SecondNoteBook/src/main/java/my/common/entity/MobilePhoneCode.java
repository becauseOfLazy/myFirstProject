package my.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 手机验证码实体对象
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class MobilePhoneCode implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -2637647881576642613L;
	//id
	private Integer id;
	//手机号码
		private String phoneNumber;
		//验证码
		private String phoneCode;
		//验证码详细
		private String title;
		//创建时间
		private String createdTime;
		//验证码状态
		private Integer status;
		//uuid
		private String uuId;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getPhoneCode() {
			return phoneCode;
		}
		public void setPhoneCode(String phoneCode) {
			this.phoneCode = phoneCode;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		public String getCreatedTime() {
			return createdTime;
		}
		public void setCreatedTime(String createdTime) {
			this.createdTime = createdTime;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getUuId() {
			return uuId;
		}
		public void setUuId(String uuId) {
			this.uuId = uuId;
		}
		
		
}
