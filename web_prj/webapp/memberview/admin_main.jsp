<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.kosmo.member.MemberVO"%>

<% List<MemberVO> list = (List)request.getAttribute("userList");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h5>Administrator 계정으로 접속</h5>
	<h1>userList</h1>


	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<form method="post" action="/member">
					<input type="hidden" name="info" value="join">
					<div class="table-responsive">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>#####</th>
									<th>Sequence</th>
									<th>Member Id</th>
									<th>Member Name</th>
									<th>Member Roll</th>
									<th>Member Regist Date</th>

								</tr>
							</thead>
							<tbody>
								<%for(int i=0;i<list.size();++i){ %>
								<tr>
									<td><%= i+1%></td>
									<td><%=list.get(i).getMemberSeq() %></td>
									<td><%=list.get(i).getId() %></td>
									<td><%=list.get(i).getName() %></td>
									<td><%=list.get(i).getRoll() %></td>
									<td><%=list.get(i).getRegdate() %></td>

								</tr>
								<%} %>

							</tbody>
						</table>
					</div>
				</form>
				<div class="col-sm-3"></div>
			</div>
		</div>

	</div>



</body>
</html>