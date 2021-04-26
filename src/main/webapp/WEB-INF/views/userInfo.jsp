<%--
  Created by IntelliJ IDEA.
  User: 86199
  Date: 2021/4/25
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.xiehuohuan.model.User" %>
<h1>User Info</h1>
<%
    Cookie [] allCookies=request.getCookies();
    for(Cookie c:allCookies){
        out.println("<br/>"+c.getName()+"---"+c.getValue());
    }
%>
<%
    //User user=(User)request.getAttribute("user");
    User u=(User)session.getAttribute("user");
%>
<!--<table border=1>
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
</table>-->
<table>
    <!--tr><td>id:</td><td><%=u.getId()%></td></tr-->
    <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=u.getPassward()%></td></tr>
    <tr><td>email:</td><td><%=u.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=u.getGenter()%></td></tr>
    <tr><td>Birth Date:</td><td><%=u.getBirthDate()%></td></tr>
    <tr><td><a href="updateUser">update</a></td></tr>
</table>
<%@include file="footer.jsp"%>