package com.mvc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mvc.dao.BoardDAO;
import com.mvc.dao.CommonCodeDTO;

@Component
public class BoardService {
	
	@Autowired
	BoardDAO boardDAO;
	
	//저장된 공통 대분류 코드 가져오기
	public List<CommonCodeDTO> getCommonGroupCode(){
		return boardDAO.getCommonGroupCode();
	}
	
	//대분류 공통코드 가지고 와서 중분류 만들기
	public List<CommonCodeDTO> selectChangeCheck(HttpServletRequest request){
		String groupCodeCD = "AD01" + request.getParameter("groupCodeCD"); // "AD0101" 이런식..?
		return boardDAO.selectChangeCheck(groupCodeCD);
	}
}
