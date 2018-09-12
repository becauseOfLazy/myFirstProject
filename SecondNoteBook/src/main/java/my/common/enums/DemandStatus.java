package my.common.enums;
/**
 * 需求单状态
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public enum DemandStatus {
	RELEASE_YES(1,"已发布"),
	RELEASE_PAUSE(2,"暂停发布"),
	RELEASE_NO(3,"未发布");
 
 private Integer code;
 private String description;
 
 DemandStatus(Integer code, String description) {
   this.code = code;
   this.description = description;
}
 /**
  * 根据枚举的code返回枚举对象
  * @param code  枚举code值
  * @return  枚举对象
  */
 public static DemandStatus find(String code) {
     if (code == null)
         return null;
     for (DemandStatus type : values()) {
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
