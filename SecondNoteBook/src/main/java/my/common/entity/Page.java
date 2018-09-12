package my.common.entity;

import java.io.Serializable;

/**
 * 分页对象
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class Page implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8865951071354361840L;
		//一页页显示数据量
		private Integer pageSize;
		//当前页数
		private Integer pageCurrent;
		//开始点
		private Integer start;
		//总页数
		private Integer pageCount;
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
		public Integer getPageCurrent() {
			return pageCurrent;
		}
		public void setPageCurrent(Integer pageCurrent) {
			this.pageCurrent = pageCurrent;
		}
		public Integer getStart() {
			return start;
		}
		public void setStart(Integer start) {
			this.start = start;
		}
		public Integer getPageCount() {
			return pageCount;
		}
		public void setPageCount(Integer pageCount) {
			this.pageCount = pageCount;
		}
		
}
