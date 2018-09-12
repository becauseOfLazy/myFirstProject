package my.common.enums;
/**
 * 用户状态枚举
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public enum UserStatus {
		ONLINE(1,"已上线"),
		OFFLINE(2,"已离线"),
		FREEZE(3,"已冻结");
	private Integer code;
  private String description;
  
	UserStatus(Integer code, String description) {
	    this.code = code;
	    this.description = description;
	 }
  /**
   * 根据枚举的code返回枚举对象
   * @param code  枚举code值
   * @return  枚举对象
   */
  public static UserStatus find(String code) {
      if (code == null)
          return null;
      for (UserStatus type : values()) {
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
