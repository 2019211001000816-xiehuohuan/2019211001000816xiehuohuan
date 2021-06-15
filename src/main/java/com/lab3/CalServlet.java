package com.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/CalServlet")
public class CalServlet extends HttpServlet {
    //todo 1: create a method to add(int firstVal, int secondVal) two number创建一个方法来添加（int firstVal，int secondVal）两个数字
    public int add(int firstVal,int secondVal){
        return firstVal+secondVal;
    }
    //todo 2: create a method to subtract two number创建两个数字相减的方法
    public int subtract(int firstVal,int secondVal){
        return firstVal-secondVal;
    }
    //todo 3: create a method to multiply two number创建两个数相乘的方法
    public int multiply(int firstVal,int secondVal){
        return firstVal*secondVal;
    }
    //todo 4: create a method to divide two number创建一个方法来除两个数
    public int divide(int firstVal,int secondVal){
        return firstVal/secondVal;
    }
    //todo 5: create a method to computeLength of a string创建一个方法来计算字符串的长度
    public int computerLength(String name){
        return name.trim().length();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //todo 6: get all request parameters- firstValue , secondValue,name,action获取所有请求参数-firstValue、secondValue、name、action
        int firstVal=request.getParameter("firstVal")!=null?Integer.parseInt(request.getParameter("firstVal")):0;
        int secondVal= request.getParameter("secondVal")!=null?Integer.parseInt(request.getParameter("secondVal")):0;
        String name=request.getParameter("name");
        String action=request.getParameter("action");
        //todo 7: use if else to determine action is add or subtract or multiply or divide or computerLength使用if-else来确定操作是加法、减法、乘法、除法还是计算机长度
        //todo 8 : call method add, subtract , multiply, divide or computeLength based on action and get the calculated result根据动作调用加法、减法、乘法、除法或computeLength方法，得到计算结果
        //todo 9: if action =add or subtract or multiply or divide如果动作=加或减或乘或除
        //todo 10 :create 3 cookie name cFirstValue, cSecondValue,cResult and set the value of cookie创建3个cookie名称cFirstValue、cSecondValue、cResult并设置cookie的值
        //todo 11 : add 3 cookies into response在响应中添加3个cookie
        if(action.equals("add")){
            int result=add(firstVal,secondVal);
            Cookie cFirstValue=new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondValue=new Cookie("cSecondVal",String.valueOf(secondVal));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));
            /*cFirstValue.setMaxAge(5);
            cSecondValue.setMaxAge(5);
            cResult.setMaxAge(5);*/
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }else if(action.equals("subtract")){
            int result=subtract(firstVal,secondVal);
            Cookie cFirstValue=new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondValue=new Cookie("cSecondVal",String.valueOf(secondVal));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));
            /*cFirstValue.setMaxAge(5);
            cSecondValue.setMaxAge(5);
            cResult.setMaxAge(5);*/
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }else if(action.equals("multiply")){
            int result=multiply(firstVal,secondVal);
            Cookie cFirstValue=new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondValue=new Cookie("cSecondVal",String.valueOf(secondVal));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));
            /*cFirstValue.setMaxAge(5);
            cSecondValue.setMaxAge(5);
            cResult.setMaxAge(5);*/
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }else if(action.equals("divide")){
            int result=divide(firstVal,secondVal);
            Cookie cFirstValue=new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondValue=new Cookie("cSecondVal",String.valueOf(secondVal));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));
            /*cFirstValue.setMaxAge(5);
            cSecondValue.setMaxAge(5);
            cResult.setMaxAge(5);*/
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }
        //todo 12: if action =computeLength
        //todo 13 :create 2 cookies name cName, cLength and set the value
        //todo 14 : add 2 cookies into response
        else if(action.equals("computeLength")){
            int result=computerLength(name);
            Cookie cName=new Cookie("cName",name);
            Cookie cLength=new Cookie("cLength",String.valueOf(result));
            /*cName.setMaxAge(5);
            cLength.setMaxAge(5);*/
            response.addCookie(cName);
            response.addCookie(cLength);
        }
        //todo 13 : send redirect to cal.jsp
        response.sendRedirect("/2019211001000816xiehuohuan_war_exploded/lab3/cal.jsp");
    }
}
