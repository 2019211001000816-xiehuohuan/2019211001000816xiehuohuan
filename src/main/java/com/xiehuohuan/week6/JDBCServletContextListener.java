package com.xiehuohuan.week6;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public  void contextInitialized(ServletContextEvent sce){
            ServletContext context= sce.getServletContext();
            String driver=context.getInitParameter("driver");
            String url=context.getInitParameter("url");
            String user=context.getInitParameter("user");
            String key=context.getInitParameter("key");
            try {
                Class.forName(driver);
                Connection con = DriverManager.getConnection(url,user,key);//(Connection) getServletContext().getAttribute("con");
                System.out.println("i am in contextInitialized()-->"+con);
                //System.out.println("init()-->"+con);
                context.setAttribute("con",con);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("i am in contextDestroyed()");
        sce.getServletContext().removeAttribute("con");
    }
}