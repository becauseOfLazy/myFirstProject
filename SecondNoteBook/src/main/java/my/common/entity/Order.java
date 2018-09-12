package my.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 订单实体类
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6886904727064404061L;
	//id
	private Integer id;
	//订单id
	private String orderId;
	//用户id
	private Integer	uId;
	//商品ids
	private String prodIds;
	//创建时间
	private String createdTime;
	//订单有效时间
	private String cancelTime;
	//收货地址
	private String address;
	//购买方式
	private Integer buyType;
	//订单状态
	private Integer status;
	//修改时间
	private String updateTime;
	//备注
	private String note;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getProdIds() {
		return prodIds;
	}
	public void setProdIds(String prodIds) {
		this.prodIds = prodIds;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getBuyType() {
		return buyType;
	}
	public void setBuyType(Integer buyType) {
		this.buyType = buyType;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
