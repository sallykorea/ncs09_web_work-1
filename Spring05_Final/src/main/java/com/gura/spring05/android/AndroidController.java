package com.gura.spring05.android;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gura.spring05.file.dao.FileDao;
import com.gura.spring05.file.dto.FileDto;
import com.gura.spring05.member.dao.MemberDao;
import com.gura.spring05.member.dto.MemberDto;

@Controller
public class AndroidController {
	
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private FileDao fileDao;
	
	/*
	 * ["김구라", "해골", "원숭이"] 형식의 문자열이 응답되는 메소드
	 */
	@ResponseBody
	@RequestMapping("/android/getnames")
	public List<String> getNames() {
		List<String> names=new ArrayList<String>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		return names;
	}
	/*
	 * {"num":1, "name":"김구라", "isMan":true}형식의 json 문자열이 응답된다.
	 */
	@ResponseBody
	@RequestMapping("/android/getDetail")
	public Map<String, Object> getDetail() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		return map;
	}
	/*
	 * [{},{},{},...]형식의 json 문자열이 응답된다.
	 */
	@ResponseBody  //@ResponseBody 가 있어야 jackson-databind 라이브러리에서 json 형식으로 변경해준다.
	@RequestMapping("/android/getList")
	public List<Map<String, Object>> getList(){
		List<Map<String, Object>> list=dao.getList2();
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/android/member/list")
	public List<Map<String, Object>> memberGetList() {
		List<Map<String, Object>> list=dao.memberGetList();
		return list;
	}
	/*
	 *  Dto 를 리턴하고 @ResponseBody 어노테이션을 붙여도
	 *  Map 을 리턴한 것과 동일하게 응답된다.
	 *  {"num":1, "name":"김구라", "addr":"노량진"}
	 */
	@ResponseBody
	@RequestMapping("/android/member/detail")
	public MemberDto memberDetail(@RequestParam int num) {
		return dao.getData(num);
	}
	
	@ResponseBody
	@RequestMapping("/android/member/delete")
	public String memberDelete(@RequestParam int num) {
		dao.delete(num);
		return "{\"isSuccess\":true}";
	}
	
	/*
	 * 요청되는 파라미터의 이름과 MemberDto의 필드명이 같은 경우,
	 * Spring 프레임워크가 자동으로 dto 객체에 담아준다.(get방식, post방식 모두 가능)
	 * (@ModelAttribute 어노테이션을 붙여줘도 되고 없어도 된다.) 
	 * 
	 * 예) 요청 파라미터가 name=김구라&addr=노량진 인 경우,
	 *		MemberDto dto=new MemberDto();
	 *		dto.setName(name);
	 *		dto.setAddr(addr);
	 *
	 *@ModelAttribute("dto")라고 작성을 하면 
	 */
	@ResponseBody
	@RequestMapping("/android/member/insert")
	public String memberDelete(@ModelAttribute MemberDto dto) {
		dao.insert(dto);
		return "{\"isSuccess\":true}";
	}
	
	@ResponseBody
	@RequestMapping("/android/file/upload")
	private String savePicture(HttpServletRequest request, FileDto dto) {
		//파일을 저장할 폴더의 절대 경로를 얻어온다.
		String realPath=request.getServletContext().getRealPath("/upload");
		//콘솔창에 테스트 출력
		System.out.println(realPath);
		
		//MultipartFile 객체의 참조값 얻어오기
		//FileDto 에 담긴 MultipartFile 객체의 참조값을 얻어온다.
		MultipartFile mFile=dto.getMyFile();
		//원본 파일명
		String orgFileName=mFile.getOriginalFilename();
		//파일 사이즈
		//long fileSize=mFile.getSize();
		//저장할 파일의 상세 경로
		String filePath=realPath+File.separator;
		//디렉토리를 만들 파일 객체 생성
		File file=new File(filePath);
		if(!file.exists()){//디렉토리가 존재하지 않는다면
			file.mkdir();//디렉토리를 만든다.
		}
		//파일 시스템에 저장할 파일명을 만든다. (겹치치 않게)
		String saveFileName=
				System.currentTimeMillis()+orgFileName;
		try{
			//upload 폴더에 파일을 저장한다.
			//temporary folder에 저장되어 있는 data를 upload folder로 옮긴다.
			//파일 정보는 db에, 파일 data는 upload folder에 저장
			mFile.transferTo(new File(filePath+saveFileName));
		}catch(Exception e){
			e.printStackTrace();
		}
		//FileDto 객체에 추가 정보를 담는다.
		//String id=(String)request.getSession().getAttribute("id");
		//dto.setWriter(id); //작성자
		//dto.setOrgFileName(orgFileName);
		dto.setSaveFileName("/upload/"+saveFileName);
		//dto.setFileSize(fileSize);
		//FileDao 객체를 이용해서 DB 에 저장하기
		fileDao.savePicture(dto);
		
		return "{\"isSuccess\":true}";
	}
}
