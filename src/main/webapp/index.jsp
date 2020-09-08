<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
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
			<c:out value="${NEW_DETAILS}" escapeXml="false" />
		</div>
		<div>
			<h2>News</h2>
			<p><a href="?n=1">Why should choose Greenwich University?</a></p>
			<p><a href="?n=2">Top 10 students in 09/2020.</a></p>
			<p><a href="?n=3">The way to increase your English skill.</a></p>
		</div>
	</div>
	<div id="footer">
		<p>Copyright &copy; 2020</p>
	</div>
</body>

</html>