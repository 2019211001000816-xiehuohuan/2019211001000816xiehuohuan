<%@ page import="com.xiehuohuan.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 86199
  Date: 2021/4/11
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<table>
    <tr>
        <td>username:</td><td><%=request.getAttribute("username")%></td>
        <td>password:</td><td><%=request.getAttribute("password")%></td>
        <td>email:</td><td><%=request.getAttribute("email")%></td>
        <td>gender:</td><td><%=request.getAttribute("gender")%></td>
        <td>birthDate:</td><td><%=request.getAttribute("birthDate")%></td>
    </tr>
</table>
<%@include file="footer.jsp"%>
