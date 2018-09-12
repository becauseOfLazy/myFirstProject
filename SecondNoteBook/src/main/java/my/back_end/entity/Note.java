package my.back_end.entity;

import java.io.Serializable;

public class Note implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6131066923849850132L;
	private Integer id;
	private Integer parentId;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
