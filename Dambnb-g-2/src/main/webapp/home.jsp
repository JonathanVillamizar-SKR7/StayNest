<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>StayNest</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="styles/home.css">
    </head>

    <body>
        <nav>
            <div class="logo">
                <a href="home.jsp">
                    <img src="img/Logo_right.png" alt="StayNest" class="logo">
                </a>
            </div>
            <div class="menu">
                <a href="index.jsp" class="Index m-lg-4">STAYS</a>
                <a href="login.jsp">
                    <img src="img/user.png" alt="User Icon" class="User-Icon m-4">
                </a>
            </div>
        </nav>

        <header>
            <div class="image-container">
                <img src="img/portada_home.jpg" alt="PortadaHome" class="portada-image">
                <div class="logo-overlay">
                    <img src="img/Logo_right_white.png" alt="StayNest Logo" class="logoPortada">
                </div>
            </div>
        </header>

        <main>
            <div class="container">
                <h2>Featured houses</h2>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="card my-3">
                            <img class="card-img-top img-fluid" src="img/7-1.jpg" alt="Card image">
                            <div class="card-body">
                                <h4 class="card-title">Villa Stay 7</h4>
                                <p class="card-text">Port James, Portugal</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4">
                        <div class="card my-3">
                            <img class="card-img-top img-fluid" src="img/6-1.jpg" alt="Card image">
                            <div class="card-body">
                                <h4 class="card-title">Cabin Stay 6</h4>
                                <p class="card-text">South Beverlyview, France</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4">
                        <div class="card my-3">
                            <img class="card-img-top img-fluid" src="img/1-1.jpg" alt="Card image">
                            <div class="card-body">
                                <h4 class="card-title">Countryside Stay 1</h4>
                                <p class="card-text">Stewartmouth, Germany</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <footer class="row row-cols-1 row-cols-sm-2 row-cols-md-5 py-5 my-5 border-top">
                <div class="col mb-3">
                    <a href="home.jsp" class="d-flex align-items-center mb-3 link-dark text-decoration-none">
                        <img src="img/logo_white.png" width="60%" alt="">
                    </a>
                </div>
                <div class="col mb-3">
                </div>

                <div class="col mb-3">
                    <h5 id="footer-title">About & Support</h5>
                    <ul class="nav flex-column">
                        <li class="nav-item mb-3"><a href="#" class="nav-link p-0 text-muted">About Us</a></li>
                        <li class="nav-item mb-3"><a href="#" class="nav-link p-0 text-muted">Contact Us</a></li>
                        <li class="nav-item mb-3"><a href="#" class="nav-link p-0 text-muted">FAQ</a></li>
                    </ul>
                </div>

                <div class="col mb-3">
                    <h5 id="footer-title">Explore</h5>
                    <ul class="nav flex-column">
                        <li class="nav-item mb-3"><a href="#" class="nav-link p-0 text-muted">Countryside
                                Retreats</a></li>
                        <li class="nav-item mb-3"><a href="#" class="nav-link p-0 text-muted">Apartment Stays</a>
                        </li>
                        <li class="nav-item mb-3"><a href="#" class="nav-link p-0 text-muted">Cabin Getaways</a>
                        </li>
                    </ul>
                </div>

                <div class="col mb-3">
                    <h5 id="footer-title">Policies & Security</h5>
                    <ul class="nav flex-column">
                        <li class="nav-item mb-3"><a href="#" class="nav-link p-0 text-muted">Privacy Policy</a>
                        </li>
                        <li class="nav-item mb-3"><a href="#" class="nav-link p-0 text-muted">Term & Conditions</a>
                        </li>
                        <li class="nav-item mb-3"><a href="#" class="nav-link p-0 text-muted">Refund & Cancellation
                                Policy</a></li>
                    </ul>
                </div>
            </footer>
        </main>
    </body>

    </html>
    ""