package my.common.enums;
/**
 * 群验证方式
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public enum GroupCheckType {
	NO_NEED_VERIFY(1,"不需要验证"),
	NEED_VERIFY(2,"需要验证"),
	FORBID_ANYONE(3,"禁止任何人");
 
	 private Integer code;
	 private String description;
 
	 GroupCheckType(Integer code, String description) {
		   this.code = code;
		   this.description = description;
		}
		 /**
		  * 根据枚举的code返回枚举对象
		  * @param code  枚举code值
		  * @return  枚举对象
		  */
		 public static GroupCheckType find(String code) {
		     if (code == null)
		         return null;
		     for (GroupCheckType type : values()) {
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
