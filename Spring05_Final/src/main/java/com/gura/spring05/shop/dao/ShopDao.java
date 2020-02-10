package com.gura.spring05.shop.dao;

import java.util.List;

import com.gura.spring05.shop.dto.ShopDto;

public interface ShopDao {
	//상품의 목록 리턴
	public List<ShopDto> getList();
	//상품 제고 감소시키기
	public void minusCount(int num);
	//잔고 감소 시키기
	public void minusMoney(ShopDto dto);
	//포인트 증가 시키기
	public void plusPoint(ShopDto dto);
	//특정 상품의 가격 리턴 시키기
	public int getPrice(int num);
}
