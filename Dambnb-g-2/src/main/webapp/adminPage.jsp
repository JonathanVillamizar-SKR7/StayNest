<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="daxbnb.DAO.*"%>
<%@ page import="daxbnb.model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.File"%>

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
	
	  function togglePassword(id) {
	    const span = document.getElementById("pass-" + id);
	    const hiddenInput = document.getElementById("real-pass-" + id);

	    if (span.innerText.includes("*")) {
	      span.innerText = hiddenInput.value;
	    } else {
	      span.innerText = "*".repeat(hiddenInput.value.length);
	    }
	  }
	</script>


</head>

<body>
	<%
		HousingDAO housingDAO = new HousingDAO();
		HousingImagesDAO imgDAO = new HousingImagesDAO();
		UserDAO userDAO = new UserDAO();
		ReservesDAO reservesDAO = new ReservesDAO();
		FacilityDAO facilitiesDAO = new FacilityDAO();
		ImagesDAO imagesDAO = new ImagesDAO();
		HousingImagesDAO housingImagesDAO = new HousingImagesDAO();
		HousingFacilityDAO housingFacilityDAO = new HousingFacilityDAO();
		List<Housing> housings = housingDAO.selectAll();
		List<User> users = userDAO.selectAll();
		List<Facilities> facilities = facilitiesDAO.selectAll();
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

			case "submit_insert_nest":
		String image = request.getParameter("image");
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
		int newHousing = housingDAO.insertHousing(newName, newLocation, numGuest, numBedroom, numBed, numBath,
				idType, price, description, available);
		successMessage = "Nest added successfully!";
		break;
			case "list_users":

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
			
			try{
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
			int newHousing = housingDAO.insertHousing(newName, newLocation, numGuest, numBedroom, numBed, numBath, idType, price,
			description, available);

			String imageUrl = request.getParameter("image");
			int newImage = imagesDAO.insertImage(imageUrl);
			housingImagesDAO.insertImage(newHousing,newImage);
			
			String[] newFacilities = {
	            request.getParameter("facilities1"),
	            request.getParameter("facilities2"),
	            request.getParameter("facilities3")
	        };

	            for (String facilityId : newFacilities) {
            if (facilityId != null && !facilityId.isEmpty()) {
                housingFacilityDAO.insertFacility(newHousing, Integer.parseInt(facilityId));
            }
        
			}
			successMessage = "Nest added successfully!";
			}catch (Exception e){
		errorMessage = "Error adding nest:"+ e.getMessage();
		e.printStackTrace();
			}
			break;
		case "list_users":

			break;
		case "insert_user":
			break;
		case "submit_insert_user":
			String userName = request.getParameter("newuserName");
			long phone = Long.parseLong(request.getParameter("Phone"));
			String email = request.getParameter("Email");
			int passport = Integer.parseInt(request.getParameter("Passport"));
			String password = request.getParameter("Password");

			userDAO.insertUser(userName, phone, email, passport, password);
			successMessage = "User added successfully!";
			break;

		case "delete_user":
			String deleteUser = request.getParameter("userId");
			if (deleteUser != null) {
		UserDAO dao = new UserDAO();
		dao.deleteUser(Integer.parseInt(deleteUser));
			}
			successMessage = "User deleted successfully!";
			break;

		case "list_facilities":

			break;

		case "delete_facility":
			String deleteFacility = request.getParameter("facilityId");
			if (deleteFacility != null) {
		FacilityDAO dao = new FacilityDAO();
		dao.deleteFacility(Integer.parseInt(deleteFacility));
			}
			successMessage = "Facility deleted successfully!";
			break;

		case "edit_facility":

			break;

		case "submit_edit_facility":
			int idFacility = Integer.parseInt(request.getParameter("facilityId"));
			String typeFacility = request.getParameter("editTypeF");

			facilitiesDAO.updateFacility(idFacility, typeFacility);

			successMessage = "Facility updated successfully!";
			break;

		case "insert_facility":

			break;

		case "submit_insert_facility":
			String newFacility = request.getParameter("typeFacility");
			facilitiesDAO.insertFacility(newFacility);
			successMessage = "Facility added successfully!";
			break;

		case "list_reserves":

			break;

		case "insert_reserve":

			break;

		case "submit_insert_reserve": {
			int idUser = Integer.parseInt(request.getParameter("idUser"));
			int idHouse = Integer.parseInt(request.getParameter("idHouse"));
			String nameH = request.getParameter("editNameR");
			int numGuests = Integer.parseInt(request.getParameter("editGuestsR"));
			java.sql.Date checkIn = java.sql.Date.valueOf(request.getParameter("editCheckIn"));
			java.sql.Date checkOut = java.sql.Date.valueOf(request.getParameter("editCheckOut"));

			Housing selectedHousing = housingDAO.selectById(idHouse);
			double pricePerNight = selectedHousing.getPrice();
			double totalPrice = calcularPrecioTotal(checkIn, checkOut, pricePerNight);

			reservesDAO.insertReserve(idHouse, idUser, nameH, numGuests, totalPrice, checkIn, checkOut);
			successMessage = "Reserve added successfully!";
			break;
		}

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

		case "edit_user":
			break;

		case "submit_edit_user":
			int idUser = Integer.parseInt(request.getParameter("userId"));
			String userNamee = request.getParameter("editUserName");
			String passwordd = request.getParameter("editPassword");
			long phonee = Long.parseLong(request.getParameter("editPhone"));
			String emaill = request.getParameter("editEmail");
			int passportt = Integer.parseInt(request.getParameter("editPassport"));
			String userType = request.getParameter("editUserType");

			userDAO.updateUser(idUser, userNamee, phonee, emaill, passportt, passwordd, userType);

			successMessage = "User updated successfully!";

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
											<th></th>
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
									<label for="image" class="col-sm-3 col-form-label">Insert
										Image</label>
									<div class="col-sm-9">
										<input class="form-control" type="text" id="image"
											name="image" multiple required>
									</div>
								</div>

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
										<select class="form-select" id="idTypes" name="idTypes"
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
									<label for="facilities1" class="col-sm-3 col-form-label">Facilities</label>
									<div class="col-sm-9">
										<select class="form-select" id="facilities1"
											name="facilities1" required>
											<%
											FacilityDAO facilityDAO = new FacilityDAO();
											List<Facilities> facilityList = facilityDAO.selectAll();
											for (Facilities facility : facilityList) {
											%>
											<option value="<%=facility.getIdFacilities()%>">
												<%=facility.getTypeFacilities()%>
											</option>
											<%
											}
											%>
										</select>
									</div>
								</div>
								<div class="row mb-3">
									<label for="facilities2" class="col-sm-3 col-form-label">Facilities</label>
									<div class="col-sm-9">
										<select class="form-select" id="facilities2"
											name="facilities2" required>
											<%
											for (Facilities facility : facilityList) {
											%>
											<option value="<%=facility.getIdFacilities()%>">
												<%=facility.getTypeFacilities()%>
											</option>
											<%
											}
											%>
										</select>
									</div>
								</div>
								<div class="row mb-3">
									<label for="facilities3" class="col-sm-3 col-form-label">Facilities</label>
									<div class="col-sm-9">
										<select class="form-select" id="facilities3"
											name="facilities3" required>
											<%
											for (Facilities facility : facilityList) {
											%>
											<option value="<%=facility.getIdFacilities()%>">
												<%=facility.getTypeFacilities()%>
											</option>
											<%
											}
											%>
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
											<td><%=(r.getIdUser() != null) ? r.getIdUser() : "Deleted"%></td>
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
						%>
						<%
						if ("edit_reserve".equals(action)) {
							int idReserve = Integer.parseInt(request.getParameter("idReserve"));
							Reserves r = reservesDAO.selectById(idReserve);
						%>
						<div class="card-header text-center">
							<h2 style="color: var(--primary-color)">EDIT RESERVE</h2>
						</div>
						<form method="post">
							<input type="hidden" value="submit_edit_reserve" name="action" />
							<input type="hidden" name="idReserve"
								value="<%=r.getIdReserva()%>" />

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
											<td><span class="password-mask"
												id="pass-<%=u.getIdUser()%>">********</span> <input
												type="hidden" id="real-pass-<%=u.getIdUser()%>"
												value="<%=u.getPassword()%>">
												<button type="button" style="width: 1rem; height: 1rem;"
													onclick="togglePassword(<%=u.getIdUser()%>)"
													class="btn btn-sm btn-secondary">👁</button></td>
											<td><%=u.getPhone()%></td>
											<td><%=u.getEmail()%></td>
											<td><%=u.getPassport()%></td>
											<td>
												<form method="POST" style="display: inline;">
													<button type="submit" name="action" value="edit_user"
														class="btn btn-warning"
														formaction="adminPage.jsp?userId=<%=u.getIdUser()%>">
														<img src="img/edit.png" alt="Edit"
															style="width: 30px; height: 30px;">
													</button>
												</form>

												<form method="POST" style="display: inline;"
													onsubmit="return confirmDelete();">
													<input type="hidden" name="userId"
														value="<%=u.getIdUser()%>">
													<button type="submit" name="action" value="delete_user"
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
						if ("edit_user".equals(action)) {
						int userId = Integer.parseInt(request.getParameter("userId"));
						User u = userDAO.selectById(userId);
						%>
						<div class="card-header text-center">
							<h2 style="color: var(--primary-color)">EDIT USER</h2>
						</div>
						<form method="post">
							<input type="hidden" value="submit_edit_user" name="action" /> <input
								type="hidden" name="userId" value="<%=u.getIdUser()%>" />

							<div class="row mb-3">
								<label for="editUserName" class="col-sm-3 col-form-label">User
									Name</label>
								<div class="col-sm-9">
									<input type="text" id="editUserName" name="editUserName"
										value="<%=u.getUserName()%>" class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editPassword" class="col-sm-3 col-form-label">Password</label>
								<div class="col-sm-9">
									<input type="password" id="editPassword" name="editPassword"
										value="<%=u.getPassword()%>" class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editPhone" class="col-sm-3 col-form-label">Phone</label>
								<div class="col-sm-9">
									<input type="tel" id="editPhone" name="editPhone"
										value="<%=u.getPhone()%>" class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editEmail" class="col-sm-3 col-form-label">Email</label>
								<div class="col-sm-9">
									<input type="email" id="editEmail" name="editEmail"
										value="<%=u.getEmail()%>" class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editPassport" class="col-sm-3 col-form-label">Passport</label>
								<div class="col-sm-9">
									<input type="text" id="editPassport" name="editPassport"
										value="<%=u.getPassport()%>" class="form-control" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="editUserType" class="col-sm-3 col-form-label">User
									Type</label>
								<div class="col-sm-9">
									<select id="editUserType" name="editUserType"
										class="form-select" required>
										<option value="client"
											<%="client".equals(u.getUserType()) ? "selected" : ""%>>Client</option>
										<option value="admin"
											<%="admin".equals(u.getUserType()) ? "selected" : ""%>>Admin</option>
									</select>
								</div>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary w-100">Update
									User</button>
							</div>

						</form>
						<%
						}
						%>
						<%
						if ("insert_reserve".equals(action)) {
						%>
						<div class="card-header text-center">
							<h2>NEW RESERVE</h2>

							<form method="post">
								<input type="hidden" value="submit_insert_reserve" name="action" />

								<div class="row mb-3">
									<label for="idUser" class="col-sm-3 col-form-label">User</label>
									<div class="col-sm-9">
										<select id="idUser" name="idUser" class="form-select" required>
											<option disabled selected value="">Select user</option>
											<%
											for (User u : users) {
											%>
											<option value="<%=u.getIdUser()%>"><%=u.getUserName()%></option>
											<%
											}
											%>
										</select>
									</div>
								</div>

								<div class="row mb-3">
									<label for="idHouse" class="col-sm-3 col-form-label">Housing</label>
									<div class="col-sm-9">
										<select id="idHouse" name="idHouse" class="form-select"
											required>
											<option disabled selected value="">Select nest</option>
											<%
											for (Housing h : housings) {
											%>
											<option value="<%=h.getIdHouse()%>"><%=h.getName()%></option>
											<%
											}
											%>
										</select>
									</div>
								</div>

								<div class="row mb-3">
									<label for="editNameR" class="col-sm-3 col-form-label">Name</label>
									<div class="col-sm-9">
										<input type="text" id="editNameR" name="editNameR"
											class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="editCheckIn" class="col-sm-3 col-form-label">Check
										In</label>
									<div class="col-sm-9">
										<input type="date" id="editCheckIn" name="editCheckIn"
											class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="editCheckOut" class="col-sm-3 col-form-label">Check
										Out</label>
									<div class="col-sm-9">
										<input type="date" id="editCheckOut" name="editCheckOut"
											class="form-control" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="editGuestsR" class="col-sm-3 col-form-label">Guests</label>
									<div class="col-sm-9">
										<input type="number" id="editGuestsR" name="editGuestsR"
											class="form-control" required>
									</div>
								</div>

								<div class="text-center">
									<button type="submit" class="btn btn-primary w-100">Create
										Reserve</button>
								</div>
							</form>
						</div>


						<%
						}
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
											<input type="email" id="Email" name="Email"
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
						<%
						if ("list_facilities".equals(action)) {
						%>
						<div class="card-header text-center">
							<h2 style="color: var(--primary-color)">FACILITIES</h2>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>Id Facility</th>
											<th>Type Facility</th>
										</tr>
									</thead>
									<tbody>
										<%
										for (Facilities f : facilities) {
										%>
										<tr>
											<td><%=f.getIdFacilities()%></td>
											<td><%=f.getTypeFacilities()%></td>
											<td>
												<form method="POST" style="display: inline;">
													<input type="hidden" name="facilityId"
														value="<%=f.getIdFacilities()%>">
													<button type="submit" name="action" value="edit_facility"
														class="btn btn-warning">
														<img src="img/edit.png" alt="Edit"
															style="width: 30px; height: 30px;">
													</button>
												</form>
												<form method="POST" style="display: inline;"
													onsubmit="return confirmDelete();">
													<input type="hidden" name="facilityId"
														value="<%=f.getIdFacilities()%>">
													<button type="submit" name="action" value="delete_facility"
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
						if ("edit_facility".equals(action)) {
						int facilityId = Integer.parseInt(request.getParameter("facilityId"));
						Facilities f = facilitiesDAO.selectById(facilityId);
						%>
						<div class="card-header text-center">
							<h2 style="color: var(--primary-color)">EDIT FACILITY</h2>
						</div>
						<form method="post">
							<input type="hidden" value="submit_edit_facility" name="action" />
							<input type="hidden" name="facilityId"
								value="<%=f.getIdFacilities()%>" />

							<div class="row mb-3">
								<label for="editTypeF" class="col-sm-3 col-form-label">Type
									Facility</label>
								<div class="col-sm-9">
									<input type="text" id="editTypeF" name="editTypeF"
										value="<%=f.getTypeFacilities()%>" class="form-control"
										required>
								</div>
							</div>


							<div class="text-center">
								<button type="submit" class="btn btn-primary w-100">Update
									Facility</button>
							</div>

						</form>
						<%
						}
						%>
						<%
						if ("insert_facility".equals(action)) {
						%>
						<div class="card">
							<div class="card-header text-center">
								<h2>NEW FACILITY</h2>
								<form method="post">
									<input type="hidden" value="submit_insert_facility"
										name="action" />
									<div class="row mb-3">
										<label for="typeFacility" class="col-sm-3 col-form-label">New
											Facility</label>
										<div class="col-sm-9">
											<input type="text" id="typeFacility" name="typeFacility"
												class="form-control" required>
										</div>
									</div>
									<div class="text-center">
										<button type="submit" class="btn btn-primary w-100">Create
											Facility</button>

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
	<%@ include file="Footer.jsp"%>

</body>
</html>