package com.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
		
	//로그인 성공하여 게시판 들어가기
	@RequestMapping(value = "/apprBoard")
	public String apprBoardDefault(){
		return "redirect:apprBoard/1";
	}
	
	//게시판 페이징처리
	@RequestMapping(value="/apprBoard/{page}")
	public String arrpBoard(@PathVariable int page){
		
		return "";
	}
	
	//양식 작성
	@RequestMapping(value = "/writeForm")
	public String writeForm(Model model){		
		//대분류 공통 코드 가져와서 (list) 양식에 보여주기
		model.addAttribute("groupCode", boardService.getCommonGroupCode());
		return "board/apprWriteForm";
	}
	
	//대분류에 따라서 중분류를 바꾸기 위한 에이잭스
	@RequestMapping(value = "/selectChangeCheck")
	public String selectChangeCheck(Model model, HttpServletRequest request){
		model.addAttribute("changeGroupCode", boardService.selectChangeCheck(request));
		return "board/apprWriteForm";
	}
}
