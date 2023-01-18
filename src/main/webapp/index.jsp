<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Hello World!</h2>

<%

    System.out.println("Test Scriptlet");
    Date serverDate=new Date();
    for(int i=0; i<5; i++){%>



<h4> <%=i%></h4>
<%}%>
%>
</body>
</html>
