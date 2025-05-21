<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="daxbnb.DAO.UserDAO"%>
<%@ page import="daxbnb.DAO.ReservesDAO"%>

<%@ page import="daxbnb.model.*"%>
<%@ page import="main.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="styles/Index.css">
<title>User Details</title>
</head>
<body>
	<%
	UserDAO userDAO = new UserDAO();
	ReservesDAO resDAO = new ReservesDAO();
	String username = null;
	String userType = null;
	if (session != null) {
		username = (String) session.getAttribute("username");
		out.println(username);
		System.out.println(username);
		userType = (String) session.getAttribute("userType");
	}
	User user = userDAO.selectByUserName("Alfredo");
	%>
	<main>
		<div class="p-5">
			<h1>Details</h1>
			<div class="card" style="width: 100%;">
				<div class="card-body">
					<h2 class="card-text">
						Username:<%=user.getUserName()%></h2>
					<h3 class="card-text">
						Password:<%=user.getPassword()%></h3>
					<h3 class="card-text">
						UserType:<%=user.getUserType()%></h3>
					<h3 class="card-text">
						Description:
						<%=user.getUserDescription()%></h3>
				</div>
			</div>
		</div>
		<div>
			<table class="table table-striped">
				<thead>
					<th scope="col"></th>
					<th scope="col">ID</th>
					<th scope="col">Stay</th>
					<th scope="col">Start</th>
					<th scope="col">Finish</th>
					<th scope="col">Num.Guest</th>
					<th scope="col">Total</th>
				</thead>
				<%-- Hacer con un for el body --%>
				<%
				List<Reserves> reserves = resDAO.selectByIdUser(user.getIdUser());
				for (Reserves a : reserves) {
				%>
				<tbody>
					<tr>
						<th scope="row" style="width: 15%;"><img src="img/1-1.jpg"
							alt="" height="80rem"></th>
						<td class="align-middle"><%=a.getHousing().getIdHouse()%></td>
						<td class="align-middle"><%=a.getHousing().getDescription()%></td>
						<td class="align-middle"><%=a.getCheckIn()%></td>
						<td class="align-middle"><%=a.getCheckOut()%></td>
						<td class="align-middle"><%=a.getNumGuests()%></td>
						<td class="align-middle"><%=a.getTotalPrice()%></td>
					</tr>
				</tbody>
				<%
				}
				%>
			</table>
		</div>

	</main>
</body>
</html>