package my.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 需求单实体对象
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class Demand implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1055270678844940851L;
		//id
		private Integer id;
		//商品名称
		private String prodName;
		//商品类型
		private String prodType;
		//最低价格
		private double minPrice;
		//最高价格
		private double maxPrice;
		//购买方式
		private Integer buyType;
		//联系方式
		private String phoneNumber;
		//用户id
		private Integer uId;
		//发布时间
		private String beginTime;
		//发布结束时间
		private String endTime;
		//简介
		private String note;
		//需求单状态
		private Integer status;
		//修改时间
		private String updateTime;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getProdName() {
			return prodName;
		}
		public void setProdName(String prodName) {
			this.prodName = prodName;
		}
		public String getProdType() {
			return prodType;
		}
		public void setProdType(String prodType) {
			this.prodType = prodType;
		}
		public double getMinPrice() {
			return minPrice;
		}
		public void setMinPrice(double minPrice) {
			this.minPrice = minPrice;
		}
		public double getMaxPrice() {
			return maxPrice;
		}
		public void setMaxPrice(double maxPrice) {
			this.maxPrice = maxPrice;
		}
		public Integer getBuyType() {
			return buyType;
		}
		public void setBuyType(Integer buyType) {
			this.buyType = buyType;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public Integer getuId() {
			return uId;
		}
		public void setuId(Integer uId) {
			this.uId = uId;
		}
		public String getBeginTime() {
			return beginTime;
		}
		public void setBeginTime(String beginTime) {
			this.beginTime = beginTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
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
		public String getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		}
		
		
}
