package com.jj.pojo.qo.front;

import java.io.Serializable;
@SuppressWarnings("serial")
public class BaseFrontQO implements Serializable{
	private Integer id;

	private String userId;

	private Integer doubi;

	private String nickName;

	// 分页条件
	private Integer pageNo = 1;

	private Integer pageSize = 10;

	//开始位置
	private Integer start;

	/**
	 * 服务器ID
	 */
	private Integer serverId;

	public Integer getStart(Integer pageNo, Integer pageSize){
		return (pageNo-1)*pageSize;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getDoubi() {
		return doubi;
	}

	public void setDoubi(Integer doubi) {
		this.doubi = doubi;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getServerId() {
		return serverId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
}
