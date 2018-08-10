<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- //스크립트릿으로 자바코드가 가능합니다 -->
<% 
String name =request.getParameter("kname");
String ugd =request.getParameter("kugd");
%>

<%if(ugd.equals("u")) {%>
유저 메인
<%}else if(ugd.equals("a")){%>

<%out.println(name); %>유저 어드민입니다.
<%} %>
<br>


</body>
</html>