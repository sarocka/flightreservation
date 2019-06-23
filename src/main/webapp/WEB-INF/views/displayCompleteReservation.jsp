<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete reservation</title>
</head>
<body>
<h2>Flight information: </h2>
<pre>
Operating airlines: ${flight.operatingAirlines}
Flight No: ${flight.flightNo}
Departure city: ${flight.departureCity}
Arrival city: ${flight.arrivalCity}
Departure date: ${flight.departureDate}
Estimated arrival time: ${flight.estimatedDepartureTime}
</pre>

<h2>Passenger information: </h2>
<form action="completeReservation" method="post">
<pre>
Firstname: <input type="text" name="passengerFirstname"/>
Lastname:  <input type="text" name="passengerLastname"/>
Phone number: <input type="text" name="passengerPhone"/>
email:  <input type="text" name="passengerEmail"/>
<input type="hidden"  name="flightId" value="${flight.id}"/>
</pre>

<h2>Card details: </h2>
<pre>
Name on the card: <input type="text" name=""/>
Card No:  <input type="text" name=""/>
Expiry date: <input type="text" name=""/>
Security code:  <input type="text" name=""/>



<input type="submit" value="Confirm"/>
</pre>
</form>
</body>
</html>