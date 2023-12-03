<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
            color: #495057;
            font-family: 'Arial', sans-serif;
        }

        nav {
            background-color: #800080;
        }

        .navbar-brand, .navbar-nav .nav-link {
            color: #fff;
        }

        .container {
            margin-top: 30px;
        }

        .jumbotron {
            background-color: #800080;
            color: #fff;
            padding: 2rem;
        }

        .feature-icon {
            font-size: 3rem;
            color: #800080;
        }

        .feature {
            margin-top: 20px;

        }
        .navbar-brand, .navbar-nav .nav-link {
            color: #fff !important;
        }

        footer {
            background-color: #800080;
            color: #fff;
            padding: 10px 0;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="#">Your E-Commerce</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="adminHome">Home Page</a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Role
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/">User</a>
                    <a class="dropdown-item" href="Dashboard">Admin</a>
                </div>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="jumbotron">
        <h1>Welcome to Your E-Commerce Store</h1>
        <p>Discover amazing deals and shop with confidence!</p>
    </div>

    <div class="row">
        <div class="col-md-4 feature">
            <i class="feature-icon">🛍</i>
            <h3>Shop Anytime, Anywhere</h3>
            <p>Our online store is open 24/7. Browse and shop whenever it's convenient for you.</p>
        </div>
        <div class="col-md-4 feature">
            <i class="feature-icon">🚚</i>
            <h3>Fast and Reliable Delivery</h3>
            <p>Enjoy fast and reliable delivery services to your doorstep. We value your time!</p>
        </div>
        <div class="col-md-4 feature">
            <i class="feature-icon">💳</i>
            <h3>Secure Payment Options</h3>
            <p>Shop with confidence using our secure payment options. Your transactions are safe with us.</p>
        </div>
    </div>
</div>

<footer class="text-center">
    &copy; 2023 Your E-Commerce. All rights reserved.
</footer>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

</body>
</html>