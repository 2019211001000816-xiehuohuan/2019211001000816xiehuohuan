package com.xiehuohuan.week5;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    boolean valid=false;
    @Override
    public void init() throws ServletException{
        ServletContext config=getServletConfig().getServletContext();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String user=config.getInitParameter("user");
        String key=config.getInitParameter("key");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,user,key);
            System.out.println("init(login)-->"+con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sql = "select * from usertable where username="+"'"+username+"'"+"and passward="+"'"+password+"'";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            if(rs.next())
            {
                valid=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        if (valid){
            out.println("Login Success!!!");
            out.println("Welcome "+username);
        }else {
            out.println("Username or Password Error!!!") ;
        }
    }
    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
