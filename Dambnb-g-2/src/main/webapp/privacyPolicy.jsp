<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Privacy Policy - StayNest</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="styles/info.css">
</head>

<body>
	<header>
		<nav
			class="d-flex justify-content-between align-items-center shadow-sm w-100"
			style="background-color: white;">
			<div class="logo">
				<a href="home.jsp"><img src="img/Logo_right.png" alt="StayNest"
					class="logo"></a>
			</div>
			<div class="menu d-flex align-items-center gap-4">
				<a href="index.jsp" class="nav-link-custom">STAYS</a> <a
					href="login.jsp"><img src="img/user.png" alt="User Icon"
					class="User-Icon"></a>
			</div>
		</nav>
	</header>

	<main class="container my-5">
		<section>
			<h1 class="mb-4">Privacy Policy</h1>
			<p>At StayNest, your privacy is our priority. This Privacy Policy
				explains the types of personal information we collect, how we use
				it, and the security measures we employ to protect your data.</p>

			<h5 class="mt-4">Information We Collect</h5>
			<ul>
				<li>Personal Information: Name, email address, phone number,
					etc.</li>
				<li>Payment Details: Information required to complete bookings.</li>
				<li>Location Data: To enhance search accuracy and improve user
					experience.</li>
			</ul>

			<h5 class="mt-4">How We Use Your Information</h5>
			<ul>
				<li>To process bookings and manage reservations.</li>
				<li>To personalize your experience and suggest relevant stays.</li>
				<li>To communicate updates, promotions, and support.</li>
			</ul>

			<h5 class="mt-4">Data Security</h5>
			<p>We implement advanced security protocols to safeguard your
				personal information. All data is encrypted and stored securely,
				accessible only to authorized personnel.</p>

			<h5 class="mt-4">Your Rights</h5>
			<p>
				You have the right to access, modify, or delete your personal data
				at any time. For assistance, contact us at <a
					href="mailto:support@staynest.com">support@staynest.com</a>.
			</p>

			<p class="mt-4">We are committed to maintaining your trust and
				ensuring your privacy is protected with the highest standards of
				security.</p>
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
