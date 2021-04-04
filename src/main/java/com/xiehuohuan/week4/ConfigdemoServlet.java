package com.xiehuohuan.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigdemoServletServlet", value = "/ConfigdemoServletServlet")
public class ConfigdemoServlet extends HttpServlet {
    @Override
    public void init() throws ServletException{

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String name= config.getInitParameter("name");
        String id= config.getInitParameter("id");
        PrintWriter writer = response.getWriter();
        writer.println("<br/>name:"+name);
        writer.println("<br/>id:"+id);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
