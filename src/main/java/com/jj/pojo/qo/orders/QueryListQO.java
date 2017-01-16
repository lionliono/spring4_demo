package com.jj.pojo.qo.orders;

import com.jj.pojo.qo.BaseQO;

@SuppressWarnings("serial")
public class QueryListQO extends BaseQO{

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
