<%--
  Created by IntelliJ IDEA.
  User: 86199
  Date: 2021/4/26
  Time: 3:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<section id="form"><!--form-->
<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="signup-form">
<h1>User Update</h1>
<%
    User u=(User) session.getAttribute("user");
%>
<form method="post" action="updateUser">
    ID<input type="text" name="id"value="<%=u.getId()%>"/><br/>
    Username<input type="text " name="username"value="<%=u.getUsername()%>"/><br/>
    Password<input type="password"name="password"value="<%=u.getPassward()%>"/><br/>
    Email<input type="text"name="email"value="<%=u.getEmail()%>"/><br/>
    Gender:<input type="radio"style="width: 15px; height: 15px; display:inline;"name="gender"value="male"<%="male".equals(u.getGenter())?"checked":""%>>Male
    <input type="radio"style="width: 15px; height: 15px;   display: inline;"name="gender"value="female"<%="female".equals(u.getGenter())?"checked":""%>>Female<br/>
    Date of Birth :<input type="type name="name="birthDate"value="<%=u.getBirthDate()%>"><br/>
    <!--<input type="submit"value="Save Changes"/>-->
    <button type="submit" class="btn btn-default">Save Changes</button>
</form>
            </div>
        </div>
    </div>
</div>
</section><!--/form-->
<%@include file="footer.jsp"%>