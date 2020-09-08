<!DOCTYPE html>
<html lang="en">

<head>
	<meta charshet="utf-8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>JUNIOR</title>
	<link href="assets/default.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="header">
		<h1>JUNIOR</h1>
		<h2>School Management System</h2>
	</div>
	<div id="menu">
		<jsp:include page="fragments/nav.jsp" />
	</div>
	<div id="content">
		<div>
			<h2>Welcome to JUNIOR</h2>
			<p><u>Contact warden for setting up an account.</u></p>
			<p>
				To login, you need to have right email, and specify right role below. An account maybe have more than 1 role, so please choose your role before login into the system.
				Current role are following:
			</p>
			<ul>
				<li>Student</li>
				<li>Teacher</li>
				<li>Warden</li>
				<li>Principal</li>
				<li>Administrator</li>
			</ul>
			<p>After login, a verification code will be sent into your email, you need to verify that before access into the system.</p>
		</div>
		<div>
			<h2>Login</h2>
			<form action="/login" method="POST">
				<table>
					<tr>
						<td>Email:</td>
						<td>
							<input type="text" name="email" />
						</td>
					</tr>
					<tr>
						<td>
							Password:
						</td>
						<td>
							<input type="password" name="password" />
						</td>
					</tr>
					<tr>
						<td>
							Role:
						</td>
						<td>
							<select name="role">
								<option value="1">student</option>
								<option value="2">teacher</option>
								<option value="3">warden</option>
								<option value="4">principal</option>
								<option value="5">administrator</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="Login" />
						</td>
						<td>
							<a href="#">PASSWORD RECOVERY</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="footer">
		<p>Copyright &copy; 2020</p>
	</div>
</body>

</html>
