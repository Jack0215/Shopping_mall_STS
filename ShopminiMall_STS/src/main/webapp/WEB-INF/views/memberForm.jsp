<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 화면입니다.</h1>
<jsp:include page="common/top.jsp" flush="false"></jsp:include><br>&nbsp;
<jsp:include page="common/menu.jsp"  flush="false"></jsp:include><br>
<hr>
<jsp:include page="member/memberForm.jsp"  flush="true"></jsp:include> <!-- 실제 회원가입에 필요한 jsp -->
</body>
</html>  