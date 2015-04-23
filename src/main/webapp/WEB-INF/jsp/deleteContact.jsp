<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Contacts</title>
</head>
<body>


	<form id="deleteForm" method="post">

		<c:forEach var="record" items="${records}">
			<input type="checkbox" value="${record.contactId}" /> ${record.personName }<br />
		</c:forEach>
		<input type="hidden" id="streamedSelection"> 
		<input type="submit" />
		<input type="button" value="Back" onClick="history.go(-1);return true;"/> 
	</form>

	
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/delete.js"></script>
</body>
</html>