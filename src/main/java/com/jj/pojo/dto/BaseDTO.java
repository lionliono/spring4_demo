package com.jj.pojo.dto;

import java.io.Serializable;

/**
 *
 * @类功能说明：baseDTO
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：竞技世界
 * @部门：技术部
 * @作者：yuqz
 * @创建时间：2016年3月29日上午10:52:00
 * @版本：V1.0
 *
 */
@SuppressWarnings("serial")
public class BaseDTO implements Serializable {

	private String id;

	private String statusCode;

	private String message;

	// 分页条件
	private Integer pageNo;

	private Integer pageSize;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
}
