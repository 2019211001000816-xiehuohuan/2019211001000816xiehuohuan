<%--
  Created by IntelliJ IDEA.
  User: 86199
  Date: 2021/3/28
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<br>
<%@include file="header.jsp"%>
This is my JSP register page.<br/>


<form method="post" action="register">
    username<input type="text " name="username"/><br/>
    password<input type="password"name="password"/><br/>
    Email<input type="text"name="email"/><br/>
    Gender:<input type="radio"name="gender"value="male">Male<input type="radio"name="gender"value="female">Female<br/>
    Date of Birth :<input type="type name="name="birthDate"><br/>
    <input type="submit"value="Register"/>
</form>


<%@include file="footer.jsp"%>
</body>
</html>