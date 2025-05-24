@@ -0,0 +1,234 @@
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="daxbnb.DAO.*"%>
<%@ page import="daxbnb.model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin forms</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="styles/adminPage.css">
<style>
.container {
	margin-top: 50px;
}

.card {
	width: 100%;
	border: none;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	overflow: hidden;
}

.card img {
	width: 100%;
	height: auto;
	object-fit: cover;
}

.card-body {
	padding: 1.5rem;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

.table {
	width: 100%;
	border-collapse: separate;
	border-spacing: 0 15px;
}

.table thead th {
	color: var(--primary-color);
	text-align: center;
	padding: 1rem;
	border-radius: 10px 10px 0 0;
}

.table tbody tr {
	background-color: var(--secundary-color);
	text-align: center;
	vertical-align: middle;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.table tbody td {
	padding: 1rem;
}

.table tbody tr td:last-child {
	display: flex;
	justify-content: center;
	align-items: center;
	gap: 1rem;
}

.table tbody tr img {
	width: 80px;
	height: 80px;
	object-fit: cover;
	border-radius: 50%;
}

.btn {
	padding: 0;
}
</style>
</head>

<body>
	<%
	HousingDAO housingDAO = new HousingDAO();
	HousingImagesDAO imgDAO = new HousingImagesDAO();
	List<Housing> housings = housingDAO.selectAll();
	%>
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
	<main>
		<div class="container-fluid mt-5">
			<div class="row">
				<div class="col-lg-2 col-md-3 col-sm-12 mb-3"
					style="display: flex; flex-direction: column; gap: 0.5rem;">
					<form method="POST">
						<button name="action" value="list_nest"
							class="btn btn-primary btn-menu w-100"
							style="padding: 0.75rem 1.5rem; font-size: 1rem;">Nests</button>
					</form>
					<form method="POST">
						<button name="action" value="insert_nest"
							class="btn btn-primary btn-menu w-100"
							style="padding: 0.75rem 1.5rem; font-size: 1rem;">New
							Nest</button>
					</form>
					<form method="POST">
						<button name="action" value="list_reserves"
							class="btn btn-success btn-menu w-100"
							style="padding: 0.75rem 1.5rem; font-size: 1rem;">Reserves</button>
					</form>
					<form method="POST">
						<button name="action" value="insert_reserve"
							class="btn btn-success btn-menu w-100"
							style="padding: 0.75rem 1.5rem; font-size: 1rem;">New
							reserve</button>
					</form>
					<form method="POST">
						<button name="action" value="list_users"
							class="btn btn-warning btn-menu w-100"
							style="padding: 0.75rem 1.5rem; font-size: 1rem;">Users</button>
					</form>
					<form method="POST">
						<button name="action" value="insert_user"
							class="btn btn-warning btn-menu w-100"
							style="padding: 0.75rem 1.5rem; font-size: 1rem;">New
							User</button>
					</form>
					<form method="POST">
						<button name="action" value="list_facilities"
							class="btn btn-info btn-menu w-100"
							style="padding: 0.75rem 1.5rem; font-size: 1rem;">House
							facilities</button>
					</form>
					<form method="POST">
						<button name="action" value="insert_facility"
							class="btn btn-info btn-menu w-100"
							style="padding: 0.75rem 1.5rem; font-size: 1rem;">New
							house facility</button>
					</form>
					<form method="POST">
						<button name="action" value="logout"
							class="btn btn-danger btn-menu w-100"
							style="padding: 0.75rem 1.5rem; font-size: 1rem;">Logout</button>
					</form>
				</div>
				<div class="col-lg-10 col-md-9 col-sm-12">
					<div class="card">
						<div class="card-header text-center">
							<h2>NEW NEST</h2>
							<form action="">
								<div class="row mb-3">
									<label for="newName" class="col-sm-3 col-form-label">New
										name</label>
									<div class="col-sm-9">
										<input type="text" id="newName" class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="Location" class="col-sm-3 col-form-label">Location</label>
									<div class="col-sm-9">
										<input type="text" id="Location" class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="numGuest" class="col-sm-3 col-form-label">Number
										guests</label>
									<div class="col-sm-9">
										<input type="number" id="numGuest" class="form-control"
											required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="numBedroom" class="col-sm-3 col-form-label">Number
										Bedrooms</label>
									<div class="col-sm-9">
										<input type="number" id="numBedroom" class="form-control"
											required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="numBed" class="col-sm-3 col-form-label">Number
										Beds</label>
									<div class="col-sm-9">
										<input type="number" id="numBed" class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="numBaths" class="col-sm-3 col-form-label">Number
										Baths</label>
									<div class="col-sm-9">
										<input type="number" id="numBaths" class="form-control"
											required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="idTypes" class="col-sm-3 col-form-label">Id
										Type</label>
									<div class="col-sm-9">
										<input type="number" id="idTypes" class="form-control"
											required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="price" class="col-sm-3 col-form-label">Price</label>
									<div class="col-sm-9">
										<input type="number" id="price" class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="description" class="col-sm-3 col-form-label">Description</label>
									<div class="col-sm-9">
										<input type="text" id="description" class="form-control"
											required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="floatingSelect" class="col-sm-3 col-form-label">Available</label>
									<div class="col-sm-9">
										<select class="form-select" id="floatingSelect" required>
											<option value="1">1</option>
											<option value="2">2</option>
										</select>
									</div>
								</div>

								<div class="text-center">
									<button type="submit" class="btn btn-primary w-100">Create
										Nest</button>
								</div>
							</form>


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
				<li class="nav-item mb-3"><a href="aboutUs.jsp"
					class="nav-link p-0 text-muted">About Us</a></li>
				<li class="nav-item mb-3"><a href="contactUs.jsp"
					class="nav-link p-0 text-muted">Contact Us</a></li>
				<li class="nav-item mb-3"><a href="FAQ.jsp"
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
				<li class="nav-item mb-3"><a href="privacyPolicy.jsp"
					class="nav-link p-0 text-muted">Privacy Policy</a></li>
				<li class="nav-item mb-3"><a href="term&conditions.jsp"
					class="nav-link p-0 text-muted">Term & Conditions</a></li>
				<li class="nav-item mb-3"><a href="refund.jsp"
					class="nav-link p-0 text-muted">Refund & Cancellation Policy</a></li>
			</ul>
		</div>
		<div class="col-12 text-center mt-4">
			<p class="text-muted">@Jonathan Villamizar - Alfredo Noriega</p>
		</div>
	</footer>
</body>

</html>