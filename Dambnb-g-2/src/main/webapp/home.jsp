<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>StayNest</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="styles/home.css">
</head>

<body>
		<%@ include file="Header.jsp" %>
	<main>
		<div class="container">
			<h2 class="fw-bold">Featured houses</h2>
			<div class="row">
				<div class="col-lg-4">
					<div class="card my-3 ">
						<a href="housing.jsp?id=7" class="text-decoration-none"> <img
							class="card-img-top img-fluid" src="img/7-1.jpg" alt="Card image">
							<div class="card-body">
								<h4 class="card-title" style="color: var(--dark-color);">Villa
									Stay 7</h4>
								<p class="card-text">Port James, Portugal</p>
							</div>
						</a>
					</div>
				</div>

				<div class="col-lg-4">
					<div class="card my-3">
						<a href="housing.jsp?id=6" class="text-decoration-none"> <img
							class="card-img-top img-fluid" src="img/6-1.jpg" alt="Card image">
							<div class="card-body">
								<h4 class="card-title" style="color: var(--dark-color);">Cabin
									Stay 6</h4>
								<p class="card-text">South Beverlyview, France</p>
							</div>
						</a>
					</div>
				</div>

				<div class="col-lg-4">
					<div class="card my-3">
						<a href="housing.jsp?id=1" class="text-decoration-none"> <img
							class="card-img-top img-fluid" src="img/1-1.jpg" alt="Card image">
							<div class="card-body">
								<h4 class="card-title" style="color: var(--dark-color);">Countryside
									Stay 1</h4>
								<p class="card-text">Stewartmouth, Germany</p>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>

		<div class="container my-5">
			<div class="row align-items-center">
				<div class="col-md-6 d-flex flex-column justify-content-around"
					style="height: 100%;">
					<h2 class="text mb-4 fw-bold">Book with us</h2>
					<ul class="list-unstyled info-list">
						<li>
							<h5 class="fw-bold">Flexible cancellation</h5>
							<p class="text-muted">We adapt our policies so you can travel
								worry-free.</p>
						</li>
						<li>
							<h5 class="fw-bold">Quality verification</h5>
							<p class="text-muted">All accommodations are evaluated to
								ensure a safe and comfortable experience.</p>
						</li>
						<li>
							<h5 class="fw-bold">Exclusive offers</h5>
							<p class="text-muted">Access unique discounts only available
								at StayNest.</p>
						</li>
					</ul>
					<button class="btn btn-warning btn-lg mt-3 custom-button">
						<a href="index.jsp" class="text-decoration-none"
							style="color: var(--dark-color);"> Find your Nest 
					</button>
					</a>
				</div>

				<div class="col-md-6">
					<img src="img/inmobiliaria.jpg" alt="Beautiful Stay"
						class="img-fluid rounded image-full">
				</div>
			</div>
		</div>
	</main>
</body>

<footer class="row row-cols-1 row-cols-sm-2 row-cols-md-5 py-5 my-5 border-top">
		<div class="col mb-3">
			<a href="home.jsp" class="d-flex align-items-center mb-3 link-dark text-decoration-none">
				<img src="img/logo_white.png" width="60%" alt="">
			</a>
		</div>
		<div class="col mb-3"></div>
		<div class="col mb-3">
			<h5 id="footer-title">About & Support</h5>
			<ul class="nav flex-column">
				<li class="nav-item mb-3"><a href="aboutUs.jsp" class="nav-link p-0 text-muted">About Us</a></li>
				<li class="nav-item mb-3"><a href="contactUs.jsp" class="nav-link p-0 text-muted">Contact Us</a></li>
				<li class="nav-item mb-3"><a href="FAQ.jsp" class="nav-link p-0 text-muted">FAQ</a></li>
			</ul>
		</div>
		<div class="col mb-3">
			<h5 id="footer-title">Explore</h5>
			<ul class="nav flex-column">
				<li class="nav-item mb-3"><a href="#" class="nav-link p-0 text-muted">Countryside Retreats</a></li>
				<li class="nav-item mb-3"><a href="#" class="nav-link p-0 text-muted">Apartment Stays</a></li>
				<li class="nav-item mb-3"><a href="#" class="nav-link p-0 text-muted">Cabin Getaways</a></li>
			</ul>
		</div>
		<div class="col mb-3">
			<h5 id="footer-title">Policies & Security</h5>
			<ul class="nav flex-column">
				<li class="nav-item mb-3"><a href="privacyPolicy.jsp" class="nav-link p-0 text-muted">Privacy Policy</a></li>
				<li class="nav-item mb-3"><a href="term&conditions.jsp" class="nav-link p-0 text-muted">Term & Conditions</a></li>
				<li class="nav-item mb-3"><a href="refund.jsp" class="nav-link p-0 text-muted">Refund & Cancellation Policy</a></li>
			</ul>
		</div>
		<div class="col-12 text-center mt-4">
			<p class="text-muted">@Jonathan Villamizar - Alfredo Noriega - Diana Kopyv</p>
		</div>
	</footer>

</html>