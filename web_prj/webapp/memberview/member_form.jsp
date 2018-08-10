<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" 	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
</script>


</head>
<body>
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
									<th>value</th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<td>id</td>
									<td><input type="text" name="id"></td>
								</tr>

								<tr>
									<td>password</td>
									<td><input type="password" name="pw"></td>
								</tr>

								<tr>
									<td>passwordCheck</td>
									<td><input type="password" name="pwcheck"></td>
								</tr>

								<tr>
									<td>name</td>
									<td><input type="text" name="name"></td>
								</tr>

								<tr>
									<td>regdate</td>
									<td><input type="text" id="datepicker" name="regdate"></td>
								</tr>

								<tr>
									<td>insert</td>

									<td><input type="submit"></td>
								</tr>

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