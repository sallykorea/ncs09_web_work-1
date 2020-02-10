package com.sally.shop.dto;

import java.sql.Date;

public class MemberDto {
	private String userId;
	private String userPass;
	private String userName;
	private String userPhon;
	private String userAddr1;
	private String userAddr2;
	private String userAddr3;
	private Date regiDate;
	private int verify;
	
	public MemberDto() {}

	public MemberDto(String userId, String userPass, String userName, String userPhon, String userAddr1,
			String userAddr2, String userAddr3, Date regiDate, int verify) {
		super();
		this.userId = userId;
		this.userPass = userPass;
		this.userName = userName;
		this.userPhon = userPhon;
		this.userAddr1 = userAddr1;
		this.userAddr2 = userAddr2;
		this.userAddr3 = userAddr3;
		this.regiDate = regiDate;
		this.verify = verify;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhon() {
		return userPhon;
	}

	public void setUserPhon(String userPhon) {
		this.userPhon = userPhon;
	}

	public String getUserAddr1() {
		return userAddr1;
	}

	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}

	public String getUserAddr2() {
		return userAddr2;
	}

	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}

	public String getUserAddr3() {
		return userAddr3;
	}

	public void setUserAddr3(String userAddr3) {
		this.userAddr3 = userAddr3;
	}

	public Date getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}
	
	
}
