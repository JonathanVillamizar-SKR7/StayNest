<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"%>
<%@ page import="daxbnb.model.Housing"%>
<%@ page import="daxbnb.model.Types"%>
<jsp:directive.page import="java.util.List" />

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
<link ref="stylesheet" src="styles/styles.css" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<h1>Project Test</h1>
	<p>This is a paragraph</p>

	<%
	//public Housing(int idHouse, String name, String location, int numGuest, int numBedroom, int numBed, int numBath,
	//		int idType, double price, List<Images> images, List<Facilities> facilities)

	Housing housing = new Housing(1, "Casita de paja", "BCN", 2, 1, 4, 2, Types.CABIN, 2.45);
	Housing housing1 = new Housing(2, "Casita de hierro", "BCN", 2, 1, 4, 2, Types.CABIN, 2.45);
	Housing housing2 = new Housing(3, "Casita de acero", "BCN", 2, 1, 4, 2, Types.CABIN, 2.45);

	List<Housing> housings = new ArrayList<>();
	housings.add(housing);
	housings.add(housing1);
	housings.add(housing2);

	//for (Housing s : housings) {
	//out.println(s);
	//}
	%>
	<table class="table">
		<thead>
			<tr>

				<th>ID</th>
				<th>Title</th>

			</tr>

		</thead>
		<tbody>
			<%
			for (Housing s : housings) {
			%>
			<tr>
				<td><%=s.getIdHouse()%></td>
				<td><%=s.getName()%></td>

			</tr>
			<%
			}
			%>
		</tbody>
	</table>



	<form method="post">
		<input type="hidden" name="action" value="select" />
		<div>
			<label for="ID" class="form-label">Give me the IdHouse:</label> <input
				type="text" id="ID" name="ID"
				value="<%=request.getParameter("ID") != null ? request.getParameter("ID") : ""%>">
		</div>
		<div>
			<label for="nameHouse" class="form-label">Give me the
				nameHouse</label> <input type="text" id="nameHouse" name="nameHouse"
				value="<%=request.getParameter("nameHouse") != null ? request.getParameter("nameHouse") : ""%>">
		</div>
		<br />
		<div>
			<button type="submit" class="btn btn-primary">Select</button>
		</div>
	</form>

	<%
	String action = "";
	if ("POST".equalsIgnoreCase(request.getMethod())) {
		action = request.getParameter("action");

		switch (action) {
		case "select":
			out.println("Select");

			int id = Integer.parseInt(request.getParameter("ID"));
			String name = request.getParameter("nameHouse");

			List<Housing> newList = new ArrayList<>();

			for (Housing h : housings) {
		if (h.getIdHouse() == id && h.getName().toUpperCase().contains(name.toUpperCase())) {
			newList.add(h);
		}

			}

			for (Housing h : newList) {
		out.println(h.getIdHouse() + " " + h.getName());
			}
			break;
		default:
		}
	}
	%>


</body>
</html>