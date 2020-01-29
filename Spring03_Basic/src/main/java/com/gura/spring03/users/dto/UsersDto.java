package com.gura.spring03.users.dto;

public class UsersDto {
	//필드
	private String id;
	private String pwd;
	//생성자
	public UsersDto() {}
	public UsersDto(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	//메서드
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
