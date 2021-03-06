package my.common.enums;
/**
 * 时间枚举
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public enum TimeStatus {
	TODAY(1,"今天"),
	YESTERDAY(2,"昨天"),
	WEEKDAY(3,"最近一周"),
	MONTH(4,"最近一月");
 
	 private Integer code;
	 private String description;
 
	 TimeStatus(Integer code, String description) {
	   this.code = code;
	   this.description = description;
	}
	 /**
	  * 根据枚举的code返回枚举对象
	  * @param code  枚举code值
	  * @return  枚举对象
	  */
	 public static TimeStatus find(Integer code) {
	     if (code == null)
	         return null;
	     for (TimeStatus type : values()) {
	         if (type.getCode().equals(code))
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
