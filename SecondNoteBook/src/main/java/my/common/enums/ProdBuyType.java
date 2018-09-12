package my.common.enums;
/**
 * 商品购买方式
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public enum ProdBuyType {
	BUY_ONLINE(1,"在线交易"),
	BUY_OFFLINE(2,"线下交易"),
	BUY_EXCHANGE(3,"物品交换");
 
 private Integer code;
 private String description;
 
 ProdBuyType(Integer code, String description) {
   this.code = code;
   this.description = description;
}
 /**
  * 根据枚举的code返回枚举对象
  * @param code  枚举code值
  * @return  枚举对象
  */
 public static ProdBuyType find(String code) {
     if (code == null)
         return null;
     for (ProdBuyType type : values()) {
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
