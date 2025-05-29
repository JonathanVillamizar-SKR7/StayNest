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
<link rel="stylesheet" href="styles/Login.css">
<title>Login</title>
</head>

<body>
	<%
	UserDAO uS = new UserDAO();
	User u = new User();
	if ("POST".equalsIgnoreCase(request.getMethod())) {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = uS.selectByEmailandPassword(email, password);
			String username = user.getUserName();
			String userType = user.getUserType();
			int id = user.getIdUser();
			if (user != null) {
		session.setAttribute("username", username);
		session.setAttribute("userType", userType);
		session.setAttribute("idUser", id);

		if (user.getUserType().equals("client")) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("index.jsp");
		}
			} else {
		//tira excepcion personalizada de no existe email y password 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	%>
	<header>
		<nav
			class="d-flex justify-content-between align-items-center shadow-sm w-100"
			style="background-color: white;">
			<div class="logo">
				<a href="home.jsp"> <img src="img/Logo_right.png" alt="StayNest"
					class="logo">
				</a>
			</div>
			<div class="menu d-flex align-items-center gap-4">
				<a href="index.jsp" class="nav-link-custom">STAYS</a> <a
					href="login.jsp"> <img src="img/user.png" alt="User Icon"
					class="User-Icon">
				</a>
			</div>
		</nav>
	</header>
	<main>
		<div class="figura">
			<div class="login">
				<form method="POST">
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
						If you don't have and account&nbsp; <a href="SingUp.jsp">
							register</a>&nbsp; now
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
<%@ include file="Footer.jsp"%>

</html>