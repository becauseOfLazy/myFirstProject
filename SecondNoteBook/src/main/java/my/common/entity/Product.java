package my.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 商品详细实体表
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -455189573899748459L;
	//商品Id
	private Integer id;
	//用户Id
	private Integer uId;
	//用户名
	private String prodName;
	//标题
	private String title;
	//商品价格
	private double prodPrice;
	//电话号码
	private String phoneNumber;
	//联系人
	private String contactName;
	//城市
	private String city;
	//保修状态
	private Integer warrantyStatus;
	//关注度
	private Integer attenNum;
	//开始时间
	private String beginDate;
	//结束时间
	private String endDate;
	//商品状态
	private Integer status;
	//备注
	private String note;
	//交易类型
	private Integer buyType;
	//修改时间
	private String updateTime;
	//图片地址ַ
	private String imgUrl;
	
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
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getWarrantyStatus() {
		return warrantyStatus;
	}
	public void setWarrantyStatus(Integer warrantyStatus) {
		this.warrantyStatus = warrantyStatus;
	}
	public Integer getAttenNum() {
		return attenNum;
	}
	public void setAttenNum(Integer attenNum) {
		this.attenNum = attenNum;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getBuyType() {
		return buyType;
	}
	public void setBuyType(Integer buyType) {
		this.buyType = buyType;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
