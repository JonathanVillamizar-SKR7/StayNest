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
	<%@ include file="Header.jsp"%>
	<main>
		<div class="image-container">
			<img src="img/portada_home.jpg" alt="PortadaHome"
				class="portada-image">
			<div class="logo-overlay">
				<img src="img/Logo_right_white.png" alt="StayNest Logo"
					class="logoPortada">
			</div>
		</div>
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
					<button class="btn btn-warning btn-lg mt-3 custom-button"
						style="background-color:"var(--accent-color);">
						<a href="index.jsp" class="text-decoration-none" style=color:var(--dark-color);"> Find your Nest 
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

<%@ include file="Footer.jsp"%>


</html>