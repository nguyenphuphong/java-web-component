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
			<p>
				You can contact us for:
			</p>
			<ul>
				<li><u>Charity:</u> Activities to encourage learning.</li>
				<li><u>Cooperate:</u> Acitivies associated with school</li>
				<li><u>Feedback & Complain:</u> Feedback &amp; Complain</li>
			</ul>
			<p>After submit, a verification code will be sent into your email, you need to verify that to avoid spam contact.</p>
			<p>Attachments will be available after email verification.</p>
		</div>
		<div>
			<h2>Mail</h2>
			<form action="/contact" method="POST" id="contact_form">
				<table>
					<tr>
						<td>Email:</td>
						<td>
							<input type="text" name="email" />
						</td>
					</tr>
					<tr>
						<td>
							Mobile:
						</td>
						<td>
							<input type="text" name="mobile" />
						</td>
					</tr>
					<tr>
						<td>
							Purpose:
						</td>
						<td>
							<select name="purpose">
								<option value="1">charity</option>
								<option value="2">cooperate</option>
								<option value="3">feedback &amp; complain</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="vertical-align: text-top;">
							Content:
						</td>
						<td>
							<textarea rows="10" cols="50" name="content" form="contact_form"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="Send" />
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
