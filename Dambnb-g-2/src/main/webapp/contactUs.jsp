<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Contact Us</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="styles/info.css">
</head>

<body>
		<%@ include file="Header.jsp" %>


	<main class="container my-5">
		<section>
			<h1 class="mb-4">Contact Us</h1>
			<p>We’re here to help you 24/7. Whether you have questions about your booking, need assistance with cancellations, or want to learn more about our services, don’t hesitate to reach out.</p>

			<h5 class="mt-4">How to Reach Us</h5>
			<ul>
				<li>Email: support@staynest.com</li>
				<li>Phone: +34 633 13 06 12</li>
				<li>Live Chat: Available on our website for instant support.</li>
			</ul>

			<h5 class="mt-4">Office Address</h5>
			<p>Ilerna Barcelona, Carrer de Pelai, 8, 08001 Barcelona, Spain</p>

			<h5 class="mt-4">Social Media</h5>
			<ul>
				<li><a href="https://facebook.com/staynest" target="_blank">Facebook</a></li>
				<li><a href="https://twitter.com/staynest" target="_blank">Twitter</a></li>
				<li><a href="https://instagram.com/staynest" target="_blank">Instagram</a></li>
			</ul>

			<p class="mt-4">Feel free to contact us anytime. We are dedicated to providing the best experience for our guests and hosts.</p>
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
