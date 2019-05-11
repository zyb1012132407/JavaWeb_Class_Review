package cn.edu.bdu.test.Chapter05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

//练习：输出getWriter()
//对应页码：P135
@WebServlet(name = "Servlet_Chapter_05_Test1", urlPatterns = {"/Servlet_Chapter_05_Test1"})
public class Servlet_Chapter_05_Test1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        //声明要输出的变量
        String name = "Test PrintWriter\n";

        //另一种输出的方式，但是一山不能容二虎
//        OutputStream outputStream = response.getOutputStream();
//        outputStream.write(name.getBytes());

        //输出变量
        printWriter.println(name);

        //输出结果为：Test PrintWriter
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
