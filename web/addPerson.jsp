<%--
  Created by IntelliJ IDEA.
  User: Fivaz
  Date: 03/04/2020
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <form method="POST" action="<%= request.getContextPath() %>/people">
        <label for="firstName">Prénom :</label>
        <input type="text" id="firstName" name="firstName"/>
        <label for="lastName">Nom :</label>
        <input type="text" id="lastName" name="lastName">
        <input type="submit" value="Enregistrer">
    </form>
</head>
<body>

</body>
</html>
