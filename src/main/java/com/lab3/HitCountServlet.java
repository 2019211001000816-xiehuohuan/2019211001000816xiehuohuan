package com.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HitCountServlet", value = "/HitCountServlet")
public class HitCountServlet extends HttpServlet {
    int count;
    @Override
    public void init() throws ServletException {
        count=0;
        ServletContext application=this.getServletContext();
        application.setAttribute("count",count);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "Total Number of this Hits";
        ServletContext page=this.getServletContext();
        count=(Integer)page.getAttribute("count");
        count++;
        page.setAttribute("count",count);
        PrintWriter out= response.getWriter();
        out.println("<html><body>");
        out.println("<table align=\"center\">");
        out.println("<center>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + count + "</h1>");
        out.println("</center>");
        out.println("</body></html>");
    }
}
