package com.gura.spring05.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeService {
	public void list(HttpServletRequest request);
	public void saveContent(HttpServletRequest request, CafeDto dto);
	public void showdetail(int num, ModelAndView mView);
	public void updateDtailForm(int num, ModelAndView mView);
	public void updateDtail(HttpServletRequest request, CafeDto dto);
}
