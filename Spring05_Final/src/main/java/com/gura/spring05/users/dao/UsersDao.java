package com.gura.spring05.users.dao;

import com.gura.spring05.users.dto.UsersDto;

public interface UsersDao {
	public boolean isExist(String inputId);
	public void insert(UsersDto dto);
	public String getPwdHash(String inputId); //입력한 id를 이용해서 암호화된 비밀번호를 갖고 와야한다.
	public UsersDto getData(String id);
}
