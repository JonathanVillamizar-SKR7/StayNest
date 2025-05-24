<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Terms & Conditions - StayNest</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="styles/info.css">
</head>

<body>
		<%@ include file="Header.jsp" %>

	<main class="container my-5">
		<section>
			<h1 class="mb-4">Terms & Conditions</h1>
			<p>Welcome to StayNest! These terms and conditions outline the
				rules and regulations for the use of our platform and services.</p>

			<h5 class="mt-4">Booking Policy</h5>
			<ul>
				<li>All bookings are subject to availability and confirmation.</li>
				<li>Payments must be completed through our secure platform.</li>
				<li>Cancellation policies are set by the property owners and
					are clearly stated during the booking process.</li>
			</ul>

			<h5 class="mt-4">User Responsibilities</h5>
			<ul>
				<li>Users must provide accurate information during registration
					and booking.</li>
				<li>Misuse of the platform or fraudulent activities will result
					in account suspension.</li>
			</ul>

			<h5 class="mt-4">Property Rules</h5>
			<ul>
				<li>Each accommodation may have its own set of rules (e.g.,
					check-in times, pet policies, etc.).</li>
				<li>Users are responsible for respecting the property and its
					regulations.</li>
			</ul>

			<h5 class="mt-4">Liability</h5>
			<p>StayNest is not liable for personal injuries, damages, or loss
				of property during your stay. We act as an intermediary between
				guests and property owners.</p>

			<p class="mt-4">
				By using our platform, you agree to comply with these terms and
				conditions. For questions, contact us at <a
					href="mailto:support@staynest.com">support@staynest.com</a>.
			</p>
		</section>
	</main>

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
</body>
</html>
