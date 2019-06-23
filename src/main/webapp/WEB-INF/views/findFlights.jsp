<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find flights</title>
</head>
<body>
<h2>Find flights</h2>
<form action="findFlights" method="get">
<pre>
From: <input type="text" name="departureCity"/>
To: <input type="text" name="arrivalCity"/>
Departure date: <input type="text" name="departureDate"/>

<input type="submit" value="Search"/>
</pre>
</form>
${message}

</body>
</html>