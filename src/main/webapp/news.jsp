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
            <p>For admin control news</p>
            <ul>
                <li><u>To create:</u> Click on "Create News" on side bar.</li>
                <li><u>To edit:</u> Click on "Edit" in home page.</li>
                <li><u>To delete:</u> Click "Edit" first then "DELETE" link will appear</li>
                <li><u>To add attachments:</u> Click "Attachments"</li>
            </ul>
		</div>
		<div>
			<h2>News</h2>
            <form action="/admin/news/post" method="POST" id="news_form">
                <input type="hidden" name="id" value="${NEWS.id}" />
                <table>
                    <tr>
                        <td>Title:</td>
                        <td>
                            <input type="text" name="title" value="${NEWS.title}" size="70" />
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: text-top;">Content:</td>
                        <td>
                            <textarea rows="15" cols="80" name="content" form="news_form">${NEWS.content}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Submit" />
                        </td>
                        <td>
                            <c:if test="${NEWS.id ne 0}">
                                <a href="#">DELETE</a> | <a href="/admin/attachments/view?n=${NEWS.id}">ATTACHMENTS</a>
                            </c:if>
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
