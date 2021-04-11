package com.xiehuohuan.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    String txt = request.getParameter("txt");
    String search = request.getParameter("search");

        if(txt == null){
        response.sendRedirect("index.jsp");
    }else{
        if(search.equals("Baidu")) {
            response.sendRedirect("https://www.baidu.com/s?wd="+txt);
        }else if(search.equals("Bing")){
            response.sendRedirect("https://cn.bing.com/search?q="+txt);
        }else if(search.equals("Google")){
            response.sendRedirect("https://www.google.com/search?q="+txt);
        }
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
