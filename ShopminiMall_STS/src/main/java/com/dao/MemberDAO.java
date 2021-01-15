package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.MemberDTO;

//dao는 db접근해야됨
//dao에서 sqlsession 템블릿을 받아와서 service를 사용할 필요가 없을수 있지만 트랜잭션 처리를 service에서 사용해야함
//commit은 auto이다.
//현재 close가 사라짐. connection pull 자동으로 연결, 끊어줌
//dto를 service에 넘겨주는 코드 필요함 - Membercontroller로 이동
@Repository // component-scan으로 bean생성이 됨
public class MemberDAO {
	@Autowired
	SqlSessionTemplate template;// 자동주입

	public void memberAdd(MemberDTO m) {
		int n = template.insert("MemberMapper.memberAdd", m); // Mapper한테 DTO를 넘겨서 insert한다.
		// 회원가입이 되면 다시 service로 돌아간다.
		System.out.println(n);
	}
	
	public MemberDTO login(HashMap<String, String> m) {
		MemberDTO mdto = template.selectOne("MemberMapper.login", m);
		return mdto;
	}
	
	public MemberDTO myPage(String userid) {
		MemberDTO dto = template.selectOne("MemberMapper.mypage",userid);
		return dto;
	}
	
	public int memberUpdate(MemberDTO m) {
		int n = template.update("MemberMapper.memberUpdate",m);
		return n;
	}
}
