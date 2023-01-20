<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 20.01.2023
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.Model.User" %>
<%@ page import="org.example.DAO.impl.UserDAO" %>
<%@ page import="java.util.Set" %>
<html>

    <head>
        <title> Users List</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
                border: solid;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>email</th>
        <th>password</th>
    </tr>
    <tr>
            <%  Set<User> users=new UserDAO().getAll();
    for (User user:users
         )  {%>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getName()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getPassword()%></td>

<%}%>
    </tr>

</table>
</body>

</html>
