<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kosmo.member.MemberVO" %>
<%String id = request.getParameter("id"); %>
<%MemberVO vo = (MemberVO)session.getAttribute("SK_vo"); %>


    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function logout(){
	document.logout.value = "logout";
	
}

$(function(){
	var page                                     
})

</script>
</head>
<body>
<h3>어서 옵쇼  <%=vo.getName() %> 회원님</h3>


<h1>회 원 번 호 : <%=vo.getMemberSeq() %> </h1>
<h1>회 원 I D : <%=vo.getId() %> </h1>
<h1>회 원 등 급 : <%=vo.getRoll() %> </h1>


<form name ="view" method ="post" action= "/member">
<input type="hidden" name="info" value ="view">
<input type="hidden" name="seq" value ="<%=vo.getMemberSeq() %>">
<input type="submit" value ="회원정보 수정">

</form>

<input type="button" name ="logout" value ="logout">

</body>
</html>