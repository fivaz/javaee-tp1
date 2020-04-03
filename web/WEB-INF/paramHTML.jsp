<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Map" %>
<%@ page import="ch.hesge.programmation.models.Person" %><%--
  Created by IntelliJ IDEA.
  User: Fivaz
  Date: 03/04/2020
  Time: 01:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Person</h2>
<%Person person = (Person) request.getAttribute("person");%>
</strong>firstName:</strong> <%=person.firstName%>
</br>
</strong>firstName:</strong> <%=person.lastName%>
</body>
</html>
