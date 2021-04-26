package com.xiehuohuan.week5;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import com.xiehuohuan.dao.UserDao;
import com.xiehuohuan.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    boolean valid=false;
    @Override
    public void init() throws ServletException{
        //ServletConfig config=getServletConfig();
        //String driver=config.getInitParameter("driver");
        //String url=config.getInitParameter("url");
        //String user=config.getInitParameter("user");
        //String key=config.getInitParameter("key");
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
        }
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String passward = request.getParameter("password");

        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username,passward);
            if(user!=null){

                Cookie c=new Cookie("sessionid",""+user.getId());
                c.setMaxAge(10*60);
                response.addCookie(c);

                String rememberMe=request.getParameter("rememberMe");
                if(rememberMe!=null&&rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassward());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }

                HttpSession session =request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);

                session.setAttribute("user",user);
                //request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*String sql = "select * from usertable where username="+"'"+username+"'"+"and passward="+"'"+password+"'";
        String r="select id,username,passward,email,genter,birthdate from usertable";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            ResultSet result = con.createStatement().executeQuery(r);
            if(rs.next())
            {
                valid=true;
            }
            PrintWriter out = response.getWriter();
            if (valid){
                //out.println("Login Success!!!");
                //out.println("Welcome "+username);
                request.setAttribute("rsname",result);
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }else {
                //out.println("Username or Password Error!!!") ;
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }
}
