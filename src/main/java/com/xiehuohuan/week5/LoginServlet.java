package com.xiehuohuan.week5;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    boolean valid=false;
    @Override
    public void init() throws ServletException{
        super.init();
        //ServletContext config=getServletConfig().getServletContext();
        //String driver=config.getInitParameter("driver");
        //String url=config.getInitParameter("url");
        //String user=config.getInitParameter("user");
        //String key=config.getInitParameter("key");
        //try {
            //Class.forName(driver);
            //con= DriverManager.getConnection(url,user,key);
            //System.out.println("init(login)-->"+con);
        //} catch (ClassNotFoundException e) {
          //  e.printStackTrace();
        //} catch (SQLException e) {
           // e.printStackTrace();
        //}
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
        PreparedStatement pre = null;
        ResultSet result = null;
        //String sql = "select * from usertable where username="+"'"+username+"'"+"and passward="+"'"+password+"'";
        try {
            String sql = "select * from usertable where username=? and password=?";
            pre = con.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            result = pre.executeQuery();
            if(result.next())
            {
                valid=true;
                request.setAttribute("id",result.getInt("id"));
                request.setAttribute("username",result.getString("Username"));
                request.setAttribute("password",result.getString("password"));
                request.setAttribute("email",result.getString("Email"));
                request.setAttribute("gender",result.getString("Gender"));
                request.setAttribute("birthDate",result.getString("BirthDate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //PrintWriter out = response.getWriter();
        if (!valid){
            request.setAttribute("message","username or Password Error!!!");
            request.getRequestDispatcher("login.jsp").forward(request,response);
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
