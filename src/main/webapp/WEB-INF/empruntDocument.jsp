<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <title>Abonné-emprunt</title>
</head>
<body>
<!-- Navbar sans toggle -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="menu">Médiathèque</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="emprunt">Emprunter un Document</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="retour">Rendre un document</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="deconnexion">Déconnexion</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Emprunt Form -->
<div class="container">
    <div class="row container d-flex justify-content-center">
        <div class="col-md-6 col-lg-4">
            <form class="card" method="post" action="emprunt">
                <h5 class="card-title fw-400">Espace Emprunt</h5>
                <div class="card-body">
                    <div class="form-group">
                        <select class="form-control" name="docEmprunte">
                            <option value="0">Séléctioner un document</option>
                            <c:forEach var="docEmprunte" items="${docEmpruntes}">
                                <option value="${docEmprunte.toString().split("/")[0]}">${docEmprunte.toString().split("/")[1]}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-block btn-bold btn-primary">Emprunter</button>
                    </div>
                    <p style="color: limegreen">${success}</p>
                    <p style="color: darkred">${error}</p>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<style>
    .card {
        border: 0;
        border-radius: 0px;
        margin-bottom: 30px;
        -webkit-box-shadow: 0 2px 3px rgba(0, 0, 0, 0.03);
        box-shadow: 0 2px 3px rgba(0, 0, 0, 0.03);
        -webkit-transition: .5s;
        transition: .5s
    }

    body {
        background-color: #f9f9fa
    }

    h5.card-title {
        font-size: 15px
    }

    .fw-400 {
        font-weight: 400 !important
    }

    .card-title {
        font-family: Roboto, sans-serif;
        font-weight: 300;
        line-height: 1.5;
        margin-bottom: 0;
        padding: 15px 20px;
        border-bottom: 1px solid rgba(77, 82, 89, 0.07)
    }

    .card-body {
        -ms-flex: 1 1 auto;
        flex: 1 1 auto;
        padding: 1.25rem
    }

    .form-group {
        margin-bottom: 1rem
    }

    .form-control {
        border-color: #ebebeb;
        border-radius: 2px;
        color: #8b95a5;
        padding: 5px 12px;
        font-size: 14px;
        line-height: inherit;
        -webkit-transition: 0.2s linear;
        transition: 0.2s linear
    }

    .card-body>*:last-child {
        margin-bottom: 0
    }

    .btn-primary {
        background-color: #33cabb;
        border-color: #33cabb;
        color: #fff
    }

    .btn-bold {
        font-family: Roboto, sans-serif;
        text-transform: uppercase;
        font-weight: 500;
        font-size: 12px
    }

    .btn-primary:hover {
        background-color: #52d3c7;
        border-color: #52d3c7;
        color: #fff
    }

    .btn:hover {
        cursor: pointer
    }

    .form-control:focus {
        border-color: #83e0d7;
        color: #4d5259;
        -webkit-box-shadow: 0 0 0 0.1rem rgba(51, 202, 187, 0.15);
        box-shadow: 0 0 0 0.1rem rgba(51, 202, 187, 0.15)
    }
</style>
