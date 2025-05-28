<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="daxbnb.DAO.*"%>
<%@ page import="daxbnb.model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.Date"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Reserve Nest</title>
<link rel="stylesheet" href="styles/reserves.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%
	Integer idUserObj = (Integer) session.getAttribute("idUser");
	if (idUserObj == null) {
	%>
	<script>
		alert("You must log in to access this page.");
		window.location.href = "login.jsp";
	</script>
	<%
	return;
	}

	int idUser = idUserObj;
	boolean reservaExitosa = false;
	String detallesReserva = "";

	if ("POST".equalsIgnoreCase(request.getMethod())) {
	try {
		int idHouse = Integer.parseInt(request.getParameter("id"));
		String checkInStr = request.getParameter("checkIn");
		String checkOutStr = request.getParameter("checkOut");
		int guests = Integer.parseInt(request.getParameter("guests"));
		String cardExists = request.getParameter("cardExists");

		if ("false".equals(cardExists)) {
			String cardHolderName = request.getParameter("cardHolderName");
			long creditCardNum = Long.parseLong(request.getParameter("creditCardNum"));
			String expirationStr = request.getParameter("expiration") + "-01";
			int cvv = Integer.parseInt(request.getParameter("cvv"));
			Date expiration = Date.valueOf(expirationStr);

			CreditCardsDAO cardDAO = new CreditCardsDAO();
			cardDAO.insertCreditCard(cardHolderName, creditCardNum, expiration, cvv, idUser);
		}

		Date checkIn = Date.valueOf(checkInStr);
		Date checkOut = Date.valueOf(checkOutStr);
		HousingDAO hdao = new HousingDAO();
		Housing housing = hdao.selectById(idHouse);

		long noches = java.time.temporal.ChronoUnit.DAYS.between(checkIn.toLocalDate(), checkOut.toLocalDate());
		double pricePerNight = housing.getPrice();
		double totalPrice = noches * pricePerNight;

		ReservesDAO rdao = new ReservesDAO();
		rdao.insertReserve(idUser, housing.getIdHouse(), housing.getName(), guests, totalPrice, checkIn, checkOut);

		reservaExitosa = true;
		detallesReserva = "Reservation at <strong>" + housing.getName() + "</strong> from <strong>" + checkInStr
		+ "</strong> to <strong>" + checkOutStr + "</strong> for <strong>" + guests
		+ "</strong> guests over <strong>" + noches + "</strong> night(s).<br>Total Price: <strong>$" + totalPrice
		+ "</strong>";

	} catch (Exception e) {
		out.println("<div class='alert alert-danger'>Error: " + e.getMessage() + "</div>");
	}
	}

	String checkIn = request.getParameter("checkIn");
	String checkOut = request.getParameter("checkOut");
	String guests = request.getParameter("guests");
	String idStr = request.getParameter("id");
	int idHousing = Integer.parseInt(idStr);

	HousingDAO h = new HousingDAO();
	Housing housing = h.selectById(idHousing);

	CreditCardsDAO cardDAO = new CreditCardsDAO();
	CreditCard userCard = cardDAO.selectByIdUser(idUser);
	%>

	<%@ include file="Header.jsp"%>

	<main class="container my-5">
		<%
		if (reservaExitosa) {
		%>
		<div class="alert alert-success text-center shadow-sm p-4 rounded">
			<h4 class="alert-heading">Reservation Completed Successfully!</h4>
			<p><%=detallesReserva%></p>
			<hr>
			<p class="mb-0">
				You can view or manage your reservations in your <a
					href="userDetails.jsp?username=<%=session.getAttribute("username")%>">profile</a>.
			</p>
		</div>
		<%
		} else {
		%>
		<h2>Complete Your Reservation</h2>
		<form method="post" class="row g-3">
			<input type="hidden" name="id" value="<%=idHousing%>"> <input
				type="hidden" name="idUser" value="<%=idUser%>">

			<div class="col-md-6">
				<label for="checkIn" class="form-label">Check-In</label> <input
					type="date" class="form-control" id="checkIn" name="checkIn"
					value="<%=checkIn%>" required>
			</div>

			<div class="col-md-6">
				<label for="checkOut" class="form-label">Check-Out</label> <input
					type="date" class="form-control" id="checkOut" name="checkOut"
					value="<%=checkOut%>" required>
			</div>

			<div class="col-md-6">
				<label for="guests" class="form-label">Number of Guests</label> <input
					type="number" class="form-control" id="guests" name="guests"
					value="<%=guests%>" required>
			</div>

			<div class="col-md-12">
				<h4>Credit Card Information</h4>
				<%
				if (userCard != null) {
				%>
				<p>
					<strong>Card on File:</strong> **** **** ****
					<%=String.valueOf(userCard.getCreditCardNum()).substring(12)%></p>
				<input type="hidden" name="cardExists" value="true">
				<%
				} else {
				%>
				<input type="hidden" name="cardExists" value="false">
				<div class="mb-3">
					<label for="cardHolderName" class="form-label">Card Holder
						Name</label> <input type="text" class="form-control" id="cardHolderName"
						name="cardHolderName" required>
				</div>
				<div class="mb-3">
					<label for="creditCardNum" class="form-label">Credit Card
						Number</label> <input type="text" class="form-control" id="creditCardNum"
						name="creditCardNum" maxlength="16" required>
				</div>
				<div class="mb-3">
					<label for="expiration" class="form-label">Expiration Date</label>
					<input type="month" class="form-control" id="expiration"
						name="expiration" required>
				</div>
				<div class="mb-3">
					<label for="cvv" class="form-label">CVV</label> <input type="text"
						class="form-control" id="cvv" name="cvv" maxlength="4" required>
				</div>
				<%
				}
				%>
			</div>

			<div class="col-12">
				<button type="submit" class="btn btn-primary w-100">Confirm
					Reservation</button>
			</div>
		</form>
		<%
		}
		%>
	</main>

	<footer
		class="row row-cols-1 row-cols-sm-2 row-cols-md-5 py-5 my-5 border-top">
		<div class="col mb-3">
			<a href="home.jsp"
				class="d-flex align-items-center mb-3 link-dark text-decoration-none">
				<img src="img/logo_white.png" width="60%" alt="">
			</a>
		</div>
		<div class="col-12 text-center mt-4">
			<p class="text-muted">@Jonathan Villamizar - Alfredo Noriega -
				Diana Kopyv</p>
		</div>
	</footer>
</body>
</html>
