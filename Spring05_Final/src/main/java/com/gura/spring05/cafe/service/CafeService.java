package com.gura.spring05.cafe.service;

import javax.servlet.http.HttpServletRequest;

import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeService {
	public void list(HttpServletRequest request);
	public void saveContent(HttpServletRequest request, CafeDto dto);
}
