package my.common.enums;
/**
 * 商品状态
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public enum ProdStatus {
	WAIT_PUBLISH(1,"等待上架"),
	PUBLISHED(2,"已上架"),
	PAUSE(3,"暂停上架"),
	DROP_OFF(4,"已下架");
 
	 private Integer code;
	 private String description;
 
	 ProdStatus(Integer code, String description) {
	   this.code = code;
	   this.description = description;
	}
	 /**
	  * 根据枚举的code返回枚举对象
	  * @param code  枚举code值
	  * @return  枚举对象
	  */
	 public static ProdStatus find(String code) {
	     if (code == null)
	         return null;
	     for (ProdStatus type : values()) {
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
