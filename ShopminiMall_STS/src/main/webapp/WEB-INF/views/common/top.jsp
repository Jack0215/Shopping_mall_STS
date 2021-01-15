<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${empty login }"> <!-- 세션에서 로그인 정보 검사 후 로그인이 안된 경우  -->

	<a href="loginForm">로그인</a>&nbsp; <!-- xml에 설정되어있음 -->
	<a href="LoginCheck/CartList">장바구니목록</a>&nbsp;
	<a href="memberForm">회원가입</a>&nbsp; <!-- xml에 등록해놓은 주소(servlet-context.xml에 있음) -->
	 
</c:if> 
<c:if test="${!empty login }"> <!-- 세션에서 로그인 정보 검사 후 로그인이 된 경우  -->
안녕하세요 ${login.username } 님! <br>
	<a href="LogoutCheck/logout"> 로그아웃</a>&nbsp;
	<a href="myPage">mypage</a>&nbsp;
	<a href="CartListServlet">장바구니 목록</a> 
</c:if>
 