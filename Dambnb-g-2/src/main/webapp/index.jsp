<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="daxbnb.DAO.*"%>
<%@ page import="daxbnb.model.*"%>
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
<body>

	<%
	HousingDAO h = new HousingDAO();
	HousingImagesDAO imgDAO = new HousingImagesDAO();
	List<Housing> houses;

	String minBedroomsParam = request.getParameter("minBedrooms");
	String bedroomParam = request.getParameter("numBedroom");
	String idTypeParam = request.getParameter("idType");

	if (minBedroomsParam != null) {
		int minBedrooms = Integer.parseInt(minBedroomsParam);
		houses = h.selectHousingByBedroomGreaterThanOrEqual(minBedrooms);
	} else if (bedroomParam != null) {
		int numBedroom = Integer.parseInt(bedroomParam);
		houses = h.selectHousingByBedroom(numBedroom);
	} else if (idTypeParam != null) {
		int idType = Integer.parseInt(idTypeParam);
		houses = h.selectHousingByType(idType);
	} else {
		houses = h.selectAll();
	}
	%>

	<%@ include file="Header.jsp"%>

	<main style="background-color: white;">
		<nav
			class="navbar navbar-expand-lg justify-content-center py-5 shadow-sm"
			style="background-color: white;">
			<a class="nav-link me-5 nav-link-custom" href="index.jsp">ALL</a> <a
				class="nav-link me-5 nav-link-custom" href="index.jsp?idType=1">CABIN</a>
			<a class="nav-link me-5 nav-link-custom" href="index.jsp?idType=2">TINY
				HOME</a> <a class="nav-link me-5 nav-link-custom"
				href="index.jsp?idType=3">APARTMENT</a> <a
				class="nav-link me-5 nav-link-custom" href="index.jsp?idType=4">COUNTRYSIDE</a>
			<a class="nav-link me-5 nav-link-custom" href="index.jsp?idType=5">VILLA</a>
		</nav>

		<nav class="navbar navbar-expand-lg py-3 shadow-sm"
			style="background-color: white;">
			<div
				class="container d-flex justify-content-between align-items-center">
				<div class="d-flex align-items-center">
					<span>How many rooms are you Resting in? &nbsp;&nbsp;&nbsp;</span>
					<a class="nav-link me-5 nav-link-custom" href="index.jsp">&nbsp;&nbsp;All</a>
					<a class="nav-link me-5 nav-link-custom"
						href="index.jsp?numBedroom=1">1</a> <a
						class="nav-link me-5 nav-link-custom"
						href="index.jsp?numBedroom=2">2</a> <a
						class="nav-link me-5 nav-link-custom"
						href="index.jsp?minBedrooms=3">3+</a>
				</div>
				<form class="form-inline d-flex ms-auto">
					<input class="form-control mr-sm-2 me-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn Search my-2 my-sm-0"
						style="color: var(--warning-color); background-color: var(--primary-color);"
						type="submit">Search</button>
				</form>
			</div>
		</nav>

		<div class="container- justify-content-center">
			<div class="card-deck p-5">
				<div class="row">
					<%
					for (Housing f : houses) {
						List<Images> imgs = imgDAO.selectImagesByHousingId(f.getIdHouse());
						String firstImg = (imgs != null && !imgs.isEmpty()) ? request.getContextPath() + imgs.get(0).getImgRoute()
						: "img/default.jpg";
					%>
					<div class="col-lg-6 col-xl-4 mb-3">
						<a href="housing.jsp?id=<%=f.getIdHouse()%>"
							class="text-decoration-none">
							<div class="card h-100"
								style="background-color: white; border-color: transparent;">
								<img class="card-img-top"
									style="height: 400px; object-fit: cover;" src="<%=firstImg%>"
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
	<%@ include file="Footer.jsp"%>


</body>
</html>
