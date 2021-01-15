package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {
	@Autowired //서비스 자동 주입
	MemberService service;
	
	@RequestMapping(value="/MemberAdd")
	public String memberAdd(MemberDTO m, Model model) { //
		
		service.memberAdd(m);
		model.addAttribute("success","회원가입성공");
		///success 문구 저장
		return "main"; //main.jsp , View-controller의 mian이 아님
	}
	
	@RequestMapping(value="/LoginCheck/myPage")
	public String myPage(HttpSession session) {
		//세션에서 id얻기
		//db에서 id에 해당하는 DTO 정보 얻기(myPage(사용자 id이용)
		//dto 정보 콘솔에 출력
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		
		String userid = dto.getUserid();
		dto = service.myPage(userid);   
		session.setAttribute("login", dto); 
		return "redirect:../myPage"; //주소에 해당하는 사이트를 servlet-context에 연동
	}
	
	@RequestMapping(value="idDuplicateCheck", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String idDuplicateCheck(@RequestParam ("userid") String userid) {
		MemberDTO dto = service.myPage(userid); //myPage하면 userid에 해당하는 memberDTO를 꺼내옴
		System.out.println("idDuplicateCheck"+userid);
		String mesg="아이디 사용 가능";
		if(dto != null) { //기존 id객체가 db에 존재하는 경우
			mesg="아이디 중복";
		}
		return mesg;
	}
	@RequestMapping(value="/LoginCheck/MemberUpdate")
	public String memberUpdate(MemberDTO m, Model model) {
		service.memberUpdate(m);
		System.out.println(m);
		model.addAttribute("success","정보가 정상적으로 수정되었습니다.");
		return "redirect:../LoginCheck/myPage"; 
	}
} 
