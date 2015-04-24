<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Contact</title>
</head>
<body>
<form method="post" id="newContactForm">
	Name: <input type="text" name="name" placeholder="your name" required="required"/><br/>
	Email: <input type="text" name="email" placeholder="your email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"/><br/>
	Phone Number: <input type="text" name="phone" maxlength="10" placeholder="e.g. 8880001234" pattern="^[0-9]{10}$"title="your number wihtout any symbol e.g. 8880001234"><br/>
	<input type="submit" value="submit"/>
</form>
</body>
</html>