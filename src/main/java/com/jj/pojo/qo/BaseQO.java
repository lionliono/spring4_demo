package com.jj.pojo.qo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class BaseQO implements Serializable{
	/**
	 * 实体ID
	 */
	private String id;
	/**
	 * 实体ID集合
	 */
	private List<String> ids;
	// ------------------不包含的属性条件------------------
	/**
	 * 不包含的ID集合
	 */
	private String[] idNotIn;

	// ------------------状态类条件------------------

	// 分页条件
	private Integer pageNo = 1;

	private Integer pageSize = 10;

	//开始位置
	private Integer start;

	public Integer getStart(Integer pageNo, Integer pageSize){
		return (pageNo-1)*pageSize;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public String[] getIdNotIn() {
		return idNotIn;
	}

	public void setIdNotIn(String[] idNotIn) {
		this.idNotIn = idNotIn;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

}
