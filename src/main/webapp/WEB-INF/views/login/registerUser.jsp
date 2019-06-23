<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h2>User registration</h2>
<form action="registerUser" method="post">
<pre>
Firstname: <input type="text" name="firstname"/>
Lastname: <input type="text" name="lastname"/>
Username(email): <input type="email" name="username"/>
Password: <input type="password" name="password"/>
Confirm Password: <input type="password" name="confirmPassword"/>

<input type="submit" value="Register"/>
</pre>
</form>
</body>
</html>