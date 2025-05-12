<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="styles/Login.css">
        <title>Login</title>
    </head>

    <body>
        <header>
            <div class="logo_header">
                <img class="logo_header" src="<%= request.getContextPath() %>/img/Logo_transparente.png" alt="Logo"
                    style="width: 150px; height: auto;">
            </div>
            <div class="links_header">
                <a href="">Company</a>
                <a href="">Legal</a>
                <a href="">Social</a>
            </div>
        </header>
        <main>

            <H1>LOG IN</H1>
            <div class="login">
                <form action="">
                    <div>
                        <input type="email" name="email" id="email" required>
                        <label for="email">email</label>
                    </div>
                    <div>
                        <input type="password" name="password" id="password" required>
                        <label for="password">password</label>
                    </div>
                    <div>
                        <button type="submit">LOGIN</button>
                    </div>
                    <img class="logo_header" src="<%= request.getContextPath() %>/img/Logo_transparente.png" alt="Logo"
                        style="width: 577px; height: auto;">
            </div>
            </form>
        </main>
        <footer>
        </footer>
    </body>

    </html>