package com.xiehuohuan.week3;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns= {"/register"} )

public class RegisterServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException{
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
            Statement createDbStatement = con.createStatement();
            String add="insert into usertable values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthDate+"')";
            createDbStatement.executeUpdate(add);
        } catch (Exception e) {
            System.out.println(e);
        }
        response.sendRedirect("login.jsp");


    }
}
