package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class LoginController {
	@Autowired
	MemberService service;

	// 로그인에 대한 매핑주소, 로그인 함수 생성, 데이터 파싱은 id,passwd를 해쉬맵으로 받음
	// id, pw받아서 db가서 맞는지 확인
	// 맞으면 세션에다 로그인정보 꽂아줌, 틀리면 틀렸다고 로그인화면으로 돌림

	@RequestMapping(value = "/Login") // 로그인으로 옴

	// id, pw를 맵에 저장, model써서 화면 전환시킴, session에다가 로그인정보 꽂아주기위해 매개변수로 받고있음
	/*
	 * public String Login(@RequestParam HashMap<String, String> map, Model model,
	 * HttpSession session) {
	 * 
	 * // 맵을 service에 로그인함수에 넘겨주고 MemberDTO에 저장 // service는 dao에 넘겨주고 // dao는 맵퍼에
	 * 넘겨서 검사하는것까지 만들기 //nextPage 설정해도 괜찮음 MemberDTO mdto = service.login(map); if
	 * (mdto != null) { session.setAttribute("login", mdto); return "main"; } else {
	 * model.addAttribute("mesg","아이디 또는 비밀번호가 잘못되었습니다."); return "loginForm"; } }
	 */
	
	public String Login(@RequestParam HashMap<String, String> map, Model model, HttpSession session) {

		// 맵을 service에 로그인함수에 넘겨주고 MemberDTO에 저장
		// service는 dao에 넘겨주고
		// dao는 맵퍼에 넘겨서 검사하는것까지 만들기
		//nextPage 설정해도 괜찮음
		String nextPage = null;
		MemberDTO dto = service.login(map); //id,passwd select함
		if (dto != null) {
		///////////////////////////////////////////////////////////
			session.setAttribute("login", dto); //로그인 정보 저장/////
		///////////////////////////////////////////////////////////
			nextPage= "redirect:/goodsList?gCategory=top"; //로그인시 상품 목록 자동 출력
			//nextPage는 goodsController를 찾아감
			//gCategory가 null인 경우 자동으로 top이 되도록 설정
		} else {
			model.addAttribute("mesg","아이디 또는 비밀번호가 잘못되었습니다.");
			nextPage ="loginForm";
		}	
		return nextPage;
	}
	
	@RequestMapping(value = "/LogoutCheck/logout") 
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "redirect:../"; //main    //xml에 설정 main.jsp
	}
	
	
}

