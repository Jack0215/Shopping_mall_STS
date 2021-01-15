<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${! empty mesg}"> <!-- 아이디 or 비밀번호 틀렸을 경우 -->
	<script>
		alert('${mesg}'); 
	</script>
</c:if>

<%-- <%
   String mesg = (String)request.getAttribute("mesg");
  if(mesg!=null){
%>    
   <script>
     alert('<%=mesg %>');
   </script>
<%
  }
%> --%>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("form").on("submit", function(event) {
			var userid = $("#userid").val();
			var passwd = $("#passwd").val();
			if (userid.length == 0) {
				alert("userid 필수")
				$("#userid").focus();
				event.preventDefault();
			} else if (passwd.length == 0) {
				alert("passwd 필수")
				$("#passwd").focus();
				event.preventDefault();
			}
		});
	});
</script>
<!-- <form action="LoginServlet" method="get"> -->
<form action="Login" method="get"> <!-- 주소지정 -->
	아이디 : <input type="text" name="userid" id="userid"><br> <br>
	비밀번호 : <input type="text" name="passwd" id="passwd"><br> <br>
	<input type="submit" value="로그인"> &nbsp;
	<input type="reset" value="취소"> &nbsp; &nbsp; 
	<a href="MemberIdSearchUIServlet">아이디찾기</a>
</form>
