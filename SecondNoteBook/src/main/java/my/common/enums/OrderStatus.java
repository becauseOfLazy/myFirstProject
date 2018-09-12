package my.common.enums;
/**
 * 订单状态
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public enum OrderStatus {
	PAID_YES(1,"已付款"),
	PAID_NO(2,"未付款"),
	PAID_CANCEL(3,"已失效"),
	PAID_NO_SET(4,"未设置"),
	RECEIVED_NO(5,"待签收"),
	RECEIVED_YES(6,"已签收");
 
 private Integer code;
 private String description;
 
 OrderStatus(Integer code, String description) {
   this.code = code;
   this.description = description;
}
 /**
  * 根据枚举的code返回枚举对象
  * @param code  枚举code值
  * @return  枚举对象
  */
 public static OrderStatus find(String code) {
     if (code == null)
         return null;
     for (OrderStatus type : values()) {
         if (type.getCode().equals(code.trim()))
             return type;
     }
     return null;
 }

public Integer getCode() {
	return code;
}
public void setCode(Integer code) {
	this.code = code;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
 
}
