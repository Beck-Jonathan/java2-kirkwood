<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Team Directory</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<header class="bg-dark">
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container-fluid">
            <a class="navbar-brand text-light" href="#">Team Directory</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <form class="d-flex pt-2" action="hockey-json" method="get">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="q" value="${q}">
                    <input type="hidden" name="sort" value="${s}">
                    <input type="hidden" name="league" value="${league}">
                    <button class="btn btn-light" type="submit">Search</button>
                </form>
                <div class="dropdown ms-3">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="sortDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        Sort
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="sortDropdown">
                        <li><a class="dropdown-item" href="hockey-json?sort=az&q=${q}&league=${league}">A to Z</a></li>
                        <li><a class="dropdown-item" href="hockey-json?sort=za&q=${q}&league=${league}">Z to A</a></li>
                    </ul>
                </div>
                <div class="dropdown ms-3">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="sortDropdown2" data-bs-toggle="dropdown" aria-expanded="false">
                        Filter by league
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="sortDropdown2">
                        <li><a class="dropdown-item" href="hockey-json?sort=${s}&q=${q}&league=">All</a></li>
                        <c:forEach items="${leagues}" var="league">
                            <li><a class="dropdown-item" href="hockey-json?sort=${s}&q=${q}&league=${league}">${league}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</header>
<div class="container py-4">
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Team Name</th>
                <th scope="col">League</th>
                <th scope="col">Stadium Name</th>
                <th scope="col">Stadium Location</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${teams}" var="team1" varStatus="status">
                <tr>
                    <th scope="row">${status.count}</th>
                    <td>${team1.strTeam}</td>
                    <td>${team1.strLeague}</td>
                    <td>${team1.strStadium} </td>
                    <td>${team1.strStadiumLocation} </td>


                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
