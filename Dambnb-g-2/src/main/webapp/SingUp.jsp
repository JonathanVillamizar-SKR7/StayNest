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
<link rel="stylesheet" href="styles/SingUp.css">
<title>Sing Up</title>
</head>

<body>
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
			<div class="singUp">
				<form action="">
					<H1>Sing Up</H1>
					<div>
						<input type="text" name="userName" id="userName" required>
						<label for="userName">userName</label>
					</div>
					<div>
						<input type="email" name="email" id="email" required> <label
							for="email">Email</label>
					</div>
					<div>
						<input type="password" name="password" id="password" required>
						<label for="password">Password</label>
					</div>
					<div class="button_singup">
						<button type="submit">Sing Up</button>
					</div>
					<p>
						If you have and account &nbsp;<a href="login.jsp"> Log in </a>&nbsp;
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
	<%@ include file="Footer.jsp"%>

</body>

</html>