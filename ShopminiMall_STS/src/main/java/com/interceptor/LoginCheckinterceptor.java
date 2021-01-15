package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//interceptor를 servlet-context에 등록시킬거임
//context에서 bean등록
//path:/loginCheck/** 체크 뒤에 뭐가 오든 실행
//얘가 처리할 주소는 전부 LoginCheckinterceptor 이쪽으로 들어옴
//세션가져오고 로그인 정보 있는지 없는지 검사
//로그인 할 때 로그인 정보 set 해줬음
//로그인정보가 null이면 로그인폼으로 이동 후 return false 하면 false이후 작업은 진행하지 않음
//만약 로그인 정보가 null이 아니면 retrun true해서 이후 작업을 할 수 있게 설정
public class LoginCheckinterceptor extends HandlerInterceptorAdapter{
// /loginCheck/** //장바구니, 마이페이지, 장바구니에서 삭제, 수량업데이트, 주문 등 회원전용 메뉴에서 선동작
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle동작");
		HttpSession session = request.getSession();
		if(session.getAttribute("login")==null) { //로그인 검사
			response.sendRedirect("../loginForm"); //servlet-context.xml //로그인 페이지로 이동
			return false; //주의
		}else {
			return true; //로그인 정보가 있는 경우 작업 계속 진행
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	
	
	}
	


