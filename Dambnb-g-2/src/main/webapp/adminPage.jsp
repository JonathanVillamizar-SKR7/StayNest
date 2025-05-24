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

	String action = "";
	if ("POST".equalsIgnoreCase(request.getMethod())) {
		try {
			action = request.getParameter("action");

			switch (action) {
			case "list_nest":

		break;
			case "delete_house":
		String deleteId = request.getParameter("houseId");
		if (deleteId != null) {
			HousingDAO dao = new HousingDAO();
			dao.deleteHousing(Integer.parseInt(deleteId));
		}
		response.sendRedirect("adminPage.jsp?action=list_nest");
		break;

			default:
		out.println("<div class='alert alert-warning' role='alert'>Action not found</div>");

			}
		} catch (Exception e) {
			out.println("<div class='alert alert-danger' role='alert'>ERROR: " + e.getMessage() + "</div>");
		}
	}
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
							class="btn btn-primary btn-menu w-100">Nests</button>
					</form>
					<form method="POST">
						<button name="action" value="insert_nest"
							class="btn btn-primary btn-menu w-100">New Nest</button>
					</form>
					<form method="POST">
						<button name="action" value="list_reserves"
							class="btn btn-success btn-menu w-100">Reserves</button>
					</form>
					<form method="POST">
						<button name="action" value="insert_reserve"
							class="btn btn-success btn-menu w-100">New reserve</button>
					</form>
					<form method="POST">
						<button name="action" value="list_users"
							class="btn btn-warning btn-menu w-100">Users</button>
					</form>
					<form method="POST">
						<button name="action" value="insert_user"
							class="btn btn-warning btn-menu w-100">New User</button>
					</form>
					<form method="POST">

						<button name="action" value="list_facilities"
							class="btn btn-info btn-menu w-100">House facilities</button>
					</form>
					<form method="POST">
						<button name="action" value="insert_facility"
							class="btn btn-info btn-menu w-100">New house facility</button>
					</form>
					<form method="POST">
						<button name="action" value="logout"
							class="btn btn-danger btn-menu w-100">Logout</button>
					</form>
				</div>
				<div class="col-lg-10 col-md-9 col-sm-12">
					<div class="card">
						<%
						if ("list_nest".equals(action)) {
						%>
						<div class="card-header text-center">
							<h2>NESTS</h2>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table">
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
										<tr>
											<td><img src="<%=imagePath%>" alt="Housing Image"></td>
											<td><%=h.getIdHouse()%></td>
											<td><%=h.getName()%></td>
											<td><%=h.getPrice()%></td>
											<td><%=h.getIdType()%></td>
											<td><%=h.getNumGuest()%></td>
											<td><%=h.getNumBedroom()%></td>
											<td><%=h.getNumBed()%></td>
											<td><%=h.getNumBath()%></td>
											<td>
												<form method="POST" style="display: inline;">
													<input type="hidden" name="houseId"
														value="<%=h.getIdHouse()%>">
													<button type="submit" name="action" value="edit_house"
														class="btn btn-warning">
														<img src="img/edit.png" alt="Edit"
															style="width: 30px; height: 30px;">
													</button>
												</form>
												<form method="POST" style="display: inline;">
													<input type="hidden" name="houseId"
														value="<%=h.getIdHouse()%>">
													<button type="submit" name="action" value="delete_house"
														class="btn btn-danger">
														<img src="img/delete.png" alt="Delete"
															style="width: 30px; height: 30px;">
													</button>
												</form>
											</td>
										</tr>
										<%
										}
										%>
									</tbody>
								</table>
							</div>
						</div>
						<%
						}
						if ("".equals(action)) {
						%>
						<p>sfasdasdasdasdasdasdas</p>
						<%
						}
						%>
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