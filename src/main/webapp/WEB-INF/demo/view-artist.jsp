<%--
  Created by IntelliJ IDEA.
  User: jjbec
  Date: 12/12/2023
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table">
<thead>
<tr>
    <th scope="col">ID</th>
    <th scope="col">First</th>

</tr>
</thead>
<tbody>
<c:forEach items="${artists}" var="artist" varStatus="status">
    <tr>

        <th scope="row">
        </th>
        <td>${artist.name}</td>
        <td>${artist.picture}</td>

    </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
