package com.sally.shop.dto;

import java.sql.Date;

public class GoodsDto {
	private int gdsNum;
	private String gdsName;
	private String cateCode; //상품 분류번호
	private int gdsPrice;
	private int gdsStock;  //상품 수량
	private String gdsDes;	//상품 설명
	private String gdsImg;
	private Date gdsDate;
	
	public GoodsDto() {}

	public GoodsDto(int gdsNum, String gdsName, String cateCode, int gdsPrice, int gdsStock, String gdsDes,
			String gdsImg, Date gdsDate) {
		super();
		this.gdsNum = gdsNum;
		this.gdsName = gdsName;
		this.cateCode = cateCode;
		this.gdsPrice = gdsPrice;
		this.gdsStock = gdsStock;
		this.gdsDes = gdsDes;
		this.gdsImg = gdsImg;
		this.gdsDate = gdsDate;
	}

	public int getGdsNum() {
		return gdsNum;
	}

	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}

	public String getGdsName() {
		return gdsName;
	}

	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public int getGdsPrice() {
		return gdsPrice;
	}

	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}

	public int getGdsStock() {
		return gdsStock;
	}

	public void setGdsStock(int gdsStock) {
		this.gdsStock = gdsStock;
	}

	public String getGdsDes() {
		return gdsDes;
	}

	public void setGdsDes(String gdsDes) {
		this.gdsDes = gdsDes;
	}

	public String getGdsImg() {
		return gdsImg;
	}

	public void setGdsImg(String gdsImg) {
		this.gdsImg = gdsImg;
	}

	public Date getGdsDate() {
		return gdsDate;
	}

	public void setGdsDate(Date gdsDate) {
		this.gdsDate = gdsDate;
	}
	
	
}
