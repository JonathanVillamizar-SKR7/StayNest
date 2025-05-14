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
            <div class="logo_header"><a href="">
                <img class="logo_header" src="<%= request.getContextPath() %>/img/Logo_transparente.png" alt="Logo"
                    style="width: 150px; height: auto;">
                    </a>
            </div>
            <div class="links_header">
                <a href="">Company</a>
                <a href="">Legal</a>
                <a href="">Social</a>
            </div>
        </header>
        <main>
            <div class="figura">
                <div class="login">
                    <form action="">
                        <H1>LOG IN</H1>
                        <div>
                            <input type="email" name="email" id="email" required>
                            <label for="email">Email</label>
                        </div>
                        <div>
                            <input type="password" name="password" id="password" required>
                            <label for="password">Password</label>
                        </div>
                        <div class="button_login">
                            <button type="submit">LOGIN</button>
                        </div>
                        <p>If you don't have and account&nbsp; <a href=""> register</a>&nbsp; now</p>
                    </form>
                    <div class="logoCorner_content">
                    <img class="logo_corner" src="<%= request.getContextPath() %>/img/Logo_transparente.png"
                            alt="Logo" >
                    </div>
                </div>
            </div>
        </main>
        <footer>
        </footer>
    </body>

    </html>