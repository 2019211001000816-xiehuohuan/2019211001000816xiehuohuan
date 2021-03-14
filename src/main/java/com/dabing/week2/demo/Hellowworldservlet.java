package com.dabing.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Hellowworldservlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer =response.getWriter();
        writer.println("Hellow Client!!!");
        writer.println("Hellow xiehuohan!!");
        writer.println("Hellow 2019211001000816!!!");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
