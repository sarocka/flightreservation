<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login in</title>
</head>
<body>

<h2>User login</h2>
<form action="login" method="post">
<pre>
Username: <input type="text" name="username"/>
Password: <input type="password" name="password"/>
 
<input type="submit" value="Login"/>
</pre>
</form>
${message}
</body>
</html>