<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- //스크립트릿으로 자바코드가 가능합니다 -->
<% 
String name =(String)(request.getAttribute("kname"));
String ugd =(String)(request.getAttribute("kugd"));
ArrayList<String> list = (ArrayList<String>)(request.getAttribute("klist"));
%>
<%=name %>

<%out.println(list.size()); %>
<%for(int i=0;i<list.size();++i){ %>
<%out.println(list.get(i)+"<br>"); %>
<%} %>
<br>


</body>
</html>