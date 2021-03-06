package cn.edu.bdu.test.Chapter05;

import jdk.nashorn.internal.ir.LiteralNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//练习：解决乱码问题
//对应页码：P137-P140
@WebServlet(name = "Servlet_Chapter_05_Test2", urlPatterns = {"/Servlet_Chapter_05_Test2"})
public class Servlet_Chapter_05_Test2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置Response的格式，解决乱码问题
//        response.setContentType("text/html;charset=utf-8");

        //另一种解决乱码的问题，相比起来有点臃肿，建议第一种
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type","text/html;charset=utf-8");

        //声明一个用于输出的对象
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Test  <br/>");

        printWriter.println("中国");

        //输出结果为：Test
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
