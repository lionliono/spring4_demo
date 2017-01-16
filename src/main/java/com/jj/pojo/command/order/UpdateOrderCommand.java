package com.jj.pojo.command.order;

import com.jj.pojo.command.BaseCommand;

@SuppressWarnings("serial")
public class UpdateOrderCommand extends BaseCommand {
	/**
	 * 快递单号
	 */
	private String expressNum;

	/**
	 * 省代码
	 */
	private String provinceCode;

	/**
	 * 市代码
	 */
	private String cityCode;

	/**
	 * 区代码
	 */
	private String districtCode;

	/**
	 * 详细地址
	 */
	private String detail;

	/**
	 * 收货人名字
	 */
	private String name;

	/**
	 * 收货人电话
	 */
	private String phoneNum;

	public String getExpressNum() {
		return expressNum;
	}

	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
