<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="styles/SingUp.css">
        <title>Sing Up</title>
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
            <div class="figura">
                <div class="singUp">
                    <form action="">
                        <H1>Sing Up</H1>
                        <div>
                            <input type="text" name="userName" id="userName" required>
                            <label for="userName">userName</label>
                        </div>
                        <div>
                            <input type="email" name="email" id="email" required>
                            <label for="email">Email</label>
                        </div>
                        <div>
                            <input type="password" name="password" id="password" required>
                            <label for="password">Password</label>
                        </div>
                        <div class="button_singup">
                            <button type="submit">LOGIN</button>
                        </div>
                        <p>If you have and account &nbsp;<a href=""> log in now</a></p>
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