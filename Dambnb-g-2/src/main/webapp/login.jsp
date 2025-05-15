<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="styles/Login.css">
<title>Login</title>
</head>

<body>
		<nav class="d-flex justify-content-between align-items-center">
			<div class="logo">
				<a href="home.jsp"> <img src="img/Logo_right.png" alt="StayNest"
					class="logo">
				</a>
			</div>
			<div class="menu d-flex align-items-center">
				<a href="index.jsp" class="Index m-lg-4">STAYS</a> <a
					href="login.jsp"> <img src="img/user.png" alt="User Icon"
					class="User-Icon m-4">
				</a>
			</div>
		</nav>
	<main>
		<div class="figura">
			<div class="login">
				<form action="">
					<H1>LOG IN</H1>
					<div>
						<input type="email" name="email" id="email" required> <label
							for="email">Email</label>
					</div>
					<div>
						<input type="password" name="password" id="password" required>
						<label for="password">Password</label>
					</div>
					<div class="button_login">
						<button type="submit">LOGIN</button>
					</div>
					<p>
						If you don't have and account&nbsp; <a href=""> register</a>&nbsp;
						now
					</p>
				</form>
				<div class="logoCorner_content">
					<img class="logo_corner"
						src="<%=request.getContextPath()%>/img/Logo_transparente.png"
						alt="Logo">
				</div>
			</div>
		</div>
	</main>
</body>
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
		<p class="text-muted">@Jonathan Villamizar - Alfredo Noriega</p>
	</div>
</footer>
</html>