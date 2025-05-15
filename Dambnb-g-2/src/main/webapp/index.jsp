<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="styles/Index.css">
        <title>Index</title>
    </head>

    <body style="background-color: rgb(236, 238, 248);">
        <header>
            <nav class="navbar navbar-expand-lg " style="background-color:white;">
                <a class="navbar-link" href="#">
                    <img src="img/Logo_transparente.png" width="10%" alt="">
                </a>
                <div class="d-flex align-items-center ms-auto">
                    <a class="nav-link me-3" style="font-size: 1em; " href="">STAYS</a>
                    <a href="">
                        <img src="img/user.png" alt="" width="35" height="35">
                    </a>
                </div>

            </nav>
            <main>
                <nav class="navbar navbar-expand-lg justify-content-center py-5">
                    <a class="nav-link me-5 nav-link-custom" href="">ALL</a>
                    <a class="nav-link me-5 nav-link-custom" href="">CABIN</a>
                    <a class="nav-link me-5 nav-link-custom" href="">TINY HOME</a>
                    <a class="nav-link me-5 nav-link-custom" href="">APARTMENT</a>
                    <a class="nav-link me-5 nav-link-custom" href="">COUNTRYSIDE</a>
                    <a class="nav-link me-5 nav-link-custom" href="">VILLA</a>
                </nav>

                <nav class="navbar navbar-expand-lg py-3">
                    <div class="container d-flex justify-content-between align-items-center">
                        <div class="d-flex align-items-center">
                            <span>How many rooms are you Resting in? &nbsp; </span>
                            <a class="nav-link me-5 nav-link-custom" href="">+1</a>
                            <a class="nav-link me-5 nav-link-custom" href="">+2</a>
                            <a class="nav-link me-5 nav-link-custom" href="">+3</a>
                        </div>
                        <form class="form-inline d-flex ms-auto">
                            <input class="form-control mr-sm-2 me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </div>
                </nav>
            </main>


            <%-- Llamar a base de datos para recoger la lista de las casas , es el selectall de housingdao --%>

                <%-- Crear tabla y recorrer lista con cada departamento --%>

                    <%-- <div>
                        <table>
                            <% for(housing s : house){ %>
                                <td></td>
                        </table>

                        </div>
                        <% %> --%>

        </header>
    </body>

    </html>