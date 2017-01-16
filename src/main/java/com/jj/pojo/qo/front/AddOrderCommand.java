package com.jj.pojo.qo.front;

@SuppressWarnings("serial")
public class AddOrderCommand extends BaseFrontQO {
	private String userId;

	/**
     * 标题
     */
    private String title;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 商品id
     */
    private Integer commodityId;

    /**
     * 详细地址
     */
    private String detail;

    /**
     * 收货人姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phoneNum;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 兑换类型
	 * 默认为斗币兑换
	 * 1：卡券兑换

	 */
	private String type;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
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
}
