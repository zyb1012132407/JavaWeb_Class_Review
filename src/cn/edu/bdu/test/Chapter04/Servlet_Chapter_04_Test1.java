package cn.edu.bdu.test.Chapter04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//第一次体验Servlet
//P106-P107

//Servlet3.0 标注器，
@WebServlet(
        //Servlet标注名称
        name = "Servlet_Chapter_04_Test1",
        //相应的URL
        urlPatterns = "/Servlet_Chapter_04_Test1"
         )

public class Servlet_Chapter_04_Test1 extends HttpServlet {

    //对Post类型的Request做出Response
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //声明一个输出对象
        PrintWriter printWriter = response.getWriter();
        //调用输出对象的输出方法，打印字符串
        printWriter.println("this is doPost method");
    }

    //对Get类型的Request做出Response
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
