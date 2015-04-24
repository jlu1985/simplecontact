<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Contacts</title>
</head>
<body>


	<form id="deleteForm" method="post">
		<input type="checkbox" id="selectAll"> Toggle All<br/>
		<c:forEach var="contact" items="${contacts}">
			<input type="checkbox" value="${contact.contactId}" /> ${contact.personName }<br />
		</c:forEach>
		<input type="hidden" id="selections" name="selections"> 
		<input type="submit" />
		<input type="button" value="Back" onClick="history.go(-1);return true;"/> 
	</form>

	
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/delete.js"></script>
</body>
</html>