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
<title>Admin - Housing List</title>
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
	height: 100%;
}

.btn-menu {
	width: 100%;
	margin-bottom: 10px;
}

.text {
	margin: 20px;
}

.table td img {
	width: 80px;
	height: auto;
	object-fit: cover;
	border-radius: 8px;
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
		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<form method="POST">
						<button name="action" value="list_nest"
							class="btn btn-primary btn-menu">Nests</button>
					</form>
					<form method="POST">
						<button name="action" value="insert_nest"
							class="btn btn-primary btn-menu">New Nest</button>
					</form>
					<form method="POST">
						<button name="action" value="list_reserves"
							class="btn btn-success btn-menu">Reserves</button>
					</form>
					<form method="POST">
						<button name="action" value="insert_reserve"
							class="btn btn-success btn-menu">New reserve</button>
					</form><form method="POST">
						<button name="action" value="list_users"
							class="btn btn-warning btn-menu">Users</button>
					</form><form method="POST">
						<button name="action" value="insert_user"
							class="btn btn-warning btn-menu">New User</button>
					</form><form method="POST">
						<button name="action" value="list_facilities"
							class="btn btn-info btn-menu">House facilities</button>
					</form><form method="POST">
						<button name="action" value="insert_facility"
							class="btn btn-info btn-menu">New house facility</button>
					</form><form method="POST">
						<button name="action" value="logout"
							class="btn btn-danger btn-menu">Logout</button>
					</form>
				</div>
				<div class="col-md-10">
					<div class="card">
						<div class="card-header">
							<h2 class="text-center">NESTS</h2>
						</div>
						<div class="card-body">
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>Image</th>
										<th>ID</th>
										<th>Name</th>
										<th>Price</th>
										<th>Type</th>
										<th>Guests</th>
										<th>Bedrooms</th>
										<th>Bed</th>
										<th>Bath</th>
                                        <th>Options</th>
									</tr>
								</thead>
								<tbody>
									<%
									for (Housing h : housings) {
										List<Images> imgs = imgDAO.selectImagesByHousingId(h.getIdHouse());
										String imagePath = (!imgs.isEmpty()) ? request.getContextPath() + imgs.get(0).getImgRoute() : "img/default.jpg";
									%>
									<tr style="background-color: var(--secundary-color);">
										<td><img src="<%=imagePath%>" alt="Housing Image"></td>
										<td><%=h.getIdHouse()%></td>
										<td><%=h.getName()%></td>
										<td><%=h.getPrice()%></td>
										<td><%=h.getIdType()%></td>
										<td><%=h.getNumGuest()%></td>
										<td><%=h.getNumBedroom()%></td>
										<td><%=h.getNumBed()%></td>
										<td><%=h.getNumBath()%></td>
										<td class="btn btn-warning" style="width: 20%; align-items:center; justify-content: center;"><img src="img/edit.png" style="width: 50%;" alt="">										<td class="btn btn-danger" style="width: 20%;align-items:center; justify-content: center;" ><img src="img/delete.png" style="width: 50%;" alt=""></td>
										</td>
										
									</tr>
									<%
									}
									%>
								</tbody>
							</table>
						</div>
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
			<p class="text-muted">@Jonathan Villamizar - Alfredo Noriega -
				Diana Kopyv</p>
		</div>
	</footer>
</body>
</html>
