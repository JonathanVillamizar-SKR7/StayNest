<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Header</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="styles/home.css">
</head>
<body>
	<%
	String username = null;
	String userType = null;
	if (session != null) {
		username = (String) session.getAttribute("username");
		userType = (String) session.getAttribute("userType");
	}
	%>
	<header>
		<nav
			class="d-flex justify-content-between align-items-center shadow-sm w-100">
			<div class="logo">
				<a href="home.jsp"> <img src="img/Logo_right.png" alt="StayNest"
					class="logo">
				</a>
			</div>
			<%
			if (username == null) {
			%>
			<div class="menu d-flex align-items-center gap-4">
				<a href="index.jsp" class="nav-link-custom">STAYS</a>
				 <a href="login.jsp"> <img	src="img/user.png" alt="User Icon" class="User-Icon">
				</a>
			</div>
			<%
			} else {
			if (userType.equals("client")) {
			%>
			<div class="menu d-flex align-items-center gap-4">
				<span>Welcome <%=username%></span> <a href="index.jsp"
					class="nav-link-custom">STAYS</a> <a href="userDetails.jsp?username=<%=username%>"> <img
					src="img/user.png" alt="User Icon" class="User-Icon">
				</a> <a href="login.jsp"> <img
					src="img/log_outStayNest.png" alt="User Icon" class="User-Icon">
				</a>
			</div>
			<%
			} else {
			%>
			<div class="menu d-flex align-items-center gap-4">
				<span>Welcome <%=username%></span> <a href="index.jsp"
					class="nav-link-custom">STAYS</a> <a href="userDetails.jsp?username=<%=username%>"> <img
					src="img/user_admin.png" alt="User Icon" class="User-Icon">
				</a> <a href="login.jsp"> <img
					src="img/log_outStayNest.png" alt="User Icon" class="User-Icon">
				</a>
			</div>
			<%
			}
			}
			%>
		</nav>
	</header>
</body>
</html>