<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>FAQ</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="styles/info.css">
</head>

<body>
	<header>
		<nav class="d-flex justify-content-between align-items-center shadow-sm w-100" style="background-color: white;">
			<div class="logo">
				<a href="home.jsp"><img src="img/Logo_right.png" alt="StayNest" class="logo"></a>
			</div>
			<div class="menu d-flex align-items-center gap-4">
				<a href="index.jsp" class="nav-link-custom">STAYS</a>
				<a href="login.jsp"><img src="img/user.png" alt="User Icon" class="User-Icon"></a>
			</div>
		</nav>
	</header>

	<main class="container my-5">
		<section>
			<h1 class="mb-4">Frequently Asked Questions (FAQ)</h1>
			<p>Find quick answers to the most common questions about StayNest.</p>

			<h5 class="mt-4">Booking Questions</h5>
			<ul>
				<li><strong>How do I book a stay?</strong><br>Simply search for your destination, select your dates, and choose your preferred accommodation.</li>
				<li><strong>Can I modify or cancel my booking?</strong><br>Yes, you can modify or cancel your booking through your StayNest account, based on the cancellation policy of the accommodation.</li>
				<li><strong>Are there any hidden fees?</strong><br>No, our pricing is transparent and what you see is what you pay.</li>
			</ul>

			<h5 class="mt-4">Payment Questions</h5>
			<ul>
				<li><strong>What payment methods do you accept?</strong><br>We accept major credit cards, PayPal, and bank transfers.</li>
				<li><strong>Is my payment information secure?</strong><br>Absolutely. We use state-of-the-art encryption to protect your data.</li>
			</ul>

			<h5 class="mt-4">Support Questions</h5>
			<ul>
				<li><strong>How can I contact customer service?</strong><br>You can reach us 24/7 via live chat, email, or phone.</li>
				<li><strong>What if I encounter an issue during my stay?</strong><br>Our support team is available around the clock to assist you with any concerns.</li>
			</ul>

			<p class="mt-4">Still have questions? Contact us at <a href="mailto:support@staynest.com">support@staynest.com</a> – we’re here to help!</p>
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
