<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="session" value="${sessionScope.SESSION}" />
<c:if test="${not empty session}">
    <div id="header">
        <h2>
            <c:out value="${session.email}" />
        </h2>
        <h2>
            Role: <c:out value="${session.roleId}" />
        </h2>
    </div>
</c:if>

<ul>
    <li><a href="/">Home</a></li>
    <c:if test="${empty session}">
        <li><a href="/login.jsp">Login</a></li>
    </c:if>
    <c:if test="${not empty session}">
        <li><a href="/logout">Logout</a></li>
    </c:if>
    <c:if test="${session.administrator}">
        <li><a href="/admin/news/create">Create News</a></li>
    </c:if>
    <c:if test="${session.student}">
        <li><a href="/student/course">Courses</a></li>
    </c:if>
    <li><a href="contact.jsp">Contact Us</a></li>
</ul>
