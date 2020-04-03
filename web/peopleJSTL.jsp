<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Fivaz
  Date: 03/04/2020
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<c:url value="/people" var="linkServletPeople"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="POST" action="${linkServletPeople}">
    <label for="firstName">Prénom :</label>
    <input type="text" id="firstName" name="firstName"/>
    <label for="lastName">Nom :</label>
    <input type="text" id="lastName" name="lastName">
    <input type="submit" value="Enregistrer">
</form>
<c:if test="${not empty people}">
    <table border="2">
        <thead>
        <tr>
            <th>Prénom :</th>
            <th>Nom :</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${people}" var="person">
            <tr>
                <td>${person.getFirstName()}</td>
                <td>${person.getLastName()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
