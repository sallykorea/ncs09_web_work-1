package com.sally.spring07.lunch.dto;

public class LunchDto {
	private int num;
	private String menu;
	private String regdate;
	
	public LunchDto() {}

	public LunchDto(int num, String menu, String regdate) {
		super();
		this.num = num;
		this.menu = menu;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
