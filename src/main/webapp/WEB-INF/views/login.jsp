<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello  </title>
</head>
<body>
	
    <form action="/login" method="POST">
    <p> ${errorMessage} </p>
    <label>Enter your name:</label><input type="text" name="name">
    <label>Enter your password:</label><input type="password" name="password">
    <input type="submit"> </form>
</body>
</html>