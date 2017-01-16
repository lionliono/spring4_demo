package com.jj.pojo.command.commodity;

import com.jj.pojo.command.BaseCommand;

@SuppressWarnings("serial")
public class ChangeCommodityStatusCommand extends BaseCommand{
	/**
	 * 商品状态（0：下架，1：上架）
	 */
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
