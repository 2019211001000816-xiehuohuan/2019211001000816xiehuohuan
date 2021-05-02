package com.xiehuohuan.week3;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = {"/register"},
/*initParams = {@WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
        @WebInitParam(name="url",value="jdbc:sqlserver://localhost;databaseName=userdb;"),
        @WebInitParam(name="user",value="sa"),
        @WebInitParam(name="key",value="211816"),
},*/loadOnStartup =1)
public class RegisterServlet extends HttpServlet {
    Connection con = null;
   @Override
    public void init() throws ServletException{
        super.init();
        /*ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String user=config.getInitParameter("user");
        String key=config.getInitParameter("key");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,key);//(Connection) getServletContext().getAttribute("con");
            System.out.println("init()-->"+con);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }*/
       con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);//doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

        PrintWriter writer = response.getWriter();
        //writer.println("<br>username:"+username);
        //writer.println("<br>password:"+password);
        //writer.println("<br>email:"+email);
        //writer.println("<br>gender:"+gender);
        //writer.println("<br>birth Date:"+birthDate);
        //writer.close();
        String[][] arr=new String[100][6];
        int a=0;
        try {
            System.out.println("con:"+con);
            Statement createDbStatement = con.createStatement();if(password!=""){
            String add="insert into usertable values('"+id+"','"+username+"','"+password+"','"+email+"','"+gender+"','"+birthDate+"')";
            createDbStatement.executeUpdate(add);}
            String rs="select id,username,passward,email,genter,birthdate from usertable";
            ResultSet result=createDbStatement.executeQuery(rs);
            /*while(result.next()) {
                arr[a][0]=result.getString(1);
                arr[a][1]=result.getString(2);
                arr[a][2]=result.getString(3);
                arr[a][3]=result.getString(4);
                arr[a][4]=result.getString(5);
                arr[a][5]=result.getString(6);
                a++;
            }*/
            request.setAttribute("rsname",result);
            response.sendRedirect("login.jsp");
            //request.getRequestDispatcher("userList.jsp").forward(request,response);
            System.out.println("i am in RegisterServlet-->after forward()");
            //response.sendRedirect("login.jsp");
        } catch (Exception e) {
            System.out.println(e);
        }
        /*writer.println("<table border=\"1\">");
        writer.println("<tr><th>ID</th><th>UserName</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th></tr>");
        for(int i=0;i<a;i++) {
           writer.println("<tr><td>"+(i+1)+"</td>");
            for(int j=1;j<=5;j++) {
                writer.println("<td>"+arr[i][j]+"</td>");
            }
            writer.println("</tr>");
        }
        writer.println("</table>");*/
        }
}
