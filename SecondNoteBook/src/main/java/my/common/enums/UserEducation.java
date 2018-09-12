package my.common.enums;
/**
 * 用户教育等级
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public enum UserEducation {
	PRIMARY(1,"小学"),
	SECONDARY(2,"中学"),
	HIGH(3,"高中"),
	UNIVERSITY(4,"大学"),
	POSTGRADUATE(5,"研究生"),
	PhD(6,"研究生");
 
 private Integer code;
 private String description;
 
 UserEducation(Integer code, String description) {
   this.code = code;
   this.description = description;
}
 /**
  * 根据枚举的code返回枚举对象
  * @param code  枚举code值
  * @return  枚举对象
  */
 public static UserEducation find(String code) {
     if (code == null)
         return null;
     for (UserEducation type : values()) {
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
