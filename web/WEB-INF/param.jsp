<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Map" %><%--
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
<table border="2">
    <%
        Map<String, String[]> params = (Map<String, String[]>) request.getAttribute("params");
        for (String param : params.keySet()) {%>
    <tr>
        <td><%=param%>
        </td>
        <td><%=Arrays.toString(params.get(param))%>
        </td>
    </tr>
    <%}%>
    <td></td>
</table>
</body>
</html>
