<%--
  Created by IntelliJ IDEA.
  User: 41509
  Date: 2021/4/1
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h2>Welcome to My Online Shop Home Page.</h2>
<form method="get"  target="_blank" action="search">
    <input type="text" name="txt" size=30/>
    <select name="search">
        <option value="Baidu">Baidu</option>
        <option value="Bing">Bing</option>
        <option value="Google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>
<%@ include file="footer.jsp"%>