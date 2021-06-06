package com.xiehuohuan.controller;

import com.xiehuohuan.dao.UserDao;
import com.xiehuohuan.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        /*ServletContext context= getServletContext();
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
        }*/
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

        //User u = new User(Integer.valueOf(id), username, passward, email, gender, Date.valueOf(birthDate) );
        User user=new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassward(password);
        user.setEmail(email);
        user.setGenter(gender);
        user.setBirthDate(Date.valueOf(birthDate));
        UserDao userDao = new UserDao();
        HttpSession session=request.getSession();
        try {
            int n=userDao.updateUser(con,user);
            User updateUser=userDao.findById(con,id);

            session.removeAttribute("user");
            session.setAttribute("user",updateUser);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        session.setAttribute("user",user);
        //request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
        request.getRequestDispatcher("accountDetails").forward(request,response);
    }
}
