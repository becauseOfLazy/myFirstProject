package my.common.enums;
/**
 * 信息状态
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public enum MessageStatus {
	READ_YES(1,"已读"),
	READ_NO(2,"未读");
 
 private Integer code;
 private String description;
 
 MessageStatus(Integer code, String description) {
   this.code = code;
   this.description = description;
}
 /**
  * 根据枚举的code返回枚举对象
  * @param code  枚举code值
  * @return  枚举对象
  */
 public static MessageStatus find(String code) {
     if (code == null)
         return null;
     for (MessageStatus type : values()) {
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
