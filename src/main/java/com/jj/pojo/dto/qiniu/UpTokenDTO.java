package com.jj.pojo.dto.qiniu;

import com.jj.pojo.dto.BaseDTO;

@SuppressWarnings("serial")
public class UpTokenDTO extends BaseDTO{

	private String uptoken;

	public String getUptoken() {
		return uptoken;
	}

	public void setUptoken(String uptoken) {
		this.uptoken = uptoken;
	}

}
