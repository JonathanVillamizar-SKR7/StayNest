<%@page import="m03_abp_project_test.UserType"%>
<%@page import="m03_abp_project_test.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="m03_abp_project_test.exceptions.AdminException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link type="text/css" rel="stylesheet" href="../link_al.css" />
    <!-- Agrega las referencias a Bootstrap CSS y JS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        /* Estilo adicional */
        .container {
            margin-top: 50px;
        }
        .card {
            height: 100%;
        }
        .btn-menu {
            width: 100%;
            margin-bottom: 10px;
        }
        .texto {
            margin: 20px;
        }
    </style>
</head>
<body>

<%
    String titulo = "NEW USER";
    String action = "";
    ArrayList<String> test = new ArrayList<>();
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        try {
            //TODO: Here we determine which action we are performing

            action = request.getParameter("action");
            switch (action) {
                case "save_user":
                    User user = new User();
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String email = request.getParameter("email");
                    String userType = request.getParameter("user_type");
                    user.setPassword(password);
                    user.setEmail(email);
                    user.setUserType(UserType.valueOf(userType.toUpperCase()));
                    user.setUsername(username);
                    //UserDAO userDAO = new UserDAO();
                    //userDAO.insert(user);
                    response.sendRedirect("./home.jsp");
                    break;
                case "logout":
                    response.sendRedirect("./index.jsp");
                    break;
                case "home":
                    response.sendRedirect("./home.jsp");
                    break;
            }
        } catch (Exception e) {
            //Get all excepcions to print message error.
            out.println("<div class='alert alert-danger' role='alert'>ERROR: " + e.getMessage() + "</div>");
        }

    } else if ("GET".equalsIgnoreCase(request.getMethod())) {


    }
%>
<div class="container">
    <div class="row">

        <!-- Menú -->
        <div class="col-md-3">
            <form method="POST">
                <input type="hidden" name="action" value="home"/>
                <button type="submit" class="btn btn-primary btn-menu">HOME</button>
            </form>
            <form method="POST">
                <input type="hidden" name="action" value="logout"/>
                <button type="submit" class="btn btn-danger btn-menu">LOGOUT</button>
            </form>
        </div>

        <!-- Content -->
        <div class="col-md-9">
            <div class="card">

                <div class="card-header">
                    <h2 class="text-center"><%=titulo%></h2>
                </div>

                <!-- Left side content: menu -->
                <div class="texto">
                    <form method="post">
                        <input type="hidden" name="action" value="guardar_usuari"/>
                        <div class="mb-3">
                            <label for="username" class="form-label">User name:</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">email:</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="mb-3">
                            <label for="user_type" class="form-label">User Type:</label>
                            <select class="form-control" name="user_type" id="user_type">
                                <option value="admin">Admin</option>
                                <option value="user">User</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password:</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>