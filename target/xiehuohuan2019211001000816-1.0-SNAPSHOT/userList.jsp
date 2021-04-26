<%--
  Created by IntelliJ IDEA.
  User: 86199
  Date: 2021/4/24
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<h1>User List</h1>
<table border=1>
    <tr>
        <td>Id</td><td>Username</td><td>password</td><td>Email</td><td>Gender</td><td>Birthday</td>
    </tr>
    <%
        ResultSet result=(ResultSet) request.getAttribute("rsname");
        if(result==null){
    %>
    <tr>
        <td>No Data!!!</td>
    </tr>
<%}else {
            while(result.next()){
                out.println("<tr>");
                out.println("<td>"+result.getInt("id")+"</td>");
                out.println("<td>"+result.getString("username")+"</td>");
                out.println("<td>"+result.getString("passward")+"</td>");
                out.println("<td>"+result.getString("email")+"</td>");
                out.println("<td>"+result.getString("genter")+"</td>");
                out.println("<td>"+result.getString("birthdate")+"</td>");
                out.println("</tr>");
            }}
    %>
</table>
<%@include file="footer.jsp"%>