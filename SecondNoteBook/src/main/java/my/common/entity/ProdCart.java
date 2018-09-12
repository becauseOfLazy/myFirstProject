package my.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 商品购物车
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class ProdCart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5259462639178781433L;
	//id
	private Integer id;
	//商品id
	private Integer prodId;
	//用户id
	private Integer uId;
	//创建时间
	private String createdTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

}
