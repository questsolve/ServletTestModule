<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String count = request.getParameter("count");%>

<%if(count.equals("1")) {%>

<%=count%> 명이 새로 가입했습니다

<%} else {%>
잘 못입력하셨습니다. 다시 처음부터 ㄱㄱ
<%} %>

<a href="member_form.jsp">돌아가기</a>
<a href="member_login.jsp">로그인 하러가기</a>
</body>
</html>