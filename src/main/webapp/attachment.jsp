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
            <p>Attachments</p>
            <table>
                <c:if test="${empty ATTACHMENTS}">
                    <p>No attachments</p>
                </c:if>
                <c:forEach var="attachment" items="${ATTACHMENTS}">
                    <tr>
                        <td>${attachment.filename}</td>
                        <td><a href="/admin/attachment/download?a=${attachment.id}">Download</a></td>
                    </tr>
                </c:forEach>
            </table>
		</div>
		<div>
            <h2>Attachment</h2>
            <c:if test="${not empty ATTACHMENT_MESSAGE}">
                <div id="header">
                    <h2>${ATTACHMENT_MESSAGE}</h2>    
                </div>
            </c:if>
            <ul>
                <li>Only able to attach PDF, DOCX type</li>
                <li>File size less than 5MB</li>
            </ul>
            <form action="/admin/attachments/upload" method="POST" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${ATTACHMENT_NEW_ID}" />
                <input type = "file" name = "file" size = "50" />
                <br />
                <input type = "submit" value = "Upload" />
            </form>
		</div>
	</div>
	<div id="footer">
		<p>Copyright &copy; 2020</p>
	</div>
</body>

</html>
