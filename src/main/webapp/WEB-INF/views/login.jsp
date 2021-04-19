<%@ page import="javafx.scene.web.HTMLEditor" %>
<%@ page import="java.io.PrintStream" %><%--
  Created by IntelliJ IDEA.
  User: 86199
  Date: 2021/4/4
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<br>
<%@include file="../../header.jsp"%>
<html>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(request.getAttribute("message")!=null){
        System.out.print("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>
<form method="post" action="/2019211001000816xiehuohuan_war_exploded/login">
    Username:<input type="text" name="username" ><br/>
    Password:<input type="password" name="password"><br/>
    <input type="submit" value="Login"/>
</form>
</body>
<%@ include file="footer.jsp"%>
</html>