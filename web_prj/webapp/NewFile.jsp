<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style></style>
<link rel="stylesheet" href="web_prj/css/my.css">
</head>
<body>

	<table border="1" width="300">
		<tr>
			<td>SEQ</td>
			<td>ID</td>
			<td>PW</td>
		</tr>

		<tr>
			<td>1</td>
			<td>lee</td>
			<td>1234</td>
		</tr>




	</table>


	<br>

	<form method="POST" action="/web_prj/HelloServlet">
		<input type="text" name="kid" value="" /> <input type="password"
			name="kpw" value="" /> <br> 남<input type="radio" name="gender"
			value="m"> 여<input type="radio" name="gender" value="f">
		<br> 맥주<input type="checkbox" name="hobby" value="b"> 소주<input
			type="checkbox" name="hobby" value="s"> 막걸리<input
			type="checkbox" name="hobby" value="m"> <br>
		<textarea rows="" cols="" name="context">
	</textarea>

		<br> <input type="hidden" name="hiddenV" value="00000"> <br>
		<input type="file" name="uploadFile"> <select name="kbirth">
			<option value="011">SKT</option>
			<option value="016">LGT</option>
			<option value="010">KT</option>



		</select> <br> <input type="image" src=""> <br> <input
			type="button" value="button"> <br> <input type="submit"
			value="post전송" /> <input type="reset" value="reset">

	</form>

	<a href="/web_prj/HelloServlet?kid=hee&kpw=111">get</a> 한글 두글 세글
	<% 
for(int i=0; i<10; ++i){
	out.println(i);
	System.out.println(i);
}
%>
</body>
</html>