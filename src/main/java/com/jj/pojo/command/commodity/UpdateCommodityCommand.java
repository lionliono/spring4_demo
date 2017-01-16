package com.jj.pojo.command.commodity;

import com.jj.pojo.command.BaseCommand;

@SuppressWarnings("serial")
public class UpdateCommodityCommand extends BaseCommand {
	/**
	 * 标题
	 */
    private String title;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 商品分类
     */
    private Integer classifyId;

    /**
     * 销售量
     */
    private Integer saleCount;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 说明内容
     */
    private String content;

    /**
     * 商品状态（0：下架，1：上架）
     */
    private Integer status;

	/**
	 * 商品编号
	 */
	private String cNumber;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getcNumber() {
		return cNumber;
	}

	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}
}
