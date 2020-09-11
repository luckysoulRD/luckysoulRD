<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
	<h2>Flight Details:</h2>
	Airlines:${reservation.flight.operatingAirlines} <br>
	Flight No:${reservation.flight.flightNumber} <br>
	Departure City:${reservation.flight.departureCity} <br>
	Arrival City:${reservation.flight.arrivalCity} <br>
	Date Of Departure:${reservation.flight.dateOfDeparture} <br>
	Estimate Departure Time:${reservation.flight.estimatedDepartureTime}<br>

	<h2>Passenger Details:</h2>
	First-Name:${reservation.passenger.firstName }<br>
	Last-Name:${reservation.passenger.lastName }<br>
	Email:${reservation.passenger.email }<br>
	Phone:${reservation.passenger.phone }<br>

<form action="/completeCheckIn" method="post">
Enter Number Of Bags You Want to Check In:<input type="text" name="numberOfBags">
<input type="hidden" name="reservationId" value="${reservation.id}">
<input type="submit" value="Check-In">
</form>
</body>
</html>