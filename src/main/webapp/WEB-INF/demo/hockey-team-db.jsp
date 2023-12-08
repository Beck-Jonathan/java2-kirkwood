<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Teams</h1>
    <p class="lead">There ${teams.size() == 1 ? "is" : "are"} ${teams.size()} Team${teams.size() != 1 ? "s" : ""}</p>
    <c:if test="${teams.size() > 0}">
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Team Name</th>
                    <th scope="col">League</th>
                    <th scope="col">Arena Name</th>
                    <th scope="col">Location</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${teams}" var="team">
                    <tr>
                        <!-- <th scope="row">${team}</th> -->
                        <td>${team.strTeam}</td>
                        <td>${team.strLeague}</td>
                        <td>${team.strStadium}</td>
                        <td>${team.strStadiumLocation}</td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
