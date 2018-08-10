<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<form method="post" action="/web_prj/HelloServlet">
		ID:<input type="text" name="kid"><br> 
		PW:<input type="password" name="kpw"><br> 
		GEN:<input type="radio" name="kgen" value="m">
		남 <input type="radio" name="kgen" value="f">여 <br> 
		HABIT:<input type="checkbox" name="khiabit" value="mot">등산
		      <input type="checkbox" name="khiabit" value="fish">낚시 
		      <input type="checkbox" name="khiabit" value="book">독서 <br> 
		HIDDEN:<input type="hidden" name="kvirus" value="00000"> <br> 
		FILE:<input type="file" name="kfile"> <br> 
		TEL:<select name="ktel">
			<option value="011">SKT</option>
			<option value="016">LGT</option>
			<option value="018">KT</option>
		</select> <br> 
		INTRO: <textarea name="kintro">내용입니다</textarea><br> 
		<input type="submit" value="post전송버튼"> 
		<input type="image" src=""> 
		<input type="button" value="그냥버튼">
		<input type="reset" value="리셋버튼">
	</form>

</body>
</html>