package com.gura.spring05.file.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.file.dto.FileDto;
import com.gura.spring05.file.service.FileService;

@Controller
public class FileController {
	@Autowired
	private FileService service;
	
	@RequestMapping("/file/list")
	public ModelAndView list(ModelAndView mView, HttpServletRequest request) {
		//파일 목록과 페이징 처리에 필요한 값들을 request에 담아주는 서비스 메소드 호출하기
		service.list(request);
		mView.setViewName("file/list");
		return mView;
	}
	
	@RequestMapping("/file/upload_form")
	public ModelAndView authUploadForm(HttpServletRequest request) {
		return new ModelAndView("file/upload_form");
	}
	
	@RequestMapping(value = "/file/upload", method = RequestMethod.POST)
	public ModelAndView authUpload(HttpServletRequest request, @ModelAttribute FileDto dto) {
		service.saveFile(request, dto);
		return new ModelAndView("redirect:/file/list.do");
	}
	
	@RequestMapping("/file/download")
	public ModelAndView download(ModelAndView mView, @RequestParam int num) {
		service.getFileData(mView, num);
		service.addDownCount(num);
		mView.setViewName("fil/download");
		mView.setViewName("fileDownView"); // '/views/fileDownView.jsp'를 찾아가기 전에 저 이름이 있는 bean이 존재하는지 찾는다.
		return mView;
	}
	
}
