<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="daxbnb.DAO.*"%>
<%@ page import="daxbnb.model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%!public double calcularPrecioTotal(java.util.Date checkIn, java.util.Date checkOut, double precioPorNoche) {
		long diffMillis = checkOut.getTime() - checkIn.getTime();
		long noches = diffMillis / (1000 * 60 * 60 * 24);
		return noches * precioPorNoche;
	}%>

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
	width: 4rem;
	height: 3rem;
}

body {
	background-color: white;
}
</style>

<script>
	function confirmDelete() {
		return confirm("Are you sure you want to delete this nest?");
	}
</script>

</head>

<body>
	<%
	HousingDAO housingDAO = new HousingDAO();
	HousingImagesDAO imgDAO = new HousingImagesDAO();
	UserDAO userDAO = new UserDAO();
	ReservesDAO reservesDAO = new ReservesDAO();
	List<Housing> housings = housingDAO.selectAll();
	List<User> users = userDAO.selectAll();
	List<Reserves> reserves = reservesDAO.selectAll();
	String successMessage = null;
	String errorMessage = null;

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
		successMessage = "Nest deleted successfully!";
		break;

			case "edit_house":

		break;

			case "submit_edit_house": {
		int idHouse = Integer.parseInt(request.getParameter("houseId"));
		String name = request.getParameter("editName");
		String location = request.getParameter("editLocation");
		int numGuest = Integer.parseInt(request.getParameter("editGuests"));
		int numBedroom = Integer.parseInt(request.getParameter("editBedrooms"));
		int numBed = Integer.parseInt(request.getParameter("editBed"));
		int numBath = Integer.parseInt(request.getParameter("editBath"));
		int idType = Integer.parseInt(request.getParameter("editType"));
		double price = Double.parseDouble(request.getParameter("editPrice"));
		String description = request.getParameter("editDescription");
		boolean available = "1".equals(request.getParameter("Available"));

		housingDAO.updateHousing(idHouse, name, location, numGuest, numBedroom, numBed, numBath, idType, price,
				description, available);

		successMessage = "Nest updated successfully!";
		break;
			}
			case "insert_nest":
		break;

			case "submit_insert_nest":
		String newName = request.getParameter("newName");
		String newLocation = request.getParameter("newLocation");
		int numGuest = Integer.parseInt(request.getParameter("numGuest"));
		int numBedroom = Integer.parseInt(request.getParameter("numBedroom"));
		int numBed = Integer.parseInt(request.getParameter("numBed"));
		int numBath = Integer.parseInt(request.getParameter("numBaths"));
		int idType = Integer.parseInt(request.getParameter("idTypes"));
		double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");
		boolean available = "1".equals(request.getParameter("Available"));
		housingDAO.insertHousing(newName, newLocation, numGuest, numBedroom, numBed, numBath, idType, price,
				description, available);
		successMessage = "Nest added successfully!";
		break;
			case "list_users":

		break;
			case "insert_user":
		break;
			case "submit_insert_user":
		String userName = request.getParameter("userName");
		long phone = Long.parseLong(request.getParameter("userName"));
		String email = request.getParameter("Email");
		int passport = Integer.parseInt(request.getParameter("Passport"));
		String password = request.getParameter("Passport");

		userDAO.insertUser(userName, phone, email, passport, password);
		successMessage = "User added successfully!";
		break;
			case "delete_user":
		String deleteUser = request.getParameter("userId");
		if (deleteUser != null) {
			HousingDAO dao = new HousingDAO();
			dao.deleteHousing(Integer.parseInt(deleteUser));
		}
		successMessage = "Nest deleted successfully!";
		break;

			case "list_reserves":

		break;

			case "edit_reserve":

		break;

			case "submit_edit_reserve": {
		int idReserve = Integer.parseInt(request.getParameter("idReserve"));
		String nameH = request.getParameter("editNameR");
		int numGuests = Integer.parseInt(request.getParameter("editGuestsR"));
		java.sql.Date checkIn = java.sql.Date.valueOf(request.getParameter("editCheckIn"));
		java.sql.Date checkOut = java.sql.Date.valueOf(request.getParameter("editCheckOut"));

		Reserves r = reservesDAO.selectById(idReserve);
		int idUser = r.getIdUser();
		int idHouse = (r.getHousing() != null) ? r.getHousing().getIdHouse() : 0;
		double precioPorNoche = (r.getHousing() != null) ? r.getHousing().getPrice() : 0.0;

		double totalPrice = calcularPrecioTotal(checkIn, checkOut, precioPorNoche);

		reservesDAO.updateReserve(idReserve, idHouse, idUser, nameH, numGuests, checkIn, checkOut, totalPrice);
		successMessage = "Reserve updated successfully!";
		break;
			}

			case "delete_reserve":
		String deleteReserve = request.getParameter("idReserve");
		if (deleteReserve != null) {
			ReservesDAO dao = new ReservesDAO();
			dao.deleteReserve(Integer.parseInt(deleteReserve));
		}
		successMessage = "Nest deleted successfully!";
		break;

			default:
		errorMessage = "Action not found";
		out.println("<div class='alert alert-warning' role='alert'>Action not found</div>");

			}
		} catch (Exception e) {
			errorMessage = "Error adding nest: " + e.getMessage();
		}
	}
	%>

	<%@ include file="Header.jsp"%>

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
						<button name="action" value="housing_images"
							class="btn btn-danger btn-menu w-100">Nests Images</button>
					</form>
					<form method="POST">
						<button name="action" value="logout"
							class="btn btn-outline-danger btn-menu w-100">Logout</button>
					</form>
				</div>
				<div class="col-lg-10 col-md-9 col-sm-12">
					<%
					if (successMessage != null) {
					%>
					<div class="alert alert-success text-center" role="alert">
						<%=successMessage%>
					</div>
					<%
					}
					%>

					<%
					if (errorMessage != null) {
					%>
					<div class="alert alert-danger text-center" role="alert">
						<%=errorMessage%>
					</div>
					<%
					}
					%>


					<div class="card">
						<%
						if ("list_nest".equals(action) || "".equals(action)) {
						%>
						<div class="card-header text-center">
							<h2 style="color: var(--primary-color)">NESTS</h2>
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
											<td><%=h.getPrice()%>€</td>
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
												<form method="POST" style="display: inline;"
													onsubmit="return confirmDelete();">
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
						if ("insert_nest".equals(action)) {
						%>
						<div class="card-header text-center">
							<h2 style="color: var(--primary-color)">NEW NEST</h2>
							<form method="post">
								<input type="hidden" value="submit_insert_nest" name="action" />
								<div class="row mb-3">
									<label for="newName" class="col-sm-3 col-form-label">New
										name</label>
									<div class="col-sm-9">
										<input type="text" id="newName" name="newName"
											class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="newLocation" class="col-sm-3 col-form-label">Location</label>
									<div class="col-sm-9">
										<input type="text" id="newLocation" name="newLocation"
											class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="numGuest" class="col-sm-3 col-form-label">Number
										guests</label>
									<div class="col-sm-9">
										<input type="number" id="numGuest" name="numGuest"
											class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="numBedroom" class="col-sm-3 col-form-label">Number
										Bedrooms</label>
									<div class="col-sm-9">
										<input type="number" id="numBedroom" name="numBedroom"
											class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="numBed" class="col-sm-3 col-form-label">Number
										Beds</label>
									<div class="col-sm-9">
										<input type="number" id="numBed" name="numBed"
											class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="numBaths" class="col-sm-3 col-form-label">Number
										Baths</label>
									<div class="col-sm-9">
										<input type="number" id="numBaths" name="numBaths"
											class="form-control" required>
									</div>
								</div>


								<div class="row mb-3">
									<label for="idTypes" class="col-sm-3 col-form-label">Types</label>
									<div class="col-sm-9">
										<select class="form-select" id="idTypes" name="isTypes"
											required>
											<option value="1">Cabin</option>
											<option value="2">Tiny home</option>
											<option value="3">Apartment</option>
											<option value="4">Countryside</option>
											<option value="5">Villa</option>
										</select>
									</div>
								</div>

								<div class="row mb-3">
									<label for="price" class="col-sm-3 col-form-label">Price</label>
									<div class="col-sm-9">
										<input type="number" id="price" name="price"
											class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="description" class="col-sm-3 col-form-label">Description</label>
									<div class="col-sm-9">
										<input type="text" id="description" name="description"
											class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="available" class="col-sm-3 col-form-label">Available</label>
									<div class="col-sm-9">
										<select class="form-select" id="available" name="available"
											required>
											<option value="1">Available</option>
											<option value="2">No Available</option>
										</select>
									</div>
								</div>

								<div class="text-center">
									<button type="submit" class="btn btn-primary w-100">Create
										Nest</button>
								</div>
							</form>


						</div>
						<%
						}

						if ("edit_house".equals(action)) {
						int houseId = Integer.parseInt(request.getParameter("houseId"));
						Housing h = housingDAO.selectById(houseId);
						%>
						<div class="card-header text-center">
							<h2 style="color: var(--primary-color)">EDIT NEST</h2>
						</div>
						<form method="post">
							<input type="hidden" value="submit_edit_house" name="action" />
							<input type="hidden" name="houseId" value="<%=h.getIdHouse()%>" />

							<div class="row mb-3">
								<label for="editName" class="col-sm-3 col-form-label">Name</label>
								<div class="col-sm-9">
									<input type="text" id="editName" name="editName"
										value="<%=h.getName()%>" class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editLocation" class="col-sm-3 col-form-label">Location</label>
								<div class="col-sm-9">
									<input type="text" id="editLocation"
										value="<%=h.getLocation()%>" name="editLocation"
										class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editType" class="col-sm-3 col-form-label">Types</label>
								<div class="col-sm-9">
									<select id="editType" value="<%=h.getIdType()%>"
										name="editType" class="form-select" required>
										<option value="1">Cabin</option>
										<option value="2">Tiny home</option>
										<option value="3">Apartment</option>
										<option value="4">Countryside</option>
										<option value="5">Villa</option>
									</select>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editPrice" class="col-sm-3 col-form-label">Price</label>
								<div class="col-sm-9">
									<input type="text" id="editPrice" value="<%=h.getPrice()%>"
										name="editPrice" class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editGuests" class="col-sm-3 col-form-label">Number
									of Guests</label>
								<div class="col-sm-9">
									<input type="number" id="editGuests"
										value="<%=h.getNumGuest()%>" name="editGuests"
										class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editBedrooms" class="col-sm-3 col-form-label">Number
									of Bedrooms</label>
								<div class="col-sm-9">
									<input type="number" id="editBedrooms" name="editBedrooms"
										value="<%=h.getNumBedroom()%>" class="form-control" required>
								</div>
							</div>

							<div class="row mb-3">
								<label for="editBed" class="col-sm-3 col-form-label">Number
									of Beds</label>
								<div class="col-sm-9">
									<input type="number" id="editBed" value="<%=h.getNumBed()%>"
										name="editBed" class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editBath" class="col-sm-3 col-form-label">Number
									of Baths</label>
								<div class="col-sm-9">
									<input type="number" id="editBath" name="editBath"
										value="<%=h.getNumBath()%>" class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editDescription" class="col-sm-3 col-form-label">Description</label>
								<div class="col-sm-9">
									<input type="text" id="editDescription"
										value="<%=h.getDescription()%>" name="editDescription"
										class="form-control" required>
								</div>
							</div>

							<div class="row mb-3">
								<label for="available" class="col-sm-3 col-form-label">Available</label>
								<div class="col-sm-9">
									<select class="form-select" id="available" name="available"
										required>
										<option value="1"
											<%if (h.isAvailable())
	out.print("selected");%>>Available</option>
										<option value="0"
											<%if (!h.isAvailable())
	out.print("selected");%>>Not
											available</option>
									</select>
								</div>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary w-100">Update
									Nest</button>
							</div>

						</form>
						<%
						}
						%>
						<%
						if ("list_reserves".equals(action)) {
						%>
						<div class="card-header text-center">
							<h2 style="color: var(--primary-color)">Reserves</h2>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>ID</th>
											<th>Image</th>
											<th>Name</th>
											<th>User</th>
											<th>Start</th>
											<th>Finish</th>
											<th>Guests</th>
											<th>Total</th>
										</tr>
									</thead>
									<tbody>
										<%
										for (Reserves r : reserves) {
											Housing h = r.getHousing();
											String imagePath = "img/not_available.jpg"; // imagen genérica por defecto

											if (h != null) {
												List<Images> imgs = imgDAO.selectImagesByHousingId(h.getIdHouse());
												if (!imgs.isEmpty()) {
											imagePath = request.getContextPath() + imgs.get(0).getImgRoute();
												}
											}
										%>
										<tr>
											<td><%=r.getIdReserva()%></td>
											<td><img src="<%=imagePath%>" alt="Housing Image"></td>
											<td><%=r.getNameH()%></td>
											<td><%=r.getIdUser()%></td>
											<td><%=r.getCheckIn()%></td>
											<td><%=r.getCheckOut()%></td>
											<td><%=r.getNumGuests()%></td>
											<td><%=r.getTotalPrice()%>€</td>
											<td>
												<form method="POST" style="display: inline;">
													<input type="hidden" name="idReserve"
														value="<%=r.getIdReserva()%>">
													<button type="submit" name="action" value="edit_reserve"
														class="btn btn-warning">
														<img src="img/edit.png" alt="Edit"
															style="width: 30px; height: 30px;">
													</button>
												</form>
												<form method="POST" style="display: inline;"
													onsubmit="return confirmDelete();">
													<input type="hidden" name="idReserve"
														value="<%=r.getIdReserva()%>">
													<button type="submit" name="action" value="delete_reserve"
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
						if ("edit_reserve".equals(action)) {
						int idReserve = Integer.parseInt(request.getParameter("idReserve"));
						Reserves r = reservesDAO.selectById(idReserve);
						%>
						<div class="card-header text-center">
							<h2 style="color: var(--primary-color)">EDIT RESERVE</h2>
						</div>
						<form method="post">
							<input type="hidden" value="submit_edit_reserve" name="action" />
							<input type="hidden" name="idReserve" value="<%=r.getIdReserva()%>" />

							<div class="row mb-3">
								<label for="editNameR" class="col-sm-3 col-form-label">Name</label>
								<div class="col-sm-9">
									<input type="text" id="editNameR" name="editNameR"
										value="<%=r.getNameH()%>" class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editCheckIn" class="col-sm-3 col-form-label">CheckIn</label>
								<div class="col-sm-9">
									<input type="date" id="editCheckIn" value="<%=r.getCheckIn()%>"
										name="editCheckIn" class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editCheckOut" class="col-sm-3 col-form-label">CheckOut</label>
								<div class="col-sm-9">
									<input type="date" id="editCheckOut"
										value="<%=r.getCheckOut()%>" name="editCheckOut"
										class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editGuestsR" class="col-sm-3 col-form-label">Guests</label>
								<div class="col-sm-9">
									<input type="number" id="editGuestsR"
										value="<%=r.getNumGuests()%>" name="editGuestsR"
										class="form-control" required>
								</div>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary w-100">Update
									Reserve</button>
							</div>

						</form>
						<%
						}
						if ("list_users".equals(action)) {
						%>
						<div class="card-header text-center">
							<h2>USERS</h2>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>idUser</th>
											<th>Username</th>
											<th>Password</th>
											<th>Phone</th>
											<th>Email</th>
											<th>Passport</th>
										</tr>
									</thead>
									<tbody>
										<%
										for (User u : users) {
										%>
										<tr>
											<td><%=u.getIdUser()%></td>
											<td><%=u.getUserName()%></td>
											<td><%=u.getPassword()%></td>
											<td><%=u.getPhone()%></td>
											<td><%=u.getEmail()%></td>
											<td><%=u.getPassport()%></td>
											<td>
												<form method="POST" style="display: inline;">
													<input type="hidden" name="userId"
														value="<%=u.getIdUser()%>">
													<button type="submit" name="action" value="edit_house"
														class="btn btn-warning">
														<img src="img/edit.png" alt="Edit"
															style="width: 30px; height: 30px;">
													</button>
												</form>
												<form method="POST" style="display: inline;"
													onsubmit="return confirmDelete();">
													<input type="hidden" name="houseId"
														value="<%=u.getIdUser()%>">
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
						%>
						<%
						if ("insert_user".equals(action)) {
						%>
						<div class="card">
							<div class="card-header text-center">
								<h2>NEW USER</h2>
								<form method="post">
									<input type="hidden" value="submit_insert_user" name="action" />
									<div class="row mb-3">
										<label for="newuserName" class="col-sm-3 col-form-label">New
											userName</label>
										<div class="col-sm-9">
											<input type="text" id="newuserName" name="newuserName"
												class="form-control" required>
										</div>
									</div>

									<div class="row mb-3">
										<label for="Phone" class="col-sm-3 col-form-label">Phone</label>
										<div class="col-sm-9">
											<input type="number" id="Phone" name="Phone"
												class="form-control" required>
										</div>
									</div>

									<div class="row mb-3">
										<label for="Email" class="col-sm-3 col-form-label">Email</label>
										<div class="col-sm-9">
											<input type="text" id="Email" name="Email"
												class="form-control" required>
										</div>
									</div>

									<div class="row mb-3">
										<label for="Passport" class="col-sm-3 col-form-label">Passport</label>
										<div class="col-sm-9">
											<input type="number" id="Passport" name="Passport"
												class="form-control" required>
										</div>
									</div>

									<div class="row mb-3">
										<label for="Password" class="col-sm-3 col-form-label">Password</label>
										<div class="col-sm-9">
											<input type="text" id="Password" name="Password"
												class="form-control" required>
										</div>
									</div>

									<div class="text-center">
										<button type="submit" class="btn btn-primary w-100">Create
											User</button>
									</div>
								</form>


							</div>
							<%
							}
							%>
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
			<p class="text-muted">@Jonathan Villamizar - Alfredo Noriega</p>
		</div>
	</footer>
</body>
</html>