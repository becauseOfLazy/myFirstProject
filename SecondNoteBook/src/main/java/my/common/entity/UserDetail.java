package my.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 用户详情信息实体
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class UserDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6179089218457178523L;
	//id
	private Integer id;
	//用户id
	private Integer uId;
	//姓名
	private String name;
	//年龄
	private String age;
	//性别
	private String sex;
	//身份证
	private String idCard;
	//头像图片
	private String avatar_img;
	//学历
	private String education;
	//手机号
	private String phoneNumber;
	//个人简介
	private String note;
	//创建时间
	private String createdTime;
	//修改时间
	private String updateTime;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getAvatar_img() {
		return avatar_img;
	}
	public void setAvatar_img(String avatar_img) {
		this.avatar_img = avatar_img;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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

	
}
