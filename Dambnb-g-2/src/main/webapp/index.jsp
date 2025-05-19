<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="daxbnb.DAO.*"%>
<%@ page import="daxbnb.model.*"%>
<%@ page import="main.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
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
<link rel="stylesheet" href="styles/Index.css">
<title>Index</title>
</head>

<body style="background-color: rgb(236, 238, 248);">

	<%
	HousingDAO h = new HousingDAO();
	%>
	<header>
		<nav class="navbar navbar-expand-lg " style="background-color: white;">
			<a class="navbar-link" href="#"> <img
				src="img/Logo_transparente.png" width="10%" alt="">
			</a>
			<div class="d-flex align-items-center ms-auto">
				<a class="nav-link me-3" style="font-size: 1em;" href="">STAYS</a> <a
					href=""> <img src="img/user.png" alt="" width="35" height="35">
				</a>
			</div>

		</nav>
		<main>
			<nav class="navbar navbar-expand-lg justify-content-center py-5">
				<a class="nav-link me-5 nav-link-custom" href="">ALL</a> <a
					class="nav-link me-5 nav-link-custom" href="">CABIN</a> <a
					class="nav-link me-5 nav-link-custom" href="">TINY HOME</a> <a
					class="nav-link me-5 nav-link-custom" href="">APARTMENT</a> <a
					class="nav-link me-5 nav-link-custom" href="">COUNTRYSIDE</a> <a
					class="nav-link me-5 nav-link-custom" href="">VILLA</a>
			</nav>

			<nav class="navbar navbar-expand-lg py-3">
				<div
					class="container d-flex justify-content-between align-items-center">
					<div class="d-flex align-items-center">
						<span>How many rooms are you Resting in? &nbsp; </span> <a
							class="nav-link me-5 nav-link-custom" href="">+1</a> <a
							class="nav-link me-5 nav-link-custom" href="">+2</a> <a
							class="nav-link me-5 nav-link-custom" href="">+3</a>
					</div>
					<form class="form-inline d-flex ms-auto">
						<input class="form-control mr-sm-2 me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
				</div>
			</nav>
			<div class="container-fluid d-flex justify-content-center">
				<div class="card-deck p-5">
					<div class="row">
						<%
						List<Housing> house = h.selectAll();
						for (Housing f : house) {
						%>
						<div class="col-md-4 mb-3">
							<a href="home.jsp" class="text-decoration-none">
								<div class="card">
									<img class="card-img-top" src="img/1-1.jpg"
										alt="Card image cap">
									<div class="card-body">
										<h3 class="card-title"><%=f.getName()%></h3>
										<h5 class="card-text text-muted"><%=f.getLocation()%></h5>
										<br>
										<h5 class="card-text text-muted"><%=f.getNumGuest()%>
											guests -
											<%=f.getNumBedroom()%>
											bedrooms -
											<%=f.getNumBed()%>
											beds -
											<%=f.getNumBath()%>
											bath
										</h5>
										<br>
										<h5 class="card-text"><%=f.getPrice()%>
											€
										</h5>
										<span class="stretched-link"></span>
									</div>
								</div>
							</a>
						</div>

						<%
						}
						%>
					</div>
				</div>
			</div>
		</main>
	</header>
</body>

</html>