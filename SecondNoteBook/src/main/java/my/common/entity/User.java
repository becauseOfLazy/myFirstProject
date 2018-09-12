package my.common.entity;

import java.io.Serializable;

/**
 * 用户实体类
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2635731636120242288L;
	//id
	private Integer id;
	//用户名
	private String userName;
	//密码
	private String password;
	//昵称
	private String nickName;
	//邮箱
	private String email;
	//角色id
	private Integer roleId;
	//注册时间
	private String createdTime;
	//上线时间
	private String onlineTime;
	//离线时间
	private String offlineTime;
	//状态
	private Integer status;
	//修改时间
	private String updateTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getOnlineTime() {
		return onlineTime;
	}
	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}
	public String getOfflineTime() {
		return offlineTime;
	}
	public void setOfflineTime(String offlineTime) {
		this.offlineTime = offlineTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
