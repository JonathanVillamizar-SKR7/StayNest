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
	TypesDAO typesDAO = new TypesDAO();
	HousingFacilityDAO facilityDAO = new HousingFacilityDAO();
	HousingImagesDAO imagesDAO = new HousingImagesDAO(); 
	Housing house = h.selectById();
	List<Facilities> facilities = facilityDAO.selectFacilitiesByHousingId(idHouse);
	List<Images> images = imagesDAO.selectImagesByHousingId(idHouse);
	%>

	<nav>
		<div class="logo">
			<a href="home.jsp"> <img src="img/Logo_right.png" alt="StayNest"
				class="logo">
			</a>
		</div>
		<div class="menu">
			<a href="index.jsp" class="Index m-lg-4">STAYS</a> <a
				href="login.jsp"> <img src="img/user.png" alt="User Icon"
				class="User-Icon m-4">
			</a>
		</div>
	</nav>

	<main>
		<div class="container my-5">
			<div class="row align-items-center">
				<div class="col-md-6">
                    <div id="housingCarousel" class="carousel slide" data-bs-ride="carousel">
                        
                        <div class="carousel-indicators">
                            <%
                            for (int i = 0; i < images.size(); i++) {
                            %>
                                <button type="button" data-bs-target="#housingCarousel" data-bs-slide-to="<%=i%>"
                                    class="<%= (i == 0) ? "active" : "" %>" aria-label="Slide <%=i + 1%>"></button>
                            <% 
                            } 
                            %>
                        </div>
                
                        <div class="carousel-inner">
                            <% 
                            if (!images.isEmpty()) {
                                String firstImagePath = request.getContextPath() + images.get(0).getImgRoute();
                            %>
                                <div class="carousel-item active">
                                    <img src="<%=firstImagePath%>" class="d-block w-100 img-fluid rounded image-full" alt="Main Image">
                                </div>
                            <% 
                            }
                            for (int i = 1; i < images.size(); i++) {
                                String imagePath = request.getContextPath() + images.get(i).getImgRoute();
                            %>
                                <div class="carousel-item">
                                    <img src="<%=imagePath%>" class="d-block w-100 img-fluid rounded image-full" alt="Image House">
                                </div>
                            <% 
                            } 
                            %>
                        </div>
                
                        <button class="carousel-control-prev" type="button" data-bs-target="#housingCarousel" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#housingCarousel" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
                
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
                <script>
                    var myCarousel = document.querySelector('#housingCarousel');
                    var carousel = new bootstrap.Carousel(myCarousel, {
                        interval: 3000,
                        wrap: true
                    });
                </script>
                
				<div class="col-md-6 d-flex flex-column justify-content-around"
					style="height: 100%;">
					<h2 class="align-text-top">
						<%=house.getName()%>
					</h2>
					<p class="text-left">
						<%=house.getLocation()%>
					</p>
					<figcaption class="blockquote-footer">
						Type of accommodation: <cite title="Source Title text"> <%=house.getIdType()%>
						</cite>
					</figcaption>
					<div class="list">
						<ul class="nav flex-column">
							<li class="nav-item"><img src="img/guest.png" width="8%"
								class="img-fluid" alt=""> <%=house.getNumGuest()%> guest</li>
							<li class="nav-item"><img src="img/bedroom.png" width="8%"
								class="img-fluid" alt=""> <%=house.getNumBedroom()%>
								bedroom</li>
							<li class="nav-item"><img src="img/bed.png" width="8%"
								class="img-fluid" alt=""> <%=house.getNumBed()%> bed</li>
							<li class="nav-item"><img src="img/bath.png" width="8%"
								class="img-fluid" alt=""> <%=house.getNumBath()%> bath</li>
						</ul>
					</div>
					<div class="textt-left ms-1 mb-4">
						<li>Price <%=house.getPrice()%> € per night.
						</li>
					</div>
				</div>
			</div>

			<div class="description col-12 mt-4">
				<h3>Description</h3>
				<p>
					<%=house.getDescription()%>
				</p>
			</div>

			<div class="row">
				<div class="col-6">
					<h4>Offers</h4>
					<ul class="Offers nav flex-column">
						<%
						for (Facilities f : facilities) {
						%>
						<li class="Offer"><%=f.getTypeFacilities()%></li>
						<%
						}
						%>
					</ul>
				</div>
				<div class="formReserve col-6">
					<h4>Reserve:</h4>
					<div class="mb-3">
						<label for="Check-In" class="form-label">Check-In</label> <input
							type="date" class="form-control" id="formReserve"
							placeholder="dd/mm/aaaa">
					</div>
					<div class="mb-3">
						<label for="Check-Out" class="form-label">Check-Out</label> <input
							type="date" class="form-control" id="formReserve"
							placeholder="dd/mm/aaaa">
					</div>
					<div class="mb-3">
						<label for="guest" class="form-label">Guests</label> <input
							type="number" class="form-control" id="formReserve"
							placeholder="Number of guests">
					</div>
				</div>
			</div>
		</div>
	</main>

	<footer
		class="row row-cols-1 row-cols-sm-2 row-cols-md-5 py-5 my-5 border-top">
		<div class="col mb-3">
			<a href="home.jsp"
				class="d-flex align-items-center mb-3 link-dark text-decoration-none">
				<img src="img/logo_white.png" width="60%" alt="">
			</a>
		</div>
		<div class="col mb-3"></div>

		<div class="col mb-3">
			<h5 id="footer-title">About & Support</h5>
			<ul class="nav flex-column">
				<li class="nav-item mb-3"><a href="#"
					class="nav-link p-0 text-muted">About Us</a></li>
				<li class="nav-item mb-3"><a href="#"
					class="nav-link p-0 text-muted">Contact Us</a></li>
				<li class="nav-item mb-3"><a href="#"
					class="nav-link p-0 text-muted">FAQ</a></li>
			</ul>
		</div>

		<div class="col mb-3">
			<h5 id="footer-title">Explore</h5>
			<ul class="nav flex-column">
				<li class="nav-item mb-3"><a href="#"
					class="nav-link p-0 text-muted">Countryside Retreats</a></li>
				<li class="nav-item mb-3"><a href="#"
					class="nav-link p-0 text-muted">Apartment Stays</a></li>
				<li class="nav-item mb-3"><a href="#"
					class="nav-link p-0 text-muted">Cabin Getaways</a></li>
			</ul>
		</div>

		<div class="col mb-3">
			<h5 id="footer-title">Policies & Security</h5>
			<ul class="nav flex-column">
				<li class="nav-item mb-3"><a href="#"
					class="nav-link p-0 text-muted">Privacy Policy</a></li>
				<li class="nav-item mb-3"><a href="#"
					class="nav-link p-0 text-muted">Term & Conditions</a></li>
				<li class="nav-item mb-3"><a href="#"
					class="nav-link p-0 text-muted">Refund & Cancellation Policy</a></li>
			</ul>
		</div>


		<div class="col-12 text-center mt-4">
			<p class="text-muted">@Jonathan Villamizar - Alfredo Noriega -
				Diana Kopyv</p>
		</div>
	</footer>
</body>

</html>