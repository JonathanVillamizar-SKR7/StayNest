<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="daxbnb.DAO.*"%>
<%@ page import="daxbnb.model.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Housing</title>
<link rel="stylesheet" href="styles/housing.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<%
	HousingDAO h = new HousingDAO();
	String id = request.getParameter("id");
	Housing housing = h.selectById(Integer.parseInt(id));
	%>

	<%@ include file="Header.jsp"%>

	<main style="background-color: var(--secundary-color);">
		<div class="container my-5">
			<div class="row align-items-center">
				<div class="col-md-6">
					<div id="housingCarousel" class="carousel slide"
						data-bs-ride="carousel">
						<div class="carousel-indicators">
							<%
							for (int i = 0; i < housing.getImages().size(); i++) {
							%>
							<button type="button" data-bs-target="#housingCarousel"
								data-bs-slide-to="<%=i%>" class="<%=(i == 0) ? "active" : ""%>"
								aria-label="Slide <%=i + 1%>"></button>
							<%
							}
							%>
						</div>

						<div class="carousel-inner">
							<%
							if (!housing.getImages().isEmpty()) {
								String firstImagePath = request.getContextPath() + housing.getImages().get(0).getImgRoute();
							%>
							<div class="carousel-item active">
								<img src="<%=firstImagePath%>"
									class="d-block w-100 img-fluid rounded image-full"
									alt="Main Image">
							</div>
							<%
							}
							for (int i = 1; i < housing.getImages().size(); i++) {
							String imagePath = request.getContextPath() + housing.getImages().get(i).getImgRoute();
							%>
							<div class="carousel-item">
								<img src="<%=imagePath%>"
									class="d-block w-100 img-fluid rounded image-full"
									alt="Image House">
							</div>
							<%
							}
							%>
						</div>

						<button class="carousel-control-prev" type="button"
							data-bs-target="#housingCarousel" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#housingCarousel" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
					</div>
				</div>

				<script
					src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
				<script>
					var myCarousel = document.querySelector('#housingCarousel');
					var carousel = new bootstrap.Carousel(myCarousel, {
						interval : 3000,
						wrap : true
					});
				</script>

				<div class="col-md-6 d-flex flex-column justify-content-around"
					style="height: 100%;">
					<h2 class="align-text-top">
						<%=housing.getName()%>
					</h2>
					<p class="text-left">
						<%=housing.getLocation()%>
					</p>
					<figcaption class="blockquote-footer">
						Type of accommodation: <cite title="Source Title text"> <%=housing.getIdType()%>
						</cite>
					</figcaption>
					<div class="list">
						<ul class="nav flex-column">
							<li class="nav-item"><img src="img/guest.png" width="8%"
								class="img-fluid" alt=""> <%=housing.getNumGuest()%> guest</li>
							<li class="nav-item"><img src="img/bedroom.png" width="8%"
								class="img-fluid" alt=""> <%=housing.getNumBedroom()%>
								bedroom</li>
							<li class="nav-item"><img src="img/bed.png" width="8%"
								class="img-fluid" alt=""> <%=housing.getNumBed()%> bed</li>
							<li class="nav-item"><img src="img/bath.png" width="8%"
								class="img-fluid" alt=""> <%=housing.getNumBath()%> bath</li>
						</ul>
					</div>
					<div class="textt-left ms-1 mb-4">
						<li>Price <%=housing.getPrice()%> € per night.
						</li>
					</div>
				</div>
			</div>

			<div class="description col-12 mt-4">
				<h3>Description</h3>
				<p>
					<%=housing.getDescription()%>
				</p>
			</div>

			<div class="row">
				<div class="col-6">
					<h4>Offers</h4>
					<ul class="Offers nav flex-column">
						<%
						List<Facilities> facilities = housing.getFacilities();
						for (Facilities s : facilities) {
						%>
						<li class="Offer"><%=s.getTypeFacilities()%></li>
						<%
						}
						%>
					</ul>
				</div>
				<div class="formReserve col-12 col-md-6">
					<h4>Reserve:</h4>
					<form id="reserveForm" action="reserve.jsp" method="get">
						<div class="mb-3">
							<label for="checkIn" class="form-label">Check-In</label> <input
								type="date" class="form-control" id="checkIn" name="checkIn"
								required>
						</div>
						<div class="mb-3">
							<label for="checkOut" class="form-label">Check-Out</label> <input
								type="date" class="form-control" id="checkOut" name="checkOut"
								required>
						</div>
						<div class="mb-3">
							<label for="guests" class="form-label">Guests</label> <input
								type="number" class="form-control" id="guests" name="guests"
								min="1" required>
						</div>
						<input type="hidden" name="id" value="<%=housing.getIdHouse()%>">
						<button type="submit" class="btn btn-primary w-100">Continue
							Reservation</button>
					</form>
					<div id="loginAlert" class="alert alert-warning mt-3 d-none"
						role="alert">You must log in to continue with the
						reservation.</div>
				</div>

				<%
				boolean isLoggedIn = (session.getAttribute("username") != null);
				%>
				<script>
					document
							.getElementById('reserveForm')
							.addEventListener(
									'submit',
									function(e) {
										var isLoggedIn =
				<%=isLoggedIn%>
					;
										if (!isLoggedIn) {
											e.preventDefault();
											document
													.getElementById('loginAlert').classList
													.remove('d-none');
										}
									});
				</script>

			</div>
		</div>
	</main>

	<%@ include file="Footer.jsp"%>

</body>

</html>