<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Contacts</title>
</head>
<body>
	<div id="nav">
		<ul>
			<li><a href=<c:url value="/newContact"/>>new</a></li>
			<li><a href=<c:url value="/deleteContact"/>>delete</a></li>
		
		</ul>
	</div>

	<c:choose>
		<c:when test="${hasContent}">
			<c:set var="messageStyle" value="none" />
			<c:set var="contentStyle" value="block" />
		</c:when>
		<c:otherwise>
			<c:set var="messageStyle" value="block" />
			<c:set var="contentStyle" value="none" />
		</c:otherwise>
	</c:choose>
	<div id="messageDiv" style="display:${messageStyle}">There is no content, <a href=<c:url value="/newContact"/>>click</a> to add a new one</div>
	<div id="contactsDiv" style="display:${contentStyle}">Some contents here</div>
	
	${sessionScope.myobject}
</body>
</html>