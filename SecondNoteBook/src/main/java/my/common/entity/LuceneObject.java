package my.common.entity;
/**
 * 检索对象
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class LuceneObject {
		//id
		private Integer id;
		//商品名
		private String prodName;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getProdName() {
			return prodName;
		}
		public void setProdName(String prodName) {
			this.prodName = prodName;
		}
		@Override
		public String toString() {
			return "LuceneObject [id=" + id + ", prodName=" + prodName + "]";
		}
	
}
