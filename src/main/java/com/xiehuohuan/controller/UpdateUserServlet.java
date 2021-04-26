package com.xiehuohuan.controller;

import com.xiehuohuan.dao.UserDao;
import com.xiehuohuan.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException{
        ServletContext context= getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String user=context.getInitParameter("user");
        String key=context.getInitParameter("key");
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,key);//(Connection) getServletContext().getAttribute("con");
            //System.out.println("i am in contextInitialized()-->"+con);
            System.out.println("init()-->"+con);
            context.setAttribute("con",con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String passward = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        User u = new User(Integer.valueOf(id), username, passward, email, gender,birthDate );
        UserDao userDao = new UserDao();
        try {
            userDao.updateUser(con,u);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
    }
}
