<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>JUNIOR</title>
	<link href="${request.getContextPath()}/assets/default.css" rel="stylesheet" type="text/css" />
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
			<c:set var="session" value="${sessionScope.SESSION}" />
			<table>
				<c:forEach var="title" items="${NEW_TITLES}">
					<tr>
						<td>
							<a href="?n=${title.id}"><c:out value="${title.title}" /></a>
						</td>
						<c:if test="${session.administrator}">
							<td>
								<a href="/admin/news/edit?n=${title.id}">Edit</a>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div id="footer">
		<p>Copyright &copy; 2020</p>
	</div>
</body>

</html>
