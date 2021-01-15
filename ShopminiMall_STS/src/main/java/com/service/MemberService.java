package com.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired // 자동 주입 받도록 설정
	MemberDAO dao;

	public void memberAdd(MemberDTO m) { // 회원가입, service에서 DTO받음
		dao.memberAdd(m);
		; // DTO를 전달 함
	}

	public MemberDTO login(HashMap<String, String> map) {
		MemberDTO dto = dao.login(map);
		return dto;  
	}
	
	public MemberDTO myPage(String userid) {
		MemberDTO dto = dao.myPage(userid);
		return dto;
	}
	public int memberUpdate(MemberDTO m) {
		int n = dao.memberUpdate(m);
		System.out.println("업데이트 갯수:"+n);
		return n;
	}
}
