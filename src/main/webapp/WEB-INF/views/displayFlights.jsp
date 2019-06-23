<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search results</title>
</head>
<body>
<table border="1">
<tr><th>Operating airlines</th><th>Departure city</th><th>Arrival city</th><th>Departure Date</th><th>Estimated departure time</th></tr>
<c:forEach items="${flights}" var="flight">
<tr><td>${flight.operatingAirlines}</td><td>${flight.departureCity}</td><td>${flight.arrivalCity}</td><td>${flight.departureDate}</td><td>${flight.estimatedDepartureTime}</td>
<td><a href="showCompleteReservation?id=${flight.id}">Book a flight</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>