<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Fivaz
  Date: 03/04/2020
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<c:url value="/people" var="linkServletPeople"/>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <title><fmt:message key="label.people"/></title>
</head>
<body>
<ul>
    <li><a href="?lang=en"><fmt:message key="label.lang.en"/></a></li>
    <li><a href="?lang=fr"><fmt:message key="label.lang.fr"/></a></li>
</ul>

<form method="POST" action="${linkServletPeople}">
    <label for="firstName"><fmt:message key="label.firstName"/> :</label>
    <input type="text" id="firstName" name="firstName"/>
    <label for="lastName"><fmt:message key="label.lastName"/> :</label>
    <input type="text" id="lastName" name="lastName">
    <input type="submit" value="<fmt:message key="label.submit"/>">
</form>
<c:if test="${not empty people}">
    <table border="2">
        <thead>
        <tr>
            <th><fmt:message key="label.firstName"/> :</th>
            <th><fmt:message key="label.lastName"/> :</th>
            <th><fmt:message key="label.date"/> :</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${people}" var="person">
            <tr>
                <td>${person.getFirstName()}</td>
                <td>${person.getLastName()}</td>
                <td><fmt:formatDate value="${person.getDate()}" pattern="dd.MM.yyyy hh:mm"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
