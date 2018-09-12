package my.common.enums;
/**
 * 用户角色枚举
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public enum UserRole {
		SUPER(1,"超级管理员"),
		VIP(2,"普通会员"),
		USER(3,"普通用户");
	 
	 private Integer code;
   private String description;
   
   UserRole(Integer code, String description) {
     this.code = code;
     this.description = description;
  }
   /**
    * 根据枚举的code返回枚举对象
    * @param code  枚举code值
    * @return  枚举对象
    */
   public static UserRole find(String code) {
       if (code == null)
           return null;
       for (UserRole type : values()) {
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
